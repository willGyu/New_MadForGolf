<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<%@ include file="../include/header.jsp" %>

<style type="text/css">
.container{
	display:grid;
}

.main-container{
	display:grid;
	grid-template-columns:500px 500px;
	padding-bottom:200px;
}

.main-container-img{
	display:grid;
	grid-template-columns:500px;
}

.img-container{
	display:grid;
	width:300px;
	height:300px;
	padding-top:50px;
	padding-bottom:500px;
}

.chart-container{
	width:500px;
	height:500px;
	margin:0px auto;
	positon:realtive
}

.content-container{
	padding-left:200px;
	padding-top:100px;
}

</style>

	<!-- ##### Breadcrumb Area Start ##### -->
    <div class="breadcrumb-area">
        <!-- Top Breadcrumb Area -->
        <div class="top-breadcrumb-area bg-img bg-overlay d-flex align-items-center justify-content-center" style="background-image: url(${pageContext.request.contextPath }/resources/img/bg-img/24.jpg);">
            <h2>My Account Book</h2>
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
	
	
	<section class="about-us-area">
		<div class="container">
			<div class="section-heading text-center">
			   <h2>My Account Book</h2>
			   <p>${user_name }님의 가계부</p>
			</div>
		
			<!-- 선 -->
	        <div class="col-12">
	            <div class="border-line"></div>
	            <br><br><br>
			</div>
			<!-- 선 -->
			
			<!-- JSTL -->
			<c:choose>
				<c:when test="${purchaseCnt eq 0 && saleCnt eq 0}">
					<div class="main-container-img">
						<div class="img-container">
							<img src="${pageContext.request.contextPath }/resources/img/geoji4.jpg">
							<br><br>
						</div>
						
	                    <div class="checkout-btn mt-30">
                            <a href="#" class="btn alazea-btn w-100">거래하러 가기</a>
	                        <br><br><br><br>
                        </div>
					</div>
				</c:when>
					
				<c:otherwise>
					<div class="main-container">
						<!-- 차트를 그릴 영역 -->
						<div class="chart-container">
							<canvas id="saleMonth"></canvas>
							<br><br><br><br>
						</div>
						<!-- 차트를 그릴 영역 -->
						
						
						<!-- 글자 영역 -->
						<div class="content-container">
							<!-- <h5>이번 달 판매 내역</h5> -->
	                        <p>Driver ${saleDriver }원</p>
	                        <p>Iron ${saleIron }원</p>
	                        <p>Util ${saleUtil }원</p>
	                        <p>Wedge ${saleWedge }원</p>
	                        <p>Putter ${salePutter }원</p>
	                        <p>Etc. ${saleEtc }원</p>
						</div>
						<!-- 글자 영역 -->
						
						
						
					</div>
				</c:otherwise>
			</c:choose>
			<!-- JSTL -->
		</div>
	</section>
    
    
    
    <script src="https://cdn.jsdelivr.net/npm/chart.js@3.5.1/dist/chart.min.js"></script>
    <script>
    	new Chart(document.getElementById("saleMonth"),{
    		type:'doughnut',
    		data:{
    			labels: [
    				'Driver',
    				'Iron',
    				'Util',
    				'Wedge',
    				'Putter',
    				'Etc.'
    			],
    			datasets:[
    				{
    					label: "Category",
    					backgroundColor:[
    						'#FEFFDE','#FBF2CF','#DDFFBC','#91C788','#A1C298','#52734D'
    					],
    					data:[${saleDriver},${saleIron},${saleUtil},${saleWedge},${salePutter},${saleEtc}]
    				}
    			]
    		},
    		options:{
    			plugins:{
    				title:{
        				display:true,
        				text:'카테고리 별 판매 현황'
        			}
    			},

    			maintainAspectRatio:false
    		}
    	});
    </script>
    
    
    
    <%@ include file="../include/footer.jsp" %>