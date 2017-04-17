package cn.baochao.test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by huangbaochao on 2017/4/13 $version 1.0.
 */
public class Demo5 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
//---------------------------servlet的生命周期-----------------------------------
//servlet通过web.xml加载到tomcat容器，通过applicationContextLisenler监听，若果在web.xml中配置了<load-on-startup>  > 0 ,
    //innit方法启动的时候初始化一次（只初始化一次），
    //classNotFoundException(类名写错了，或没有注入到spring容器)
    //annotation-driven component-scan



}
