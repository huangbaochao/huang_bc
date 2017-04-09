package cn.baochao.test;

import com.google.gson.Gson;
import org.junit.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by huangbaochao on 2017/4/2 $version 1.0.
 */
public class Demo3 {

    public static void main(String[] args) {
        Integer a = 12;

        switch (a){
            case 12:
                System.out.println("huangbaochao");
                break;
            case 11:
                System.out.println("hewei");
                break;
            default:
                System.out.println("gaobo");
        }
    }

    @Test
    public void test(){
        int b = 12;
        for (int i = 0; i < b; i++) {
            System.out.println("我是，黄保朝");
        }
    }

    @Test
    public void test1() {
        //选择排序
        int[] arr = {11,9,13,16,4};
        for (int x = 0; x < arr.length-1; x++) {

            for (int y= x+1;y <arr.length;y++){
                if(arr[x]>arr[y]){
                    int temp = arr[x];
                    arr[x] = arr[y];
                    arr[y] = temp;
                }
            }

        }
        for (int i : arr) {
            System.out.println(i);
        }

    }


    @Test
    public void test2() {
        //选择排序
        int[] arr = {11,9,13,16,4};
        for (int x = 0; x < arr.length-1; x++) {//冒泡排序

            for (int y= 0;y <arr.length-1-x;y++){
                if(arr[y]>arr[y+1]){
                    int temp = arr[y];
                    arr[y] = arr[y+1];
                    arr[y+1] = temp;
                }
            }

        }
        for (int i : arr) {
            System.out.println(i);
        }

    }

    @Test
    public void test3(){
        String str = "{'userName':huangbaochao,'age':26}";
        Map map = new Gson().fromJson(str, HashMap.class);
        map.forEach((k,v)->{
            System.out.println(k+"----"+v);
        });
    }

    @Test
    public void test4(){
        //递归test，获取文件
        String pathname = "E:\\idea_workspace";
        File file = new File(pathname);
        listFile(file);

    }

    private static void listFile(File file) {

        System.out.println("dir"+file.getName());
        File[] files = file.listFiles();
        for (File file1 : files) {
            //如果文件是目录，继续遍历
           if( file1.isDirectory()){
               listFile(file1);
           }else{
               System.out.println("file"+file1.getName());
           }

        }
    }

    @Test
    public void test5(){
        System.out.println();
    }

}
