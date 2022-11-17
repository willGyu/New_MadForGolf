<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<%@ include file="../include/header.jsp" %>

<style>
		
		.checkout_area mb-100{
			width: 1000px; 
			margin: 0px auto;
		
		}
		
		
		
		@media only screen and (max-width: 767px) and (max-height: 1280px){
			
		.container {
			width:90%;

		}

}
	
	</style>		

<!-- ##### Breadcrumb Area Start ##### -->
    <div class="breadcrumb-area">
        <div class="top-breadcrumb-area bg-img bg-overlay d-flex align-items-center justify-content-center" style="background-image: url(${pageContext.request.contextPath }/resources/img/bg-img/golf-2704608.jpg);">
            <h2>Delete My Account</h2>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="/"><i class="fa fa-home"></i> Home</a></li>
                            <li class="breadcrumb-item"><a href="/member/mypage"> Mypage </a>
                            <li class="breadcrumb-item active" aria-current="page">delete</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>
<!-- ##### Breadcrumb Area End ##### --> 


	<!-- 본문 -->
    <!-- ##### Checkout Area Start ##### -->
    <div class="checkout_area mb-100">
        <div class="container">
<!--             <div class="row justify-content-between"> -->
<!--                 <div class="col-12 col-lg-7"> -->
                    <div class="checkout_details_area clearfix">
                        <h2>회원 탈퇴</h2><br><br>
                        <form action="${pageContext.request.contextPath }/member/delete" id="deleteMember" method="post" name="deleteMember">
                            <div class="row">
                                <div class="col-12 mb-4">
                                    <label for="email_address">ID</label>
                                    <input type="email" class="form-control" id="user_id" name="user_id" value="${loginVO.user_id }" readonly>
                                </div>
                                <br>
                                <div class="col-12 mb-4">
                                    <label for="phone_number">Password *</label>
                                    <input type="password" class="form-control" id="user_pw" name="user_pw" min="0" value="">
                                    <!-- <input type="hidden" name="user_pw2" id="user_pw2"> -->
                                <br><br>
                                </div>
                                
                                <div>
                                	<c:if test="${msg == true}">
                                		비밀번호가 틀립니다.
                                	</c:if>
                                	<br><br>
                                </div>
                                
				                <div class="col-12 mb-4">
				                	<button class="btn alazea-btn w-100" name="checkPw" id="checkPw">Good-Bye</button>
				                </div><br><br><br>
                            </div>
                        </form>
                        
                    </div>
                </div>
            </div>
        
    <!-- ##### Checkout Area End ##### -->
    <!-- 본문 -->
    
    
    
    <script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.min.js"></script>
    <script type="text/javascript">
		$(document).ready(function(){
			$('#checkPw').on("click",function(){
				// alert("성공!");
				if($('#user_pw').val() == ''){
					alert("비밀번호를 입력하세요");
					$('#user_pw').focus();
					return false;
				}
				$.ajax({
					url:"/member/pwCheck",
					type:"POST",
					dataType:"json",
					data:$('#deleteMember').serializeArray(),
					success:function(data){
						if(data == 0){
							consol.log(data);
							return;
						}else{
							if(confirm("정말 탈퇴하시겠습니까?")){
								$('#deleteMember').sumbit();
							}
						}
						
					}
				})
				
			});
			
			
		});
		
	
	</script>
    
<%@ include file="../include/footer.jsp" %>