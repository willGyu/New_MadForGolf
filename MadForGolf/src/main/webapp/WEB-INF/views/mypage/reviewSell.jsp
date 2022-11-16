<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- header -->
<jsp:include page="../include/header.jsp" />
<!-- header -->

<style>
.container_box{
/*  	border: 5px solid black; */
	background-color: #f9f9f9;
}

.content_inner_box{

}

.post-content{
/* 	border: 5px solid red; */
	margin-top: 20px;
}

.board_head{
/* 	border: 5px solid yellow; */
/* 	background-color: #FBF2CF; */
	padding: 30px;
}
.board_category{
/* 	border: 5px solid blue; */
	color:#52734D;
	font-weight: bold;
}
.post-title{
/* 	border: 5px solid red; */
	margin : 20px 0;
	font-weight: bold;
}
.post-meta{
/* 	border: 5px solid black; */
	border-top : 1px solid #b7b7b7; 
	padding-top : 10px;
	margin-bottom: 20px;
}
.post-meta a{
	font-size: 20px;
}

.content_box{
/*  	border: 5px solid gray;  */
	padding: 30px;
	height: auto;
	background-color: white;
}

.content_inner_box{
/* 	border: 5px solid blue; */
	width: 100%;
	font-weight: bold;
	color: black;
}

.img_box{
	display: flex;
	flex-flow: column wrap;
	justify-content: center;
	margin-left: 10%;
}

.img{
	width: 85%;
	margin: 10px;
}

.alazea-portfolio-filter{
/* 	border: 5px solid yellow; */

}

.board_btn_box{
/*  	border: 5px solid black; */
	display: flex;
	flex-flow: row nowrap;
	justify-content: center;	
	width: 100%;
	margin-bottom: 10px;
}



.board_btn{
/* 	border: 5px solid blue; */
	width : 140px;
	height: 50px;
	margin : 10px 20px;
	background-color: #91C788;
	border: 0;
	color: white;
	font-size: 17px;
	font-weight: bold;

}

.board_btn:hover{
	background-color : #FA7070;
	color: white;
}

.comment_area{
/* 	border: 5px solid green; */
	padding: 30px;

}

.comment_title{
 	font-size: 30px;
}
.comment_meta_name{
	font-size: 17px;
	font-weight: bold;
	padding-right: 20px;
	color: #b7b7b7;
}
.comment-wrapper{
	border-bottom: 1px dashed #b7b7b7;
	padding-bottom: 20px;
}
.comment_text{
	background-color: white;
	padding: 40px;
	margin-bottom: 30px;
}



.leave-comment-area{
/* 	border: 5px solid blue; */
	padding: 30px;
	

}
comment-head{

}

.comment_meta{
/* 	border: 5px solid blue; */
	display: flex;
 	flex-flow: row nowrap;
 	justify-content: flex-start;
 	padding-left: 5px;
 	
 } 
 
.comment_meta div{
	margin-right: 10px
}

.comment_control{
/* 	border: 5px solid red; */
	display: flex;
 	flex-flow: row nowrap;
 	justify-content: flex-end;
}

.comment_control a{
	color: #b7b7b7;
}

.comment_content{
/* 	border: 5px solid yellow; */
	padding-left: 5px;
	color: #52734D;
	font-weight: bold;
	
}
.form-control{
	resize: none;
}
#updateFormReply, #deleteReply{
	font-size: 12px;
	color: #b7b7b7;
	width: 47px;
	height: 20px;
	margin: 0 5px;
	padding: 0 10px;
	background-color: #f9f9f9;
	border-radius: 3px;
	
}
#page-link_real:hover{
	background-color: #C6EBC5;
	border: 1px solid #C6EBC5;
	
}



</style>

<!-- ##### Breadcrumb Area Start ##### -->
<div class="breadcrumb-area">

        <div class="top-breadcrumb-area bg-img bg-overlay d-flex align-items-center justify-content-center" style="background-image: url('/resources/img/bg-img/background-img (3).jpg');">

		<h2>Review</h2>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-12">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="/"><i class="fa fa-home"></i> Home</a></li>
						<li class="breadcrumb-item"><a href="/board/listBoardAll">MyPage</a></li>
						<li class="breadcrumb-item active" aria-current="page">MannerScore</li>
					</ol>
				</nav>
			</div>
		</div>
	</div>
</div>
<!-- ##### Breadcrumb Area End ##### -->

<!-- 수정, 삭제 시 필요한 글번호 저장 -->


<!-- ##### Blog Content Area Start ##### -->
<section class="blog-content-area section-padding-0-100">
	<div class="container container_box">
<!-- 		<div class="row justify-content-center"> -->
			<!-- Blog Posts Area -->
			<div class="">
				<div class="blog-posts-area">
					
					<!-- 글내용#############@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ -->
					<div class="single-post-details-area" style="margin: 0;">
						<div class="post-content">
							<!-- 게시글 헤더 -->
							<div class="board_head">
								<h4 class="post-title">${vo.review_num }</h4>
								<div class="post-meta mb-30">
									<a><i class="fa fa-user" aria-hidden="true"></i>${user_name }</a>
									<a><i class="fa fa-clock-o" aria-hidden="true"></i>
										<fmt:formatDate pattern="yy-MM-dd HH:mm" value="${vo.review_date }" /></a> 
								</div>
							</div>
							
							<!-- 게시글 본문 -->
							<div class=" mb-30 content_box">
								<div class="content_inner_box" style="margin-bottom: 80px; margin-top: 40px;"><pre>${vo.content }</pre></div>
							</div>
							
							<!-- 게시글 버튼 -->
							<div class="row">
<!-- 								<div class="alazea-portfolio-filter"> -->
									<div class="portfolio-filter board_btn_box">
										<button type="submit" class="btn board_btn" id="listAll">목록</button>
							</div>
						</div>
						
					</div>
				</div>
			</div>
		</section>
<!-- ##### Blog Content Area End ##### -->

	<script>
		//목록으로 이동하기
		$("#listAll").click(function(){
			location.href="/mypage/mannerScore";
			//history.back();
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