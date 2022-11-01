<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- header -->
<jsp:include page="../include/header.jsp" />
<!-- header -->
	
 <!-- ##### Breadcrumb Area Start ##### -->
    <div class="breadcrumb-area">
        
        <div class="top-breadcrumb-area bg-img bg-overlay d-flex align-items-center justify-content-center" style="background-image: url(${pageContext.request.contextPath }/resources/img/bg-img/24.jpg);">
            <h2>COMMUNITY</h2>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="#"><i class="fa fa-home"></i> Home</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Community</li>
                            <li class="breadcrumb-item active" aria-current="page">Modify</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>
<!-- ##### Breadcrumb Area End ##### -->


			<!-- 글쓰기 입력폼 시작@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ --> 
 			<div class="col-12 col-lg-5">
                    <!-- Section Heading -->
                    <div class="section-heading">
                        <h2>글 상세 페이지</h2>
                        <p>보세용~.~</p>
                    </div>
                    
                    <!-- 수정, 삭제 시 필요한 글번호 저장 -->
					<form action="/board/boardModify" method="post">
                    ${vo }
                    <!-- Contact Form Area -->
                    <div class="contact-form-area mb-100">
                            <div class="row">
                            	<div class="col-12 col-md-6">
                                    <div class="form-group">
                                        <input type="text" class="form-control" name="board_num" id="contact-name" readonly value="${vo.board_num }">
                                    </div>
                                </div>
                                <div class="col-12 col-md-6">
                                    <div class="form-group">
                                        <select class="form-control" name="board_category" id="board_category" >
   												<option value="질문">질문</option>
    											<option value="친목">친목</option>
    											<option value="정보">정보</option>
    											<option value="신고">신고</option>
                                        </select>
                                        
                                    </div>
                                </div>
                                <div class="col-12">
                                    <div class="form-group">
                                        <input type="text" class="form-control" name="title" id="contact-subject" value="${vo.title }">
                                    </div>
                                </div>
                                <div class="col-12 col-md-6">
                                    <div class="form-group">
                                        <input type="text" class="form-control" name="user_name" id="contact-name" readonly value="${vo.user_name }">
                                    </div>
                                </div>
                                <div class="col-12 col-md-6">
                                    <div class="form-group">
                                   		<fmt:formatDate pattern="yy-MM-dd HH:mm" value="${vo.write_date }"/> &nbsp;&nbsp;&nbsp; 조회수 ${vo.readcount }
                                        <%-- <input type="email" class="form-control" name="write_date" id="contact-email" placeholder="글쓴시간" value="${vo.write_date }"> --%>
                                    </div>
                                </div>
                                <div class="col-12">
                                    <div class="form-group">
                                        <textarea class="form-control" name="content" id="message" cols="30" rows="10">${vo.content }</textarea>
                                    </div>
                                </div>
                                <div class="col-12">
                                    <button type="submit" class="btn alazea-btn mt-15" id="updateBoard">수정</button>
                                    <input type="button" class="btn alazea-btn mt-15" value="목록" onclick="location.href='/board/listBoardAll';">
                                </div>
                            </div>
                    </div>
					</form>
                </div>
			<!-- 글쓰기 입력폼 끝@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ --> 









<script type="text/javascript">

var ctg = "<c:out value='${vo.board_category}'/>";

$('select[name="board_category"]').val(ctg).prop("selected", true);

</script>



<!-- 푸터들어가는 곳 -->
<jsp:include page="../include/footer.jsp" />
<!-- 푸터들어가는 곳 -->





