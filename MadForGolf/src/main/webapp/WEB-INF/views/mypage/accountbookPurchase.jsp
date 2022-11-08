<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ include file="../include/header.jsp" %>
    
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
                            <li class="breadcrumb-item active" aria-current="page" onClick="location.href='/mypage/accountbookMonth'">My Account Book</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>
    <!-- ##### Breadcrumb Area End ##### -->
    
    
    <!-- Single Cool Facts Area -->
   <div class="col-12 col-sm-6 col-md-3" style="text-align: center; margin: 0px auto; height: 70px; width: 80%;">
        <div class="single-cool-fact d-flex align-items-center justify-content-center mb-100">
            <div class="cf-icon">
                <img src="${pageContext.request.contextPath }/resources/img/core-img/cf1.png" alt="">
            </div>
            <div class="cf-content">
                <h2><span class="counter">20</span></h2>
                <h6>이번 달 구매 현황</h6>
            </div>
         </div>
         
         
    </div>
    
    <!-- 차트를 그릴 영역 -->
    <div style="position:relative; margin: 0px auto; height: 600px; width: 60%;">
    	<br><br><br><br>
    	<canvas id="purchaseMonth"></canvas>
    	<br><br><br><br>
    </div>
    
    
    
    <script src="https://cdn.jsdelivr.net/npm/chart.js@3.5.1/dist/chart.min.js"></script>
    <script>
    	new Chart(document.getElementById("purchaseMonth"),{
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
    					data:[1,2,3,4,5,6]
    				}
    			]
    		},
    		options:{
    			plugins:{
    				title:{
        				display:true,
        				text:'카테고리 별 구매 현황'
        			}
    			},
    			responsive:false
    		}
    	});
    </script>
    
    
    
    <%@ include file="../include/footer.jsp" %>