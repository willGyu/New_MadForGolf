<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/style.css">

<style>
@import url('https://fonts.googleapis.com/css2?family=Jua&display=swap');



</style>

<script>
	
	function hide_numbers(s){
	var result = "";
	var sLength = s.length;
	for(var i = 0; i < sLength; i++){
		result += i < sLength - 4 ? "*" : s.charAt(i);
	}
	return result;
}


</script>


    <!-- ##### Breadcrumb Area Start ##### -->
    <div class="breadcrumb-area">
        <!-- Top Breadcrumb Area -->
        <div class="top-breadcrumb-area bg-img bg-overlay d-flex align-items-center justify-content-center" 
        	style="background-image: url('https://igp.brightspotcdn.com/dims4/default/42109d2/2147483647/strip/true/crop/1920x933+0+73/resize/1926x936!/quality/90/?url=http%3A%2F%2Findigogolf-brightspot.s3.amazonaws.com%2Fclubs%2F0f%2F0f%2Ffe62828f4d1591e4e038cf161087%2Fsydney-marovitz-pano-1.jpg');">
            <h2 style="font-family: 'Jua', sans-serif;">판매자 상세페이지</h2>
            
         
        </div>
              
        
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="#"><i class="fa fa-home"></i> Home</a></li>
                            <li class="breadcrumb-item active" aria-current="page">
                            	Seller Details</a></li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>
    <!-- ##### Breadcrumb Area End ##### -->
	
	
    <!-- ##### Checkout Area Start ##### -->
    <div class="checkout_area mb-100">
        <div class="container">
            <div class="row justify-content-between">
                <div class="col-12 col-lg-7">
                    <div class="checkout_details_area clearfix">
                        	<h2 class="text-center mb-5" style="font-family: 'Jua', sans-serif;">'${sellerInfo.user_id}'님의 매너점수는 ${sellerInfo.score}P     입니다.</h2>
                        <h5 style="font-family: 'Jua', sans-serif;">현재보고 계신 상품</h5>
                                               
                        
                        <input type="hidden" name="prodNum" id="prodNum" value=" ${sellerInfo.prod_num}">
                        <input type="hidden" name="home" id="home" value="${pageContext.request.contextPath}" >
                              <img src="${pageContext.request.contextPath}/resources/product_img/${sellerInfo.prod_img}" 
                              style="width:150px  ; height: auto"> <br>
                        
                         <%-- ${sellerInfo} --%>                        
                         <form action="${pageContext.request.contextPath }/product/listAll" method="post">
                            <div class="row">
                                <div class="col-md-6 mb-4">
                                    <label for="seller_Id">
                                     <h3 style="font-family: 'Jua', sans-serif;"> ${sellerInfo.prod_name}</h3></label>
                                    <input type="hidden" class="form-control" id="sellerId" name="sellerId" value="${sellerInfo.user_id}" required>
                                </div>
                                <div class="col-md-6 mb-4">
                                    <label for="seller_name">${sellerInfo.price} won</label>
                                    <input type="hidden" class="form-control" id="seller_name" name="seller_name" value=VeryGood required>
                                </div>                                
                            </div>
                        </form> 
                    </div>
                </div>
          <!--               
                        <h2>리뷰 출력란</h2>
                          	<div id="sellerReviewList" >
                        	
                        </div>                                     
                        
                         <h2>리뷰 출력란 끝</h2> -->

                <div class="col-12 col-lg-4">
                    <div class="checkout-content">
                        <h5 class="title--">${sellerInfo.user_id}님의 정보</h5>
                        <div class="subtotal d-flex justify-content-between align-items-center">
                            <h5>Name</h5>
                            <h5>${sellerInfo.user_name}</h5>
                        </div>
                        <div class="subtotal d-flex justify-content-between align-items-center">
                            <h5>Contact number</h5>
                            <h5>${ hide_number}</h5>
                        </div>
                        <div class="shipping d-flex justify-content-between align-items-center">
                            <h5 style="font-family: 'Jua', sans-serif;">가입한 날짜</h5>
                            <h5>${sellerInfo.reg_date}</h5>
                        </div>
                        <div class="order-total d-flex justify-content-between align-items-center">
                            <h5>Manner Score</h5>
                            <h5>${sellerInfo.score}P</h5>
                        </div>
                        <div class="checkout-btn mt-30">
                            <a href="http://localhost:8080/product/productDetail?prod_num=${sellerInfo.prod_num}" style="font-family: 'Jua', sans-serif;"  class="btn alazea-btn w-100">구매하러 가기</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- ##### Checkout Area End ##### -->

	<!-- 템플릿 폼 시작 -->
