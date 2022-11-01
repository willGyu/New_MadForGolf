<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

    
<!-- header -->
<jsp:include page="../include/header.jsp" />
<!-- header -->
   
   
     <!-- ##### Breadcrumb Area Start ##### -->
    <div class="breadcrumb-area">
        <!-- Top Breadcrumb Area -->
        <div class="top-breadcrumb-area bg-img bg-overlay d-flex align-items-center justify-content-center" style="background-image: url(${pageContext.request.contextPath }/resources/img/bg-img/24.jpg);">
            <h2>Community</h2>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-12">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="#"><i class="fa fa-home"></i> Home</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Community</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>
    <!-- ##### Breadcrumb Area End ##### -->


<%-- 		<c:if test="${!(empty sessionScope.loginID) }"> --%>
        <div class="col-12">
        	<button class="btn alazea-btn mt-15" onclick="location.href='${pageContext.request.contextPath }/board/insertBoard'">글쓰기</button>
        </div>
<%-- 	</c:if> --%>


   		<!-- category 클릭 시 말머리별 게시글 리스트만 뜨도록 구현 -->
	 	<div class="category_list">
	 		<a class="btn alazea-btn mt-15" href="listBoardAll">전체</a>
	 		<a class="btn alazea-btn mt-15" href="listBoardCategory?board_category=질문">질문</a>
	 		<a class="btn alazea-btn mt-15" href="listBoardCategory?board_category=신고">신고</a>
	 		<a class="btn alazea-btn mt-15" href="listBoardCategory?board_category=친목">친목</a>
	 		<a class="btn alazea-btn mt-15" href="listBoardCategory?board_category=정보">정보</a>
		</div>
   
   
  <!--  #####  게시글 리스트 시작   ##### --> 

<table class="table">
	<tbody>
	
		<tr>
			<th>No</th>
			<th>Category</th>
			<th>Title</th>
			<th>Writer</th>
			<th>Date</th>
			<th>Count</th>
		</tr>

	<c:forEach var="vo" items="${boardList }">
		<tr>
			<td>${vo.board_num }</td>
			<td class="category all">${vo.board_category }</td>
			<td>
				<a href="/board/boardRead?board_num=${vo.board_num}">${vo.title }</a></td>
			<td>조인해오기</td>
			<td>
				<fmt:formatDate value="${vo.write_date }" pattern="yy-MM-dd HH:mm"/>
			</td>
			<td>${vo.readcount}</td>
		</tr>
	</c:forEach>
	</tbody>
</table>

	<!-- ##### 페이징 처리 시작  ##### -->
	<nav aria-label="Page navigation">
    	<ul class="pagination">
    	
    		<c:if test="${pm.prev}">
	        	<li class="page-item">
	        		<a class="page-link" href="listBoardAll?page=${pm.startPage-1}">
        				<i class="fa fa-angle-left"></i>
       				</a>
     			</li>
	        </c:if>
	        
	        <c:forEach var="idx" begin="${pm.startPage }" end="${pm.endPage }">
	        	<li class="page-item" ${pm.vo.page == idx ? 'class=active' : '' }>
	        		<a class="page-link" href="listBoardAll?page=${idx}">${idx}</a>
        		</li>
	        </c:forEach>
	        
	        <c:if test="${pm.next}">
	        	<li class="page-item">
	        		<a class="page-link" href="listBoardAll?page=${pm.endPage+1 }">
	        			<i class="fa fa-angle-right"></i>
        			</a>
       			</li>
      		</c:if>
	    </ul>
	</nav>
	
	<!-- #####  페이징 처리 종료 #####  -->

<!-- ##### 게시글 목록 종료 ##### -->

<!-- 푸터들어가는 곳 -->
<jsp:include page="../include/footer.jsp" />
<!-- 푸터들어가는 곳 -->	


	
