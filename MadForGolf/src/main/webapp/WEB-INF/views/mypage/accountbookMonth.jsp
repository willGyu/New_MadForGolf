<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<style>
/* div.row{
	width:100px;
	display:flex;
}

div.left{
	width:50%;
	float:left;
}

div.right{
	width:50%;
	float:right;
} */
</style>

	<!-- ##### Breadcrumb Area Start ##### -->
    <div class="breadcrumb-area">
        <!-- Top Breadcrumb Area -->
        <div class="top-breadcrumb-area bg-img bg-overlay d-flex align-items-center justify-content-center" style="background-image: url(${pageContext.request.contextPath }/resources/img/bg-img/24.jpg);">
            <h2>MyPage</h2>
        </div>
        
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="#"><i class="fa fa-home"></i> Home</a></li>
                            <li class="breadcrumb-item active" aria-current="page">My Account Book</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>
	<!-- ##### Breadcrumb Area End ##### -->
	
	
	
	<div class="section-heading text-center">
	   <h2>My Account Book</h2>
	   <p>${user_name }님의 가계부</p>
	   <br><br><br><br>
	</div>
	
	
	<div class="row">
		<!-- 차트를 그릴 영역 -->
		<div class="left" style="position:relative; margin: 0px auto; height:400px; width: 0%;">
			<canvas id="MonthChart"></canvas>
			<br><br><br><br>
		</div>
		
		<div class="right" style="margin: 0px auto; height:400px; width: 30%;">
			<!-- side -->
			<div onClick="location.href='/mypage/accountbookPurchase'">
				<h6>이번 달 구매 횟수는 입니다.</h6>
				<br>
				<h6>이번 달 구매 금액은 입니다.</h6>
				<br><br><br>
			</div>
			
			<div onClick="location.href='/mypage/accountbookSale'">
				<h6>이번 달 판매 횟수는 입니다.</h6>
				<br>
				<h6>이번 달 판매 금액은 입니다.</h6>
				<br><br><br>
			</div>
		</div>
	</div>
	
	
<script src="https://cdn.jsdelivr.net/npm/chart.js@3.5.1/dist/chart.min.js"></script>
<script>
	var chartArea = document.getElementById('MonthChart').getContext('2d');
	
	var MonthChart = new Chart(chartArea,{
		type:'pie',
		data: {
			labels:["구매","판매"],
			datasets:[{
				label:"원",
				backgroundColor:[
					"#A1C298","#FA7070"
				],
				data:[300000,500000]
			}]
		},
		options:{
			plugins:{
				title:{
					display:true,
					text:'이번 달 거래 현황',
					padding:{
						top:10,
						botton:50
					}
				}
			},
			responsive:false
		}
	});
</script>

<%@ include file="../include/footer.jsp" %>