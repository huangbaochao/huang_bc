package cn.baochao.test;

import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by huangbc on 2017/4/27.
 */
public class ConcurrentHashMapDemo {


    public static void main(String[] args) {

        ConcurrentHashMap<String, Object> hashMap = new ConcurrentHashMap<>();
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        HashMap<Object, Object> hashMap1 = new HashMap<>();
        Collections.synchronizedMap(hashMap1);
//        ConcurrentHashMap、hashMap、hashtable的区别
//        hashtable是锁住的整个map容器，Concurrenthashmap锁住的是桶，默认分为16个桶。
//        锁分段技术：---------------------------------------------------------------------------------
//        HashTable容器在竞争激烈的并发环境下表现出效率低下的原因是所有访问HashTable的线程都必须竞争同一把锁，
//        那假如容器里有多把锁，
//        每一把锁用于锁容器其中一部分数据，
//        那么当多线程访问容器里不同数据段的数据时，线程间就不会存在锁竞争，
//        从而可以有效的提高并发访问效率，这就是 ConcurrentHashMap所使用的锁分段技术，
//        首先将数据分成一段一段的存储，然后给每一段数据配一把锁，当一个线程占用锁访问其中一个段数据 的时候，
//        其他段的数据也能被其他线程访问。
//        锁分段技术：---------------------------------------------------------------------------------

    }


}
