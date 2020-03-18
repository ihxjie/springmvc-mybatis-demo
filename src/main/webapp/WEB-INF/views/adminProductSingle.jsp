<%--
  Created by IntelliJ IDEA.
  User: xingj
  Date: 2019/12/12
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>商品详情</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i">
    <link rel="stylesheet" href="assets/fonts/fontawesome-all.min.css">
    <script type="text/javascript">
        var domainUrl = "${pageContext.request.contextPath}";
    </script>
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
                <h3 class="text-dark mb-4">商品详细信息</h3>
                <div class="row mb-3">
                    <div class="col-lg-3">
                        <div class="card shadow mb-3">
                            <div class="card-header py-3">
                                <p class="text-primary m-0 font-weight-bold">商品图片</p>
                            </div>
                            <div class="card-body text-center shadow">
                                <img src="${product.productPicture}" class="mb-3 mt-4" style="max-width: 300px;max-height: 160px" alt="商品图片" id="picture">
                                <hr>
                                <div class="mb-3">
                                    <form id="picUpload" enctype="multipart/form-data">
                                        <input name="uploadFile" type="file" id="uploadFile" onchange="picUpload()">
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-9">
                        <div class="row">
                            <div class="col">
                                <div class="card shadow mb-3">
                                    <div class="card-header py-3">
                                        <p class="text-primary m-0 font-weight-bold">商品详细信息</p>
                                    </div>
                                    <div class="card-body">
                                        <form id="productForm">
                                            <div class="form-row">
                                                <div class="col">

                                                    <input class="form-control" type="hidden" name="productId" value="${product.productId}">
                                                    <input class="form-control" type="hidden" name="productPicture" id="productPicture" value="${product.productPicture}">

                                                    <div class="form-group"><strong>商品名称</strong>
                                                        <input class="form-control" type="text" placeholder="商品名称" name="productName" value="${product.productName}">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-row">
                                                <div class="col">
                                                    <div class="form-group"><strong>商品原价</strong>
                                                        <input class="form-control" type="text" placeholder="商品原价" name="productOriginalPrice" value="${product.productOriginalPrice}">
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <div class="form-group"><strong>商品现价</strong>
                                                        <input class="form-control" type="text" placeholder="商品现价" name="productCurrentPrice" value="${product.productCurrentPrice}">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-row">
                                                <div class="col">
                                                    <div class="form-group"><strong>库存</strong>
                                                        <input class="form-control" type="text" placeholder="库存" name="productStock" value="${product.productStock}">
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <div class="form-group"><strong>类型</strong>
                                                        <input class="form-control" type="text" placeholder="类型" name="typeId" value="${product.typeId}">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group"><button class="btn btn-primary btn-sm" type="button" onclick="send()">提交更改</button></div>
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
                <div class="text-center my-auto copyright"><span>Copyright © Brand 2019</span></div>
            </div>
        </footer>
    </div><a class="border rounded d-inline scroll-to-top" href="#page-top"><i class="fas fa-angle-up"></i></a></div>
<script src="assets/js/jquery.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<script src="assets/js/chart.min.js"></script>
<script src="assets/js/bs-init.js"></script>
<script src="assets/js/productSingle-init.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.js"></script>
<script src="assets/js/theme.js"></script>

</body>

</html>
