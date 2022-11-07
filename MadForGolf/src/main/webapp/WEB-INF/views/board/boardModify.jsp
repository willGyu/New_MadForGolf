<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- header -->
<jsp:include page="../include/header.jsp" />
<!-- header -->

<style>

.container{
/*  	border: 5px solid red; */
}

.container2{
/*  	border: 5px solid yellow; */

}

.container3{
/*  	border: 5px solid gray; */
	width: 100%;
}

.section-heading{
/* 	border: 5px solid blue; */
	text-align: center;
}

.contact-form-area{
/* 	border: 5px solid green; */
	
}

.form-group label{
	font-weight: bold;
}
#message{
	width: 100%;
    height: 400px;
/*      border-color: #f5f5f5; */
    resize: none;
/*      background-color: #f5f5f5;  */
}

.placeholder::placeholder{
	color: #b7b7b7; 
}

.form-control_real{
    position: relative;
    z-index: 2;
    height: 45px;
    width: 100%;
    background-color: #ffffff;
    font-size: 16px;
    margin-bottom: 15px;
    border: 1px solid #e1e1e1;
    border-radius: 2px;
     padding: 0px 20px;
    font-weight: 400;
    color: #b7b7b7;
    transition-duration: 500ms;
}
.form-control_file{
    position: relative;
    z-index: 2;
    height: 70px;
    width: 100%;
    background-color: #ffffff;
    font-size: 16px;
/*     margin-bottom: 5px; */
    border: 1px solid #e1e1e1;
    border-radius: 2px;
     padding: 15px 20px;
    font-weight: 400;
    color: #b7b7b7;
    transition-duration: 500ms;
}


.label{
	height: 40px;
}

.form-control_file input{
	background-color: white;
	color: red;
}
.board_btn{
/*  	border: 5px solid blue; */
	display: flex;
	flex-flow: row nowrap;
 	justify-content: center;

	
}

.board_btn button{
	width : 30px;
	margin : 10px 20px;
	background-color: #91C788;
	border: 0;
}

.board_btn button:hover{
	margin : 10px 20px;
	background-color: #C6EBC5;
	color: white;
	
}


</style>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>

<script type="text/javascript">


function readURL(input) {
	if(input.files && input.files[0]) {
		var reader = new FileReader();
		reader.onload = function(e) { document.getElementById('preview').src = e.target.result; };
		reader.readAsDataURL(input.files[0]);
	} else {
		document.getElementById('preview').src = "";
	}
}

$(document).ready(function(){
// 	alert("확인");
	$('form').submit(function(){
		alert("확인");
		// 카테고리 제어
		if($('#board_category option:selected').val()==""){
			alert('카테고리를 선택해주세요.');
			$('#board_category').focus();
			return false;
		}
		
		// 제목 제어
		if($('#contact-subject').val()==""){
			alert('제목을 작성하세요.');
			$('#contact-subject').focus();
			return false;
		}
		// 내용 제어
		if($('#message').val()==""){
			alert('내용을 작성하세요.');
			$('#message').focus();
			return false;
		}
		
		alert("게시글 수정이 완료되었습니다.");
	});
});
</script>

	
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
                            <li class="breadcrumb-item"><a href="/"><i class="fa fa-home"></i> Home</a></li>
                            <li class="breadcrumb-item" aria-current="page"><a href="/"> Community</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Modify</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>
<!-- ##### Breadcrumb Area End ##### -->


			<!-- 글쓰기 입력폼 시작@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ --> 
<div class="container">
	<div class="row align-items-center justify-content-between container2">
		<div class="container3">			
 		
                    
			<!-- Section Heading -->
			<div class="section-heading">
				<h2>Modify Board</h2>
			</div>
                    
             
             
            <!-- 수정, 삭제 시 필요한 글번호 저장 -->
            <div class="contact-form-area mb-100">
				<form action="/board/boardModify?oldfile1=${vo.content_img}&oldfile2=${vo.content_img2}&oldfile3=${vo.content_img3}" enctype="multipart/form-data" method="post">
                <input type="hidden" class="form-control" name="board_num" id="contact-name" readonly value="${vo.board_num }">
                	<div class="row">
                		
                		<!-- 말머리 선택 -->
                    	<div class="col-12 col-md-6">
                        	<div class="form-group">
                            	<select class="form-control_real" name="board_category" id="board_category" >
									<option value="질문">질문</option>
									<option value="친목">친목</option>
									<option value="정보">정보</option>
									<option value="신고">신고</option>
                               </select>
                            </div>
                        </div>
                        
                        
                        <!-- 작성자명 -->
                        <div class="col-12 col-md-6">
                        	<div class="form-group">
                            	<input type="text" class="form-control_real" name="user_name" id="contact-name" readonly value="${vo.user_name }">
                            </div>
                        </div>
                        
                        
                        <!-- 제목 -->
                        <div class="col-12">
                            <div class="form-group">
                                <input type="text" class="form-control placeholder" name="title" id="contact-subject" value="${vo.title }">
                            </div>
                        </div>
                        
                        
                        <!-- 내용 -->
                        <div class="col-12">
                            <div class="form-group">
                            	<textarea class="form-control" name="content" id="message" cols="30" rows="10">${vo.content }</textarea>
                            </div>
                        </div>
                        
                        
                        <!-- 첨부파일 -->
<!--                         <div class="col-12 mb-4 ">
                        	<div class="form-group">
                        		<input type="file" class="form-control_file" id="content_img" name="img" onchange="readURL(this);">
                         	<img id="preview"/>
                        	</div>
                    	</div> -->
                    	<div class="carousel-item active">
                        	<a class="product-img" href="${pageContext.request.contextPath }/resources/board_file/${vo.content_img }" >
                            <img src="${pageContext.request.contextPath }/resources/board_file/${vo.content_img }" alt="1" style="width: 300px; margin: 20px;">
                            </a>
<!--                             		<input type="file" class="form-control_file" id="content_img" name="file1" onchange="readURL(this);"> -->
                            
                        </div>
                    	
                    	                        
                        <!-- 제어버튼 -->        
                        <div class="col-12 board_btn">
                            <button type="submit" class="btn alazea-btn mt-15" id="updateBoard">게시글 수정</button>
                            <button type="button" class="btn alazea-btn mt-15" onclick="location.href='/board/listBoardAll'">수정 취소</button>
                        </div>
                        
                        
                    </div>
				</form>
			</div>
		</div>
	</div>
</div>
<!-- 글쓰기 입력폼 끝@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ --> 









<script type="text/javascript">

var ctg = "<c:out value='${vo.board_category}'/>";

$('select[name="board_category"]').val(ctg).prop("selected", true);

</script>



<!-- 푸터들어가는 곳 -->
<jsp:include page="../include/footer.jsp" />
<!-- 푸터들어가는 곳 -->





