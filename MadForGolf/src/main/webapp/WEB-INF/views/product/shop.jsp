<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- JSTL사용  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <!DOCTYPE html>
<html lang="en">

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
   --%>
        <style>
#topMenu {
	height: 30px;
	width: 1100px;
}

#topMenu .women {
	margin-bottom: 0px;
}

#topMenu ul li {
	list-style: none;
	color: #FBF2CF;
	background-color: #C6EBC5;
	float: left;
	line-height: 30px;
	vertical-align: middle;
	text-align: center;
}

#topMenu .menuLink {
	text-decoration: none;
	color: white;
	display: block;
	width: 150px;
	font-size: 16px;
	font-weight: bold;
	font-family: "Trebuchet MS", Dotum, Arial;
}

#topMenu .menuLink1 {
	text-decoration: none;
	color: white;
	display: block;
	width: 150px;
	font-size: 16px;
	font-weight: bold;
	font-family: "Trebuchet MS", Dotum, Arial;
	background-color: #A1C298;
}

#topMenu .menuLink:hover {
	color: #FBF2CF;
	background-color: #F8C4B4;
}

/* .active2 {
	color: red !important;
}
 */
/*=======최신순 인기순 마우스오버=================  */
.date_like:hover {
	color:#F8C4B4;
  font-weight: bolder;
  cursor: pointer;
}
/*=======최신순 인기순 마우스오버=================  */

/*===============상품올리기 버튼========================  */
@import url(https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700);

/*
.fonts {
  font-family: 'Josefin Slab', serif;
}
*/

body {
  font-family: 'Josefin Slab', serif;
  font-size: 20px;
  line-height: 24px;
  color: #333;
  background: #C6EBC5;
  overflow-y: scroll;
}

p {
  margin-bottom: 0.5em;
}

a,
a:visited {
  text-decoration: none;
  color: #F8C4B4;
}

.clear {
  clear: both;
}

.pageTitle {
  font-size: 2em;
  font-weight: 700;
  text-transform: uppercase;
  line-height: 1em;
  color: #C6EBC5;
}

.pageSubTitle {
  margin-bottom: 0.5em;
  font-size: 1.3em;
  font-weight: 700;
  line-height: 1em;
  color: #222;
}

.articleTitle {
  font-size: 1.15em;
  font-weight: 700;
  line-height: 1em;
  color: #222;
}

.wrapper {
  width: 600px;
  margin: 20px auto;
}

.container {
  padding-top: 1em;
  margin-top: 1em;
  border-top: 
    solid
    1px
    #CCC;
}

a.button {
  display: block;
  position: relative;
  float: left;
  width: 120px;
  padding: 0;
  margin: 10px 20px 10px 0;
  font-weight: 600;
  text-align: center;
  line-height: 50px;
  color: #FFF;
  border-radius: 5px;
  transition: all 0.2s ;
}

.btnBlueGreen {
  background: #C6EBC5;
}

.btnLightBlue {
  background: #5DC8CD;
}

.btnOrange {
  background: #FFAA40;
}

.btnPurple {
  background: #A74982;
}

/* FADE */
.btnFade.btnBlueGreen:hover {
color:white;
  background: #F8C4B4;
  font-weight: bolder;
  cursor: pointer;
}

.btnFade.btnLightBlue:hover {
  background: #01939A;
}

.btnFade.btnOrange:hover {
  background: #FF8E00;
}

.btnFade.btnPurple:hover {
  background: #6D184B;
}

/* 3D */
.btnBlueGreen.btnPush {
  box-shadow: 0px 5px 0px 0px #007144;
}

.btnLightBlue.btnPush {
  box-shadow: 0px 5px 0px 0px #1E8185;
}

.btnOrange.btnPush {
  box-shadow: 0px 5px 0px 0px #A66615;
}

.btnPurple.btnPush {
  box-shadow: 0px 5px 0px 0px #6D184B;
}

.btnPush:hover {
  margin-top: 15px;
  margin-bottom: 5px;
}

.btnBlueGreen.btnPush:hover {
  box-shadow: 0px 0px 0px 0px #007144;
}

.btnLightBlue.btnPush:hover {
  box-shadow: 0px 0px 0px 0px #1E8185;
}

.btnOrange.btnPush:hover {
  box-shadow: 0px 0px 0px 0px #A66615;
}

.btnPurple.btnPush:hover {
  box-shadow: 0px 0px 0px 0px #6D184B;
}

/* BORDER */
.btnBlueGreen.btnBorder {
  box-shadow: 0px 0px 0px 0px #C6EBC5;
}

.btnBlueGreen.btnBorder:hover {
  box-shadow: 0px 0px 0px 5px #F8C4B4;
}

.btnLightBlue.btnBorder {
  box-shadow: 0px 0px 0px 0px #01939A;
}

.btnLightBlue.btnBorder:hover {
  box-shadow: 0px 0px 0px 5px #01939A;
}

.btnOrange.btnBorder {
  box-shadow: 0px 0px 0px 0px #A66615;
}

.btnOrange.btnBorder:hover {
  box-shadow: 0px 0px 0px 5px #A66615;
}

