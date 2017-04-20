package cn.baochao.test;

/**
 * Created by huangbc on 2017/4/20.
 */

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 功能：线程安全的计数器，5个线程同时跑，计数到1000，输出线程名和计数
 * @author Yolanda
 *
 */
public class MySafeThread implements Runnable{

    private static AtomicInteger count = new AtomicInteger(0);//线程安全的计数变量
    private int threadCount = 0;//线程编号
    private static int num = 1;

    /**
     * 功能：计数
     */
    public static void calc(){
        while((count.get())<1000)
        {
            count.incrementAndGet();//自增1,返回更新值
            System.out.println("正在运行是线程" + Thread.currentThread().getName() + ":" + count);
        }
    }

    /**
     * 功能：线程运行方法，每次只能一个线程访问
     */
    public synchronized void run() {
        while(true)
        {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            MySafeThread.calc();
        }
    }

    public static void main(String[] args) {
        //创建五个线程实例并启动
        for (int i = 1; i < 6; i++) {
            Thread mySafeThread = new Thread(new MySafeThread());
            mySafeThread.start();
        }
    }
}