<section class="single_product_details_area mb-50">
        <div class="produts-details--content mb-50">
            <div class="container">
<!--                 <div class="row justify-content-between">

                    <div class="col-12 col-md-6 col-lg-5">
                        <div class="single_product_thumb">
                            <div id="product_details_slider" class="carousel slide" data-ride="carousel">
                                <div class="carousel-inner">
                                    <div class="carousel-item active">
                                        <a class="product-img" href="img/bg-img/49.jpg" title="Product Image">
                                        <img class="d-block w-100" src="img/bg-img/49.jpg" alt="1">
                                    </a>
                                    </div>
                                    <div class="carousel-item">
                                        <a class="product-img" href="img/bg-img/49.jpg" title="Product Image">
                                        <img class="d-block w-100" src="img/bg-img/49.jpg" alt="1">
                                    </a>
                                    </div>
                                    <div class="carousel-item">
                                        <a class="product-img" href="img/bg-img/49.jpg" title="Product Image">
                                        <img class="d-block w-100" src="img/bg-img/49.jpg" alt="1">
                                    </a>
                                    </div>
                                </div>
                                <ol class="carousel-indicators">
                                    <li class="active" data-target="#product_details_slider" data-slide-to="0" style="background-image: url(img/bg-img/49.jpg);">
                                    </li>
                                    <li data-target="#product_details_slider" data-slide-to="1" style="background-image: url(img/bg-img/49.jpg);" class="">
                                    </li>
                                    <li data-target="#product_details_slider" data-slide-to="2" style="background-image: url(img/bg-img/49.jpg);" class="">
                                    </li>
                                </ol>
                            </div>
                        </div>
                    </div>

                    <div class="col-12 col-md-6">
                        <div class="single_product_desc">
                            <h4 class="title">Recuerdos Plant</h4>
                            <h4 class="price">$9.99</h4>
                            <div class="short_overview">
                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus pellem malesuada in nibh selama euismod. Curabitur a rhoncus dui. Nunc lobortis cursus magna utrum faucibus. Vivamus justo nibh, pharetra non risus accumsan, tincidunt suscipit leo.</p>
                            </div>

                            <div class="cart--area d-flex flex-wrap align-items-center">
                                Add to Cart Form
                                <form class="cart clearfix d-flex align-items-center" method="post">
                                    <div class="quantity">
                                        <span class="qty-minus" onclick="var effect = document.getElementById('qty'); var qty = effect.value; if( !isNaN( qty ) &amp;&amp; qty > 1 ) effect.value--;return false;"><i class="fa fa-minus" aria-hidden="true"></i></span>
                                        <input type="number" class="qty-text" id="qty" step="1" min="1" max="12" name="quantity" value="1">
                                        <span class="qty-plus" onclick="var effect = document.getElementById('qty'); var qty = effect.value; if( !isNaN( qty )) effect.value++;return false;"><i class="fa fa-plus" aria-hidden="true"></i></span>
                                    </div>
                                    <button type="submit" name="addtocart" value="5" class="btn alazea-btn ml-15">Add to cart</button>
                                </form>
                                Wishlist & Compare
                                <div class="wishlist-compare d-flex flex-wrap align-items-center">
                                    <a href="#" class="wishlist-btn ml-15"><i class="icon_heart_alt"></i></a>
                                    <a href="#" class="compare-btn ml-15"><i class="arrow_left-right_alt"></i></a>
                                </div>
                            </div>

                            <div class="products--meta">
                                <p><span>SKU:</span> <span>CT201807</span></p>
                                <p><span>Category:</span> <span>Outdoor Plants</span></p>
                                <p><span>Tags:</span> <span>plants, green, cactus </span></p>
                                <p>
                                    <span>Share on:</span>
                                    <span>
                                    <a href="#"><i class="fa fa-facebook"></i></a>
                                    <a href="#"><i class="fa fa-twitter"></i></a>
                                    <a href="#"><i class="fa fa-pinterest"></i></a>
                                    <a href="#"><i class="fa fa-google-plus"></i></a>
                                </span>
                                </p>
                            </div>

                        </div>
                    </div>
                </div> -->
            </div>
        </div>

	    <div class="container">
	        <div class="row">
	            <div class="col-12">
	                <div class="product_details_tab clearfix">
	                    <!-- Tabs -->
	                    <ul class="nav nav-tabs" role="tablist" id="product-details-tab">
	                        <li class="nav-item">
	                            <a href="#description" class="nav-link active" data-toggle="tab" role="tab" style="font-family: 'Jua', sans-serif;">판매상품 총 37개 </a>
	                        </li>
	                        <li class="nav-item">
	                            <a href="#addi-info" class="nav-link" data-toggle="tab" role="tab">&#127948;</a>
	                        </li>
	                        <li class="nav-item">
	                            <a style="font-family: 'Jua', sans-serif;" href="#reviews"
	                             class="nav-link" data-toggle="tab" role="tab">거래후기 <span class="text-muted" id="review-totcnt"></span></a>
	                        </li>
	                    </ul>
	                    <!-- Tab 시작  -->
	                    <div class="tab-content">
	                        <div role="tabpanel" class="tab-pane fade show active" id="description">
	                            <div class="description_area">
	                               	<!-- tap 1 내용 : 판매자 상품 스크롤 -->
	                               	<div class="related-products-area">
					        <div class="container">
					            <div class="row">
					                <div class="col-12">
				                
				                
				     <!-- Section Heading -->
				                     <div class="section-heading text-center">
				                        <h2 class="text-left"></h2>
				                    </div>
				                </div>
				            </div>
				
				            <div class="row" id="sellerProductList">
				             </div>
				        </div>
				   	 </div> 
	                           </div>
	                        </div>
	                        <div role="tabpanel" class="tab-pane fade" id="addi-info">
	                            <div style="font-family: 'Jua', sans-serif;" class="additional_info_area">
	                                <p align="center"> 판매자가 직거래 도중 골프채로 저를 위협하면 어떻게 해야하나요???
	                                    <br> <span>가까운 경찰서 혹은 주변에 도움을 청하세요.</span></p>
	                                <p align="center"> 판매자가 판매한 상품이 사진 및 설명과 많이 다릅니다.
	                                    <br> <span> 저희 Mad For Golf 대표를 맡고 계신 Dev.Dan님께 연락을 취하면 해결될수도 있고 안될수도 있어요.</span></p>
	                                <p align="center"> 구매한 상품이 마음에 들지 않습니다. 환불이 되나요?
	                                    <br> <span>Nope! 낙장불입</span></p>
	                                <p align="center"> 너무 불친절한테 사이트 탈퇴 가능한가요?
	                                    <br> <span> Nope! 가입할땐 당신 마음이지만 나갈땐 마음대로 못나갑니다.</span></p>
	                                <p align="center"> 이 탭은 다른 컨텐츠로 대체할 예정이니 혹시 발견하신 분은 너무 놀라지 마세요&#128578; 
	                                    <br> <span> 다들 프로젝트 하시느라 대단히 수고 많으십니다. 저의 숨겨진 메세지를 발견한 모두에게 큰 행운이 가득하기를...</span></p>
	                            </div>
	                        </div>
	                        <!-- tab3 (리뷰/후기) 시작 -->
	                        <div role="tabpanel" class="tab-pane fade" id="reviews">
	                        
	                        
	                                                <!-- Comment Area Start -->
                        <div class="comment_area clearfix">
                            <h4 class="headline">2 Comments</h4>
                            <ol>
       
								<!-- 리뷰란 -->
                                
                            </ol>
                        </div>
	                        
                  <div class="page_box" >

	<nav aria-label="Page navigation" id="review-pagination">
