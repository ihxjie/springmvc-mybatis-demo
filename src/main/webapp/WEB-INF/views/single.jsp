<%--
  Created by IntelliJ IDEA.
  User: Captivate
  Date: 2019/12/9
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Single</title>
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
    <link href="assets/css/form.css" rel="stylesheet" type="text/css" media="all" />
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
        <h1>Single</h1>
        <em></em>
        <h2><a href="index.html">Home</a><label>/</label>Single</a></h2>
    </div>
</div>
<div class="single">

    <div class="container">
        <div class="col-md-9">
            <div class="col-md-5 grid">
                <div class="flexslider">
                    <ul class="slides">
                        <li data-thumb="assets/images/si.jpg">
                            <div class="thumb-image"> <img src="assets/images/si.jpg" data-imagezoom="true" class="img-responsive"> </div>
                        </li>
                        <li data-thumb="assets/images/si1.jpg">
                            <div class="thumb-image"> <img src="assets/images/si1.jpg" data-imagezoom="true" class="img-responsive"> </div>
                        </li>
                        <li data-thumb="assets/images/si2.jpg">
                            <div class="thumb-image"> <img src="assets/images/si2.jpg" data-imagezoom="true" class="img-responsive"> </div>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="col-md-7 single-top-in">
                <div class="span_2_of_a1 simpleCart_shelfItem">
                    <h3>${product.productName}</h3>
                    <p class="in-para">欢迎您的大量购买，我们将会不定期退出获得，请持续关注</p>
                    <div class="price_single">
                        <span class="reducedfrom item_price">￥${product.productCurrentPrice}</span>
                        <div class="clearfix"></div>
                    </div>
                    <h4 class="quick">商品概述</h4>
                    <p class="quick_desc"> 这是一件低调奢华的产品</p>
                    <div class="wish-list">
                        <ul>
                            <li class="wish"><a onclick="addfollow();"><span class="glyphicon glyphicon-check" aria-hidden="true"></span>加入收藏</a></li>
                        </ul>
                    </div>
                    <div class="quantity">
                        <div class="quantity-select">
                            <div class="entry value-minus">&nbsp;</div>
                            <div class="entry value"  id="quantity"><span>1</span></div>
                            <div class="entry value-plus active">&nbsp;</div>
                        </div>
                    </div>
                    <!--quantity-->
                    <script>
                        $('.value-plus').on('click', function(){
                            var divUpd = $(this).parent().find('.value'), newVal = parseInt(divUpd.text(), 10)+1;
                            divUpd.text(newVal);
                        });

                        $('.value-minus').on('click', function(){
                            var divUpd = $(this).parent().find('.value'), newVal = parseInt(divUpd.text(), 10)-1;
                            if(newVal>=1) divUpd.text(newVal);
                        });
                    </script>
                    <!--quantity-->
                    <script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
                    <script>
                        addcart = function(){
                            var num = document.getElementById("quantity").innerText;
                            var uid = "${uid}";
                            var pid = "${pid}";
                            console.log(num);
                            // alert(JSON.stringify(arry));
                            $.ajax({
                                //json格式
                                url:"cart/postcart",
                                contentType:"application/json;charset=UTF-8",
                                data:JSON.stringify({
                                    "purchaseQuantity":num,
                                    "userId":uid,
                                    "productId":pid
                                }),
                                dataType:"text",
                                type:"post",
                                success:function(data){
                                    data = data.toString();
                                    if (data == "success")
                                        alert("添加成功");
                                    else
                                        alert("添加失败");
                                },
                                error:function (data) {
                                    alert("失败");
                                }
                            });
                        }

                        addfollow = function(){
                            var uid = "${uid}";
                            var pid = "${pid}";
                            // alert(JSON.stringify(arry));
                            $.ajax({
                                //json格式
                                url:"follow/postfollow",
                                contentType:"application/json;charset=UTF-8",
                                data:JSON.stringify({
                                    "userId":uid,
                                    "productId":pid
                                }),
                                dataType:"text",
                                type:"post",
                                success:function(data){
                                    data = data.toString();
                                    if (data == "success")
                                        alert("添加成功");
                                    else
                                        alert("添加失败");
                                },
                                error:function (data) {
                                    alert("失败");
                                }
                            });
                        }
                    </script>
                    <a onclick="addcart();" class="add-to item_add hvr-skew-backward">加入购物车</a>
                    <div class="clearfix"> </div>
                </div>

            </div>
            <div class="clearfix"> </div>
            <!---->
            <!---->
        </div>
        <!----->

            <!--initiate accordion-->
            <script type="text/javascript">
                $(function() {
                    var menu_ul = $('.menu-drop > li > ul'),
                        menu_a  = $('.menu-drop > li > a');
                    menu_ul.hide();
                    menu_a.click(function(e) {
                        e.preventDefault();
                        if(!$(this).hasClass('active')) {
                            menu_a.removeClass('active');
                            menu_ul.filter(':visible').slideUp('normal');
                            $(this).addClass('active').next().stop(true,true).slideDown('normal');
                        } else {
                            $(this).removeClass('active');
                            $(this).next().stop(true,true).slideUp('normal');
                        }
                    });

                });
            </script>
        </div>
        <div class="clearfix"> </div>
    </div>
</div>
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
<script src="assets/js/imagezoom.js"></script>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script defer src="assets/js/jquery.flexslider.js"></script>
<link rel="stylesheet" href="assets/css/flexslider.css" type="text/css" media="screen" />

<script>
    // Can also be used with $(document).ready()
    $(window).load(function() {
        $('.flexslider').flexslider({
            animation: "slide",
            controlNav: "thumbnails"
        });
    });
</script>

<script src="assets/js/simpleCart.min.js"> </script>
<!-- slide -->
<script src="assets/js/bootstrap.min.js"></script>


</body>
</html>
