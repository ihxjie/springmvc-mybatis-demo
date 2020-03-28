<%--
  Created by IntelliJ IDEA.
  User: xingj
  Date: 2020/3/20
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>登录 - 实训系统</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i">
    <link rel="stylesheet" href="assets/fonts/fontawesome-all.min.css">
</head>

<body class="bg-gradient-primary">
<input id="domainUrl" type="hidden" value="${pageContext.request.contextPath}">
<input id="info" type="hidden" value="${info}">
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-9 col-lg-12 col-xl-10">
            <div class="card shadow-lg o-hidden border-0 my-5">
                <div class="card-body p-0">
                    <div class="row">
                        <div class="col-lg-6 d-none d-lg-flex">
                            <div class="flex-grow-1 bg-login-image" style="background-image: url(&quot;assets/img/dogs/image3.jpeg&quot;);"></div>
                        </div>
                        <div class="col-lg-6">
                            <div class="p-5">
                                <div class="text-center">
                                    <h4 class="text-dark mb-4">欢迎回来!</h4>
                                </div>
                                <form class="user" id="login_form" method="post">
                                    <div class="form-group">
                                        <input class="form-control form-control-user" type="text" autocomplete="off" id="username" placeholder="请输入您的账号..." name="username"></div>
                                    <div class="form-group">
                                        <input class="form-control form-control-user" type="password" id="password" placeholder="密码" name="password"></div>
                                    <hr><a class="btn btn-primary btn-block text-white btn-google btn-user" role="button" onclick="student_login()"><i class="fab fa-user-f"></i>&nbsp; 学生登录</a>
                                    <a class="btn btn-primary btn-block text-white btn-user" role="button" onclick="teacher_login()"><i class="fab fa-user-f"></i>&nbsp; 教师登录</a>
                                    <a class="btn btn-success btn-block text-white btn-user" role="button" onclick="company_login()"><i class="fab fa-user-f"></i>&nbsp; 公司登录</a>
                                    <hr>
                                    <a class="btn btn-info btn-block text-white btn-user" role="button"><i class="fab fa-user-f"></i>&nbsp; 管理员登录</a>
                                    <hr>
                                </form>
                                <div class="text-center"><a class="small" href="forgot-password.html">忘记密码?</a></div>
                                <div class="text-center"><a class="small" href="register.html">立即创建新账户!</a></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="assets/js/jquery.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<script src="assets/js/chart.min.js"></script>
<script src="assets/js/bs-init.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.js"></script>
<script src="assets/js/theme.js"></script>
<script src="assets/js/login-js.js"></script>
</body>

</html>
