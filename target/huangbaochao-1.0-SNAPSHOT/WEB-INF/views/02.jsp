<%--
  Created by IntelliJ IDEA.
  User: huangbaochao
  Date: 2016/11/14
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
<html>
<head>
    <script type="text/javascript">
        $(function () {
            $("#sub_mit").click(function () {
                var data = [{name:"jon",age:"12"},{name:"jic",age:"18"},{name:"petter",age:"14"}];
                $.ajax({
                    type: "post",
                    url: "${pageContext.request.contextPath}/student/test2.do",
                    data:/* null,*/
                    {
//                        id: $("input[name='id']").val(),
                        name: $("input[name='name']").val(),
                        age: $("input[name='age']").val()
//                        age: $("input[name='age']").val()
//                        ds:JSON.stringify(data)
                    },
                    dataType: "json",
                    success: function (data) {
                        console.log(data.code);
//                        JSON.stringify()
//                        console.log(data.success)
//                        console.log(data.data.id);
//                        var listMap = eval(data.object);
//
//                        for(var j=0;j<listMap.length;j++)
//                        {
//                            $.each(listMap[j],function(key,value)
//                            {d
//                                console.log(key);
//                                console.log(value.id);
//                                console.log(value.userName);
//                                console.log(value.password);
//
//                            });
//                        }





//                        for(var j=0;j<siteMap.length;j++)
//                        {
//                            var newsiteMap = siteMap[j];
//                            for ( var key in newsiteMap )
//                            {
//                                console.log(key);
//                                var unitName = newsiteMap[key].unitName;
//                                var terminalName = newsiteMap[key].terminalName;
//                                var isMute = newsiteMap[key].siteStatus.isMute;
//                                var isQuiet = newsiteMap[key].siteStatus.isQuiet;
//                                var siteStatus = newsiteMap[key].siteStatus.status;
//                                var ip = newsiteMap[key].ip;
//                            }
//
//                        }
//                        console.log(data.object.id);
//                        console.log(data.object.username);
//                        console.log(data.object);
                    }
                });
            });
        });

        <%--$(function () {--%>
        <%--$("#sub_mit").click(function () {--%>
        <%--$.ajax({--%>
        <%--type:"post",--%>
        <%--url:"${pageContext.request.contextPath}/demo/show4.do",--%>
        <%--data:$("#but_id").serialize(),--%>
        <%--dataType:"json",--%>
        <%--success: function (data) {--%>
        <%--console.log(data.object.form);--%>
        <%--console.log(data.object.to);--%>
        <%--}--%>
        <%--});--%>
        <%--});--%>
        <%--});--%>

        //          function add() {
        //              $("#but_id").submit();
        //          }

    </script>
    <title>Title</title>
</head>
<body>
<center>
    <form id="but_id" method="post" action="${pageContext.request.contextPath}/demo/show12.do">
        <%--id: <input type="text" name="id" value="1"/>--%>
        username:<input type="text" name="name" value="huangbaochao"/>
        password:<input type="password" name="age" value="25"/>
        <%--age :<input type="text" name="age" value=""/>--%>
        <input type="button" value="tijiao" id="sub_mit">
    </form>
</center>

</body>
</html>
