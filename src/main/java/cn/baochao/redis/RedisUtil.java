package cn.baochao.redis;

import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

public class RedisUtil {
    protected static Logger logger = LogManager.getLogger(RedisUtil.class.getName());
    private static JedisPool jedisPool = null;
    private static String hashDirectory = "AAAA" + ":";
    private static String hashDomainDirectory = "BBBB" + ":";
    private static String hashStatusDirectory = "CCCC" + ":";

    /**
     * 初始化Redis连接池
     */
    private static void initialPool() throws Exception {
        InputStream in = null;
        try {
            Properties props = new Properties();

            // 取得classes文件夹
            File path = new File(Thread.currentThread().getContextClassLoader().getResource("").getPath());
            // 取得redis配置文件
            String fileName = path.getPath() + File.separator + "redis.properties";

            // apitools测试用test-classes文件夹
            if (path.getName().equals("test-classes")) {
                fileName = path.getParent() + File.separator + "classes" + File.separator + "redis.properties";
            }

            in = new BufferedInputStream(new FileInputStream(fileName));
            props.load(in);

            //Redis服务器IP
            String server = props.getProperty("server");

            //Redis的端口号
            int port = Integer.valueOf(props.getProperty("port"));

            //可用连接实例的最大数目，默认值为8；
            //如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
            int maxActive = Integer.valueOf(props.getProperty("max_active"));

            //控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
            int maxIdle = Integer.valueOf(props.getProperty("max_idle"));

            //等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；
            int maxWait = Integer.valueOf(props.getProperty("max_wait"));

            //在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
            boolean testOnBorrow = Boolean.valueOf(props.getProperty("test_on_borrow"));

            //超时时间
            int timeout = Integer.valueOf(props.getProperty("timeout"));

            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(maxActive);
            config.setMaxIdle(maxIdle);
            config.setMaxWaitMillis(maxWait);
            config.setTestOnBorrow(testOnBorrow);
            jedisPool = new JedisPool(config, server, port, timeout);
        } catch (Exception e) {
            logger.error("Create JedisPool error : " + e.getMessage(), e);
            throw e;
        } finally {
            in.close();
        }
    }

    /**
     * 在多线程环境同步初始化
     */
    private static synchronized void poolInit() throws Exception {
        if (jedisPool == null) {
            initialPool();
        }
    }

    /**
     * 同步获取Jedis实例
     *
     * @return Jedis
     */
    public static synchronized Jedis getJedis() throws Exception {
        if (jedisPool == null) {
            poolInit();
        }
        Jedis jedis = null;
        try {
            if (jedisPool != null) {
                jedis = jedisPool.getResource();
            }
        } catch (Exception e) {
            logger.error("Get jedis error : " + e.getMessage(), e);
            throw e;
        }
        //        finally {
        //            returnResource(jedis);
        //        }
        return jedis;
    }

    /**
     * 释放jedis资源
     *
     * @param jedis
     */
    public static void returnResource(final Jedis jedis) {
        if (jedis != null && jedisPool != null) {
            jedisPool.returnResource(jedis);
        }
    }

