<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<style>
#button2 {
	width: 150px; height: 46px;
	font-weight: 600;
	border: none;
	margin-left: 15px;
	cursor: pointer;
	background-color: #91C788;
	color: white;
	margin:auto; display:block;
}

#button2:hover {
	background-color: white;
	color: #70C745;
	border-color: #70C745;
	cursor: pointer;
	border: 1px solid;
}
.description_area{
background-color:#F9F9F9; margin-top:50px; width:300px; margin:auto; padding: 50px;
}

.divdiv{
background-color:#F9F9F9; margin: 20px; padding: 100px 250px; padding-bottom: 30px;
}
p{
font-size: 1.2em; margin-bottom: 10px;
}

</style>
<!-- ##### Breadcrumb Area Start ##### -->
<div class="breadcrumb-area">
	<!-- Top Breadcrumb Area -->
	<div
		class="top-breadcrumb-area bg-img bg-overlay d-flex align-items-center justify-content-center"
		style="background-image: url(${pageContext.request.contextPath }/resources/img/bg-img/24.jpg);">
		<h2>PayResult</h2>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-12">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="#"><i
								class="fa fa-home"></i> Home</a></li>
						<li class="breadcrumb-item"><a href="#">payResult</a></li>
					</ol>
				</nav>
			</div>
		</div>
	</div>
</div>
<!-- ##### Breadcrumb Area End ##### -->

<div>
	<div
		class="single-cool-fact d-flex align-items-center justify-content-center mb-100" >
		<div class="divdiv">
		<p>

			${vo.req_bank_name } &nbsp; ${vo.req_account_num_masked }&nbsp;
			${vo.req_account_holder_name } &nbsp; 님의 계좌에서 <br>
			${vo.recv_bank_name } &nbsp; ${vo.recv_account_alias } &nbsp;
			${vo.recv_account_holder_name } &nbsp;님에게 &nbsp;&nbsp;
			<fmt:formatNumber value="${vo.recv_tran_amt }" pattern="#,###"/>
			 &nbsp; 원 이체를 완료하였습니다. <br>
		</p>
		<div class="description_area" >
				<input type="button" id="button2" value="거래내역 확인하기"
					onclick="location.href = '/product/listProductDealing';" >
		</div>
		</div>
	</div>
</div>










<%@ include file="../include/footer.jsp"%>