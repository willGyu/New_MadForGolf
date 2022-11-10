<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
   <!-- ##### Breadcrumb Area Start ##### -->
    <div class="breadcrumb-area">
        <!-- Top Breadcrumb Area -->
        <div class="top-breadcrumb-area bg-img bg-overlay d-flex align-items-center justify-content-center" style="background-image: url(${pageContext.request.contextPath }/resources/img/bg-img/24.jpg);">
            <h2>User Info</h2>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-12">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="#"><i class="fa fa-home"></i> Home</a></li>
                            <li class="breadcrumb-item"><a href="#">My Page</a></li>
                            <li class="breadcrumb-item active" aria-current="page">User Info</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>
    <!-- ##### Breadcrumb Area End ##### -->
    
    
    <div class="container">
    
		<h1>사용자 정보조회 결과</h1>
		<h3>고객번호 : ${userInfo.user_seq_no }</h3>
		<h3>고객CI값 : ${userInfo.user_ci }</h3>
		<h3>res_list : ${userInfo.res_list} </h3>
		${userInfo}
	
	</div>
<%@ include file="../include/footer.jsp" %>