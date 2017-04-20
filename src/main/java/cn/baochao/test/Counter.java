package cn.baochao.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by huangbc on 2017/4/19.
 */
public class Counter {

    private final static Logger LOGGER = LoggerFactory.getLogger(Counter.class);

    public static int count = 0;

    public  static void inc() {

        LOGGER.debug("----------------开始计数！-------------------------------");

        //这里延迟1毫秒，使得结果明显

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            LOGGER.debug("计数异常");
        }

        count++;
    }

    public static void main(String[] args) {

        //同时启动1000个线程，去进行i++计算，看看实际结果

        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                public void run() {
                    Counter.inc();
                }
            }).start();
        }

        //这里每次运行的值都有可能不同,可能为1000
        System.out.println("运行结果:Counter.count=" + Counter.count);
    }
}
