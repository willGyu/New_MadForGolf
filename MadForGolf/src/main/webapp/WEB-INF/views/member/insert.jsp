<%@ page language="java" contentType="text/html; charset=UTF-8"

	pageEncoding="UTF-8"%>

    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- 템플릿 헤더 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@-->
<!-- 템플릿 -->
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<!-- Title -->
<title>Alazea - Gardening &amp; Landscaping HTML Template</title>

<!-- Favicon -->
<link rel="icon"
	href="${pageContext.request.contextPath }/resources/img/core-img/favicon.ico">

<!-- Core Stylesheet -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/style.css">

<!-- 템플릿 -->
<!-- 템플릿 헤더 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@-->

<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	
</script>
<script>
	$(document).ready(function() {
		$('#join').submit(function() {
			//alert("알럿!");
			if ($('.password2').val() != $('.password').val()) {
				$('.pass2div').html("비밀번호가 다릅니다. 다시 확인하세요.");
				$('.pass2div').focus();
				return false;
			}
			if ($('.password2').val() == $('.password').val()) {
				$('.pass2div').html("비밀번호가 일치합니다.");
			}
			if ($('.password2').val() == '') {
				$('.pass2div').html("비밀번호를 입력하세요.");
			}
			if ($('#user_id2').val() == '1') {
				alert('사용 불가능한 이메일입니다.');
				return false;
			}

		}); 
		
		// 이메일 제어 
		$('#join').submit(function() {
			if ($('#user_id').val() == '') {
				alert("이메일을 입력하세요.");
				return false;
			}

		});
		
		//비밀번호 제어 
		$('#join').submit(function() {
			if ($('#user_pw').val() == '') {
				alert("비밀번호를 확인하세요.");
				return false;
			}

		});
		
		//비밀번호 재확인 제어 
		$('#join').submit(function() {
			if ($('#user_pw1').val() == '') {
				alert("비밀번호를 재확인하세요.");
				return false;
			}

		});

		// 이름 제어
		$('#join').submit(function() {
			if ($('#user_name').val() == '') {
				alert("이름을 입력하세요.");
				return false;
			}

		});

		// 휴대전화 제어 
		$('#join').submit(function() {
			if ($('#user_phone').val() == '') {
				alert("전화번호를 입력하세요.");
				return false;
			}

		});

		//아이디 중복체크
		$('.idCheck').click(function() {
			//alert($("#user_id").val());
			$.ajax({
				url : "/member/idCheck",
				type : "post",
				dataType : "json",
				data : {
					"user_id" : $("#user_id").val()
				},
				success : function(data) {
					//alert(data);
					if (data == 1) {
						$('#user_id2').val(1);
						alert("사용 불가능한 이메일입니다.");
					} else if (data == 0) {
						$('#user_id2').val(0);
						$("#idCheck").attr("value", "Y");
						alert("사용 가능한 이메일입니다.");
					}
				}
			});
		});

	});
