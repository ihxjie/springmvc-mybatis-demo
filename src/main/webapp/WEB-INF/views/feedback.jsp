<%--
  Created by IntelliJ IDEA.
  User: xingj
  Date: 2020/3/25
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>反馈 - 实训系统</title>
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
                <div class="sidebar-brand-text mx-3"><span>实训系统</span></div>
            </a>
            <hr class="sidebar-divider my-0">
            <ul class="nav navbar-nav text-light" id="accordionSidebar">
                <c:forEach var="teacher" items="${teacherApply}">
                    <li class="nav-item" role="presentation"><a class="nav-link" style="cursor: pointer" onclick="setTeacher('${teacher.personId}','${teacher.personName}','${teacher.projectId}')">
                        <i class="fas fa-tachometer-alt"></i><span>${teacher.personName}</span></a></li>

                </c:forEach>
            </ul>
            <div class="text-center d-none d-md-inline"><button class="btn rounded-circle border-0" id="sidebarToggle" type="button"></button></div>
        </div>
    </nav>
    <div class="d-flex flex-column" id="content-wrapper">
        <div id="content">
            <nav class="navbar navbar-light navbar-expand bg-white shadow mb-4 topbar static-top">
                <div class="container-fluid"><button class="btn btn-link d-md-none rounded-circle mr-3" id="sidebarToggleTop" type="button"><i class="fas fa-bars"></i></button>
                    <form class="form-inline d-none d-sm-inline-block mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                        <div class="input-group">
                            <h1 id="teacherName">${teacherName}</h1>
                            <input id="teacherId" type="hidden" value="${teacherId}">
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
                        <li class="nav-item dropdown no-arrow mx-1" role="presentation"></li>
                        <li class="nav-item dropdown no-arrow mx-1" role="presentation">
                            <div class="shadow dropdown-list dropdown-menu dropdown-menu-right" aria-labelledby="alertsDropdown"></div>
                        </li>
                        <div class="d-none d-sm-block topbar-divider"></div>
                        <li class="nav-item dropdown no-arrow" role="presentation">
                            <div class="nav-item dropdown no-arrow"><a class="dropdown-toggle nav-link" data-toggle="dropdown" aria-expanded="false" href="#">
                                <span class="d-none d-lg-inline mr-2 text-gray-600 small">${username}</span><img class="border rounded-circle img-profile" src="assets/img/avatars/avatar1.jpeg"></a>
                                <div class="dropdown-menu shadow dropdown-menu-right animated--grow-in" role="menu">
                                    <div class="dropdown-divider"></div><a class="dropdown-item" role="presentation" href="${pageContext.request.contextPath}/logout">
                                    <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>&nbsp;退出登录</a></div>
                            </div>
                        </li>
                    </ul>
                </div>
            </nav>
            <div class="container-fluid">
                <div class="card shadow mb-4">
                    <div class="card-header py-3">
                        <h6 class="text-primary font-weight-bold m-0">老师满意度评选</h6>
                    </div>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">
                            <div class="row align-items-center no-gutters">
                                <div class="col mr-2">
                                    <h6 class="mb-0"><strong>老师不随意调停课，从不迟到和早退</strong></h6>
                                </div>
                                <div class="col-auto">
                                    <div class="custom-control custom-radio"><input class="custom-control-input" type="radio" id="formCheck-1-1" name="option1" value="20">
                                        <label class="custom-control-label" for="formCheck-1-1">满意&nbsp;&nbsp;</label></div>
                                </div>
                                <div class="col-auto">
                                    <div class="custom-control custom-radio"><input class="custom-control-input" type="radio" id="formCheck-1-2" name="option1" value="10">
                                        <label class="custom-control-label" for="formCheck-1-2">一般&nbsp;&nbsp;</label></div>
                                </div>
                                <div class="col-auto">
                                    <div class="custom-control custom-radio"><input class="custom-control-input" type="radio" id="formCheck-1-3" name="option1" value="0">
                                        <label class="custom-control-label" for="formCheck-1-3">差</label></div>
                                </div>
                            </div>
                        </li>
                        <li class="list-group-item">
                            <div class="row align-items-center no-gutters">
                                <div class="col mr-2">
                                    <h6 class="mb-0"><strong>老师讲解清楚明白，易于接受</strong></h6>
                                </div>
                                <div class="col-auto">
                                    <div class="custom-control custom-radio"><input class="custom-control-input" type="radio" id="formCheck-2-1" name="option2" value="20">
                                        <label class="custom-control-label" for="formCheck-2-1">满意&nbsp;&nbsp;</label></div>
                                </div>
                                <div class="col-auto">
                                    <div class="custom-control custom-radio"><input class="custom-control-input" type="radio" id="formCheck-2-2" name="option2" value="10">
                                        <label class="custom-control-label" for="formCheck-2-2">一般&nbsp;&nbsp;</label></div>
                                </div>
                                <div class="col-auto">
                                    <div class="custom-control custom-radio"><input class="custom-control-input" type="radio" id="formCheck-2-3" name="option2" value="0">
                                        <label class="custom-control-label" for="formCheck-2-3">差</label></div>
                                </div>
                            </div>
                        </li>
                        <li class="list-group-item">
                            <div class="row align-items-center no-gutters">
                                <div class="col mr-2">
                                    <h6 class="mb-0"><strong>上课能联系实际，注重培养运用能力</strong></h6>
                                </div>
                                <div class="col-auto">
                                    <div class="custom-control custom-radio"><input class="custom-control-input" type="radio" id="formCheck-3-1" name="option3" value="20">
                                        <label class="custom-control-label" for="formCheck-3-1">满意&nbsp;&nbsp;</label></div>
                                </div>
                                <div class="col-auto">
                                    <div class="custom-control custom-radio"><input class="custom-control-input" type="radio" id="formCheck-3-2" name="option3" value="10">
                                        <label class="custom-control-label" for="formCheck-3-2">一般&nbsp;&nbsp;</label></div>
                                </div>
                                <div class="col-auto">
                                    <div class="custom-control custom-radio"><input class="custom-control-input" type="radio" id="formCheck-3-3" name="option3" value="0">
                                        <label class="custom-control-label" for="formCheck-3-3">差</label></div>
                                </div>
                            </div>
                        </li>
                        <li class="list-group-item">
                            <div class="row align-items-center no-gutters">
                                <div class="col mr-2">
                                    <h6 class="mb-0"><strong>老师授课方式灵活多样，生动有趣善于引导学生思考、鼓励学生提问，和参与课堂的讨论</strong></h6>
                                </div>
                                <div class="col-auto">
                                    <div class="custom-control custom-radio"><input class="custom-control-input" type="radio" id="formCheck-4-1" name="option4" value="20">
                                        <label class="custom-control-label" for="formCheck-4-1">满意&nbsp;&nbsp;</label></div>
                                </div>
                                <div class="col-auto">
                                    <div class="custom-control custom-radio"><input class="custom-control-input" type="radio" id="formCheck-4-2" name="option4" value="10">
                                        <label class="custom-control-label" for="formCheck-4-2">一般&nbsp;&nbsp;</label></div>
                                </div>
                                <div class="col-auto">
                                    <div class="custom-control custom-radio"><input class="custom-control-input" type="radio" id="formCheck-4-3" name="option4" value="0">
                                        <label class="custom-control-label" for="formCheck-4-3">差</label></div>
                                </div>
                            </div>
                        </li>
                        <li class="list-group-item">
                            <div class="row align-items-center no-gutters">
                                <div class="col mr-2">
                                    <h6 class="mb-0"><strong>老师批改作业及时、认真，有反馈，辅导答疑耐心仔细</strong></h6>
                                </div>
                                <div class="col-auto">
                                    <div class="custom-control custom-radio"><input class="custom-control-input" type="radio" id="formCheck-5-1" name="option5" value="20">
                                        <label class="custom-control-label" for="formCheck-5-1">满意&nbsp;&nbsp;</label></div>
                                </div>
                                <div class="col-auto">
                                    <div class="custom-control custom-radio"><input class="custom-control-input" type="radio" id="formCheck-5-2" name="option5" value="10">
                                        <label class="custom-control-label" for="formCheck-5-2">一般&nbsp;&nbsp;</label></div>
                                </div>
                                <div class="col-auto">
                                    <div class="custom-control custom-radio"><input class="custom-control-input" type="radio" id="formCheck-5-3" name="option5" value="0">
                                        <label class="custom-control-label" for="formCheck-5-3">差</label></div>
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>
                <div class="card shadow mb-4">
                    <div class="card-header py-3">
                        <h6 class="text-primary font-weight-bold m-0">对自己的评价</h6>
                    </div>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">
                            <div class="row align-items-center no-gutters">
                                <div class="col mr-2">
                                    <h6 class="mb-0"><strong>了解本次实训的教学目的</strong></h6>
                                </div>
                                <div class="col-auto">
                                    <div class="custom-control custom-radio"><input class="custom-control-input" type="radio" id="formCheck-6-1" name="option6" value="20">
                                        <label class="custom-control-label" for="formCheck-6-1">满意&nbsp;&nbsp;</label></div>
                                </div>
                                <div class="col-auto">
                                    <div class="custom-control custom-radio"><input class="custom-control-input" type="radio" id="formCheck-6-2" name="option6" value="10">
                                        <label class="custom-control-label" for="formCheck-6-2">一般&nbsp;&nbsp;</label></div>
                                </div>
                                <div class="col-auto">
                                    <div class="custom-control custom-radio"><input class="custom-control-input" type="radio" id="formCheck-6-3" name="option6" value="0">
                                        <label class="custom-control-label" for="formCheck-6-3">差</label></div>
                                </div>
                            </div>
                        </li>
                        <li class="list-group-item">
                            <div class="row align-items-center no-gutters">
                                <div class="col mr-2">
                                    <h6 class="mb-0"><strong>自己通过本次实训已达到学习目的</strong></h6>
                                </div>
                                <div class="col-auto">
                                    <div class="custom-control custom-radio"><input class="custom-control-input" type="radio" id="formCheck-7-1" name="option7" value="20">
                                        <label class="custom-control-label" for="formCheck-7-1">满意&nbsp;&nbsp;</label></div>
                                </div>
                                <div class="col-auto">
                                    <div class="custom-control custom-radio"><input class="custom-control-input" type="radio" id="formCheck-7-2" name="option7" value="10">
                                        <label class="custom-control-label" for="formCheck-7-2">一般&nbsp;&nbsp;</label></div>
                                </div>
                                <div class="col-auto">
                                    <div class="custom-control custom-radio"><input class="custom-control-input" type="radio" id="formCheck-7-3" name="option7" value="0">
                                        <label class="custom-control-label" for="formCheck-7-3">差</label></div>
                                </div>
                            </div>
                        </li>
                        <li class="list-group-item">
                            <div class="row align-items-center no-gutters">
                                <div class="col mr-2">
                                    <h6 class="mb-0"><strong>通过本次实训，对你的团队合作、人际交往等综合素养有提高</strong></h6>
                                </div>
                                <div class="col-auto">
                                    <div class="custom-control custom-radio"><input class="custom-control-input" type="radio" id="formCheck-8-1" name="option8" value="20">
                                        <label class="custom-control-label" for="formCheck-8-1">满意&nbsp;&nbsp;</label></div>
                                </div>
                                <div class="col-auto">
                                    <div class="custom-control custom-radio"><input class="custom-control-input" type="radio" id="formCheck-8-2" name="option8" value="10">
                                        <label class="custom-control-label" for="formCheck-8-2">一般&nbsp;&nbsp;</label></div>
                                </div>
                                <div class="col-auto">
                                    <div class="custom-control custom-radio"><input class="custom-control-input" type="radio" id="formCheck-8-3" name="option8" value="0">
                                        <label class="custom-control-label" for="formCheck-8-3">差</label></div>
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>
                <div class="row">
                    <div class="col-lg-6 col-xl-3 offset-xl-0 mb-4">
                        <a class="btn btn-success btn-icon-split" role="button" onclick="submit_evaluate()">
                            <span class="text-white-50 icon"><i class="fas fa-check"></i></span>
                            <span class="text-white text">提交评价</span></a></div>
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
<script src="assets/js/feedback-js.js"></script>
</body>

</html>