<%--
  Created by IntelliJ IDEA.
  User: palanindn
  Date: 2020/3/23
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>查看学生页面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/fonts/fontawesome-all.min.css">
    <script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/studentlist.js"></script>
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
                <h3 class="text-dark mb-4">查看学生信息</h3>
                <div class="card shadow">
                    <div class="card-header py-3">
                        <p class="text-primary m-0 font-weight-bold">学生信息列表</p>
                    </div>
                    <div class="card-body">
                        <div class="row">
                            <div class="col-md-6 text-nowrap">
                                <div id="dataTable_length" class="dataTables_length" aria-controls="dataTable"><label>Show&nbsp;<select class="form-control form-control-sm custom-select custom-select-sm"><option value="10" selected="">10</option><option value="25">25</option><option value="50">50</option><option value="100">100</option></select>&nbsp;</label></div>
                            </div>
                            <div class="col-md-6">
                                <div class="text-md-right dataTables_filter" id="dataTable_filter"><label><input type="search" class="form-control form-control-sm" aria-controls="dataTable" placeholder="Search"></label></div>
                            </div>
                        </div>
                        <div class="table-responsive table mt-2" id="dataTable1" role="grid" aria-describedby="dataTable_info">
                            <table class="table dataTable my-0" id="dataTable">
                                <thead>
                                <tr>
                                    <th>学生ID</th>
                                    <th>姓名</th>
                                    <th>性别</th>
                                    <th>专业</th>
                                    <th>班级</th>
                                    <th>联系电话</th>
                                    <th>个人邮箱</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <input name = "path" id = "path" type = "hidden" value = "${pageContext.request.contextPath }"/>
                                <c:forEach var="student" items="${pageInfo.list}" >
                                    <tr>
                                        <td>
                                            <span>${student.studentId}</span>
                                        </td>
                                        <td>
                                            <span>${student.studentName}</span>
                                        </td>
                                        <td>
                                            <span>${student.studentSex}</span>
                                        </td>
                                        <td>
                                            <span>${student.studentMajor}</span>
                                        </td>
                                        <td>
                                            <span>${student.studentClass}</span>
                                        </td>
                                        <td>

                                            <span>${student.studentTel}</span>
                                        </td>
                                        <td>
                                            <span>${student.studentEmail}</span>
                                        </td>
                                        <td>
                                            <span><a class="viewStudent" href="javascript:;" studentId=${student.studentId} studentName=${student.studentName }><img src="${pageContext.request.contextPath }/assets/img/read.png" alt="修改" title="查看"/></a></span>
                                            <span><a class="modifyStudent"  href="javascript:;" studentId=${student.studentId } studentName=${student.studentName}><img src="${pageContext.request.contextPath }/assets/img/xiugai.png" alt="打分" title="打分"/></a></span>

                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                第${pageInfo.pageNum}页，共${pageInfo.pages}页，共${pageInfo.total}条记录
                            </div>
                            <div class="col-md-6 offset-md-4">
                                <nav aria-label="Page navigation example">
                                    <ul class="pagination pagination-sm">
                                        <li class="page-item"><a class="page-link" href="${BASE_PATH}/springmvc_mybatis_demo_war_exploded/studentList?page=1">首页</a></li>
                                        <c:if test="${pageInfo.hasPreviousPage}">
                                            <li class="page-item"><a class="page-link"
                                                                     href="${BASE_PATH}/springmvc_mybatis_demo_war_exploded/studentList?page=${pageInfo.pageNum-1}">上一页</a></li>
                                        </c:if>
                                        <c:forEach items="${pageInfo.navigatepageNums}" var="page">
                                            <c:if test="${page==pageInfo.pageNum}">
                                                <li class="page-item active"><a class="page-link" href="#">${page}</a></li>
                                            </c:if>
                                            <c:if test="${page!=pageInfo.pageNum}">
                                                <li class="page-item"><a class="page-link"
                                                                         href="${BASE_PATH}/springmvc_mybatis_demo_war_exploded/studentList?page=${page}">${page}</a></li>
                                            </c:if>
                                        </c:forEach>
                                        <c:if test="${pageInfo.hasNextPage}">
                                            <li class="page-item"><a class="page-link"
                                                                     href="${BASE_PATH}/springmvc_mybatis_demo_war_exploded/studentList?page=${pageInfo.pageNum+1}">下一页</a></li>
                                        </c:if>
                                        <li class="page-item"><a class="page-link" href="${BASE_PATH}/springmvc_mybatis_demo_war_exploded/studentList?page=${pageInfo.pages}">末页</a>
                                        </li>
                                    </ul>
                                </nav>
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