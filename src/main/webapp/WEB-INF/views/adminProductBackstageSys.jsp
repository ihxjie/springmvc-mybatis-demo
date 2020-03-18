<%--
  Created by IntelliJ IDEA.
  User: xingj
  Date: 2019/12/1
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>商品管理</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i">
    <link rel="stylesheet" href="assets/fonts/fontawesome-all.min.css">
</head>

<body id="page-top">
<div id="wrapper">
    <div class="d-flex flex-column" id="content-wrapper">
        <div id="content">
            <nav class="navbar navbar-light navbar-expand bg-white shadow mb-4 topbar static-top">
                <div class="container-fluid"><button class="btn btn-link d-md-none rounded-circle mr-3" id="sidebarToggleTop" type="button"><i class="fas fa-bars"></i></button>
                    <a class="navbar-brand d-flex justify-content-center align-items-center sidebar-brand m-0" href="#">
                        <div class="sidebar-brand-icon rotate-n-15"><i class="fas fa-laugh-wink"></i></div>
                        <div class="sidebar-brand-text mx-3"><span>电子商务平台</span></div>
                    </a>
                    <ul class="nav navbar-nav flex-nowrap ml-auto">

                        <li class="nav-item dropdown no-arrow" role="presentation">
                            <div class="nav-item dropdown no-arrow"><a class="dropdown-toggle nav-link" data-toggle="dropdown" aria-expanded="false" href="#">
                                <span class="d-none d-lg-inline mr-2 text-gray-600 small">${username}</span>
                                <img class="border rounded-circle img-profile" src="assets/img/avatars/avatar1.jpeg"></a>
                                <div class="dropdown-menu shadow dropdown-menu-right animated--grow-in" role="menu">
                                    <a class="dropdown-item" role="presentation" href="${pageContext.request.contextPath}/logout"><i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>&nbsp;退出登录</a>
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>
            </nav>
            <div class="container-fluid">
                <h3 class="text-dark mb-4">控制台</h3>
                <div class="row">
                    <div class="col-md-6 col-xl-3 mb-4">
                        <div class="card shadow border-left-primary py-2">
                            <div class="card-body" href="handle/adminProductBackstageSys">
                                <div class="row align-items-center no-gutters">
                                    <div class="col mr-2">
                                        <div class="text-primary font-weight-bold h5 mb-0"><span>商品管理</span></div>
                                    </div>
                                    <div class="col-auto">
                                        <a href="handle/ProductBackstageSys">
                                            <i class="fas fa-calendar fa-2x text-primary"></i>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 col-xl-3 mb-4">
                        <div class="card shadow border-left-success py-2">
                            <div class="card-body">
                                <div class="row align-items-center no-gutters">
                                    <div class="col mr-2">
                                        <div class="text-success font-weight-bold h5 mb-0"><span>类型管理</span></div>
                                    </div>
                                    <div class="col-auto">
                                        <a href="handle/TypeBackstageSys" role="button">
                                            <i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 col-xl-3 mb-4">
                        <div class="card shadow border-left-info py-2">
                            <div class="card-body">
                                <div class="row align-items-center no-gutters">
                                    <div class="col mr-2">
                                        <div class="text-info font-weight-bold h5 mb-0 mr-3"><span>用户管理</span></div>
                                    </div>
                                    <div class="col-auto">
                                        <a href="handle/UserBackstageSys">
                                            <i class="fas fa-clipboard-list fa-2x text-gray-300"></i>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 col-xl-3 mb-4">
                        <div class="card shadow border-left-danger py-2">
                            <div class="card-body">
                                <div class="row align-items-center no-gutters">
                                    <div class="col mr-2">
                                        <div class="text-danger font-weight-bold h5 mb-0"><span>公告管理</span></div>
                                    </div>
                                    <div class="col-auto">
                                        <a href="handle/BorderBackstageSys">
                                            <i class="fas fa-calculator fa-2x text-gray-300"></i>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 col-xl-3 mb-4">
                        <div class="card shadow border-left-warning py-2">
                            <div class="card-body">
                                <div class="row align-items-center no-gutters">
                                    <div class="col mr-2">
                                        <div class="text-warning font-weight-bold h5 mb-0"><span>订单基础</span></div>
                                    </div>
                                    <div class="col-auto">
                                        <a href="handle/OrderBasisBackstageSys">
                                            <i class="fas fa-comments fa-2x text-gray-300"></i>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 col-xl-3 mb-4">
                        <div class="card shadow border-left-secondary py-2">
                            <div class="card-body">
                                <div class="row align-items-center no-gutters">
                                    <div class="col mr-2">
                                        <div class="text-secondary font-weight-bold h5 mb-0"><span>订单详情</span></div>
                                    </div>
                                    <div class="col-auto">
                                        <a href="handle/OrderDetailBackstageSys">
                                            <i class="fas fa-database fa-2x text-gray-300"></i>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="card shadow">
                    <div class="card-header py-3">
                        <p class="text-primary m-0 font-weight-bold">商品信息</p>
                    </div>
                    <div class="card-body">
                        <div class="row">
                            <div class="col-md-6 text-nowrap">
                                <div id="dataTable_length" class="dataTables_length" aria-controls="dataTable">
                                    <label>每一页的条数&nbsp;<select class="form-control form-control-sm custom-select custom-select-sm" id="pageSize">
                                        <option value="5">5</option>
                                        <option value="10">10</option>
                                        <option value="50">50</option>
                                        <option value="100">100</option></select>&nbsp
                                    </label>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="text-md-right dataTables_filter" id="dataTable_filter"><label>
                                    <input type="search" class="form-control form-control-sm" aria-controls="dataTable" placeholder="模糊搜索" id="search-box"></label>
                                    <label><a class='btn btn-primary btn-icon-split' role='button' href="product/new">
                                        <span class='text-white icon'><i class='fas fa-plus'></i> 新增商品</span></a>
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="table-responsive table mt-2" role="grid" aria-describedby="dataTable_info">
                            <table class="table dataTable my-0" id="dataTable">
                                <thead>
                                <tr>
                                    <th>产品名称</th>
                                    <th>产品原价</th>
                                    <th>产品现价</th>
                                    <th>产品库存</th>
                                    <th>产品图片</th>
                                    <th>产品类别</th>
                                    <th>编辑</th>
                                    <th>删除</th>
                                </tr>
                                </thead>
                                <tbody>
                                <%--ajax填入--%>

                                </tbody>
                                <tfoot>
                                <tr>
                                    <td><strong>产品名称</strong></td>
                                    <td><strong>产品原价</strong></td>
                                    <td><strong>产品现价</strong></td>
                                    <td><strong>产品库存</strong></td>
                                    <td><strong>产品图片</strong></td>
                                    <td><strong>产品类别</strong></td>
                                    <td><strong>编辑</strong></td>
                                    <td><strong>删除</strong></td>
                                </tr>
                                </tfoot>
                            </table>
                        </div>
                        <div class="row">
                            <div class="col-md-6 align-self-center">
                                <p id="dataTable_info" class="dataTables_info" role="status" aria-live="polite"></p>
                            </div>
                            <div class="col-md-6">
                                <nav class="d-lg-flex justify-content-lg-end dataTables_paginate paging_simple_numbers">
                                    <ul class="pagination">
                                        <li id="previous-page" class="page-item disabled">
                                            <a class="page-link" onclick="getPreviousPage()" aria-label="Previous" style="cursor: pointer">
                                                <span aria-hidden="true">«</span>
                                            </a>
                                        </li>
                                        <li id="page-num" class="page-item active">
                                            <a class="page-link" href="#">1</a>
                                        </li>
                                        <li id="next-page" class="page-item">
                                            <a class="page-link" onclick="getNextPage()" aria-label="Next" style="cursor: pointer">
                                                <span aria-hidden="true">»</span>
                                            </a>
                                        </li>
                                    </ul>
                                </nav>
                            </div>
                        </div>
                    </div>
                    <div class="card-body"></div>
                    <div class="card-body"></div>
                </div>
            </div>
        </div>
        <footer class="bg-white sticky-footer">
            <div class="container my-auto">
                <div class="text-center my-auto copyright"><span>Copyright © Brand 2019</span></div>
            </div>
        </footer>
    </div><a class="border rounded d-inline scroll-to-top" href="#page-top"><i class="fas fa-angle-up"></i></a></div>
<script src="assets/js/jquery.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<script src="assets/js/chart.min.js"></script>
<script src="assets/js/product-init.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.js"></script>
<script src="assets/js/theme.js"></script>
</body>

</html>
