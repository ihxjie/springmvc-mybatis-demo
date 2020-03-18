<%--
  Created by IntelliJ IDEA.
  User: Captivate
  Date: 2019/12/9
  Time: 21:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link href="assets/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
    <!-- Custom Theme files -->
    <!--theme-style-->
    <link href="assets/css/style.css" rel="stylesheet" type="text/css" media="all" />
    <!--//theme-style-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Shopin Responsive web template, Bootstrap Web Templates, Flat Web Templates, AndroId Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!--theme-style-->
    <link href="assets/css/style4.css" rel="stylesheet" type="text/css" media="all" />
    <!--//theme-style-->
    <script src="js/jquery.min.js"></script>
    <!--- start-rate---->
    <script src="assets/js/jstarbox.js"></script>
    <link rel="stylesheet" href="assets/css/jstarbox.css" type="text/css" media="screen" charset="utf-8" />
    <script type="text/javascript">
        jQuery(function() {
            jQuery('.starbox').each(function() {
                var starbox = jQuery(this);
                starbox.starbox({
                    average: starbox.attr('data-start-value'),
                    changeable: starbox.hasClass('unchangeable') ? false : starbox.hasClass('clickonce') ? 'once' : true,
                    ghosting: starbox.hasClass('ghosting'),
                    autoUpdateAverage: starbox.hasClass('autoupdate'),
                    buttons: starbox.hasClass('smooth') ? false : starbox.attr('data-button-count') || 5,
                    stars: starbox.attr('data-star-count') || 5
                }).bind('starbox-value-changed', function(event, value) {
                    if(starbox.hasClass('random')) {
                        var val = Math.random();
                        starbox.next().text(' '+val);
                        return val;
                    }
                })
            });
        });
    </script>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>
    <base href="<%=basePath%>">
    <!---//End-rate---->
</head>
<body>
<!--header-->
<div class="header">
    <div class="container">
        <div class="head">
            <div class=" logo">
                <a href="index.html"><img src="assets/images/logo.png" alt=""></a>
            </div>
        </div>
    </div>
    <div class="header-top">
        <div class="container">
            <div class="col-sm-5 col-md-offset-2  header-login">
                <ul >
                    <li><a href="user/tologin">登陆</a></li>
                    <li><a href="product/jsp">注册</a></li>
                    <li><a href="user/getout">注销</a></li>
                    <li><a href="#">${email},欢迎你！</a></li>
                </ul>
            </div>

            <div class="col-sm-5 header-social">
                <ul >
                    <li><a href="#"><i></i></a></li>
                    <li><a href="#"><i class="ic1"></i></a></li>
                    <li><a href="#"><i class="ic2"></i></a></li>
                    <li><a href="#"><i class="ic3"></i></a></li>
                    <li><a href="#"><i class="ic4"></i></a></li>
                </ul>

            </div>
            <div class="clearfix"> </div>
        </div>
    </div>

    <div class="container">

        <div class="head-top">

            <div class="col-sm-8 col-md-offset-2 h_menu4">
                <nav class="navbar nav_bottom" role="navigation">

                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header nav_2">
                        <button type="button" class="navbar-toggle collapsed navbar-toggle1" data-toggle="collapse" data-target="#bs-megadropdown-tabs">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>

                    </div>
                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-megadropdown-tabs">
                        <ul class="nav navbar-nav nav_1">
                            <li><a class="color" href="product/list/null">主页</a></li>
                            <li><a class="color3" href="product/listbyType/1">数码</a></li>
                            <li><a class="color3" href="product/listbyType/2">服装</a></li>
                            <li><a class="color3" href="product.html">食品</a></li>
                            <li><a class="color4" href="user/toUserinform">个人中心</a></li>
                            <li><a class="color5" href="border/getborder">公告</a></li>
                            <li ><a class="color6" href="order/getorder">订单</a></li>
                        </ul>
                    </div><!-- /.navbar-collapse -->

                </nav>
            </div>
            <div class="col-sm-2 search-right">
                <ul class="heart">
                    <li>
                        <a href="follow/getfollow" >
                            <span class="glyphicon glyphicon-heart" aria-hidden="true"></span>
                        </a></li>
                    <li><a class="play-icon popup-with-zoom-anim" href="#small-dialog"><i class="glyphicon glyphicon-search"> </i></a></li>
                    <li>
                        <a href="cart/getcart">
                            <img src="assets/images/cart.png" alt=""/>
                        </a>
                    </li>
                </ul>

                <div class="clearfix"> </div>

                <!----->

                <!---pop-up-box---->
                <link href="assets/css/popuo-box.css" rel="stylesheet" type="text/css" media="all"/>
                <script src="assets/js/jquery.magnific-popup.js" type="text/javascript"></script>
                <!---//pop-up-box---->
                <script>
                    search = function(){
                        var contents = document.getElementById("contents").value;
                        console.log(contents);
                        window.location.href='product/list/' + contents;
                    }
                </script>
                <div id="small-dialog" class="mfp-hide">
                    <div class="login-search">
                        <div class="login">
                            <input type="submit" value="" onclick="search();">
                            <input id="contents" type="text" value="Search.." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search..';}">
                        </div>
                        <p>Shopin</p>
                    </div>
                </div>
                <script>
                    $(document).ready(function() {
                        $('.popup-with-zoom-anim').magnificPopup({
                            type: 'inline',
                            fixedContentPos: false,
                            fixedBgPos: true,
                            overflowY: 'auto',
                            closeBtnInside: true,
                            preloader: false,
                            midClick: true,
                            removalDelay: 300,
                            mainClass: 'my-mfp-zoom-in'
                        });

                    });
                </script>
                <!----->
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>
<!--banner-->
<div class="banner-top">
    <div class="container">
        <h1>Login</h1>
        <em></em>
        <h2><a href="index.html">Home</a><label>/</label>Login</a></h2>
    </div>