</script>
</head>
<body>
	<!-- 템플릿 헤더 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@-->
	<!-- 템플릿 헤더-->
	<header class="header-area">

		<!-- ***** Top Header Area ***** -->
		<div class="top-header-area">
			<div class="container">
				<div class="row">
					<div class="col-12">
						<div
							class="top-header-content d-flex align-items-center justify-content-between">
							<!-- Top Header Content -->
							<div class="top-header-meta">
								<a href="#" data-toggle="tooltip" data-placement="bottom"
									title="infodeercreative@gmail.com"><i
									class="fa fa-envelope-o" aria-hidden="true"></i> <span>Email:
										infodeercreative@gmail.com</span></a> <a href="#" data-toggle="tooltip"
									data-placement="bottom" title="+1 234 122 122"><i
									class="fa fa-phone" aria-hidden="true"></i> <span>Call
										Us: +1 234 122 122</span></a>
							</div>

							<!-- Top Header Content -->
							<div class="top-header-meta d-flex">
								<!-- Language Dropdown -->
								<div class="language-dropdown">
									<div class="dropdown">
										<button class="btn btn-secondary dropdown-toggle mr-30"
											type="button" id="dropdownMenuButton" data-toggle="dropdown"
											aria-haspopup="true" aria-expanded="false">Language</button>
										<div class="dropdown-menu"
											aria-labelledby="dropdownMenuButton">
											<a class="dropdown-item" href="#">USA</a> <a
												class="dropdown-item" href="#">UK</a> <a
												class="dropdown-item" href="#">Bangla</a> <a
												class="dropdown-item" href="#">Hindi</a> <a
												class="dropdown-item" href="#">Spanish</a> <a
												class="dropdown-item" href="#">Latin</a>
										</div>
									</div>
								</div>
								<!-- Login -->
								<div class="login">
									<a href="#"><i class="fa fa-user" aria-hidden="true"></i> <span>Login</span></a>
								</div>
								<!-- Cart -->
								<div class="cart">
									<a href="#"><i class="fa fa-shopping-cart"
										aria-hidden="true"></i> <span>Cart <span
											class="cart-quantity">(1)</span></span></a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- ***** Navbar Area ***** -->
		<div id="sticky-wrapper" class="sticky-wrapper" style="height: 90px;">
			<div class="alazea-main-menu">
				<div class="classy-nav-container breakpoint-off light left">
					<div class="container">
						<!-- Menu -->
						<nav class="classy-navbar justify-content-between" id="alazeaNav">

							<!-- Nav Brand -->
							<a href="index.html" class="nav-brand"><img
								src="${pageContext.request.contextPath }/resources/img/core-img/logo.png"
								alt=""></a>

							<!-- Navbar Toggler -->
							<div class="classy-navbar-toggler">
								<span class="navbarToggler"><span></span><span></span><span></span></span>
							</div>

							<!-- Menu -->
							<div class="classy-menu">

								<!-- Close Button -->
								<div class="classycloseIcon">
									<div class="cross-wrap">
										<span class="top"></span><span class="bottom"></span>
									</div>
								</div>

								<!-- Navbar Start -->
								<div class="classynav">
									<ul>
										<li><a href="index.html">Home</a></li>
										<li><a href="about.html">About</a></li>
										<li class="cn-dropdown-item has-down"><a href="#">Pages</a>
											<ul class="dropdown">
												<li><a href="index.html">Home</a></li>
												<li><a href="about.html">About</a></li>
												<li class="has-down"><a href="shop.html">Shop</a>
													<ul class="dropdown">
														<li><a href="shop.html">Shop</a></li>
														<li><a href="shop-details.html">Shop Details</a></li>
														<li><a href="cart.html">Shopping Cart</a></li>
														<li><a href="checkout.html">Checkout</a></li>
													</ul> <span class="dd-trigger"></span></li>
												<li class="has-down"><a href="portfolio.html">Portfolio</a>
													<ul class="dropdown">
														<li><a href="portfolio.html">Portfolio</a></li>
														<li><a href="single-portfolio.html">Portfolio
																Details</a></li>
													</ul> <span class="dd-trigger"></span></li>
												<li class="has-down"><a href="blog.html">Blog</a>
													<ul class="dropdown">
														<li><a href="blog.html">Blog</a></li>
														<li><a href="single-post.html">Blog Details</a></li>
													</ul> <span class="dd-trigger"></span></li>
												<li><a href="contact.html">Contact</a></li>
											</ul> <span class="dd-trigger"></span></li>
										<li><a href="shop.html">Shop</a></li>
										<li><a href="portfolio.html">Portfolio</a></li>
										<li><a href="contact.html">Contact</a></li>
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
								<input type="search" name="search" id="search"
									placeholder="Type keywords &amp; press enter...">
								<button type="submit" class="d-none"></button>
							</form>
							<!-- Close Icon -->
							<div class="closeIcon">
								<i class="fa fa-times" aria-hidden="true"></i>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>


	<div class="breadcrumb-area">
		<!-- Top Breadcrumb Area -->
		<div
			class="top-breadcrumb-area bg-img bg-overlay d-flex align-items-center justify-content-center"
			style="background-image: url(${pageContext.request.contextPath }/resources/img/bg-img/24.jpg);">
			<h2>Checkout</h2>
		</div>

		<div class="container">
			<div class="row">
				<div class="col-12">
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="#"><i
									class="fa fa-home"></i> Home</a></li>
							<li class="breadcrumb-item active" aria-current="page">Checkout</li>
						</ol>
					</nav>
				</div>
			</div>
		</div>
	</div>
	<!-- 템플릿 헤더 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@-->






	<!-- ##### Checkout Area Start ##### -->
	<div class="checkout_area mb-100">
		<div class="container">
			<div class="row justify-content-between">
				<div class="col-12 col-lg-7">
					<div class="checkout_details_area clearfix">
						<h1>회원가입</h1>
						<h2>Join</h2>
						<br><br><br><br>
						<form action="/member/insert" id="join" method="post">
							<div class="row">
								<div class="col-12 mb-4">
									<label for="email_address">이메일(Email Address) *</label> 
									<input type="text" name="user_id" class="form-control" id="user_id" value="" placeholder=" @를 포함해서 입력하세요.">
									<input type="hidden" name="user_id2" id="user_id2"><br>
									<button type="button" class="idCheck btn alazea-btn w-80" id="idCheck" value="N" style="width:50pt;height:30pt;">이메일 확인</button>
									<input type="hidden" name="user_id2" id="user_id2" value="0">
								</div>
								
								
								
								
								<div class="col-12 mb-4">
									<label for="email_address">비밀번호(Password) *</label> 
									<input type="password" name="user_pw" class="password form-control" id="user_pw" value="" placeholder="비밀번호를 입력하세요.">
									<div class="passdiv"></div>
								</div>
								<div class="col-12 mb-4">
									<label for="email_address">비밀번호 재확인(Reconfirm Password) *</label> 
									<input type="password" name="user_pw1" class="password2 form-control" id="user_pw1" value="" placeholder="비밀번호를 재입력하세요."><br>
									<div class="pass2div"></div>
								</div>
								<div class="col-12 mb-4">
									<label for="phone_number">이름(Name) *</label> 
									<input type="text" name="user_name" class="form-control" id="user_name" value="" placeholder="이름을 입력하세요.">
								</div>
								<div class="col-12 mb-4">
									<label for="phone_number">전화번호(Phone) *</label> 
									<input type="text" name="user_phone" class="form-control" id="user_phone" value="" placeholder=" (-)제외후 입력하세요."><br>
								</div>

								<button class="btn alazea-btn w-120" style="width:360pt;height:40pt;margin:auto;">회원가입</button>
								
								</div>
								

                        
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<hr>




		
				
			
			

			



			


			


			


			
			<br>


		</form>
	</fieldset>






	<!-- 템플릿푸터@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ -->
	<footer class="footer-area bg-img"
		style="background-image: url(${pageContext.request.contextPath }/resources/img/bg-img/3.jpg);">
		<!-- Main Footer Area -->
		<div class="main-footer-area">
			<div class="container">
				<div class="row">

					<!-- Single Footer Widget -->
					<div class="col-12 col-sm-6 col-lg-3">
						<div class="single-footer-widget">
							<div class="footer-logo mb-30">
								<a href="#"><img
									src="${pageContext.request.contextPath }/resources/img/core-img/logo.png"
									alt=""></a>
							</div>
							<p>Lorem ipsum dolor sit samet, consectetur adipiscing elit.
								India situs atione mantor</p>
							<div class="social-info">
								<a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a>
								<a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
								<a href="#"><i class="fa fa-google-plus" aria-hidden="true"></i></a>
								<a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a>
								<a href="#"><i class="fa fa-linkedin" aria-hidden="true"></i></a>
							</div>
						</div>
					</div>

					<!-- Single Footer Widget -->
					<div class="col-12 col-sm-6 col-lg-3">
						<div class="single-footer-widget">
							<div class="widget-title">
								<h5>QUICK LINK</h5>
							</div>
							<nav class="widget-nav">
								<ul>
									<li><a href="#">Purchase</a></li>
									<li><a href="#">FAQs</a></li>
									<li><a href="#">Payment</a></li>
									<li><a href="#">News</a></li>
									<li><a href="#">Return</a></li>
									<li><a href="#">Advertise</a></li>
									<li><a href="#">Shipping</a></li>
									<li><a href="#">Career</a></li>
									<li><a href="#">Orders</a></li>
									<li><a href="#">Policities</a></li>
								</ul>
							</nav>
						</div>
					</div>

					<!-- Single Footer Widget -->
					<div class="col-12 col-sm-6 col-lg-3">
						<div class="single-footer-widget">
							<div class="widget-title">
								<h5>BEST SELLER</h5>
							</div>

							<!-- Single Best Seller Products -->
							<div class="single-best-seller-product d-flex align-items-center">
								<div class="product-thumbnail">
									<a href="shop-details.html"><img
										src="${pageContext.request.contextPath }/resources/img/bg-img/4.jpg"
										alt=""></a>
								</div>
								<div class="product-info">
									<a href="shop-details.html">Cactus Flower</a>
									<p>$10.99</p>
								</div>
							</div>

							<!-- Single Best Seller Products -->
							<div class="single-best-seller-product d-flex align-items-center">
								<div class="product-thumbnail">
									<a href="shop-details.html"><img
										src="${pageContext.request.contextPath }/resources/img/bg-img/5.jpg"
										alt=""></a>
								</div>
								<div class="product-info">
									<a href="shop-details.html">Tulip Flower</a>
									<p>$11.99</p>
								</div>
							</div>
						</div>
					</div>

					<!-- Single Footer Widget -->
					<div class="col-12 col-sm-6 col-lg-3">
						<div class="single-footer-widget">
							<div class="widget-title">
								<h5>CONTACT</h5>
							</div>

							<div class="contact-information">
								<p>
									<span>Address:</span> 505 Silk Rd, New York
								</p>
								<p>
									<span>Phone:</span> +1 234 122 122
								</p>
								<p>
									<span>Email:</span> info.deercreative@gmail.com
								</p>
								<p>
									<span>Open hours:</span> Mon - Sun: 8 AM to 9 PM
								</p>
								<p>
									<span>Happy hours:</span> Sat: 2 PM to 4 PM
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- Footer Bottom Area -->
		<div class="footer-bottom-area">
			<div class="container">
				<div class="row">
					<div class="col-12">
						<div class="border-line"></div>
					</div>
					<!-- Copywrite Text -->
					<div class="col-12 col-md-6">
						<div class="copywrite-text">
							<p>
								©
								<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
								Copyright ©
								<script>
									document.write(new Date().getFullYear());
								</script>
								2022 All rights reserved | This template is made with <i
									class="fa fa-heart-o" aria-hidden="true"></i> by <a
									href="https://colorlib.com" target="_blank">Colorlib</a>
								<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
							</p>
						</div>
					</div>
					<!-- Footer Nav -->
					<div class="col-12 col-md-6">
						<div class="footer-nav">
							<nav>
								<ul>
									<li><a href="#">Home</a></li>
									<li><a href="#">About</a></li>
									<li><a href="#">Service</a></li>
									<li><a href="#">Portfolio</a></li>
									<li><a href="#">Blog</a></li>
									<li><a href="#">Contact</a></li>
								</ul>
							</nav>
						</div>
					</div>
				</div>
			</div>
		</div>
	</footer>
	<!-- 템플릿푸터@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ -->
