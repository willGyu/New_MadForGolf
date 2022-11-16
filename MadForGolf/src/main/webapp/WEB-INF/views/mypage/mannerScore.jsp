<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../include/header.jsp" %> 
   
   
   
	<style>
	
/*	.alazea-blog-area mb-100{
	
	display: inline-block;
	width: 85%;
	text-align: center;
	
	
	}
	
	.col-12 col-lg-6 {
	
	width: 100%;
	text-align: center;
	margin: auto;
	
	} */
	
	.post-content{
	
	width: 100%;
	
	}
	
	.container{
	
	width : 100%;
	text-align: center;
	margin: auto;
	
	}
	
.container_box{
/* 	border: 5px solid black; */

}	
	
	
.table_box{
/* 		border: 5px solid yellow; */
		margin-top: 60px;
}

.table td, .table th {
    padding: 1rem;
}    

.page_box{
/* 	border: 5px solid blue; */
	
	margin: 40px 0;
}

#page-link_real:hover{
	background-color: #C6EBC5;
	border: 1px solid #C6EBC5;
}

@media only screen and (max-width: 767px){
	.category_btn{
		width: 100px;
	}
	.table td, .table th {
    	padding: 1.5rem 0.5rem;
}

	.pagination{
/*  			border: 5px solid blue;  */
		
	}
	
	
	.page-item{
/*  		border: 5px solid red;  */
		display: flex;
		height: 30px;
		position: relative;
	}
	#page-link_real{
/*  			border: 5px solid yellow;  */
			font-size: 15px;
			width: 40px;
			height: 40px;
			line-height: 40px;
			padding: 0px;
  			margin: 0 2px; 
			border-radius: 50%;
			
	}
	
.text{

	font-size: 13px;
	
	}
		
}
</style>


       <!-- ##### Breadcrumb Area Start ##### -->
    <div class="breadcrumb-area">
        <!-- Top Breadcrumb Area -->
        <div class="top-breadcrumb-area bg-img bg-overlay d-flex align-items-center justify-content-center" style="background-image: url('/resources/img/bg-img/background-img (3).jpg');">
            <h2>MannerScore</h2>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-12">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="/"><i class="fa fa-home"></i> Home</a></li>
                            <li class="breadcrumb-item active" aria-current="page">MannerScore</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>
    <!-- ##### Breadcrumb Area End ##### -->

<div class="container container_box">
	<div class="single-blog-post mb-50">
                                                           
	<!-- 매너스코어 -->
	<div class="single-cool-fact d-flex align-items-center justify-content-center mb-100">
		<div class="cf-icon">
			<img src="/resources/img/core-img/cf3.png" alt=""> 
				</div>
					<c:set var="score" scope="session" value="${vo.score }" />
				  	<p><c:out value="${user_name }"/></p>
				  	<p> 님의 매너 점수는  </p>
				  	<p>
				  	<c:choose>
				  		<c:when test="${score <=20 }">
				  			   '파' 입니다
				  		</c:when>
				  		
				  		<c:when test="${score <=40 }">
				  			  '버디' 입니다
				  		</c:when>
				  		
				  		<c:when test="${score <=60 }">
				  			  '이글' 입니다
				  		</c:when>
				  		
				  		<c:when test="${score <=80 }">
				  			   '알바트로스' 입니다
				  		</c:when>
				  		
				  		<c:when test="${score <=100 }">
				  			   '홀인원' 입니다
				  		</c:when>
				  		
					</c:choose>
				  	</p>
<!-- 				  	<p> 입니다.</p> -->
			 </div>
		</div>
	<!-- 매너스코어 -->

	
    <!-- ##### Blog Area Start ##### 
    <section class="alazea-blog-area mb-100">
        <div class="container">
            <div class="row">
                <div class="col-12 col-md-8" style="margin: auto;">
                    <div class="row">

                        <!-- ▼ 리뷰 내용 부분 -->
<%--                         <c:forEach var="list" items="${rvo }" varStatus="status"> </c:forEach>--%>

                       <!-- <div class="col-12 col-lg-6">
                            <div class="single-blog-post mb-50">
                            
								 ▼ 이미지 영역
                                <div class="post-thumbnail mb-30">
                                    <a href="#">${prod_img }</a>
                                </div>
                                
                                <div class="post-content">
                                    <a href="${pageContext.request.contextPath }/resources/single-post.html" class="post-title"></a>
                                    <div class="post-meta">
                                        <a><i class="fa fa-clock-o" aria-hidden="true"></i>${list.review_date }</a>
                                    </div>
                                    <a href="/mypage/reviewSell?prod_num=${list.prod_num }">${list.content }</a>
                                </div>
                         </div>
                             
                             
									</div>
								
							</div>
                	    </div>
                    </div>
                     -->
                    
    <!--  #####  게시글 리스트 시작   ##### --> 
	<div class="table_box">
	
		<table class="table">
			<tbody>
			
				<tr>
					<th>No</th>
					<th>Content</th>
					<th>Date</th>
				</tr>
		
			 <c:forEach var="list" items="${rvo }" varStatus="status">
				<tr>
					<td class="text">${list.review_num }</td>
<%-- 					<td class="category all text">${list.content}</td> --%>
					<td>
						<a href="/mypage/reviewSell?prod_num=${list.prod_num }">${list.content }</a>
					</td>
					<td>	
   					   <fmt:formatDate value="${list.review_date }" pattern="yy-MM-dd HH:mm"/>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
    <!--  #####  게시글 리스트 종료   ##### --> 
                    

                    
	<!-- ##### 페이징 처리 시작  ##### -->
	<div class="page_box">
	
	<nav aria-label="Page navigation">
    	<ul class="pagination">
    	
    		<c:if test="${pm.prev}"> 
	        	<li class="page-item">
	        		<a class="page-link" id="page-link_real" href="mannerScore?page=${pm.startPage-1}">
        				<i class="fa fa-angle-left"></i>
       				</a>
     			</li>
	        </c:if>
	        
	        <c:forEach var="idx" begin="${pm.startPage }" end="${pm.endPage }">
	        	<li class="page-item" ${pm.vo.page == idx ? 'class=active' : '' }>
	        		<a class="page-link" id="page-link_real" href="mannerScore?page=${idx}">${idx}</a>
        		</li>
	        </c:forEach>
	        
	        <c:if test="${pm.next}">
	        	<li class="page-item">
	        		<a class="page-link" id="page-link_real" href="mannerScore?page=${pm.endPage+1 }">
	        			<i class="fa fa-angle-right"></i>
        			</a>
       			</li>
      		</c:if>
	    </ul>
	</nav>
	</div>
</div>
</section>
	<!-- #####  페이징 처리 종료 #####  -->
	
	<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			type:
		});
	
	
	</script>
	
	
	
	
	
	<!-- ▼ 푸터 -->

	<jsp:include page="../include/footer.jsp" />

	<!-- ▲ 푸터 종료  -->

    <!-- ##### All Javascript Files ##### -->
    <!-- jQuery-2.2.4 js -->
    <script src="js/jquery/jquery-2.2.4.min.js"></script>
    <!-- Popper js -->
    <script src="js/bootstrap/popper.min.js"></script>
    <!-- Bootstrap js -->
    <script src="js/bootstrap/bootstrap.min.js"></script>
    <!-- All Plugins js -->
    <script src="js/plugins/plugins.js"></script>
    <!-- Active js -->
    <script src="js/active.js"></script>
