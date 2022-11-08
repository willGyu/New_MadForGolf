<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ include file="../include/header.jsp" %>
    
    <!-- ##### Breadcrumb Area Start ##### -->
    <div class="breadcrumb-area">
        Top Breadcrumb Area
        <div class="top-breadcrumb-area bg-img bg-overlay d-flex align-items-center justify-content-center" style="background-image: url(${pageContext.request.contextPath }/resources/img/bg-img/24.jpg);">
            <h2>Update Password</h2>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="#"><i class="fa fa-home"></i> Home</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Find My Account</li>
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
                <div class="col-12 col-lg-7">
                    <div class="checkout_details_area clearfix">
                        <h5>Change My Password</h5>
                        <br><br>
                        <form action="${pageContext.request.contextPath }/member/updatePw" id="updatePw" method="post" name="updatePw">
                            <div class="row">
                                <div class="col-12 mb-4">
                                    <label for="email_address">ID</label>
                                    <input type="email" name="user_id" class="form-control" id="user_id" value="${findPwVo.user_id }" readonly>
                                </div>
                                <br>
                                <div class="col-12 mb-4">
                                    <label for="phone_number">New Password</label>
                                    <input type="password" name="user_pw" class="password form-control" id="user_pw" min="0" value="" placeholder="비밀번호를 입력하세요.">
                                    <div class="passdiv"></div>
                                </div>
                                <div class="col-12 mb-4">
                                    <label for="phone_number">Password Check</label>
                                    <input type="password" name="user_pw1" class="password2 form-control" id="user_pw1" min="0" value="" placeholder="비밀번호를 재입력하세요.">
                                    <div class="pass2div"></div>
                                <br><br><br><br>
                                </div>
				                <div class="col-12 mb-4">
				                	<button class="btn alazea-btn w-100">비밀번호 변경</button>
				                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
        <!-- 본문 -->
    
    
    <script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$('#updatePw').submit(function(){
				// alert("성공!");
				if($('#user_pw').val() == ''){
					alert("새로운 비밀번호를 입력하세요.");
					return false;
				}
				
				if ($('#user_pw1').val() == '') {
					alert("비밀번호를 재확인하세요.");
					return false;
				}
				
				
				if ($('.password2').val() != $('.password').val()) {
					$('.pass2div').html("입력하신 비밀번호가 일치하지 않습니다.");
					$('.pass2div').focus();
					return false;
				}
				if ($('.password2').val() == $('.password').val()) {
					alert("비밀번호가 변경되었습니다.");
				}
				
			});
		
		
		});
	
	
</script>
    
    
    
    <%@ include file="../include/footer.jsp" %>