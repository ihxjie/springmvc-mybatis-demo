<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/3/24
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page  contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Dashboard - Brand</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/fonts/fontawesome-all.min.css">
</head>

<body id="page-top">
<div id="wrapper">
    <nav class="navbar navbar-dark align-items-start sidebar sidebar-dark accordion bg-gradient-primary p-0">
        <div class="container-fluid d-flex flex-column p-0">
            <a class="navbar-brand d-flex justify-content-center align-items-center sidebar-brand m-0" href="#">
                <div class="sidebar-brand-icon rotate-n-15"><i class="fas fa-laugh-wink"></i></div>
                <div class="sidebar-brand-text mx-3"><span>Brand</span></div>
            </a>
            <hr class="sidebar-divider my-0">
            <ul class="nav navbar-nav text-light" id="accordionSidebar">
                <li class="nav-item" role="presentation"><a class="nav-link active" href="adminindex.html"><i class="fas fa-tachometer-alt"></i><span></span></a></li>
                <li class="nav-item" role="presentation"><a class="nav-link" href="studentList.html"><i class="fas fa-user"></i><span>学生信息管理</span></a></li>
                <li class="nav-item" role="presentation"><a class="nav-link" href="teacherList.html"><i class="fas fa-user"></i><span>教师信息管理</span></a></li>
                <li class="nav-item" role="presentation"><a class="nav-link" href="companyList.html"><i class="far fa-user-circle"></i><span>公司信息管理</span></a></li>
                <li class="nav-item" role="presentation"><a class="nav-link" href="projectList.html"><i class="fas fa-window-maximize"></i><span>实训信息管理</span></a></li>
                <li class="nav-item" role="presentation"><a class="nav-link" href="applyList.html"><i class="fas fa-window-maximize"></i><span>报名信息管理</span></a></li>
                <li class="nav-item" role="presentation"><a class="nav-link" href="resultList.html"><i class="fas fa-window-maximize"></i><span>成绩信息管理</span></a></li>
                <li class="nav-item" role="presentation"><a class="nav-link" href="feedbackList.html"><i class="fas fa-window-maximize"></i><span>反馈信息管理</span></a></li>
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
                    <ul class="nav navbar-nav flex-nowrap ml-auto">
                        <h1>欢迎来到教师系统</h1>
                        <li class="nav-item dropdown d-sm-none no-arrow"><a class="dropdown-toggle nav-link" data-toggle="dropdown" aria-expanded="false" href="#"><i class="fas fa-search"></i></a>
                            <div class="dropdown-menu dropdown-menu-right p-3 animated--grow-in" role="menu" aria-labelledby="searchDropdown">
                                <form class="form-inline mr-auto navbar-search w-100">
                                    <div class="input-group"><input class="bg-light form-control border-0 small" type="text" placeholder="Search for ...">
                                        <div class="input-group-append"><button class="btn btn-primary py-0" type="button"><i class="fas fa-search"></i></button></div>
                                    </div>
                                </form>
                            </div>
                        </li>
                        <li class="nav-item dropdown no-arrow" role="presentation">
                            <div class="nav-item dropdown no-arrow">
                                <input name = "wpath" id = "wpath" type = "hidden" value = "${pageContext.request.contextPath }"/>
                                <a class="dropdown-toggle nav-link" data-toggle="dropdown" aria-expanded="false" href="#">
                                    <p><span style="color: #356deb;font-size: 35px;">${adminId }</span>欢迎你！</p>
                                </a>
                                    <a class="updateAdmin" href="javascript:;" adminId=${adminId } role="presentation"><i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>&nbsp;修改</a>
                                <a href="${pageContext.request.contextPath }/logout.html"><i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>&nbsp;退出</a>
                            </div>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>
        <footer class="bg-white sticky-footer">
            <div class="container my-auto">
                <div class="text-center my-auto copyright"><span>Copyright © Brand 2020</span></div>
            </div>
        </footer>
    </div><a class="border rounded d-inline scroll-to-top" href="#page-top"><i class="fas fa-angle-up"></i></a></div>
<script src="assets/js/jquery.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<script src="assets/js/chart.min.js"></script>
<script src="assets/js/bs-init.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.js"></script>
<script src="assets/js/theme.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/admin.js"></script>
</body>

</html>
