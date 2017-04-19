package cn.baochao.test;

/**
 * Created by huangbc on 2017/4/19.
 */
public class Singleton {

    private Singleton() {
    }

    private volatile static Singleton singleton = null;

    public static Singleton getSingleton(){
        synchronized (Singleton.class){
            if(singleton==null){
                singleton =  new Singleton();
                return singleton;
            }
        }
        return singleton;
    }
}
