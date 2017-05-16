package cn.baochao.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by huangbc on 2017/5/16.
 */
public class User1 implements Comparator<User1> {

    private String name;

    private int age;



    public User1(int age) {
        this.age = age;
    }

    public User1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User1() {
    }

    @Override
    public String toString() {
        return "User1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compare(User1 o1, User1 o2) {
        return 0;
    }
}

class test{

    public static void main(String[] args) {
        List<User1> user1s = new ArrayList();
        User1 user1 = new User1();
        user1.setName("huang");
        user1.setAge(12);
        user1s.add(user1);
        User1 user2 = new User1();
        user2.setName("huang");
        user2.setAge(11);
        user1s.add(user2);
        User1 user3 = new User1();
        user3.setName("huang");
        user3.setAge(13);
        user1s.add(user3);
        Collections.sort(user1s, (t1, t2) -> t1.getAge() - t2.getAge() > 0 ? -1 : 0);
        user1s.forEach(k->{
            System.out.println(k);
        });
    }


}