<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/3/24
  Time: 0:53
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page  contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Login - Brand</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/fonts/fontawesome-all.min.css">
    <script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/regist.js"></script>
</head>

<body class="bg-gradient-primary">
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
                                    <h4 class="text-dark mb-4">Welcome Back!</h4>
                                </div>
                                <div class="providerAdd">
                                    <form id="courseForm" name="courseForm" method="post" action="${pageContext.request.contextPath }/admin/doRegist.html" enctype="multipart/form-data">
                                        <!--div的class 为error是验证错误，ok是验证成功-->
                                        <div>
                                            <label for="studentId">账号：</label>
                                            <input type="text" name="studentId" id="studentId" value="">
                                            <font color="red"></font>
                                        </div>
                                        <div>
                                            <label for="studentPwd">密码：</label>
                                            <input type="text" name="studentPwd" id="studentPwd" value="">
                                            <font color="red"></font>
                                        </div>
                                        <div>
                                            <label for="studentName">姓名：</label>
                                            <input type="text" name="studentName" id="studentName" value="">
                                            <font color="red"></font>
                                        </div>

                                        <div>
                                            <tr valign="top"><td>性别:
                                                <select name="studentSex" id="studentSex">
                                                    <option value="1" selected="selected">男</option>
                                                    <option value="2">女</option>
                                                </select></td></tr>
                                            <font color="red"></font>
                                        </div>
                                        <div>
                                            <label for="studentMajor">专业：</label>
                                            <input type="text" name="studentMajor" id="studentMajor" value="">
                                            <font color="red"></font>
                                        </div>
                                        <div>
                                            <label for="studentClass">班级：</label>
                                            <input type="text" name="studentClass" id="studentClass" value="">
                                            <font color="red"></font>
                                        </div>
                                        <div>
                                            <label for="studentTel">联系电话：</label>
                                            <input type="text" name="studentTel" id="studentTel" value="">
                                            <font color="red"></font>
                                        </div>
                                        <div>
                                            <label for="studentEmail">邮箱：</label>
                                            <input type="text" name="studentEmail" id="studentEmail" value="">
                                            <font color="red"></font>
                                        </div>
                                        <div class="subBtn">
                                            <input type="submit" name="regist" id="regist" value="注册" >
                                            <input type="button" id="back" name="back" value="返回" >
                                        </div>
                                    </form>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath }/assets/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/assets/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath }/assets/js/chart.min.js"></script>
<script src="${pageContext.request.contextPath }/assets/js/bs-init.js"></script>
<script src="${pageContext.request.contextPath }/https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.js"></script>
<script src="${pageContext.request.contextPath }/assets/js/theme.js"></script>
</body>

</html>