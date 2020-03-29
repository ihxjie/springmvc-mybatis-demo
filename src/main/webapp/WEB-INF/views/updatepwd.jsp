<%--
  Created by IntelliJ IDEA.
  User: palanindn
  Date: 2020/3/23
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>教师修改密码页面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/fonts/fontawesome-all.min.css">
    <script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/updatepwd.js"></script>
</head>

<body id="page-top">
<div id="wrapper">
    <nav class="navbar navbar-dark align-items-start sidebar sidebar-dark accordion bg-gradient-primary p-0">
        <div class="container-fluid d-flex flex-column p-0">
            <a class="navbar-brand d-flex justify-content-center align-items-center sidebar-brand m-0" href="#">
                <div class="sidebar-brand-icon rotate-n-15"><i class="fas fa-laugh-wink"></i></div>
                <div class="sidebar-brand-text mx-3"><span>教师平台</span></div>
            </a>
            <hr class="sidebar-divider my-0">
            <ul class="nav navbar-nav text-light" id="accordionSidebar">
                <li class="nav-item" role="presentation"><a class="nav-link active" href="${pageContext.request.contextPath }/sys/teacherlist/view.html"><i class="fas fa-user"></i><span>个人信息</span></a></li>
                <li class="nav-item" role="presentation"><a class="nav-link active" href="${pageContext.request.contextPath }/sys/teacherlist/modify.html"><i class="fas fa-tachometer-alt"></i><span>修改信息</span></a></li>
                <li class="nav-item" role="presentation"><a class="nav-link" href="${pageContext.request.contextPath }/sys/applylist/pass.html"><i class="fas fa-user-circle"></i><span>学生报名管理</span></a></li>
                <li class="nav-item" role="presentation"><a class="nav-link" href="${pageContext.request.contextPath }/sys/resultlist/pass.html"><i class="far fa-user-circle"></i><span>学生成绩管理</span></a></li>
                <li class="nav-item" role="presentation"><a class="nav-link" href="${pageContext.request.contextPath }/projectlist"><i class="fas fa-key"></i><span>实训项目管理</span></a></li>
                <li class="nav-item" role="presentation"><a class="nav-link" href="login.html"><i class="fas fa-window-maximize"></i><span>退出登录</span></a></li>
            </ul>
            <div class="text-center d-none d-md-inline"><button class="btn rounded-circle border-0" id="sidebarToggle" type="button"></button></div>
        </div>
    </nav>
    <div class="d-flex flex-column" id="content-wrapper">
        <div id="content">
            <nav class="navbar navbar-light navbar-expand bg-white shadow mb-4 topbar static-top">
                <div class="container-fluid"><button class="btn btn-link d-md-none rounded-circle mr-3" id="sidebarToggleTop" type="button"><i class="fas fa-bars"></i></button>
                    <form class="form-inline d-none d-sm-inline-block mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                        <div class="input-group"><input class="bg-light form-control border-0 small" type="text" placeholder="Search for ...">
                            <div class="input-group-append"><button class="btn btn-primary py-0" type="button"><i class="fas fa-search"></i></button></div>
                        </div>
                    </form>
                </div>
                </li>
                <div class="d-none d-sm-block topbar-divider"></div>
                <li class="nav-item dropdown no-arrow" role="presentation">
                    <div class="nav-item dropdown no-arrow">
                        <a class="dropdown-toggle nav-link" data-toggle="dropdown" aria-expanded="false" href="#">
                                    <span class="d-none d-lg-inline mr-2 text-gray-600 small">
                                        <span style="color: #f3a199"> ${teacherName }欢迎你！</span>
                                    </span>
                        </a>
                        <div
                                class="dropdown-menu shadow dropdown-menu-right animated--grow-in" role="menu">
                            <a class="dropdown-item" role="presentation" href="${pageContext.request.contextPath }/sys/teacherlist/view.html"><i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>个人信息</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" role="presentation" href="login.html"><i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>&nbsp;退出</a></div>
                    </div>
                </li>
            </nav>
            <div class="container-fluid">
                <h3 class="text-dark mb-4">修改密码</h3>
                <div class="row mb-3">

                    <div class="col-lg-12">
                        <div class="row mb-3 d-none">
                            <div class="col">
                                <div class="card text-white bg-primary shadow">
                                    <div class="card-body">
                                        <div class="row mb-2">
                                            <div class="col">
                                                <p class="m-0">Peformance</p>
                                                <p class="m-0"><strong>65.2%</strong></p>
                                            </div>
                                            <div class="col-auto"><i class="fas fa-rocket fa-2x"></i></div>
                                        </div>
                                        <p class="text-white-50 small m-0"><i class="fas fa-arrow-up"></i>&nbsp;5% since last month</p>
                                    </div>
                                </div>
                            </div>
                            <div class="col">
                                <div class="card text-white bg-success shadow">
                                    <div class="card-body">
                                        <div class="row mb-2">
                                            <div class="col">
                                                <p class="m-0">Peformance</p>
                                                <p class="m-0"><strong>65.2%</strong></p>
                                            </div>
                                            <div class="col-auto"><i class="fas fa-rocket fa-2x"></i></div>
                                        </div>
                                        <p class="text-white-50 small m-0"><i class="fas fa-arrow-up"></i>&nbsp;5% since last month</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col">
                                <div class="card shadow mb-3">
                                    <div class="card-header py-3">
                                        <p class="text-primary m-0 font-weight-bold">新密码设置</p>
                                    </div>
                                    <div class="card-body">
                                        <form id="teacherForm" name="teacherForm" method="post" action="${pageContext.request.contextPath }/sys/teacherlist/pwdsave.html">
                                            <input type = "hidden" id = "path" name = "path" value = "${pageContext.request.contextPath }">
                                            <form>
                                                <div class="form-row">
                                                    <div class="form-group"><label for="旧密码"><strong>旧密码</strong></label><input class="form-control" type="password"  name="oldteacherPwd" id="oldteacherPwd" value="" }></div>
                                                </div>
                                                <div class="form-row">
                                                    <div class="form-group"><label for="新密码"><strong>新密码</strong></label><input class="form-control" type="password"  name="newteacherPwd" id="newteacherPwd" value="" }></div>
                                                </div>
                                                <div class="form-row">
                                                    <div class="form-group"><label for="确认新密码"><strong>确认新密码</strong></label><input class="form-control" type="password"  name="rnewteacherPwd" id="rnewteacherPwd" value="" }></div>
                                                </div>

                                                <div class="form-group">
                                                    <input type="submit" name="save" id="save" value="保存" class="input-button">
                                                    <input type="button" type="button" id="back" name="back" value="返回" >
                                                </div>
                                            </form>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div><a class="border rounded d-inline scroll-to-top" href="#page-top"><i class="fas fa-angle-up"></i></a></div>
<script src="${pageContext.request.contextPath }/assets/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/assets/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath }/assets/js/chart.min.js"></script>
<script src="${pageContext.request.contextPath }/assets/js/bs-init.js"></script>
<script src="${pageContext.request.contextPath }/https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.js"></script>
<script src="${pageContext.request.contextPath }/assets/js/theme.js"></script>
</body>

</html>