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
    <title>Alazea - Gardening &amp; Landscaping HTML Template</title>

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

 <!-- Preloader 로딩될때 네잎클로버 도는 동작 -->
<!--     <div class="preloader d-flex align-items-center justify-content-center"> -->
<!--         <div class="preloader-circle"></div> -->
<!--         <div class="preloader-img"> -->
<!--             <img src="{pageContext.request.contextPath }/resources/img/core-img/leaf.png" alt=""> -->
<!--         </div> -->
<!--     </div> -->

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
                                <a href="#" data-toggle="tooltip" data-placement="bottom" title=""><i class="fa fa-envelope-o" aria-hidden="true"></i> <span></span></a>
                                <a href="#" data-toggle="tooltip" data-placement="bottom" title=""><i class="fa fa-phone" aria-hidden="true"></i> <span></span></a>
                            </div>

                            <!-- Top Header Content -->
                            <div class="top-header-meta d-flex">
                                 <div class="language-dropdown">
<!--                                
                            <!-- Login -->
                            <div class="login">
								 <ul class="util">
							        <%if(loginid == null){%>
							        	<!-- 로그인 X - 회원가입 -->
							        			<div class="login">
                               					<a href="/member/insert"><i class="fa fa-user" aria-hidden="true"></i> <span>Join</span></a>
                           						
							        <%} %>
							    	<%if(loginid == null){%>
							    		<!-- 로그인 X - 로그인 -->
						                         <a href="/member/login"><i class="fa fa-user" aria-hidden="true"></i> <span>Login</span></a>
							    	<%} %>
							    				</div>
							    	
									
									
							        <%if(loginid != null){%>
							        <!-- 로그인 O - 마이페이지 -->
							         	<!-- 로그인 O - 'OO'님 환영합니다. -->
							       		<div class="login">
											  <b id="user_id" ><%=loginid %> </b>님 환영합니다.
							        	      <a href="#"><i class="fa fa-user" aria-hidden="true"></i> <span>마이페이지</span></a>
							        <%} %>
							        
							        
							        <%if(loginid != null){%>
							        <!-- 로그인 O - 거래목록 -->
							        	      <a href="#"><i class="fa fa-user" aria-hidden="true"></i> <span>거래목록</span></a>
							        <%} %>
							        
							         <%if(loginid  != null){%>
										<!-- 로그인 O - 로그아웃 -->
						                     <a href="#"><i class="fa fa-user" aria-hidden="true"></i> <span>로그아웃</span></a>
						                     
									<%} %>
							        
							        
											   </div>												       
		    					</ul>	

                            </div>
                            
                           
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
                        <a href="${pageContext.request.contextPath }/resources/index.html" class="nav-brand"><img src="${pageContext.request.contextPath }/resources/img/core-img/logo.png" alt=""></a>

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
                                    <li><a href="${pageContext.request.contextPath }/resources/index.html">Home</a></li>
                                    <li><a href="${pageContext.request.contextPath }/resources/about.html">About</a></li>
                                    <li><a href="#">Shop(Deal)</a>
                                        <ul class="dropdown">
                                        	<li><a href="${pageContext.request.contextPath }/product/listAll?page=1&category=Driver">Driver</a></li>
											<li><a href="${pageContext.request.contextPath }/product/listAll?page=1&category=Iron">Iron</a></li>
											<li><a href="${pageContext.request.contextPath }/product/listAll?page=1&category=Utility">Utility</a></li>
											<li><a href="${pageContext.request.contextPath }/product/listAll?page=1&category=Wedge">Wedge</a></li>
											<li><a href="${pageContext.request.contextPath }/product/listAll?page=1&category=Putter">Putter</a></li>
											<li><a href="${pageContext.request.contextPath }/product/listAll?page=1&category=Etc">Etc</a></li>
										</ul>
<!--                                                     <li><a href="shop.html">Shop</a></li> -->
<!--                                                     <li><a href="shop-details.html">Shop Details</a></li> -->
<!--                                                     <li><a href="cart.html">Shopping Cart</a></li> -->
<!--                                                     <li><a href="checkout.html">Checkout</a></li> -->
<!--                                                 </ul> -->
<%--                                             <li><a href="${pageContext.request.contextPath }/resources/portfolio.html">Portfolio</a> --%>
<!--                                                 <ul class="dropdown"> -->
<%--                                                     <li><a href="${pageContext.request.contextPath }/resources/portfolio.html">Portfolio</a></li> --%>
<%--                                                     <li><a href="${pageContext.request.contextPath }/resources/single-portfolio.html">Portfolio Details</a></li> --%>
<!--                                                 </ul> -->
<!--                                             </li> -->
<%--                                             <li><a href="${pageContext.request.contextPath }/resources/blog.html">Blog</a> --%>
<!--                                                 <ul class="dropdown"> -->
<%--                                                     <li><a href="${pageContext.request.contextPath }/resources/blog.html">Blog</a></li> --%>
<%--                                                     <li><a href="${pageContext.request.contextPath }/resources/single-post.html">Blog Details</a></li> --%>
<!--                                                 </ul> -->
<!--                                             </li> -->
<%--                                             <li><a href="${pageContext.request.contextPath }/resources/contact.html">Contact</a></li> --%>

                                    </li>
                                    <li><a href="${pageContext.request.contextPath }/resources/shop.html">Community</a></li>
                                    <li><a href="${pageContext.request.contextPath }/resources/portfolio.html">Contact</a></li>
                                </ul>

                                <!-- Search Icon -->
                                <div id="searchIcon">
                                    <i class="fa fa-search" aria-hidden="true"></i>
                                </div>

                            </div>
                            <!-- Navbar End -->
                        </div>
                    </nav>

                    <!-- Search Form -->
                    <div class="search-form">
                        <form action="#" method="get">
                            <input type="search" name="search" id="search" placeholder="Type keywords &amp; press enter...">
                            <button type="submit" class="d-none"></button>
                        </form>
                        <!-- Close Icon -->
                        <div class="closeIcon"><i class="fa fa-times" aria-hidden="true"></i></div>
                    </div>
                </div>
            </div>
        </div>
    </header>
    <!-- ##### Header Area End ##### -->
	
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
