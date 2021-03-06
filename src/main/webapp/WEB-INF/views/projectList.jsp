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
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Dashboard - Brand</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/assets/bootstrap/css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/assets/fonts/fontawesome-all.min.css">
    <script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/projectList.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/admin.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/deleteProjects.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/updatestudent.js"></script>
    <script type="text/javascript">
        function d(){
            window.location.href="${pageContext.request.contextPath}/sys/projectController/excel";
        }
    </script>

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
                <li class="nav-item" role="presentation"><a class="nav-link active" href="adminindex.html"><i class="fas fa-tachometer-alt"></i><span>个人中心</span></a></li>
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
                    <div class="input-group">
                        <form method="post" action="${pageContext.request.contextPath }/sys/projectList/looklist.html">
                            <span>项目id：</span>
                            <input name="projectId" id="projectId" class="input-text"	type="text" value="${projectId}">
                            <!-- 刚开始让其为1 在点击下一页后，value=2，然后在后台获取数据 -->
                            <input type="hidden" name="page" value="1"/>
                            <button class="class=btn btn-primary py-0" type="submit" value="查询"></button>
                        </form>

                    </div>
                    <ul class="nav navbar-nav flex-nowrap ml-auto">
                        <li class="nav-item dropdown d-sm-none no-arrow"><a class="dropdown-toggle nav-link" data-toggle="dropdown" aria-expanded="false" href="#"><i class="fas fa-search"></i></a>
                            <div class="dropdown-menu dropdown-menu-right p-3 animated--grow-in" role="menu" aria-labelledby="searchDropdown">
                                <form class="form-inline mr-auto navbar-search w-100">
                                    <div class="input-group"><input class="bg-light form-control border-0 small" type="text" placeholder="Search for ...">
                                        <div class="input-group-append"><button class="btn btn-primary py-0" type="button"><i class="fas fa-search"></i></button></div>
                                    </div>
                                </form>
                            </div>
                        </li>
                        <li class="nav-item dropdown no-arrow mx-1" role="presentation">
                            <div class="nav-item dropdown no-arrow"><a class="dropdown-toggle nav-link" data-toggle="dropdown" aria-expanded="false" href="#"><span class="badge badge-danger badge-counter">3+</span><i class="fas fa-bell fa-fw"></i></a>
                                <div class="dropdown-menu dropdown-menu-right dropdown-list dropdown-menu-right animated--grow-in"
                                     role="menu">
                                    <h6 class="dropdown-header">alerts center</h6>
                                    <a class="d-flex align-items-center dropdown-item" href="#">
                                        <div class="mr-3">
                                            <div class="bg-primary icon-circle"><i class="fas fa-file-alt text-white"></i></div>
                                        </div>
                                        <div><span class="small text-gray-500">December 12, 2019</span>
                                            <p>A new monthly report is ready to download!</p>
                                        </div>
                                    </a>
                                    <a class="d-flex align-items-center dropdown-item" href="#">
                                        <div class="mr-3">
                                            <div class="bg-success icon-circle"><i class="fas fa-donate text-white"></i></div>
                                        </div>
                                        <div><span class="small text-gray-500">December 7, 2019</span>
                                            <p>$290.29 has been deposited into your account!</p>
                                        </div>
                                    </a>
                                    <a class="d-flex align-items-center dropdown-item" href="#">
                                        <div class="mr-3">
                                            <div class="bg-warning icon-circle"><i class="fas fa-exclamation-triangle text-white"></i></div>
                                        </div>
                                        <div><span class="small text-gray-500">December 2, 2019</span>
                                            <p>Spending Alert: We've noticed unusually high spending for your account.</p>
                                        </div>
                                    </a><a class="text-center dropdown-item small text-gray-500" href="#">Show All Alerts</a></div>
                            </div>
                        </li>
                        <li class="nav-item dropdown no-arrow mx-1" role="presentation">
                            <div class="nav-item dropdown no-arrow"><a class="dropdown-toggle nav-link" data-toggle="dropdown" aria-expanded="false" href="#"><i class="fas fa-envelope fa-fw"></i><span class="badge badge-danger badge-counter">7</span></a>
                                <div class="dropdown-menu dropdown-menu-right dropdown-list dropdown-menu-right animated--grow-in"
                                     role="menu">
                                    <h6 class="dropdown-header">alerts center</h6>
                                    <a class="d-flex align-items-center dropdown-item" href="#">
                                        <div class="dropdown-list-image mr-3"><img class="rounded-circle" src="assets/img/avatars/avatar4.jpeg">
                                            <div class="bg-success status-indicator"></div>
                                        </div>
                                        <div class="font-weight-bold">
                                            <div class="text-truncate"><span>Hi there! I am wondering if you can help me with a problem I've been having.</span></div>
                                            <p class="small text-gray-500 mb-0">Emily Fowler - 58m</p>
                                        </div>
                                    </a>
                                    <a class="d-flex align-items-center dropdown-item" href="#">
                                        <div class="dropdown-list-image mr-3"><img class="rounded-circle" src="assets/img/avatars/avatar2.jpeg">
                                            <div class="status-indicator"></div>
                                        </div>
                                        <div class="font-weight-bold">
                                            <div class="text-truncate"><span>I have the photos that you ordered last month!</span></div>
                                            <p class="small text-gray-500 mb-0">Jae Chun - 1d</p>
                                        </div>
                                    </a>
                                    <a class="d-flex align-items-center dropdown-item" href="#">
                                        <div class="dropdown-list-image mr-3"><img class="rounded-circle" src="assets/img/avatars/avatar3.jpeg">
                                            <div class="bg-warning status-indicator"></div>
                                        </div>
                                        <div class="font-weight-bold">
                                            <div class="text-truncate"><span>Last month's report looks great, I am very happy with the progress so far, keep up the good work!</span></div>
                                            <p class="small text-gray-500 mb-0">Morgan Alvarez - 2d</p>
                                        </div>
                                    </a>
                                    <a class="d-flex align-items-center dropdown-item" href="#">
                                        <div class="dropdown-list-image mr-3"><img class="rounded-circle" src="assets/img/avatars/avatar5.jpeg">
                                            <div class="bg-success status-indicator"></div>
                                        </div>
                                        <div class="font-weight-bold">
                                            <div class="text-truncate"><span>Am I a good boy? The reason I ask is because someone told me that people say this to all dogs, even if they aren't good...</span></div>
                                            <p class="small text-gray-500 mb-0">Chicken the Dog · 2w</p>
                                        </div>
                                    </a><a class="text-center dropdown-item small text-gray-500" href="#">Show All Alerts</a></div>
                            </div>
                            <div class="shadow dropdown-list dropdown-menu dropdown-menu-right" aria-labelledby="alertsDropdown"></div>
                        </li>
                        <div class="d-none d-sm-block topbar-divider"></div>
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
            <div class="container-fluid">
                <h3 class="text-dark mb-4">Team</h3>
                <div class="card shadow">
                    <div class="card-header py-3">
                        <p class="text-primary m-0 font-weight-bold">Employee Info</p>
                    </div>
                    <div class="card-body">
                        <div class="row">
                            <div class="col-md-6 text-nowrap">
                                <button><a name="delAllProject" id = "delAllProject" href="#" >批量删除</a></button>
                            </div>
                            <div>
                                <button onclick="d()">导出</button>
                            </div>
                        </div>


                        <div class="table-responsive table mt-2" id="dataTable1" role="grid" aria-describedby="dataTable_info">
                            <table class="table dataTable my-0" id="dataTable" width:max-content>
                                <thead>
                                <tr>
                                    <th>项目id</th>
                                    <th>项目负责</th>
                                    <th>负责方账号</th>
                                    <th>项目周期</th>
                                    <th>项目名称</th>
                                    <th>项目地址</th>
                                    <th>报名费用</th>
                                    <th>审核状态</th>
                                    <th>操作</th>
                                    <th>审核</th>
                                </tr>
                                </thead>
                                <input name = "path" id = "path" type = "hidden" value = "${pageContext.request.contextPath }"/>
                                <c:forEach var="tests" items="${pageInfo.list}" varStatus="status">
                                    <tr>
                                        <td>
                                            <input type="checkbox" name = "cbox" id = "cbox">
                                            <span class = "id">${tests.projectId}</span>
                                        </td>
                                        <td>
                                            <span>
								                <c:if test="${tests.isCompany==0}">学校</c:if>
								                <c:if test="${tests.isCompany==1}">公司</c:if>
							                </span>
                                        </td>
                                        <td>
                                            <span>${tests.workId}</span>
                                        </td>
                                        <td>
                                            <span>${tests.period}</span>
                                        </td>
                                        <td>
                                            <span>${tests.projectTitle}</span>
                                        </td>
                                        <td>
                                            <span>${tests.projectAddress}</span>
                                        </td>
                                        <td>

                                            <span>${tests.projectPrice}</span>
                                        </td>
                                        <td>

                                            <c:if test="${tests.status==0}">待审核</c:if>
                                            <c:if test="${tests.status==1}">审核通过</c:if>
                                            <c:if test="${tests.status==-1}">审核不通过</c:if>
                                        </td>
                                        <td>
                                            <span><a class="viewProject" href="javascript:;" projectId=${tests.projectId} ><img src="${pageContext.request.contextPath }/assets/img/read.png" alt="查看" title="查看"></a></span>
                                            <span><a class="modifyProject"  href="javascript:;" projectId=${tests.projectId} ><img src="${pageContext.request.contextPath }/assets/img/xiugai.png" alt="修改" title="修改"/></a></span>

                                        </td>
                                        <td>
                                            <c:if test="${tests.status==0}">
                                                <a class="projectOpen"  projectId=${tests.projectId} projectTitle=${tests.projectTitle} >通过</a>
                                                <a class="projectRefuse"  projectId=${tests.projectId} projectTitle=${tests.projectTitle} >不通过</a>
                                            </c:if>
                                            <c:if test="${tests.status==-1}">
                                            <form id="testsForm" name="testsForm" method="post" action="${pageContext.request.contextPath }/sys/projectRefuse/modifysave.html">
                                                <input type = "hidden" id = "path2" name = "path2" value = "${pageContext.request.contextPath }">
                                                <div class="form-group">
                                                    <label for="projectId"><strong>项目id</strong></label><input class="form-control" type="text" name="projectId" id="projectId" value="${tests.projectId }">
                                                </div>
                                                <textarea id="refuse" name = "refuse" class="form-control" placeholder="请输入不通过理由"  required="required" cols="8" rows="6"></textarea>
                                                <!--
                                                <div class="form-row">
                                                    <div class="col">
                                                        <div class="form-group"><label for="projectId"><strong>报名id</strong></label><input class="form-control" type="text" name="projectId" id="projectId" value="${tests.projectId }"></div>
                                                    </div>
                                                    <div class="col">
                                                       <div class="form-group"><label for="refuse"><strong>报名id</strong></label><input class="form-control" type="text" name="refuse" id="refuse" value="${reason.refuse }"></div>
                                                    </div>
                                                </div>-->
                                                <button class="btn btn-primary btn-sm" type="submit" name="add" id="add" value="修改">Save Settings</button>
                                            </form>
                                            </c:if>

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
                                        <li class="page-item"><a class="page-link" href="${BASE_PATH}/springmvc_mybatis_demo_war/projectList?page=1">首页</a></li>
                                        <c:if test="${pageInfo.hasPreviousPage}">
                                            <li class="page-item"><a class="page-link"
                                                                     href="${BASE_PATH}/springmvc_mybatis_demo_war/projectList?page=${pageInfo.pageNum-1}">上一页</a></li>
                                        </c:if>
                                        <c:forEach items="${pageInfo.navigatepageNums}" var="page">
                                            <c:if test="${page==pageInfo.pageNum}">
                                                <li class="page-item active"><a class="page-link" href="#">${page}</a></li>
                                            </c:if>
                                            <c:if test="${page!=pageInfo.pageNum}">
                                                <li class="page-item"><a class="page-link"
                                                                         href="${BASE_PATH}/springmvc_mybatis_demo_war/projectList?page=${page}">${page}</a></li>
                                            </c:if>
                                        </c:forEach>
                                        <c:if test="${pageInfo.hasNextPage}">
                                            <li class="page-item"><a class="page-link"
                                                                     href="${BASE_PATH}/springmvc_mybatis_demo_war/projectList?page=${pageInfo.pageNum+1}">下一页</a></li>
                                        </c:if>
                                        <li class="page-item"><a class="page-link" href="${BASE_PATH}/springmvc_mybatis_demo_war/projectList?page=${pageInfo.pages}">末页</a>
                                        </li>
                                    </ul>
                                </nav>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <footer class="bg-white sticky-footer">
            <div class="container my-auto">
                <div class="text-center my-auto copyright"><span>Copyright © Brand 2020</span></div>
            </div>
        </footer>
    </div>
</div>

</body>
</html>
