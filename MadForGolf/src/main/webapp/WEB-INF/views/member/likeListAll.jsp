<%@page import="com.madforgolf.persistence.MemberDAO"%>
<%@page import="com.madforgolf.domain.MemberVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ include file="../include/header.jsp" %>

<!-- ##### Breadcrumb Area Start ##### -->
    <div class="breadcrumb-area">
        <!-- Top Breadcrumb Area -->
        <div class="top-breadcrumb-area bg-img bg-overlay d-flex align-items-center justify-content-center" style="background-image: url(${pageContext.request.contextPath }/resources/img/bg-img/24.jpg);">
            <h2>wishList</h2>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="#"><i class="fa fa-home"></i> Home</a></li>
                            <li class="breadcrumb-item active" aria-current="page">wishList</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>
<!-- ##### Breadcrumb Area End ##### --> 



	<div class="checkout_area mb-100">
		<div class="container">
	
	<h1> 📃WishList </h1> 
	나의 찜 목록<br><br><br>
<%-- 	${pm } --%>
				
				<div class="box-body">
				<table class="table table-bordered">
					<tbody>
						<tr>
<!-- 							<th style="width: 200px">유저아이디</th> -->
							<th style="width: 200px">판매자</th>
							<th>상품명</th>
							<th>가격</th>
<!-- 							<th>찜</th> -->
						</tr>

						<c:forEach var="vo" items="${likeList }">
						<tr>
							<td>
							<span class="badge bg-orange"><a href="/product/seller?prod_num=${vo.prod_num }">${vo.seller_id }</a></span>
							</td>
							<td><a href="/product/productDetail?prod_num=${vo.prod_num}">${vo.prod_name }</a></td>
							<td><a href="/product/productDetail?prod_num=${vo.prod_num}">${vo.price }</a></td>
<%-- 							<td>${vo.check }</td> --%>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
	
			</div>
		</div>
	
<!-- ======================================== 페이징 네비바 ======================================== -->
			<!-- Pagination -->
			<nav aria-label="Page navigation">
				<ul class="pagination">
					<c:if test="${pm.prev }">
<%-- 						${pm.prev }결과가 참(true)일 때 --%>
						<li class="page-item"><a id="ProductAreaPage" class="page-link" href="likeListAll?page=${pm.startPage-1 }&buyer_id=${user_id }"><i class="fa fa-angle-left"></i></a></li>
<!-- 						현재 위치한 페이지 블럭의 첫번째 페이지보다 -1인 페이지로 이동  -->
							</c:if>
								<c:forEach var="idx" begin="${pm.startPage }" end="${pm.endPage }">
								<li class="page-item" <c:out value="${pm.vo.page == idx?'class=active':'active' }"/>>
								<a id="ProductAreaPage" class="page-link" href="likeListAll?page=${idx }&buyer_id=${user_id }">${idx }</a></li>
							</c:forEach>
							
							<c:if test="${pm.next }">
<%-- 								${pm.next }결과가 참(true)일 때  --%>
								<li class="page-item"><a id="ProductAreaPage" class="page-link" href="likeListAll=${pm.endPage+1 }&buyer_id=${user_id }"><i class="fa fa-angle-right"></i></a></li>
<!-- 								현재 위치한 페이징 블럭의 마지막 페이지보다 +1인 페이지로 이동  -->
							</c:if>
						</ul>
					</nav>
<!-- ======================================== 페이징 네비바 ======================================== -->
	

	
	
	
	
<%@ include file="../include/footer.jsp" %>