<!--     	<ul class="pagination"  >
    	    	        
	        	<li class="page-item">
	        		<a class="page-link" id="page-link_real" href="listBoardAll?page=1">1</a>
        		</li>
	        	
      		
	    </ul> -->
	</nav>
	</div>    
										                     
	                        
	                        
	                          
	
<!-- 			 <div class="reviews_area">
	                                <ul>
	                                    <li>
	                                        <div class="single_user_review mb-15">
	                                           
	                                            <div class="review-details">
	                                                <a style="font-family: 'Jua', sans-serif;">리뷰테스트다 리뷰테스트다</a>
	                                                <p>by <a href="#">itwill01@naver.com</a> on <span>10 Nov 2022</span></p>
	                                            </div>
	                                        </div>
	                                        <div class="single_user_review mb-15">
	                                            <div class="review-details">
	                                                <a style="font-family: 'Jua', sans-serif;">아직 에이잭스 제대로 뿌려지지 못하는 상태</a>
	                                                <p>by <a href="#">itwill02@naver.com</a> on <span>10 Nov 2022</span></p>
	                                            </div>
	                                        </div>
	                                         <div class="single_user_review mb-15">
	                                            <div class="review-details">
	                                                <a style="font-family: 'Jua', sans-serif;">this page opening soon</a>
	                                                <p>by <a href="#">itwill03@naver.com</a> on <span>10 Nov 2022</span></p>
	                                            </div>
	                                        </div>
	                                        <div class="single_user_review mb-15">
	                                            <div class="review-details">
	                                                <a style="font-family: 'Jua', sans-serif;">this page opening soon</a>
	                                                <p>by <a href="#">itwill03@naver.com</a> on <span>10 Nov 2022</span></p>
	                                            </div>
	                                        </div>
	                                        <div class="single_user_review mb-15">
	                                            <div class="review-details">
	                                                <a style="font-family: 'Jua', sans-serif;">this page opening soon</a>
	                                                <p>by <a href="#">itwill03@naver.com</a> on <span>10 Nov 2022</span></p>
	                                            </div>
	                                        </div>
	                                        <div class="single_user_review mb-15">
	                                            <div class="review-details">
	                                                <a style="font-family: 'Jua', sans-serif;">this page opening soon</a>
	                                                <p>by <a href="#">itwill03@naver.com</a> on <span>10 Nov 2022</span></p>
	                                            </div>
	                                        </div>
	                                        <div class="single_user_review mb-15">
	                                            <div class="review-details">
	                                                <a style="font-family: 'Jua', sans-serif;">this page opening soon</a>
	                                                <p>by <a href="#">itwill03@naver.com</a> on <span>10 Nov 2022</span></p>
	                                            </div>
	                                        </div>
	                                        
	                                    </li>
	                                </ul>
	                            </div>
	
	                            <div class="submit_a_review_area mt-50">
	                                <h4>Submit A Review</h4>
	                                <form action="#" method="post">
	                                    <div class="row">
	                                        <div class="col-12">
	                                            <div class="form-group d-flex align-items-center">
	                                                <span class="mr-15">Your Ratings:</span>
	                                                <div class="stars">
	                                                    <input type="radio" name="star" class="star-1" id="star-1">
	                                                    <label class="star-1" for="star-1">1</label>
	                                                    <input type="radio" name="star" class="star-2" id="star-2">
	                                                    <label class="star-2" for="star-2">2</label>
	                                                    <input type="radio" name="star" class="star-3" id="star-3">
	                                                    <label class="star-3" for="star-3">3</label>
	                                                    <input type="radio" name="star" class="star-4" id="star-4">
	                                                    <label class="star-4" for="star-4">4</label>
	                                                    <input type="radio" name="star" class="star-5" id="star-5">
	                                                    <label class="star-5" for="star-5">5</label>
	                                                    <span></span>
	                                                </div>
	                                            </div>
	                                        </div>
	                                        <div class="col-12 col-md-6">
	                                            <div class="form-group">
	                                                <label for="name">Nickname</label>
	                                                <input type="email" class="form-control" id="name" placeholder="Nazrul">
	                                            </div>
	                                        </div>
	                                        <div class="col-12 col-md-6">
	                                            <div class="form-group">
	                                                <label for="options">Reason for your rating</label>
	                                                <select class="form-control" id="options">
	                                                      <option>Quality</option>
	                                                      <option>Value</option>
	                                                      <option>Design</option>
	                                                      <option>Price</option>
	                                                      <option>Others</option>
	                                                </select>
	                                            </div>
	                                        </div>
	                                        <div class="col-12">
	                                            <div class="form-group">
	                                                <label for="comments">Comments</label>
	                                                <textarea class="form-control" id="comments" rows="5" data-max-length="150"></textarea>
	                                            </div>
	                                        </div>
	                                        <div class="col-12">
	                                            <button type="submit" class="btn alazea-btn">Submit Your Review</button>
	                                        </div>
	                                    </div>
	                                </form>
	                            </div> -->
	                       
	                        
	                        
	                        </div>
	
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>
	</section>	
 	<!-- 템플릿 폼 끝 -->
   


