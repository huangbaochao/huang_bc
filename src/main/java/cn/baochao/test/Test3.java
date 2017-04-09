package cn.baochao.test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by huangbaochao on 2017/3/20 $version 1.0.
 */
public class Test3 {

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("key", 12);
        Integer a = 1;
        int b = 2;
        test(a);
        test(b);
    }

    public static void test(Object object){
        System.out.println(object.toString());
    }
}