    /**
     * 设置 hash
     *
     * @param passport
     * @param hkey
     * @param hvalue
     */
    public static void hSet(String passport, String hkey, String hvalue) throws Exception {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            hvalue = StringUtils.isEmpty(hvalue) ? "" : hvalue;
            jedis.hset(hashDirectory + passport, hkey, hvalue);
        } catch (Exception e) {
            logger.error("Set key error : " + e.getMessage(), e);
            throw e;
        } finally {
            returnResource(jedis);
        }
    }

    public static void hMultiSet(String passport, Map<String, String> hash) throws Exception {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            jedis.hmset(hashDirectory + passport, hash);
        } catch (Exception e) {
            logger.error("Multi HSet error: " + e.getMessage(), e);
            throw e;
        } finally {
            returnResource(jedis);
        }
    }

    /**
     * 获取hash value值
     *
     * @param passport
     * @param hkey
     * @return value
     */
    public static String hGet(String passport, String hkey) throws Exception {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            if (jedis == null || !jedis.hexists(hashDirectory + passport, hkey)) {
                return null;
            }
            return jedis.hget(hashDirectory + passport, hkey);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            returnResource(jedis);
        }
    }

    public static List<String> hMultiGet(String key, String... hkeys) throws Exception {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            return jedis.hmget(key, hkeys);
        } catch (Exception e) {
            logger.error("hash Mutli-get error: " + e.getMessage(), e);
            throw e;
        } finally {
            returnResource(jedis);
        }
    }

    /**
     * 判断hash域是否存在
     *
     * @param passport
     * @param hkey
     */
    public static boolean hExists(String passport, String hkey) throws Exception {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            return jedis.hexists(hashDirectory + passport, hkey);
        } finally {
            returnResource(jedis);
        }
    }

    /**
     * 获取hash列表所有的值
     *
     * @param passport
     * @return map
     */
    public static Map<String, String> hGetAll(String passport) throws Exception {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            if (jedis == null || !jedis.exists(hashDirectory + passport)) {
                return null;
            }
            return jedis.hgetAll(hashDirectory + passport);
        } finally {
            returnResource(jedis);
        }
    }

    public static Set<String> keys(String pattern) throws Exception {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            if (jedis == null) {
                return null;
            }
            return jedis.keys(pattern);
        } finally {
            returnResource(jedis);
        }
    }


    /**
     * 删除 hash域
     *
     * @param passport
     * @param hkey
     */
    public static void hDel(String passport, String... hkey) throws Exception {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            jedis.hdel(hashDirectory + passport, hkey);
        } catch (Exception e) {
            logger.error("Del key error : " + e.getMessage(), e);
            throw e;
        } finally {
            returnResource(jedis);
        }
    }

    private static String convertList(String str) {
        return StringUtils.trimAllWhitespace(str).replace("[", "").replace("]", "");
    }

    /**
     * 设置 domain和passport对应关系
     *
     * @param domain
     * @param key
     * @param value
     */
    public static void setDomain(String domain, String key, String value) throws Exception {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            value = StringUtils.isEmpty(value) ? "" : value;
            jedis.hset(hashDomainDirectory + domain, key, value);
        } catch (Exception e) {
            logger.error("Set key error : " + e.getMessage(), e);
            throw e;
        } finally {
            returnResource(jedis);
        }
    }

    /**
     * 根据domain获取passport等
     *
     * @param domain
     * @param key
     * @return value
     */
    public static String getDomain(String domain, String key) throws Exception {
        Jedis jedis = null;
        try {
            jedis = getJedis();

            if (jedis == null || !jedis.hexists(hashDomainDirectory + domain, key)) {
                return null;
            }
            return jedis.hget(hashDomainDirectory + domain, key);
        } finally {
            returnResource(jedis);
        }
    }

    public static String getDomain(String passport) {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            if (jedis != null) {
                Set<String> keys = jedis.keys(hashDomainDirectory + "*:" + passport);
                if (!keys.isEmpty()) {
                    Assert.isTrue(keys.size() == 1, "Only one domain keys should exist: " + passport);
                    String found = keys.iterator().next();
                    int index1 = found.indexOf(":");
                    int index2 = found.lastIndexOf(":");
                    return found.substring(index1 + 1, index2);
                }
            }
        } catch (Exception e) {
            logger.error("Get domain error : " + e.getMessage(), e);
        } finally {
            returnResource(jedis);
        }
        return "";
    }

    /**
     * 批量设置status
     *
     * @param statusMap<directory,<date-status-channel,date>>
     * @param channel
     * @param onlyDel
     * @throws Exception
     */
    public static void zadd(Map<String, SortedMap<String, String>> statusMap, String channel, boolean onlyDel)
            throws Exception {
        Jedis jedis = null;
        Map<String, Double> scoreMembers;
        try {
            jedis = getJedis();
            if (statusMap.size() == 0) {
                return;
            }

            for (Map.Entry<String, SortedMap<String, String>> directoryEntry : statusMap.entrySet()) {
                String directory = directoryEntry.getKey();
                scoreMembers = new HashMap<String, Double>();
                for (Map.Entry<String, String> dailyEntry : directoryEntry.getValue().entrySet()) {

                    Set<String> statusList = jedis.zrangeByScore(hashStatusDirectory + directory,
                            Double.valueOf(dailyEntry.getKey()), Double.valueOf(dailyEntry.getKey()));

                    for (String status : statusList) {
                        if (!status.endsWith("-" + channel)) {
                            scoreMembers.put(status, Double.valueOf(dailyEntry.getKey()));
                        }
                    }

                    if (dailyEntry.getValue().equals("0") && !onlyDel) {
                        scoreMembers.put(dailyEntry.getKey() + "-" + dailyEntry.getValue() + "-" + channel,
                                Double.valueOf(dailyEntry.getKey()));
                    }
                    jedis.zremrangeByScore(hashStatusDirectory + directory, Double.valueOf(dailyEntry.getKey()),
                            Double.valueOf(dailyEntry.getKey()));
                }
                if (scoreMembers.size() > 0) {
                    jedis.zadd(hashStatusDirectory + directory, scoreMembers);
                }
            }
        } catch (Exception e) {
            logger.error("Set key error : " + e.getMessage(), e);
            throw e;
        } finally {
            returnResource(jedis);
        }
    }

    /**
     * status批量删除
     *
     * @param directoryList
     */
    public static void del(List<String> directoryList) throws Exception {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            for (String directory : directoryList) {
                jedis.del(hashStatusDirectory + directory);
            }

        } catch (Exception e) {
            logger.error("Del key error : " + e.getMessage(), e);
            throw e;
        } finally {
            returnResource(jedis);
        }
    }

    /**
     * @param channel   exn/agoda/booking
     * @param directory hotelcode:roomcode:ratecode
     * @param start     起始日期
     * @param end       结束日期
     * @return 某时间段内某个渠道的状态集合
     */
    public static Iterable<String> hStatusGet(String channel, String directory, double start, double end) {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            Set<String> allChannelStatus = jedis.zrangeByScore(hashStatusDirectory + directory, start, end);
            return Iterables.filter(allChannelStatus, Predicates.containsPattern(channel));
        } catch (Exception e) {
            logger.error("get status error, key[{}], due to[{}]", directory, e.getMessage());
        } finally {
            returnResource(jedis);
        }
        return null;
    }

    public static Set<String> hStatusGet(String directory, double start, double end) {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            return jedis.zrangeByScore(hashStatusDirectory + directory, start, end);
        } catch (Exception e) {
            logger.error("get status error, key[{}], due to[{}]", directory, e.getMessage());
        } finally {
            returnResource(jedis);
        }
        return null;
    }

    /**
     * sadd set
     *
     * @param key
     * @param passport
     */
    public static void sadd(String key, String passport) throws Exception {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            passport = StringUtils.isEmpty(passport) ? "" : passport;
            jedis.sadd(key, passport);
        } catch (Exception e) {
            logger.error("sadd error : " + e.getMessage(), e);
            throw e;
        } finally {
            returnResource(jedis);
        }
    }

    public static void set(String key,String value) throws Exception {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            jedis.set(key, value);
        } catch (Exception e) {
            logger.error("Set key error : " + e.getMessage(), e);
            throw e;
        } finally {
            returnResource(jedis);
        }
    }

    public static String get(String key) throws Exception {
        Jedis jedis = null;
        String k = null;
        try {
            jedis = getJedis();
            k = jedis.get(key);
        } catch (Exception e) {
            logger.error("Set key error : " + e.getMessage(), e);
            throw e;
        } finally {
            returnResource(jedis);
            return k;
        }
    }

}