=======
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript"> </script>
<script> 
$(document).ready(function () {

    $('#join').submit(function(){
        //alert("알럿!");
       if ($('.password2').val()!=$('.password').val()) {
                $('.pass2div').html("비밀번호가 다릅니다. 확인하고 다시 작성해주세요 ❤❤");
                $('.pass2div').focus();
                return false;
            }
       if($('#user_id2').val()=='1') {
	         alert('아이디 중복');
	         return false; 
	      } 
       
       
       
    });

    
	

	//아이디 중복체크
    $('.idCheck').click(function(){
    	//alert($("#user_id").val());
		$.ajax({
		url : "/member/idCheck",
		type : "post",
		dataType : "json",
		data : {"user_id" : $("#user_id").val()},
		success : function(data){
			//alert(data);
			if(data == 1){
				$('#user_id2').val(1);
				alert("중복된 아이디입니다.");
			}else if(data == 0){
				$('#user_id2').val(0);
				$("#idCheck").attr("value", "Y");
				alert("사용가능한 아이디입니다.");
			}
		}
	});
});
	
	
}); 







</script>
</head>
<body>
	<h1>회원가입</h1>
	<fieldset>
	<legend>회원가입 </legend>
	<form action="/member/insert" id="join" method="post">
		이메일 : <input type="text" name="user_id" id="user_id" class="user_id" placeholder=" @를 포함해서 입력해주세요.">
		<button class="idCheck" type="button" id="idCheck"  value="N" >중복체크</button> <br>
		<input type="hidden" name="user_id2" id="user_id2" value="0">
		비밀번호 : <input type="password" name="user_pw" class="password" placeholder="비밀번호를 입력하세요."><br>
		<div class="passdiv"> </div> <br> 
		비밀번호 확인 : <input type="password" name="user_pw1" class="password2" placeholder="비밀번호를 재입력하세요."><br>
		<div class="pass2div"> </div> <br> 
		이름 : <input type="text" name="user_name" placeholder="이름을 입력하세요."><br>
		휴대번호 : <input type="text" name="user_phone" placeholder=" (-)제외후 입력해주세요."><br>
	<input type="submit" value="회원가입">	
		
		
		
	</form>
	</fieldset>
	

</body>
</html>