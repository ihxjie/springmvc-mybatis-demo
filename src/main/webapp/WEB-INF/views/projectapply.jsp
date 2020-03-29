<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/3/22
  Time: 21:01
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page  contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html xmlns:c="http://www.w3.org/1999/XSL/Transform">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>教师查看申报项目情况</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/fonts/fontawesome-all.min.css">
    <script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/projectapply.js"></script>
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
            <div class="table-responsive table mt-2" id="dataTable1" role="grid" aria-describedby="dataTable_info">
                <table class="table dataTable my-0" id="dataTable">
                    <thead>
                    <tr>
                        <th>项目ID</th>
                        <th>项目标题</th>
                        <th>项目周期</th>
                        <th>实训地址</th>
                        <th>报名费用</th>
                        <th>审核状态</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <input name = "path" id = "path" type = "hidden" value = "${pageContext.request.contextPath }"/>
                    <c:forEach var="project" items="${projectList}" varStatus="status">

                        <tr>
                            <td>
                                <span>${project.projectId}</span>
                            </td>
                            <td>
                                <span>${project.projectTitle}</span>
                            </td>
                            <td>
                                <span>${project.period}</span>
                            </td>
                            <td>
                                <span>${project.projectAddress}</span>
                            </td>
                            <td>

                                <span>${project.projectPrice}</span>
                            </td>
                            <td>
                                <span>
                                    <c:if test="${project.status==-1}">审核不通过</c:if>
                                    <c:if test="${project.status==0}">待审核</c:if>
                                    <c:if test="${project.status==1}">审核通过</c:if>
                                </span>
                            </td>
                            <td>
                                <span>
                                    <c:if test="${project.status==-1}">
                                     <span>无法操作</span>
                                    </c:if>
                                    <c:if test="${project.status==0}">
                                     <span>暂时无法操作</span>
                                    </c:if>
                                    <c:if test="${project.status==1}">
                                     <a class="viewProject" href="javascript:;" projectId=${project.projectId }  >查看学生报名信息</a>
                                    </c:if>
                                </span>
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
                            <li class="page-item"><a class="page-link" href="${BASE_PATH}/springmvc_mybatis_demo_war_exploded/sys/applylist/pass.html?page=1">首页</a></li>
                            <c:if test="${pageInfo.hasPreviousPage}">
                                <li class="page-item"><a class="page-link"
                                                         href="${BASE_PATH}/springmvc_mybatis_demo_war_exploded/sys/applylist/pass.html?page=${pageInfo.pageNum-1}">上一页</a></li>
                            </c:if>
                            <c:forEach items="${pageInfo.navigatepageNums}" var="page">
                                <c:if test="${page==pageInfo.pageNum}">
                                    <li class="page-item active"><a class="page-link" href="#">${page}</a></li>
                                </c:if>
                                <c:if test="${page!=pageInfo.pageNum}">
                                    <li class="page-item"><a class="page-link"
                                                             href="${BASE_PATH}/springmvc_mybatis_demo_war_exploded/sys/applylist/pass.html?page=${page}">${page}</a></li>
                                </c:if>
                            </c:forEach>
                            <c:if test="${pageInfo.hasNextPage}">
                                <li class="page-item"><a class="page-link"
                                                         href="${BASE_PATH}/springmvc_mybatis_demo_war_exploded/sys/applylist/pass.html?page=${pageInfo.pageNum+1}">下一页</a></li>
                            </c:if>
                            <li class="page-item"><a class="page-link" href="${BASE_PATH}/springmvc_mybatis_demo_wa_explodedr/sys/applylist/pass.html?page=${pageInfo.pages}">末页</a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>

        </div><a class="border rounded d-inline scroll-to-top" href="#page-top"><i class="fas fa-angle-up"></i></a></div>
    <script src="${pageContext.request.contextPath }/assets/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath }/assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath }/assets/js/chart.min.js"></script>
    <script src="${pageContext.request.contextPath }/assets/js/bs-init.js"></script>
    <script src="${pageContext.request.contextPath }/https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.js"></script>
    <script src="${pageContext.request.contextPath }/assets/js/theme.js"></script>
</div>
</body>

</html>