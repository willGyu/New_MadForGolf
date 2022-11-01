<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<style type="text/css">
#submit {
	background-color: #70C745;
	color: white;
	width: 180px;
	font-weight: bold;
}

#submit:hover {
	background-color: white;
	color: #70C745;
	border-color: #70C745;
	cursor: pointer;
}

#button {
	color: #767676;
	width: 180px;
	font-weight: bold;
	margin-left: 50px;
}

#button:hover {
	background-color: white;
	color: #70C745;
	border-color: #70C745;
	cursor: pointer;
}
</style>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		// alert("확인");
		$('#form').submit(function(){
			// alert("확인");
			// 카테고리 제어
			if($('#category option:selected').val()==""){
				alert('카테고리를 선택해주세요.');
				$('#category').focus();
				return false;
			}
			// 가격 제어
			if($('#price').val()==""){
				alert('판매가격을 입력해주세요.');
				$('#price').focus();
				return false;
			}
			// 제목 제어
			if($('#prod_name').val()==""){
				alert('판매상품의 이름을 입력해주세요.');
				$('#prod_name').focus();
				return false;
			}
			// 상품설명 제어
			if($('#detail').val()==""){
				alert('상품을 설명해주세요.');
				$('#detail').focus();
				return false;
			}
			// 상품상태 제어
			if ($('input[name=condition]:radio:checked').length < 1 ) {
				alert("상품 상태를 선택해주세요.");
				return false;
			}
			// 상품성별 제어
			if ($('input[name=gender]:radio:checked').length < 1 ) {
				alert("상품 성별을 선택해주세요.");
				return false;
			}
			// 상품이미지 제어
			if($('#prod_img').val()==""){
				alert('상품이미지를 넣어주세요.');
				$('#prod_img').focus();
				return false;
			}
			
			alert("등록된이 완료되었습니다.");
		});
	});
	
	function readURL(input) {
		if(input.files && input.files[0]) {
			var reader = new FileReader();
			reader.onload = function(e) { document.getElementById('preview').src = e.target.result; };
			reader.readAsDataURL(input.files[0]);
		} else {
			document.getElementById('preview').src = "";
		}
	}
	
</script>

    <!-- ##### Breadcrumb Area Start ##### -->
    <div class="breadcrumb-area">
        <!-- Top Breadcrumb Area -->
        <div class="top-breadcrumb-area bg-img bg-overlay d-flex align-items-center justify-content-center" style="background-image: url(${pageContext.request.contextPath }/resources/img/bg-img/24.jpg);">
            <h2>Registration</h2>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-12">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="#"><i class="fa fa-home"></i> Home</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Registration</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>
    <!-- ##### Breadcrumb Area End ##### -->

    <!-- ##### Checkout Area Start ##### -->
    <div class="checkout_area mb-100" style="width: 800px; margin: 0px auto;">
        <div class="container">
            <div class="row justify-content-between">
            	<div class="checkout_details_area clearfix">
                	<h5>상품등록 수정</h5>
                    <form action="${pageContext.request.contextPath }/product/productUpdate" method="post" id="form" enctype="multipart/form-data">
                    	<!-- 로그인 기능 구현 시 value 값 수정 필요 ${loginID } -->
                    	<input type="hidden" value="itwill01" name="seller_id">
                        <div class="row">
                        	<div class="col-md-6 mb-4" id="category">
                            	<label for="country">Category</label>
                                <select class="custom-select d-block w-100" id="category" name="category">
                                	<option value="" selected="selected" disabled="disabled">카테고리</option>
                                	<option value="Driver">드라이버</option>
                                	<option value="Iron">아이언</option>
                                    <option value="Utility">유틸리티</option>
                                    <option value="Wedge">웨지</option>
                                    <option value="Putter">퍼터</option>
                                    <option value="Etc">기타</option>
                                </select>
                            </div>
                            <div class="col-md-6 mb-4">
                            	<label for="city">Price</label>
                            	<input type="number" class="form-control" id="price" name="price">
                            </div>
                            <div class="col-12 mb-4">
                                <label for="email_address">Subject</label>
                                <input type="text" class="form-control" id="prod_name" placeholder="제목을 입력해주세요." name="prod_name">
                            </div>
                            <div class="col-md-12 mb-4">
                                <label for="order-notes">Detail</label>
                                <textarea class="form-control" id="detail" cols="30" rows="10" style="height: 300px;" placeholder="내용을 입력해주세요." name="detail"></textarea>
                            </div>
                            <div class="form-group d-flex align-items-center">
                            	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label for="order-notes" style="margin-right: 30px;">Conditon</label>
                            	<input type="radio" class="custom-control-input1" id="condition" name="condition" value="최상"><span style="min-width: 40px;">&nbsp;&nbsp;최상</span>
                            	<input type="radio" class="custom-control-input2" id="condition" style="margin-left: 30px;" name="condition" value="상"><span style="min-width: 40px;">&nbsp;&nbsp;상</span>
                            	<input type="radio" class="custom-control-input3" id="condition" style="margin-left: 20px;" name="condition" value="중"><span style="min-width: 40px;">&nbsp;&nbsp;중</span>
                            	<input type="radio" class="custom-control-input4" id="condition" style="margin-left: 20px;" name="condition" value="하"><span style="min-width: 40px;">&nbsp;&nbsp;하</span>
                            	<input type="radio" class="custom-control-input5" id="condition" style="margin-left: 20px;" name="condition" value="최하"><span style="min-width: 40px;">&nbsp;&nbsp;최하</span>
                            </div>
                            <div class="form-group d-flex align-items-center">
                            	<label for="order-notes" style="margin: 0px 20px 0px 100px;">Gender</label>
                            	<input type="radio" class="custom-control-input1" id="gender1" name="gender" value="1">&nbsp;남
                            	<input type="radio" class="custom-control-input2" id="gender2" style="margin-left: 20px;" name="gender" value="2">&nbsp;여
                            </div>
                            <div class="col-12 mb-4">
                                <label for="company">Image</label>
                                <input type="file" class="form-control" id="prod_img" name="file" onchange="readURL(this);">
                                <img id="preview"/>
                            </div>
							<div style="margin:0px auto;">
								<div class="checkout-btn mt-30" >
									<input type="submit" id="submit" value="상품 등록">
									<input type="button" id="button" value="이  전" onclick="history.back();">
                        		</div>
                        	</div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <!-- ##### Checkout Area End ##### -->

<%@ include file="../include/footer.jsp" %>