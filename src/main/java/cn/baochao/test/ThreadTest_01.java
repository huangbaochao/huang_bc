package cn.baochao.test;

/**
 * Created by huangbc on 2017/4/27.
 */
public class ThreadTest_01 implements Runnable{

    private String lock ;
    private String name;

    public ThreadTest_01(String name,String lock){
        this.name = name;
        this.lock = lock;
    }

    @Override
    public  void run() {
        synchronized (lock) {
            for(int i = 0 ; i < 3 ; i++){
                System.out.println(name + " run......");
            }
        }
    }

    public static void main(String[] args) {
        String lock  = new String("test");
        for(int i = 0 ; i < 5 ; i++){
            new Thread(new ThreadTest_01("ThreadTest_" + i,lock),"test").start();
        }
    }
}