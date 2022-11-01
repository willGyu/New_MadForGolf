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
                            <li class="breadcrumb-item"><a href="#"> Community</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Writing</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>
    <!-- ##### Breadcrumb Area End ##### -->


<!-- 		<section class="contact-area"> -->
        <div class="container">
            <div class="row align-items-center justify-content-between">
				<div class="col-12 col-lg-5">
	
                    <!-- Section Heading -->
                    <div class="section-heading">
                        <h2>Write Board</h2>
<!--                         <p>Send us a message, we will call back later</p> -->
                    </div>
                    
                    <!-- Contact Form Area -->
                    <div class="contact-form-area mb-100">
                        <form action="${pageContext.request.contextPath }/board/insertBoard" method="post" enctype="multipart/form-data">
							<input type="hidden" name="user_id" value="다은쓰">
                            <div class="row">
                            
                                <div class="col-12 col-md-6">
                                    <div class="form-group">
                                    	<label for="company">말머리</label>
                                    	<select name="board_category" class="form-control" id="">
                                    		<option class="form-control" value="">--말머리 선택--</option>
							   				<option class="form-control" value="질문">질문</option>
						  					<option class="form-control"  value="신고">신고</option>
							   				<option class="form-control"  value="친목">친목</option>
							   				<option class="form-control"  value="정보">정보</option>
										</select>
                                    </div>
                                </div>
                                
                                <div class="col-12 col-md-6">
                                    <div class="form-group">
                                    	<label for="company">작성자</label>
                                    	<span name="user_name" class="form-control" id="">세션값-이름</span>
                                    </div>
                                </div>
                                
                                <div class="col-12">
                                    <div class="form-group">
                                    	<label for="company">제목</label>
                                    	<input type="text" name="title" class="form-control" id="" placeholder="제목을 작성하세요">
                                    </div>
                                </div>
                                
                                <div class="col-12">
                                    <div class="form-group">
                                    	<label for="company">내용</label>
                                        <textarea class="form-control" name="content" id="message" cols="30" rows="10" placeholder="내용을 작성하세요"></textarea>
                                    </div>
                                </div>
                                
                                <div class="col-12 mb-4">
                                	<label for="content_img">사진 등록</label>
                                	<input type="file" class="form-control" id="content_img" name="img" onchange="readURL(this);">
                                	<img id="preview"/>
                            	</div>
                            	
                                <div class="col-12 mb-4">
                                	<label for="content_file">파일 등록</label>
                                	<input type="file" class="" id="content_file" name="file" onchange="readURL(this);">
                            	</div>
                            	
                                <div class="col-12">
                                    <button type="submit" class="btn alazea-btn mt-15">게시글 작성</button>
                                    <button type="button" class="btn alazea-btn mt-15">목록</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                          </div>
        </div>
<!--     </section>   -->
                
                

<!-- 푸터들어가는 곳 -->
<jsp:include page="../include/footer.jsp" />
<!-- 푸터들어가는 곳 -->		