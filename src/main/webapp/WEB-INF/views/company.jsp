<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>公司信息 - 实训系统</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i">
    <link rel="stylesheet" href="assets/fonts/fontawesome-all.min.css">
</head>

<body id="page-top">
<div id="wrapper">
    <nav class="navbar navbar-dark align-items-start sidebar sidebar-dark accordion bg-gradient-primary p-0">
        <div class="container-fluid d-flex flex-column p-0">
            <a class="navbar-brand d-flex justify-content-center align-items-center sidebar-brand m-0" href="#">
                <div class="sidebar-brand-icon rotate-n-15"><i class="fas fa-laugh-wink"></i></div>
                <div class="sidebar-brand-text mx-3"><span>BRAND</span></div>
            </a>
            <hr class="sidebar-divider my-0">
            <ul class="nav navbar-nav text-light" id="accordionSidebar">
                <li class="nav-item" role="presentation"><a class="nav-link" href="${pageContext.request.contextPath}/company">
                    <i class="fas fa-info-circle"></i><span>&nbsp;查看/修改公司信息</span></a></li>
                <hr class="sidebar-divider">
                <div class="sidebar-heading">
                    <p class="mb-0">实训</p>
                </div>
                <li class="nav-item" role="presentation"><a class="nav-link" href="${pageContext.request.contextPath}/new_project"><i class="fas fa-info-circle"></i><span>&nbsp;发布新实训</span></a></li>
                <li class="nav-item" role="presentation">
                    <div>
                        <a class="btn btn-link nav-link" data-toggle="collapse" aria-expanded="false" aria-controls="collapse-1" href="#collapse-1" role="button">
                        <i class="far fa-list-alt"></i>&nbsp;<span>查看已申报的实训项目</span></a>
                        <div class="collapse" id="collapse-1">
                            <div class="bg-white border rounded py-2 collapse-inner">
                                <h6 class="collapse-header">正在审核的项目:</h6>
                                <c:forEach var="applying" items="${applyingList}">
                                    <a class="collapse-item" href="${pageContext.request.contextPath}/view/${applying.projectId}">${applying.projectTitle}</a>
                                </c:forEach>
                                <h6 class="collapse-header text-danger">被拒绝的项目:</h6>
                                <c:forEach var="rejected" items="${rejectedList}">
                                    <a class="collapse-item" href="${pageContext.request.contextPath}/rejected/${rejected.projectId}">${rejected.projectTitle}</a>
                                </c:forEach>
                                <h6 class="collapse-header text-success">已经审核通过的项目:</h6>
                                <c:forEach var="passed" items="${passedList}">
                                    <a class="collapse-item" href="${pageContext.request.contextPath}/view/${passed.projectId}">${passed.projectTitle}</a>
                                </c:forEach>

                            </div>
                        </div>
                    </div>
                </li>
                <hr class="sidebar-divider">
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
                        <li class="nav-item dropdown d-sm-none no-arrow"><a class="dropdown-toggle nav-link" data-toggle="dropdown" aria-expanded="false" href="#"><i class="fas fa-search"></i></a>
                            <div class="dropdown-menu dropdown-menu-right p-3 animated--grow-in" role="menu" aria-labelledby="searchDropdown">
                                <form class="form-inline mr-auto navbar-search w-100">
                                    <div class="input-group"><input class="bg-light form-control border-0 small" type="text" placeholder="Search for ...">
                                        <div class="input-group-append"><button class="btn btn-primary py-0" type="button"><i class="fas fa-search"></i></button></div>
                                    </div>
                                </form>
                            </div>
                        </li>
                        <div class="d-none d-sm-block topbar-divider"></div>
                        <li class="nav-item dropdown no-arrow" role="presentation">
                            <div class="nav-item dropdown no-arrow"><a class="dropdown-toggle nav-link" data-toggle="dropdown" aria-expanded="false" href="#">
                                <span class="d-none d-lg-inline mr-2 text-gray-600 small">${username}</span><img class="border rounded-circle img-profile" src="assets/img/avatars/avatar1.jpeg"></a>
                                <div class="dropdown-menu shadow dropdown-menu-right animated--grow-in" role="menu">
                                    <a class="dropdown-item" role="presentation" href="${pageContext.request.contextPath}/logout">
                                        <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>&nbsp;退出登录</a></div>
                            </div>
                        </li>
                    </ul>
                </div>
            </nav>
            <div class="container-fluid">
                <h3 class="text-dark mb-4">公司信息</h3>
                <div class="row mb-3">
                    <div class="col-lg-8 col-xl-12">
                        <div class="row">
                            <div class="col-xl-12 offset-xl-0">
                                <div class="card shadow mb-3">
                                    <div class="card-header py-3">
                                        <p class="text-primary m-0 font-weight-bold">公司基本信息</p>
                                    </div>
                                    <div class="card-body">
                                        <form method="post" action="${pageContext.request.contextPath}/company_information_modify">
                                            <div class="form-row">
                                                <div class="col">
                                                    <div class="form-group"><label for="companyId"><strong>公司ID</strong></label>
                                                        <input class="form-control" id="companyId" type="text" placeholder="company.id" name="companyId" readonly="" value="${company.companyId}"></div>
                                                </div>
                                                <div class="col">
                                                    <div class="form-group"><label for="companyPassword"><strong>公司密码</strong><br></label>
                                                        <input id="companyPassword" type="password" class="form-control" placeholder="******" name="companyPassword" value="${company.companyPwd}" /></div>
                                                </div>
                                            </div>
                                            <div class="form-row">
                                                <div class="col">
                                                    <div class="form-group"><label for="companyName"><strong>公司名称</strong><br></label>
                                                        <input id="companyName" class="form-control" type="text" placeholder="Microsoft" name="companyName" value="${company.companyName}"></div>
                                                </div>
                                                <div class="col">
                                                    <div class="form-group"><label for="companyAddress"><strong>公司地址</strong><br></label>
                                                        <input id="companyAddress" class="form-control" type="text" placeholder="Doe" name="companyAddress" value="${company.companyAddress}"></div>
                                                </div>
                                            </div>
                                            <div class="form-group"><button class="btn btn-primary btn-xl" type="submit">更新信息</button></div>
                                        </form>
                                    </div>
                                </div>
                                <div class="card shadow">
                                    <div class="card-header py-3">
                                        <p class="text-primary m-0 font-weight-bold">公司联系信息</p>
                                    </div>
                                    <div class="card-body">
                                        <form method="post" action="${pageContext.request.contextPath}/company_information_modify">
                                            <div class="form-group"><label for="contactName"><strong>联系人姓名</strong><br></label>
                                                <input id="contactName" class="form-control" type="text" placeholder="张三" name="contactName" value="${company.contactName}"></div>
                                            <div class="form-row">
                                                <div class="col">
                                                    <div class="form-group"><label for="contactTel"><strong>联系人电话</strong></label>
                                                        <input id="contactTel" class="form-control" type="text" placeholder="xxx-xxxx-xxxx" name="contactTel" value="${company.contactTel}"></div>
                                                </div>
                                            </div>
                                            <div class="form-group"><button class="btn btn-primary btn-xl" type="submit">更新信息</button></div>
                                        </form>
                                    </div>
                                </div>
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
    </div><a class="border rounded d-inline scroll-to-top" href="#page-top"><i class="fas fa-angle-up"></i></a></div>
<script src="assets/js/jquery.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<script src="assets/js/chart.min.js"></script>
<script src="assets/js/bs-init.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.js"></script>
<script src="assets/js/theme.js"></script>
</body>

</html>