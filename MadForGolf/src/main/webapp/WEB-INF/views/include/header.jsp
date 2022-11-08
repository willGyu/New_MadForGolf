<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                                <a href="#" data-placement="bottom" title=""><i class="fa fa-envelope-o" aria-hidden="true"></i> <span>Email: MadForGolf@gmail.com</span></a>
                                <a href="#" data-placement="bottom" title=""><i class="fa fa-phone" aria-hidden="true"></i> <span>Call Us: 051-803-0909</span></a>
                            </div>
		
							<!-- Top Header Content -->
                            <div class="top-header-meta d-flex">
                            
                            <!-- Login -->
                            <div class="login">
								 <ul class="util">
								 <c:if test="${user_id == null }">
							        <!-- 로그인 X - 회원가입 -->
							        <div class="login">
                               		<a href="/member/insert"><i class="fa fa-user" aria-hidden="true"></i> <span>Join</span></a>
                           		</c:if>			
							       
							    <c:if test="${user_id == null }">
							    	<!-- 로그인 X - 로그인 -->
						          	<a href="/member/login"><i class="fa fa-user" aria-hidden="true"></i> <span>Login</span></a>
							    </c:if>	
							</div>
							    	
									
									
							<c:if test="${user_id != null }">
								<!-- 로그인 O - 마이페이지 -->
							    <!-- 로그인 O - 'OO'님 환영합니다. -->
							    <div class="login">
									<b id="user_id" >${user_name }</b>님 환영합니다.
							        <a href="/member/mypage"><i class="fa fa-user" aria-hidden="true"></i> <span>마이페이지</span></a>
							</c:if>
							        
							        
							<c:if test="${user_id != null }">
							    <!-- 로그인 O - 거래목록 -->
							    <a href="#"><i class="fa fa-user" aria-hidden="true"></i> <span>거래목록</span></a>
							</c:if>
							        
							<c:if test="${user_id != null }">
								<!-- 로그인 O - 로그아웃 -->
						        <a href="/member/logout"><i class="fa fa-user" aria-hidden="true"></i> <span>로그아웃</span></a>         
							</c:if>
							        
							        
						</div>												       
		    		</ul>	

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
                                            <li><a href="${pageContext.request.contextPath }/product/listAll?category=Iron&gender=2">Iron</a></li>
                                            <li><a href="${pageContext.request.contextPath }/product/listAll?category=Util">Util</a></li>
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