.btnPurple.btnBorder {
  box-shadow: 0px 0px 0px 0px #6D184B;
}

.btnPurple.btnBorder:hover {
  box-shadow: 0px 0px 0px 5px #6D184B;
}

/* FLOAT */
.btnFloat {
  background: none;
  box-shadow: 0px 0px 0px 0px rgba(0, 0, 0, 0.5);
}

.btnFloat:before {
  content: 'Float';
  display: block;
  position: absolute;
  top: 0;
  left: 0;
  width: 120px;
  height: 50px;
  border-radius: 5px;
  transition: all 0.2s ;
}

.btnBlueGreen.btnFloat:before {
  background: #F8C4B4;
}

.btnLightBlue.btnFloat:before {
  background: #5DC8CD;
}

.btnOrange.btnFloat:before {
  background: #FFAA40;
}

.btnPurple.btnFloat:before {
  background: #8D336A;
}


.btnFloat:before {
  box-shadow: 0px 0px 0px 0px rgba(0, 0, 0, 0.4);
}

.btnFloat:hover:before {
  
}

.btnFloat:hover:before {
  margin-top: -2px;
  margin-left: 0px;
  transform: scale(1.1,1.1);
  -ms-transform: scale(1.1,1.1);
  -webkit-transform: scale(1.1,1.1);
  box-shadow: 0px 5px 5px -2px rgba(0, 0, 0, 0.25);
}

/* SLIDE */
.btnSlide.btnBlueGreen {
  background: 0;
}

.btnSlide .top {
  position: absolute;
  top: 0px;
  left: 0;
  width: 120px;
  height: 50px;
  background: #C6EBC5;
  z-index: 10;
  transition: all 0.2s ;
  border-radius: 5px;
}

.btnSlide.btnBlueGreen .top {
  background: #C6EBC5;
}

.btnSlide.btnLightBlue .top {
  background: #5DC8CD;
}

.btnSlide.btnOrange .top {
  background: #FFAA40;
}

.btnSlide.btnPurple .top {
  background: #A74982;
}

.btnSlide .bottom {
  position: absolute;
  top: 0;
  left: 0;
  width: 120px;
  height: 50px;
  color: #000;
  z-index: 5;
  border-radius: 5px;
}

.btnSlide:hover .top {
  top: 40px;
}
/*===============상품올리기 버튼========================  */

</style>