</div>
<!--login-->
<div class="container">
    <div class="login">
        <script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
        <script>
            /**
             * 转换成json字符串
             * @param $form
             */
            function getFormData($form) {
                var unindexed_array = $form.serializeArray();
                var indexed_array = {};

                $.map(unindexed_array, function (n, i) {
                    indexed_array[n['name']] = n['value'];
                });
                return indexed_array;
            }

            /**
             * 后端发送AJAX
             */
            $(function () {
                $("#btn").click(function () {
                    var arry = getFormData($("#login"));
                    var str = "null";
                    // alert(JSON.stringify(arry));
                    $.ajax({
                        //json格式
                        url:"user/checkUser",
                        contentType:"application/json;charset=UTF-8",
                        data:JSON.stringify(arry),
                        dataType:"text",
                        type:"post",
                        success:function(data){
                            data = data.toString();
                            if(data != "fail"){
                                window.location.href='product/list/' + str;
                            }else{
                                alert("账号或密码输出错误");
                            }
                        },
                        error:function (data) {
                            alert("失败")
                        }
                    });
                });
            });
        </script>
        <form id="login">
            <div class="col-md-6 login-do">
                <div class="login-mail">
                    <input type="text" placeholder="Email" required="" id="userEmail" name="userEmail">
                    <i  class="glyphicon glyphicon-envelope"></i>
                </div>
                <div class="login-mail">
                    <input type="password" placeholder="Password" required="" id="userPassword" name="userPassword">
                    <i class="glyphicon glyphicon-lock"></i>
                </div>
                <button type="button" class="btn btn-lg btn-success" id="btn">login</button>
            </div>
            <div class="col-md-6 login-right">
                <h3>您可用免费拥有一个账户</h3>

                <p>如果您还没有一个账户，您能可以通过点击下方的按钮跳转进行注册</p>
                <a href="product/jsp" class=" hvr-skew-backward">注册</a>

            </div>

            <div class="clearfix"> </div>
        </form>
    </div>

</div>

<!--//login-->

<!--brand-->
<div class="container">
    <div class="brand">
        <div class="col-md-3 brand-grid">
            <img src="assets/images/ic.png" class="img-responsive" alt="">
        </div>
        <div class="col-md-3 brand-grid">
            <img src="assets/images/ic1.png" class="img-responsive" alt="">
        </div>
        <div class="col-md-3 brand-grid">
            <img src="assets/images/ic2.png" class="img-responsive" alt="">
        </div>
        <div class="col-md-3 brand-grid">
            <img src="assets/images/ic3.png" class="img-responsive" alt="">
        </div>
        <div class="clearfix"></div>
    </div>
</div>
<!--//brand-->
</div>

</div>
<!--//content-->
<!--//footer-->
<div class="footer">
    <div class="footer-middle">
        <div class="container">
            <div class="col-md-3 footer-middle-in">
                <a href="index.html"><img src="assets/images/log.png" alt=""></a>
                <p>Suspendisse sed accumsan risus. Curabitur rhoncus, elit vel tincidunt elementum, nunc urna tristique nisi, in interdum libero magna tristique ante. adipiscing varius. Vestibulum dolor lorem.</p>
            </div>

            <div class="col-md-3 footer-middle-in">
                <h6>Information</h6>
                <ul class=" in">
                    <li><a href="404.html">About</a></li>
                    <li><a href="contact.html">Contact Us</a></li>
                    <li><a href="#">Returns</a></li>
                    <li><a href="contact.html">Site Map</a></li>
                </ul>
                <ul class="in in1">
                    <li><a href="#">Order History</a></li>
                    <li><a href="wishlist.html">Wish List</a></li>
                    <li><a href="login.html">Login</a></li>
                </ul>
                <div class="clearfix"></div>
            </div>
            <div class="col-md-3 footer-middle-in">
                <h6>Tags</h6>
                <ul class="tag-in">
                    <li><a href="#">Lorem</a></li>
                    <li><a href="#">Sed</a></li>
                    <li><a href="#">Ipsum</a></li>
                    <li><a href="#">Contrary</a></li>
                    <li><a href="#">Chunk</a></li>
                    <li><a href="#">Amet</a></li>
                    <li><a href="#">Omnis</a></li>
                </ul>
            </div>
            <div class="col-md-3 footer-middle-in">
                <h6>Newsletter</h6>
                <span>Sign up for News Letter</span>
                <form>
                    <input type="text" value="Enter your E-mail" onfocus="this.value='';" onblur="if (this.value == '') {this.value ='Enter your E-mail';}">
                    <input type="submit" value="Subscribe">
                </form>
            </div>
            <div class="clearfix"> </div>
        </div>
    </div>
    <div class="footer-bottom">
        <div class="container">
            <ul class="footer-bottom-top">
                <li><a href="#"><img src="assets/images/f1.png" class="img-responsive" alt=""></a></li>
                <li><a href="#"><img src="assets/images/f2.png" class="img-responsive" alt=""></a></li>
                <li><a href="#"><img src="assets/images/f3.png" class="img-responsive" alt=""></a></li>
            </ul>
            <p class="footer-class">Copyright &copy; 2016.Company name All rights reserved.<a target="_blank" href="http://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a></p>
            <div class="clearfix"> </div>
        </div>
    </div>
</div>
<!--//footer-->

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->

<script src="assets/js/simpleCart.min.js"> </script>
<!-- slide -->
<script src="assets/js/bootstrap.min.js"></script>

</body>
</html>