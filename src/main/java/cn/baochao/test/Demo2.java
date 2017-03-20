package cn.baochao.test;

import cn.baochao.dto.Result;
import cn.baochao.utils.CheckUtil;

import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by huangbaochao on 2017/3/20 $version 1.0.
 */
public class Demo2 {

    public static Result applyEunion(String userId) {
        if (CheckUtil.isEmpty(userId)) {
            return new Result(1002, "参数有误");
        }
//        Result result = this.joinEunion(userId);
//        if (result.getCode() != 0000) {
//            return result;
//        }
        //todo 积分扣除、流水？
        return null;
    }

    public static void main(String[] args) {
        //锁机制1.
        Lock lock = new ReentrantLock();
        lock.lock();
        System.out.println("huang");
        lock.unlock();

        //同步锁2
        Objects objects = (Objects) new Object();
        synchronized (objects){
            System.out.println("huang");
        }

        //
        applyEunion("");
    }

}
