<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
   <!-- ##### Breadcrumb Area Start ##### -->
    <div class="breadcrumb-area">
        <!-- Top Breadcrumb Area -->
        <div class="top-breadcrumb-area bg-img bg-overlay d-flex align-items-center justify-content-center" style="background-image: url(${pageContext.request.contextPath }/resources/img/bg-img/24.jpg);">
            <h2>self auth</h2>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-12">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="#"><i class="fa fa-home"></i> Home</a></li>
                            <li class="breadcrumb-item"><a href="#">My Page</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Self Auth</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>
    <!-- ##### Breadcrumb Area End ##### -->
    
    
    <div class="container">
    
		<h2>인증 완료</h2>
		<h3>엑세스 토큰 : ${responseToken.access_token}</h3>
		<h3>사용자 번호 : ${responseToken.user_seq_no}</h3>
		<h3>token_type : ${responseToken.token_type}</h3>
		<h3>expires_in : ${responseToken.expires_in}</h3>
		<h3>refresh_token : ${responseToken.refresh_token}</h3>
		<h3>scope : ${responseToken.scope}</h3>
		${responseToken}
	
		<hr>
		
		<!-- 사용자정보조회 API -->
		<form method="get" action="userInfo">
			<%-- 필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 --%>
			<input type="hidden" name="access_token" value="${responseToken.access_token }"> 
			<input type="hidden" name="user_seq_no" value="${responseToken.user_seq_no }">
			<input type="submit" value="사용자정보조회">
		</form>
	
		<hr>
		
		
		<!-- 2.2.3 등록계좌조회 API -->
		<form method="get" action="accountList">
			<%-- 필요 파라미터는 입력데이터 없이 hidden 속성으로 전달 --%>
			<input type="hidden" name="access_token" value="${responseToken.access_token }"> 
			<input type="hidden" name="user_seq_no" value="${responseToken.user_seq_no }"> 
			<input type="hidden" name="include_cancel_yn" value="Y"> 
			<input type="hidden" name="sort_order" value="D"> 
			<input type="submit" value="등록계좌조회">
		</form>
		
		<hr>
		
		
		
		
	</div>
<%@ include file="../include/footer.jsp" %>