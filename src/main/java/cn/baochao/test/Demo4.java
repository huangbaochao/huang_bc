package cn.baochao.test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by huangbaochao on 2017/4/12 $version 1.0.
 */
public class Demo4 {

    public static void main(String[] args) {

        Map<String, Object> map = new HashMap<>();
        map.put("1", "value1");
        map.put("2", "value2");
        map.put("3", "value3");
//--------------------------------------------
        for (String s : map.keySet()) {//方式一
            System.out.println(s + "-----" + map.get(s));
        }
//-------------------------------------------------
        Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();//方式二
        while (iterator.hasNext()) {
            Map.Entry<String, Object> entry = iterator.next();

            System.out.println(entry.getKey() + entry.getValue());
        }
//---------------------------------------------------
        for (Map.Entry<String, Object> entry : map.entrySet()) {//方式三
            System.out.println(entry.getKey() + entry.getValue());
        }
//----------------------------------------------------
        for (Object o : map.values()) {//方式四，只能获取map的value
            System.out.println("value" + o);
        }
//--------------------------------------------------------
        map.forEach((k, v) -> {//方式五，Java8以上支持
            System.out.println("key" + k + "value" + v);
        });
//---------------------------collection接口的子接口和实现类-----------------------------------
//            List
//            Map
//            SortedSet
//            SortedMap
//            HashSet
//            TreeSet
//            ArrayList
//            LinkedList
//            Vector
//            Collections
//            Arrays
//            AbstractCollection
        Vector<String> strings = new Vector<>();
        strings.add("zhang");
        strings.add("sanfeng");
        Enumeration<String> elements = strings.elements();//enumeration与iterator的区别
        while (elements.hasMoreElements()) {
            String string = elements.nextElement();
            System.out.println(string);
        }

        //Iterator
        strings.iterator().remove();//iterator有remove方法（没有add方法，因为iterator不保证迭代的顺序），而enumeration没有移除方法

//---------------------------trim的用法---------------------------------------
        String str = " huang bao chao  ";//去除前后空格
        System.out.println(str.trim());

//----------------------------------2种方法让hashmap线程安全----------------------------------------------
        Map<String, Object> map2 = new HashMap<>();
        map2.put("key", "huang");
        Map map1 = new ConcurrentHashMap();//第一种
        Map<Object, Object> map3 = Collections.synchronizedMap(map1);//第二种
        map1.put("2", "2");


    }
//-----------------------------集合框架的理解-------------------------------------------
    //java 集合框架是什么，有什么优点，如何设计自己的集合框架
    //1,该集合有什么实际的意义，比如查询效率高，增删效率高，（特点）
    //2，安全（如果没有安全的保障，没有人敢使用）
    //3，扩展性良好

    //泛型的优点 jdk1.5引入了泛型
    //1,如果传入的类型不一致，编译报错
    //2,扩展性好


//-------------------------forward与redirect区别-----------------------------------------------
    //转发页面url不跳转，对于浏览器只有一次请求，可以将对象放在requet对象进行传值
    //redirect重定向，url要变化，浏览器发送两次请求服务端

//------------------------String,StringBuffer,StringBuilder区别-----------------------------------------------------------------
    //String是字符串常量，如果修改，就会在常量池产生一个新变量
    //StringBuffer，字符串变量，线程安全...builder线程不安全

}
