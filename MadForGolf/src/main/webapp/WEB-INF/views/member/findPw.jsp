<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ include file="../include/header.jsp" %>

	<!-- ##### Breadcrumb Area Start ##### -->
    <div class="breadcrumb-area">
        <div class="top-breadcrumb-area bg-img bg-overlay d-flex align-items-center justify-content-center" style="background-image: url(${pageContext.request.contextPath }/resources/img/bg-img/golf-2704608.jpg);">
            <h2>Find My Password</h2>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="#"><i class="fa fa-home"></i> Home</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Find My Password</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>
<!-- ##### Breadcrumb Area End ##### --> 
	
	
	<!-- 본문 -->
	<div class="checkout_area mb-100">
		<div class="container">
			<div class="row justify-content-between">
				 <div class="col-12 col-lg-7" style="margin: auto;">
					<div class="checkout_details_area clearfix">
						<h5>Find My Password</h5>
						<br><br>
						
						<form action="${pageContext.request.contextPath }/member/findPw" id="findPw" method="post" name="findPw">
							<div class="row">
								<div class="col-12 mb-4">
									<label for="phone_number">아이디(Email) *</label> 
									<input type="text" name="user_id" class="form-control" id="user_id" placeholder=" 아이디를 입력하세요. ">
								</div>
								<div class="col-12 mb-4">
									<label for="phone_number">전화번호(Phone) *</label> 
									<input type="text" name="user_phone" class="form-control" id="user_phone" placeholder=" (-)는 제외하고 입력하세요. "><br>
								<br><br>
								</div>
								
								<button class="btn alazea-btn w-120" style="width:360pt;height:40pt;margin:auto;" type="submit" value="check">비밀번호 찾기</button>
								<br><br>
								</div>
						</form>
						
					</div>
				</div>
			</div>
		</div>
	</div><br><br><br>
	<!-- 본문 -->
	
	
	
	
	
	<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script type="text/javascript">
	$(document).ready(function(){
		$('#findPw').submit(function(){
			// alert("성공!");
			if($('#user_id').val() == ''){
				alert("아이디를 입력하세요.");
				return false;
			}
			
			if($('#user_phone').val() == ''){
				alert("휴대폰 번호를 입력하세요.");
				return false;
			}
			
		});
		
		
	});

	
	</script>
	
<%@ include file="../include/footer.jsp" %>