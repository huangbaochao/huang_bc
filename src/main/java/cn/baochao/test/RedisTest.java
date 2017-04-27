package cn.baochao.test;

import cn.baochao.redis.RedisUtil;

/**
 * Created by huangbc on 2017/4/27.
 */
public class RedisTest {

    public static void main(String[] args) {
        try {
            RedisUtil.set("huang", "黄保朝");
            System.out.println(RedisUtil.get("huang"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
