package cn.baochao.test;

import cn.baochao.model.*;
import sun.misc.GC;

/**
 * Created by huangbc on 2017/5/3.
 */
public class MySqlDemo extends Object{

    public static void main(String[] args) throws Exception {
        User user = new User();
        user.setName("huang");
        user.setAge("25");
        User clone = (User)user.clone();
        System.out.println(user);
        System.out.println(clone);
//        System.out.println(user);
//        Object o = new Object();
//        o.wait();
        //-----------------------case 的使用----------------------------
        //select user_id,user_name,age,
//        case when user_name = '2' then 'yong'
//        when user_name='5' then 'handsome'
//        else 'just so so ' end
//        from user;
        //
        //---------------------------------------------------------------------------
        //
        //DSBPB17041810271900000014709
        //
        //--------------------------------object的子类------------------------------------------------
        //hashcode equels toString clone wait notify  notifyAll
        //
        //clone方法：如果实现了toString方法，打印的对象是相同的，如果没有实现，打印的地址是不相同的，
        //说明clone方法，创建了一个新的地址，也就是创建了一个新对象。。。。。
        //
        //-----------------------------------------------------------------------------------
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //


    }

     public  void test() throws Throwable {
         super.clone();
         super.finalize();
     }

}