<%-- 	<!-- @@@ tap menu area start @@@ -->
	<div style='width:800px;margin:0 auto;margin-top:50px;'>
		<ul class="nav nav-tabs">
			<li class='active'><a href="#tabmenu_01" data-toggle="tab">판매자의 다른상품</a></li>
			<li><a href="#tabmenu_02" data-toggle="tab">판매자의 거래후기</a></li>			
		</ul>
		<div class="tab-content">
			<div class="tab-pane fade in active" id="tabmenu_01">
			 	<div class="related-products-area">
        			<div class="container">
           				<div class="row">
                			<div class="col-12">
                               
                    <!-- 탭메뉴1 내용 -->
                    <div class="section-heading text-center">
                        <h2 class="text-left">${sellerInfo.user_id}님이 판매중인 다른 상품</h2>
                    </div>
                </div>
            </div>

            <div class="row" id="sellerProductList">
              
            </div>
        </div>
    </div>
			</div>
			<div class="tab-pane fade" id="tabmenu_02"></div>
				
				<!-- <p>탭메뉴2 내용 </p> -->
				    	 
				   <!-- Comment Area Start -->
				    	<div class="comment_area clearfix">
                            <h4 class="headline"> 리뷰 출력</h4>

                            <ol id="sellerReviewList">
                                <li class="single_comment_area">
                                    <div class="comment-wrapper d-flex">
                                        Comment Meta
                                        <div class="comment-author">
                                            <img src="https://cdn-icons-png.flaticon.com/128/5264/5264565.png" alt="">
                                        </div>
                                        Comment Content
                                        <div class="comment-content">
                                            <div class="d-flex align-items-center justify-content-between">
                                                <h5>홍길동</h5>
                                                <span class="comment-date">02:20 PM,  20 Jun 2018</span>
                                            </div>
                                            <p>Hello</p>
                                            <a class="active" href="#">리뷰</a>
                                        </div>
                                    </div>
                                </li>
                                                      
                            </ol>
                        </div>			
				
				<!-- <p>탭메뉴2 내용 끝 </p> -->			
						
		</div>
	</div>		
	<!-- @@@ tap menu area end @@@ --> --%>

