package cn.baochao.test;

import sun.misc.Launcher;

import java.net.URL;

/**
 * Created by huangbc on 2017/4/19.
 */
public class JdkDemo {

    //java默认的三个classloader
    //bootstrp classloader:q启动类加载器，负责加载jdk中的核心类库rt.jar,resources.jar,charsets.jar
    //Extension ClassLoader：称为扩展类加载器，负责加载Java的扩展类库，默认加载JAVA_HOME/jre/lib/ext/目下的所有jar。
    //App ClassLoader：称为系统类加载器，负责加载应用程序classpath目录下的所有jar和class文件。
    //ClassLoader使用的是双亲委托模型来搜索类的
    //
    //
    //
    //
    //
    //
    //
    //
    //
    public static void main(String[] args) {
        //------------------------通过如下程序获得该类加载器从哪些地方加载了相关的jar或class文件------------------------------------------------
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();//方法1
        for (int i = 0; i < urLs.length; i++) {
            System.out.println(urLs[i].toExternalForm());///jre/lib/resources.jar,rt.jar,/sunrsasign.jar,/jsse.jar,/chersets.jar,jfr.jar,classes等
        }
        System.out.println(System.getProperty("sun.boot.class.path"));  //方法2
        //-------------------------------------------------------------------------------------




    }

}
