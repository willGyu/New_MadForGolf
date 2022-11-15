<%@page import="com.madforgolf.persistence.MemberDAO"%>
<%@page import="com.madforgolf.domain.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ include file="../include/header.jsp" %>
 	<!-- session값이 없을 경우 login 페이지 이동 -->
 	<c:if test="${user_id == null }">
		<c:redirect url="/member/login"/>
	</c:if>
	
<style type="text/css">

</style>

    <!-- ##### Breadcrumb Area Start ##### -->
    <div class="breadcrumb-area">
        <!-- Top Breadcrumb Area -->
        <div class="top-breadcrumb-area bg-img bg-overlay d-flex align-items-center justify-content-center" style="background-image: url(${pageContext.request.contextPath }/resources/img/bg-img/24.jpg);">
            <h2>MyPage</h2>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-12">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="#"><i class="fa fa-home"></i> Home</a></li>
                            <li class="breadcrumb-item active" aria-current="page">MyPage</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>
    <!-- ##### Breadcrumb Area End ##### -->

    <!-- ##### About Area Start ##### -->
    <!-- 본문 -->

    <section class="about-us-area">
        <div class="container" style="width:800; margin:0px auto;">
            <!-- <div class="row justify-content-between"> -->
                <div class="col-12 col-lg-12" justify-content="center">
                    <!-- Section Heading -->
                    <div class="row">
                    <div class="section-heading col-12 col-lg-12">
                        <h2>${user_name } 님의 마이페이지</h2><br>
					<%-- <p>${user_name} 님의 매너스코어는 ${loginVO.score }입니다.</p> --%>
					
					<!-- 매너스코어 -->
				<div class="single-cool-fact d-flex align-items-center justify-content-center mb-100">
		<div class="cf-icon">
			<img src="/resources/img/core-img/cf3.png" alt=""> 
				</div>
					<c:set var="score" scope="session" value="${loginVO.score }" />
				  	<p><c:out value="${user_name }"/>님의 매너 점수는</p>
				  	<p>
				  	<c:choose>
				  		<c:when test="${score <=20 }">
				  			파
				  		</c:when>
				  		<c:when test="${score <=40 }">
				  			버디
				  		</c:when>
				  		<c:when test="${score <=60 }">
				  			이글
				  		</c:when>
				  		<c:when test="${score <=80 }">
				  			알바트로스
				  		</c:when>
				  		<c:when test="${score <=100 }">
				  			홀인원
				  		</c:when>
				  		<c:otherwise>
				  			리뷰가 없습니다.
				  		</c:otherwise>
				  	</c:choose>
				  	</p>
		 </div> 
	</div>
				<!-- 매너스코어 -->
					
                        <br><br><br>
                    <!-- <button type="button" class="btn alazea-btn w-80" onClick="location.href='#'">채팅목록</button> <br>
                    <button type="button" class="btn alazea-btn w-80" onClick="location.href='#'">지역인증</button> <br>
                    <button type="button" class="btn alazea-btn w-80" onClick="location.href='#'">내가 쓴 리뷰</button> <br>
                    <button type="button" class="btn alazea-btn w-80" onClick="location.href='/product/productInsert'">상품등록</button> <br>
                    </div> -->

                <div class="col-20 col-lg-20">
                    <div class="alazea-benefits-area">
                        <div class="row">
                            <!-- 회원 정보 수정 -->
                            <div class="col-12 col-sm-12">
                                <div class="single-benefits-area" onClick="location.href='/member/update'">
                                    <a href="/member/update"><img src="${pageContext.request.contextPath }/resources/img/core-img/b1.png" alt=""></a>
                                     <a href="/member/update"><h5>회원정보수정</h5></a>
                                     <a href="/member/update"><p>회원정보를 관리하는 공간입니다. </p></a>
                                </div>
                            </div>

                            <!-- 매너 스코어 -->
                            <div class="col-12 col-sm-12">
                                <div class="single-benefits-area" onClick="location.href='/mypage/mannerScore'">
                                    <a href="/member/update"><img src="${pageContext.request.contextPath }/resources/img/core-img/b2.png" alt=""></a>
                                     <a href="/member/update"><h5>매너스코어</h5></a>
                                     <a href="/member/update"><p>나의 매너스코어와 나에게 쓴 리뷰 내역을 확인할 수 있는 공간입니다. </p></a>
                                </div>
                            </div>
                            
                            <!-- 가계부 -->
                            <div class="col-12 col-sm-12">
                                <div class="single-benefits-area" onClick="location.href='/mypage/accountbookMonth'">
                                    <a href="#"><img src="${pageContext.request.contextPath }/resources/img/core-img/b3.png" alt=""></a>
                                    <a href="#"><h5>가계부</h5></a>
                                    <a href="#"><p>월 별 구매, 판매 내역을 확인할 수 있는 공간입니다.</p></a>
                                </div>
                            </div>

                            <!-- 거래 목록 -->
                            <div class="col-12 col-sm-12">
                                <div class="single-benefits-area" onClick="location.href='/product/listProductAll?page=1'">
                                    <a href="#"><img src="${pageContext.request.contextPath }/resources/img/core-img/b4.png" alt=""></a>
                                    <a href="#"><h5>거래 목록</h5></a>
                                    <a href="#"><p>판매내역 및 구매내역을 확인할 수 있는 공간입니다. </p></a>
                                </div>
                            </div>

                            <!-- 문의 내역 -->
                            <div class="col-12 col-sm-12">
                                <div class="single-benefits-area" onClick="location.href='/mypage/qnaList'">
                                   <a href="#"><img src="${pageContext.request.contextPath }/resources/img/core-img/b1.png" alt=""></a>
                                   <a href="#"> <h5>문의 내역</h5></a>
                                   <a href="#"> <p>나의 문의 내역을 확인할 수 있는 공간입니다. </p></a>
                                </div>
                            </div>
                            
                            <!-- 찜 목록 -->
                            <div class="col-12 col-sm-12">
                                <div class="single-benefits-area" onClick="location.href='/member/likeListAll'">
                                    <a href="/member/likeListAll"><img src="${pageContext.request.contextPath }/resources/img/core-img/b2.png" alt=""></a>
                                     <a href="/member/likeListAll"><h5>찜 목록</h5></a>
                                     <a href="/member/likeListAll"><p>내가 찜한 상품을 확인할 수 있는 공간입니다. </p></a>
                                </div>
                            </div>
                            
                            <!-- 채팅 목록 -->
                            <div class="col-12 col-sm-12">
                                <div class="single-benefits-area" onClick="location.href='/product/chattingList'">
                                    <a href="/product/chattingList"><img src="${pageContext.request.contextPath }/resources/img/core-img/b3.png" alt=""></a>
                                     <a href="/product/chattingList"><h5>채팅 목록</h5></a>
                                     <a href="/product/chattingList"><p>나의 채팅 목록을 확인할 수 있는 공간입니다. </p></a>
                                </div>
                            </div>
                            
                            <!-- 지역 인증 -->
                            <div class="col-12 col-sm-12">
                                <div class="single-benefits-area" onClick="location.href='/member/address'">
                                    <a href="/member/address"><img src="${pageContext.request.contextPath }/resources/img/core-img/b4.png" alt=""></a>
                                     <a href="/member/address"><h5>지역 인증</h5></a>
                                     <a href="/member/address"><p>나의 지역을 인증할 수 있는 공간입니다. </p></a>
                                </div>
                            </div>
                            
                            <!-- 상품 등록 -->
                            <div class="col-12 col-sm-12">
                                <div class="single-benefits-area" onClick="location.href='/product/productInsert'">
                                    <a href="/member/update"><img src="${pageContext.request.contextPath }/resources/img/core-img/b1.png" alt=""></a>
                                     <a href="/member/update"><h5>상품 등록</h5></a>
                                     <a href="/member/update"><p>상품을 등록할 수 있는 공간입니다. </p></a>
                                </div>
                            </div>
                            
                            <!-- 회원 탈퇴 -->
                            <div class="col-12 col-sm-12">
                                <div class="single-benefits-area" onClick="location.href='/member/delete'">
                                    <a href="/member/update"><img src="${pageContext.request.contextPath }/resources/img/core-img/b2.png" alt=""></a>
                                     <a href="/member/update"><h5>회원 탈퇴</h5></a>
                                     <a href="/member/update"><p>정말 탈퇴하시겠습니까? </p></a>
                                </div>
                            </div>
                    </div>
                        <!-- </div> -->
                    </div>
                </div>
            </div>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="border-line"></div>
                </div>
            </div>
        </div>
    </section>
    <!-- ##### About Area End ##### -->
    <!-- 본문 -->
    
    
    
    <!-- 서비스 소개 -->
    <!-- ##### Service Area Start ##### -->
    <section class="our-services-area bg-gray section-padding-100-0">
        <div class="container" id=service>
            <div class="row">
                <div class="col-12">
                    <!-- Section Heading -->
                    <div class="section-heading text-center">
                        <h2>OUR SERVICES</h2>
                        <p>We provide the perfect service for you.</p>
                    </div>
                </div>
            </div>

            <div class="row align-items-centern">
                <div class="col-12 col-lg-5">
                    <div class="alazea-service-area mb-100">

                        <!-- Single Service Area -->
                        <div class="single-service-area d-flex align-items-center">
                            <!-- Icon -->
                            <div class="service-icon mr-30">
                                <img src="${pageContext.request.contextPath }/resources/icon/golf-bag.png" alt="">
                            </div>
                            <!-- Content -->
                            <div class="service-content">
                                <h5>Golf Club Trade</h5>
                                <p>뭐라 쓰지... 문구 생각중</p>
                            </div>
                        </div>

                        <!-- Single Service Area -->
                        <div class="single-service-area d-flex align-items-center">
                            <!-- Icon -->
                            <div class="service-icon mr-30">
                                <img src="${pageContext.request.contextPath }/resources/icon/golf-course.png" alt="">
                            </div>
                            <!-- Content -->
                            <div class="service-content">
                                <h5>Community</h5>
                                <p>뭐라 쓰지... 문구 생각중</p>
                            </div>
                        </div>

                        <!-- Single Service Area -->
                        <div class="single-service-area d-flex align-items-center">
                            <!-- Icon -->
                            <div class="service-icon mr-30">
                                <img src="${pageContext.request.contextPath }/resources/icon/annual-report.png" alt="">
                            </div>
                            <!-- Content -->
                            <div class="service-content">
                                <h5>Account Book</h5>
                                <p>뭐라 쓰지... 문구 생각중</p>
                            </div>
                        </div>
                        
                        <!-- Single Service Area -->
                        <div class="single-service-area d-flex align-items-center">
                            <!-- Icon -->
                            <div class="service-icon mr-30">
                                <img src="${pageContext.request.contextPath }/resources/icon/technical-support.png" alt="">
                            </div>
                            <!-- Content -->
                            <div class="service-content">
                                <h5>Customer Service</h5>
                                <p>뭐라 쓰지... 문구 생각중</p>
                            </div>
                        </div>

                    </div>
                </div>
                
            </div>
        </div>
    </section>
    <!-- ##### Service Area End ##### -->
    <!-- 서비스 소개 -->

   
    

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



<%@ include file="../include/footer.jsp" %>