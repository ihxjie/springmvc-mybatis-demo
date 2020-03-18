<%--
  Created by IntelliJ IDEA.
  User: xingj
  Date: 2019/12/1
  Time: 22:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<button onclick="test()">Test</button>
<button onclick="post()">Post</button>
<%--<form action="${pageContext.request.contextPath}/product/add"></form>--%>
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
<script>
    function test(){
        console.log("123");
        $.ajax({
            url:"test",
            type:"get",
            contentType : "application/json;charset=utf-8",
            success:function (data) {
                alert(data)
            }

        })
    }
    function post() {
        $.ajax({
            url:"add",
            type:"post",
            dataType:"json",
            contentType:"application/json",
            data:JSON.stringify({"productName":"nbnb"})
        })
    }
</script>
<a href="" onclick="test()">123</a>
</body>
</html>
