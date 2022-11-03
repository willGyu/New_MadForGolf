<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ include file="../include/header.jsp" %>
    
    <!-- ##### Breadcrumb Area Start ##### -->
    <div class="breadcrumb-area">
        Top Breadcrumb Area
        <div class="top-breadcrumb-area bg-img bg-overlay d-flex align-items-center justify-content-center" style="background-image: url(${pageContext.request.contextPath }/resources/img/bg-img/24.jpg);">
            <h2>Update My Account</h2>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="#"><i class="fa fa-home"></i> Home</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Login</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>
<!-- ##### Breadcrumb Area End ##### --> 
    
    <script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
			<script type="text/javascript"> </script>
				
				
		 	<!-- 회원정보 수정완료 alert  -->
				<script>
					function btn(){
					    alert('수정이 완료되었습니다. 다시 로그인 해주세요');
					}
					</script>
    


	<!-- 본문 -->

    <!-- ##### Checkout Area Start ##### -->
    <div class="checkout_area mb-100" style="width: 1000px; margin: 0px auto;">
        <div class="container">
<!--             <div class="row justify-content-between"> -->
<!--                 <div class="col-12 col-lg-7"> -->
                    <div class="checkout_details_area clearfix">
                        <h5>Member Details</h5>
                        <form action="${pageContext.request.contextPath }/member/updatePro" id="update" method="post">
                            <div class="row">
                                <div class="col-12 mb-4">
                                    <label for="email_address">회원님의 ID (E-mail) 수정불가 *</label>
                                    <input type="email" class="form-control" id="email_address" name="user_id" value="${loginVO.user_id }" readonly>
                                </div>
                                
                                <div class="col-md-6 mb-4">
                                    <label for="first_name">Name *</label>
                                    <input type="text" class="form-control" id="first_name" name="user_name" value="${loginVO.user_name }" required="">
                                </div>
                                <div class="col-md-6 mb-4">
                                    <label for="last_name">Password *</label>
                                    <input type="password" class="form-control" id="last_name" name="user_pw" value="${loginVO.user_pw }" required="">
                                </div>
                                <div class="col-12 mb-4">
                                    <label for="email_address">Phone Number *</label>
                                    <input type="number" class="form-control" id="email_address" name="user_phone" value="${loginVO.user_phone }">
                                </div>
                                <div class="col-12 mb-4">
                                    <label for="phone_number">My Locations *</label>
                                    <input type="number" class="form-control" id="phone_number" min="0" value="">
                                </div>
                                
                                <button onclick="javascript:btn()" class="btn alazea-btn w-120" style="width:250pt;height:40pt;margin:auto; display:block; ">회원정보 수정하기</button>
                                
                            </div>
                        </form>
                    </div>

            </div>
            	
        
    </div>
    <!-- ##### Checkout Area End ##### -->
    <!-- 본문 -->

	
	<%@ include file="../include/footer.jsp" %>