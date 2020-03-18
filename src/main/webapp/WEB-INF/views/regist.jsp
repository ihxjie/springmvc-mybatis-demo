<%--
  Created by IntelliJ IDEA.
  User: Captivate
  Date: 2019/12/9
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
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
    <script src="assets/js/jquery.min.js"></script>
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
        <h1>Register</h1>
        <em></em>
        <h2><a href="index.html">Home</a><label>/</label>Register</a></h2>
    </div>
</div>
<!--login-->
<script src="//ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.3.min.js"></script>
<%--ajax验证账号是否合法--%>
<script type="text/javascript">
    $(function () {
        $("#email").blur(function () {
            var getEmail = document.getElementById("email");
            var getEmailmsg = document.getElementById("emailmsg");
            var strEmail = getEmail.value;
            if(strEmail == null || strEmail.trim().length==0){
                $("#ok").hide();
                $("#remove").show();
                getEmailmsg.style.color="red";
                getEmailmsg.innerHTML="邮箱不能为空";
            }else{
                var reg = /^[A-Za-z\d]+([-_.][A-Za-z\d]+)*@([A-Za-z\d]+[-.])+[A-Za-z\d]{2,4}$/;
                if(!reg.test(strEmail)){
                    console.log(strEmail);
                    $("#ok").hide();
                    $("#remove").show();
                    getEmailmsg.style.color="red";
                    getEmailmsg.innerHTML="邮箱格式不正确";
                }else{
                    console.log("123");
                    $.ajax({
                        url:"user/checkEmailUnique",
                        contentType:"application/json;charset=UTF-8",
                        data:JSON.stringify({
                            userEmail:strEmail
                        }),
                        dataType:"json",
                        type:"post",
                        success:function(data) {
                            data = data.toString();
                            console.log(data.length);
                            console.log("true".length);
                            if(data === "true"){
                                $("#ok").show();
                                $("#remove").hide();
                                getEmailmsg.style.color="green";
                                getEmailmsg.innerHTML="符合";
                            }else{
                                $("#ok").hide();
                                $("#remove").show();
                                getEmailmsg.style.color="red";
                                getEmailmsg.innerHTML="该邮箱已被注册";
                            }
                        }
                    })
                }
            }
        });
    });
</script>
<%--ajax验证密码是否合法--%>
<script type="text/javascript">
    $(function () {
        $("#cpassword,#password").blur(function () {
            var getPassword = document.getElementById("password");
            var getCpassword = document.getElementById("cpassword")
            var getPasswordmsg = document.getElementById("passwordmsg");
            var strPassword = getPassword.value;
            var strCpassword = getCpassword.value;
            if(strPassword == null || strPassword.trim().length==0 || strCpassword == null || strCpassword.trim().length==0){
                $("#pok").hide();
                $("#premove").show();
                getPasswordmsg.style.color="red";
                getPasswordmsg.innerHTML="密码或确认密码不能为空";
            }else if(strPassword.toString() != strCpassword.toString()){
                $("#pok").hide();
                $("#premove").show();
                getPasswordmsg.style.color="red";
                getPasswordmsg.innerHTML="两次输入密码不相同";
            }else{
                var reg = /^[a-z0-9A-Z]+$/;
                if(!reg.test(strPassword) || strPassword.trim().length < 6){
                    console.log(strPassword);
                    $("#pok").hide();
                    $("#premove").show();
                    getPasswordmsg.style.color="red";
                    getPasswordmsg.innerHTML="密码仅包含大小字母和数字且长度大于5个字符";
                }else{
                    $("#pok").show();
                    $("#premove").hide();
                    $("#butt").attr('disabled',false);
                    getPasswordmsg.style.color="green";
                    getPasswordmsg.innerHTML="符合";
                }
            }
        });
    });
</script>
<div class="container">
    <div class="login">
            <div class="col-md-6 login-do">
                <form action="user/postUser" method="post">
                    <div class="login-mail" style="margin-bottom: 0px">
                        <input id="email"  type="text" placeholder="Email" required="required" name="email">
                        <i  class="glyphicon glyphicon-envelope"></i>
                    </div>
                    <div style="margin-bottom: 8px; font-size: 15px">
                        <span class="glyphicon glyphicon-ok" id="ok" style="display: none; color: green"></span>
                        <span class="glyphicon glyphicon-remove" id="remove" style="display: none; color: red"></span>
                        <span id="emailmsg"></span>
                    </div>
                    <div class="login-mail" style="margin-bottom: 20px">
                        <input id="password" type="password" placeholder="Password" required="required" name="password">
                        <i class="glyphicon glyphicon-lock"></i>
                    </div>
                    <div class="login-mail" style="margin-bottom: 0px">
                        <input id = "cpassword" type="password" placeholder="Confirm Password" required="required">
                        <i class="glyphicon glyphicon-lock"></i>
                    </div>
                    <div style="margin-bottom: 8px; font-size: 15px">
                        <span class="glyphicon glyphicon-ok" id="pok" style="display: none; color: green"></span>
                        <span class="glyphicon glyphicon-remove" id="premove" style="display: none; color: red"></span>
                        <span id="passwordmsg"></span>
                    </div>
                    <label class="hvr-skew-backward">
                        <input type="submit" value="Submit" disabled="disabled" id="butt">
                    </label>
                </form>


            </div>
            <div class="col-md-6 login-right">
                <h3>您可免费拥有一个账户</h3>

                <p>如果您还已有一个账户,您可以点击下方的连接进行登陆</p>
                <a href="user/tologin" class="hvr-skew-backward">Login</a>

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