<!-- <script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	alert("확인");

	
});
</script> -->
<%@ include file="../include/header.jsp" %>

    <!-- ##### Breadcrumb Area Start ##### -->
    <div class="breadcrumb-area">
        <!-- Top Breadcrumb Area -->
        <div class="top-breadcrumb-area bg-img bg-overlay d-flex align-items-center justify-content-center" style="background-image: url(${pageContext.request.contextPath }/resources/img/bg-img/24.jpg);">
            <h2>Shop</h2>
        </div>

        <div class="container" style="margin: auto; width: 100%; ">
            <div class="row">
                <div class="col-12" style="margin: auto; width: 100%; ">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="#"><i class="fa fa-home"></i> Home</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Shop</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>
	<!-- ##### Breadcrumb Area End ##### -->
	

	<!-- =================================남성용/여성용 성별 구분 상품 카테고리===========================================   -->
	
	<div style="text-align: center; margin: 0px auto; height: 70px; width: 80%;">
	        <nav id="topMenu" style="margin: 0px auto;">
                <ul>
						<!-- 남성용  -->
                        <li><a class="menuLink1"> Men's </a></li>
                        <li><a class="menuLink" href="${pageContext.request.contextPath }/product/listAll?category=Driver&gender=1">Driver</a></li>
                        <li><a class="menuLink" href="${pageContext.request.contextPath }/product/listAll?category=Iron&gender=1">Iron</a></li>
                        <li><a class="menuLink" href="${pageContext.request.contextPath }/product/listAll?category=Utility&gender=1">Utility</a></li>
                        <li><a class="menuLink" href="${pageContext.request.contextPath }/product/listAll?category=Wedge&gender=1">Wedge</a></li>
                        <li><a class="menuLink" href="${pageContext.request.contextPath }/product/listAll?category=Putter&gender=1">Putter</a></li>
                        <li><a class="menuLink" href="${pageContext.request.contextPath }/product/listAll?category=Etc&gender=1">Etc</a></li>
               
               			<!-- 여성용 -->
               			<li><a class="menuLink1"> Women's </a></li>
                        <li><a class="menuLink" href="${pageContext.request.contextPath }/product/listAll?category=Driver&gender=2">Driver</a></li>
                        <li><a class="menuLink" href="${pageContext.request.contextPath }/product/listAll?category=Iron&gender=2">Iron</a></li>
                        <li><a class="menuLink" href="${pageContext.request.contextPath }/product/listAll?category=Utility&gender=2">Utility</a></li>
                        <li><a class="menuLink" href="${pageContext.request.contextPath }/product/listAll?category=Wedge&gender=2">Wedge</a></li>
                        <li><a class="menuLink" href="${pageContext.request.contextPath }/product/listAll?category=Putter&gender=2">Putter</a></li>
                        <li><a class="menuLink" href="${pageContext.request.contextPath }/product/listAll?category=Etc&gender=2">Etc</a></li>
               
               
               
                </ul>
        	</nav>

    	</div>
	<!-- =================================남성용/여성용 성별 구분 상품 카테고리===========================================   -->


	
	<!-- ##### Shop Area Start ##### -->
	<section class="shop-page section-padding-0-100" style="width: 80%; margin: auto;">
        <div class="container" style="border: none; margin-top:0px; ">
            <div class="row">
                <!-- Shop Sorting Data -->
                <div class="col-12"  style="width: 98%; margin: auto; ">

                        
                        <div class="search_by_terms" style="float: right;">

                                
                        <!-- 인기순,최신순 선택바 div  -->
						<div style="float: right;"> 
						<form action="#" method="post" class="form-inline">

                                
                                <a class="date_like" style="color:#A1C298; font-size: 15px;" href="${pageContext.request.contextPath }/product/listAll?category=${category}&gender=${gender}">최신순</a>
                 				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <a class="date_like" style="color:#A1C298; font-size: 15px;" href="${pageContext.request.contextPath }/product/listLike?category=${category}&gender=${gender}">인기순</a>
                            
                            </form>
                        </div>    
                        
                        

                        
                        </div>
                        
                    </div>
                </div>
            </div>
            

                <!-- All Products Area -->
                <div class="col-12 col-md-8 col-lg-9" style="margin: auto;" id="products">
                    <div class="shop-products-area">
                        <div class="row">

							<!-- Single Product Area -->
							<!-- for문으로 상품 리스트 반복  -->
							<c:forEach var="vo" items="${productList }">
								<div class="col-12 col-sm-6 col-lg-4">
									<div class="single-product-area mb-50">
										<!-- Product Image -->

											<a href="${pageContext.request.contextPath }/product/productDetail?prod_num=${vo.prod_num}"><img src="${pageContext.request.contextPath }/resources/product_img/${vo.prod_img}"></a>
										<div class="product-img">

											<!-- Product Tag -->
											<div class="product-tag">
												<a href="#">Hot</a>
											</div>
											<div class="product-meta d-flex">
												<a href="#" class="wishlist-btn"><i class="icon_heart_alt"></i></a>
												<a href="cart.html" class="add-to-cart-btn">Add to cart</a>
												<a href="#" class="compare-btn"><i class="arrow_left-right_alt"></i></a>
											</div>
										</div>
										<!-- Product Info -->
										<div class="product-info mt-15 text-center">
											<a href="${pageContext.request.contextPath }/product/productDetail?prod_num=${vo.prod_num}">
												<p>${vo.prod_name }</p>
											</a>
											<h6>${vo.price }원</h6>
										</div>
									</div>
								</div>
							</c:forEach>
							<!-- for문으로 상품 리스트 반복  -->

                                         <!-- 상품 올리기 div  -->
                        <div style="float: right; margin-bottom: 60px; width: 100px; margin-left: 950px;">
<%-- 							<input type="button" title="Button fade blue/green" class="button btnFade btnBlueGreen" value="상품올리기" onclick="location.href='${pageContext.request.contextPath }/product/productInsert'">
 --%>							    <a title="Button fade blue/green" class="button btnFade btnBlueGreen" onclick="location.href='${pageContext.request.contextPath }/product/productInsert'">상품올리기</a>
						</div>        
                        </div>
                        

<!-- ======================================== 페이징 네비바 ======================================== -->
						<!-- Pagination -->
						<nav aria-label="Page navigation">
							<ul class="pagination" style="width: 910px; margin:0px auto;">
								<c:if test="${pm.prev }">
									<!-- ${pm.prev }결과가 참(true)일 때 -->
									<li class="page-item"><a class="page-link" href="listAll?page=${pm.startPage-1 }&category=${category }"><i class="fa fa-angle-left"></i></a></li>
									<!-- 현재 위치한 페이지 블럭의 첫번째 페이지보다 -1인 페이지로 이동  -->
								</c:if>

								<c:forEach var="idx" begin="${pm.startPage }" end="${pm.endPage }">
									<li class="page-item" <c:out value="${pm.vo.page == idx?'class=active':'active' }"/> style="text-align: center; margin:0px auto;">
									<a class="page-link" href="listAll?page=${idx }&category=${category }">${idx }</a></li>
								</c:forEach>
								
								<c:if test="${pm.next }">
									<!-- ${pm.next }결과가 참(true)일 때  -->
									<li class="page-item"><a class="page-link" href="listAll?page=${pm.endPage+1 }&category=${category }"><i class="fa fa-angle-right"></i></a></li>
									<!-- 현재 위치한 페이징 블럭의 마지막 페이지보다 +1인 페이지로 이동  -->
								</c:if>
							</ul>
						</nav>
<!-- ======================================== 페이징 네비바 ======================================== -->

				</div>
			</div>
<!-- 		</div> -->
<!-- 	</div> -->
</section>

    <!-- ##### Shop Area End ##### -->
<%@ include file="../include/footer.jsp" %>


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
</body>

</html>