<!-- 	<div class="related-products-area">
	        <div class="container">
	            <div class="row">
	                <div class="col-12">
                          
     Section Heading
                     <div class="section-heading text-center">
                        <h2 class="text-left"></h2>
                    </div>
                </div>
            </div>

            <div class="row" id="sellerProductList">
             </div>
        </div>
    </div> 

     <section class="blog-content-area section-padding-0-100">
        <div class="container">
            <div class="row justify-content-center">
                Blog Posts Area
                <div class="col-12 col-md-12">
                    <div class="blog-posts-area">  
 
                    </div>
                </div>
        
            </div>
        </div>
    </section> -->
   
    <%@ include file="../include/footer.jsp" %>
              

    <!-- ##### All Javascript Files ##### -->
    <!-- jQuery-2.2.4 js -->
    <script src="${pageContext.request.contextPath}/resources/js/jquery/jquery-2.2.4.min.js"></script>
    <!-- Popper js -->
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap/popper.min.js"></script>
    <!-- Bootstrap js -->
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap/bootstrap.min.js"></script>
    <!-- All Plugins js -->
    <script src="${pageContext.request.contextPath}/resources/js/plugins/plugins.js"></script>
    <!-- Active js -->
    <script src="${pageContext.request.contextPath}/resources/js/active.js"></script>
    
    <script src="${pageContext.request.contextPath}/resources/js/seller-review.js"></script>
    
    
</body>

</html>