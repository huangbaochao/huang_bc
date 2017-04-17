package cn.baochao.test;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by huangbaochao on 2017/4/13 $version 1.0.
 */
public class Demo6 {

    public static void main(String[] args) {

//        ArrayList<String> list = new ArrayList<>();
//        list.add("jiamg");
//        for (String s : list) {
//            System.out.println(list.get(1));
//        }

        Map<String, Object> map = new TreeMap<>();
        map.put("1", "huang1");
        map.put("2", "huang2");
        map.put("5", "huang5");
        map.put("3", "huang3");
        map.forEach((k,v)->{
            System.out.println(k+"---value---"+v);
        });


    }

}
