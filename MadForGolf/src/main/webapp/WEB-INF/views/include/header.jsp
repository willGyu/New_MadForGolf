<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title -->
    <title>MadForGolf - Gardening &amp; Landscaping HTML Template</title>

    <!-- Favicon -->
    <link rel="icon" href="${pageContext.request.contextPath }/resources/img/core-img/favicon.ico">

    <!-- Core Stylesheet -->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/style.css">
    
</head>

<body>

	<%
	String loginid = null;
	if(null != session.getAttribute("loginId"))
		loginid = (String)session.getAttribute("loginId");
	%>

    <!-- ##### Header Area Start ##### -->
    <header class="header-area">

        <!-- ***** Top Header Area ***** -->
        <div class="top-header-area">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <div class="top-header-content d-flex align-items-center justify-content-between">
                            <!-- Top Header Content -->
                            <div class="top-header-meta">
                                <a href="#" data-placement="bottom" title="MadForGolf@gmail.com"><i class="fa fa-envelope-o" aria-hidden="true"></i> <span>Email: MadForGolf@gmail.com</span></a>
                                <a href="#" data-placement="bottom" title="051-803-0909"><i class="fa fa-phone" aria-hidden="true"></i> <span>Call Us: 051-803-0909</span></a>
                            </div>


                            <!-- Top Header Content -->
                            <div class="top-header-meta d-flex">
                                 <div class="language-dropdown">
                              
                            <!-- Login -->
                            <div class="login">
                                    <a href="/member/login"><i class="fa fa-user" aria-hidden="true"></i> <span>Login</span></a>
                                    <a href="/member/insert"><i class="fa fa-shopping-cart" aria-hidden="true"></i> <span>Join <span class="cart-quantity"></span></span></a>
                            </div>	
                           
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

        <!-- ***** Navbar Area ***** -->
        <div class="alazea-main-menu">
            <div class="classy-nav-container breakpoint-off">
                <div class="container">
                    <!-- Menu -->
                    <nav class="classy-navbar justify-content-between" id="alazeaNav">

                        <!-- Nav Brand -->
                        <a href="/member/main" class="nav-brand"><img src="${pageContext.request.contextPath }/resources/img/core-img/logo.png" alt=""></a>

                        <!-- Navbar Toggler -->
                        <div class="classy-navbar-toggler">
                            <span class="navbarToggler"><span></span><span></span><span></span></span>
                        </div>

                        <!-- Menu -->
                        <div class="classy-menu">

                            <!-- Close Button -->
                            <div class="classycloseIcon">
                                <div class="cross-wrap"><span class="top"></span><span class="bottom"></span></div>
                            </div>

                            <!-- Navbar Start -->
                            <div class="classynav">
                                <ul>
                                    <li><a href="/member/main">Home</a></li>
                                    <li><a href="#">About</a></li>
                                    <li><a href="/product/listAll">Shop(Deal)</a>
                                        <ul class="dropdown">
                                            <li><a href="${pageContext.request.contextPath }/product/listAll?category=Driver">Driver</a></li>
                                            <li><a href="${pageContext.request.contextPath }/product/listAll?category=Iron">Iron</a></li>
                                            <li><a href="${pageContext.request.contextPath }/product/listAll?category=Utility">Util</a></li>
                                            <li><a href="${pageContext.request.contextPath }/product/listAll?page=1&category=Wedge">Wedge</a></li>
											<li><a href="${pageContext.request.contextPath }/product/listAll?page=1&category=Putter">Putter</a></li>
											<li><a href="${pageContext.request.contextPath }/product/listAll?page=1&category=Etc">Etc</a>

                                            </li>

                                        </ul>
                                    </li>
                                    <li><a href="/board/listBoardAll">Community</a></li>
                                </ul>


                            </div>
                            <!-- Navbar End -->
                        </div>
                    </nav>

                   
                    </div>
                </div>
            </div>
        </div>
    </header>
     <!--##### Header Area End #####-->


                  

    <!-- ##### All Javascript Files ##### -->
    <!-- jQuery-2.2.4 js -->
    <script src="${pageContext.request.contextPath }/resources/js/jquery/jquery-2.2.4.min.js"></script>
    <!-- Popper js -->
    <script src="${pageContext.request.contextPath }/resources/js/bootstrap/popper.min.js"></script>
    <!-- Bootstrap js -->
    <script src="${pageContext.request.contextPath }/resources/js/bootstrap/bootstrap.min.js"></script>
    <!-- All Plugins js -->
    <script src="${pageContext.request.contextPath }/resources/js/plugins/plugins.js"></script>
    <!-- Active js -->
    <script src="${pageContext.request.contextPath }/resources/js/active.js"></script>
	<a id="scrollUp" href="#top" style="position: fixed; z-index: 2147483647; display: block;"><i class="fa fa-angle-up"></i></a>
</body>

</html>
