<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

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
        <div class="top-breadcrumb-area bg-img bg-overlay d-flex align-items-center justify-content-center" style="background-image: url(img/bg-img/24.jpg);">
            <h2>Seller Details</h2>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-12">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="#"><i class="fa fa-home"></i> Home</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Seller Details</li>
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
                        	<h2 class="text-center mb-5">"${sellerInfo.user_id}"님의 매너점수는 ${sellerInfo.score}     입니다.</h2>
                        <h5>Product currently on Sale</h5>
                                               
                        
                        <input type="hidden" name="prodNum" id="prodNum" value=" ${sellerInfo.prod_num}">
                        <input type="hidden" name="home" id="home" value="${pageContext.request.contextPath}" >
                              <img src="${pageContext.request.contextPath}/resources/product_img/${sellerInfo.prod_img}" 
                              style="width:150px  ; height: auto"> <br>
                        
                         <%-- ${sellerInfo} --%>
                        
                        <form action="#" method="post">
                            <div class="row">
                                <div class="col-md-6 mb-4">
                                    <label for="seller_Id">Review 예정 *</label>
                                    <input type="text" class="form-control" id="sellerId" name="sellerId" value="${sellerInfo.user_id}" required>
                                </div>
                                <div class="col-md-6 mb-4">
                                    <label for="seller_name">Review 예정 *</label>
                                    <input type="text" class="form-control" id="seller_name" name="seller_name" value=VeryGood required>
                                </div>
                                <%--<div class="col-12 mb-4">
                                    <label for="">Seller Contanct Number *</label>
                                    <input type="hidden" class="form-control" id="seller_phone" name="seller_phone" value="${sellerInfo.user_phone}">
                                    <input type="tel" class="realphoneN" id="realphoneN" name="realphoneN" value="${ hide_number}">
                                </div>
                                <div class="col-12 mb-4">
                                    <label for="sellerRegdate">Seller Reg-Date *</label>
                                    <input type="datetime" class="sellerRegdate" id="sellerRegdate" name="sellerRegdate" value="${sellerInfo.reg_date}">
                                </div>
                                 <div class="col-12 mb-4">
                                    <label for="sellerScore">Manner Score</label>
                                    <input type="text" class="sellerScore" id="sellerScore" name="sellerScore" value="${sellerInfo.score}">
                                </div>
                                 <div class="col-12 mb-4">
                                    <label for="sellerLocation">Seller Location *</label>
                                    <input type="text" class="sellerLocation" id="sellerLocation" id="sellerLocation" value="">
                                </div> --%>
<!--                                 <div class="col-md-6 mb-4"> -->
<!--                                     <label for="city">Town/City *</label> -->
<!--                                     <input type="text" class="form-control" id="city" value=""> -->
<!--                                 </div> -->
<!--                                 <div class="col-md-6 mb-4"> -->
<!--                                     <label for="state">State/Province *</label> -->
<!--                                     <input type="text" class="form-control" id="state" value=""> -->
<!--                                 </div> -->
<!--                                 <div class="col-md-6 mb-4"> -->
<!--                                     <label for="country">Country</label> -->
<!--                                     <select class="custom-select d-block w-100" id="country"> -->
<!--                                         <option value="usa">United States</option> -->
<!--                                         <option value="uk">United Kingdom</option> -->
<!--                                         <option value="ger">Germany</option> -->
<!--                                         <option value="fra">France</option> -->
<!--                                         <option value="ind">India</option> -->
<!--                                         <option value="aus">Australia</option> -->
<!--                                         <option value="bra">Brazil</option> -->
<!--                                         <option value="cana">Canada</option> -->
<!--                                     </select> -->
<!--                                 </div> -->
<!--                                 <div class="col-md-6 mb-4"> -->
<!--                                     <label for="postcode">Postcode/Zip</label> -->
<!--                                     <input type="text" class="form-control" id="postcode" value=""> -->
<!--                                 </div> -->
<!--                                 <div class="col-md-12 mb-4"> -->
<!--                                     <label for="order-notes">Order Notes</label> -->
<!--                                     <textarea class="form-control" id="order-notes" cols="30" rows="10" placeholder="Notes about your order, e.g. special notes for delivery."></textarea> -->
<!--                                 </div> -->
<!--                                 <div class="col-12"> -->
<!--                                     <div class="d-flex align-items-center"> -->
<!--                                         Single Checkbox -->
<!--                                         <div class="custom-control custom-checkbox d-flex align-items-center mr-30"> -->
<!--                                             <input type="checkbox" class="custom-control-input" id="customCheck1"> -->
<!--                                             <label class="custom-control-label" for="customCheck1">Ship to a different address?</label> -->
<!--                                         </div> -->
<!--                                         Single Checkbox -->
<!--                                         <div class="custom-control custom-checkbox d-flex align-items-center"> -->
<!--                                             <input type="checkbox" class="custom-control-input" id="customCheck2"> -->
<!--                                             <label class="custom-control-label" for="customCheck2">Create an account?</label> -->
<!--                                         </div> -->
<!--                                     </div> -->
<!--                                 </div> -->
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
                            <h5>가입한 날짜</h5>
                            <h5>${sellerInfo.reg_date}</h5>
                        </div>
                        <div class="order-total d-flex justify-content-between align-items-center">
                            <h5>Manner Score</h5>
                            <h5>${sellerInfo.score}P</h5>
                        </div>
                        <div class="checkout-btn mt-30">
                            <a href="#" class="btn alazea-btn w-100">이전 페이지로</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- ##### Checkout Area End ##### -->





<h2>
</h2>



<div class="related-products-area">
        <div class="container">
            <div class="row">
                <div class="col-12">
                
                
                    <!-- Section Heading -->
                    <div class="section-heading text-center">
                        <h2 class="text-left">${sellerInfo.user_id}님이 판매중인 다른 상품</h2>
                    </div>
                </div>
            </div>

            <div class="row" id="sellerProductList">

                <!-- Single Product Area -->
                <div class="col-12 col-sm-6 col-lg-4">
                    <div class="single-product-area mb-100">
                        <!-- Product Image -->
                        <div class="product-img" >
                            <a href="shop-details.html"><img src="http://localhost:8080/resources/product_img/iron1.png" alt=""></a>
                            <!-- Product Tag -->
                            <div class="product-tag">
                                <a href="#">Hot</a>
                            </div>
                            <div class="product-meta d-flex">
                                <a href="#" class="wishlist-btn"><i class="icon_heart_alt"></i></a>
                                <a href="cart.html" class="add-to-cart-btn">Add to cart</a>
                                <a href="#" class="compare-btn"><i class="arrow_left-right_alt"></i></a>
                            </div>
                        </div>
                        <!-- Product Info -->
                        <div class="product-info mt-15 text-center">
                            <a href="shop-details.html">
                                <p>Cactus Flower</p>
                            </a>
                            <h6>$10.99</h6>
                        </div>
                    </div>
                </div>


                <div class="col-12 col-sm-6 col-lg-4">
                    <div class="single-product-area mb-100">
                        <!-- Product Image -->
                        <div class="product-img" >
                            <a href="shop-details.html"><img src="http://localhost:8080/resources/product_img/iron1.png" alt=""></a>
                            <!-- Product Tag -->
                            <div class="product-tag">
                                <a href="#">Hot</a>
                            </div>
                            <div class="product-meta d-flex">
                                <a href="#" class="wishlist-btn"><i class="icon_heart_alt"></i></a>
                                <a href="cart.html" class="add-to-cart-btn">Add to cart</a>
                                <a href="#" class="compare-btn"><i class="arrow_left-right_alt"></i></a>
                            </div>
                        </div>
                        <!-- Product Info -->
                        <div class="product-info mt-15 text-center">
                            <a href="shop-details.html">
                                <p>Cactus Flower</p>
                            </a>
                            <h6>$10.99</h6>
                        </div>
                    </div>
                </div>
                
                
                                <div class="col-12 col-sm-6 col-lg-4">
                    <div class="single-product-area mb-100">
                        <!-- Product Image -->
                        <div class="product-img" >
                            <a href="shop-details.html"><img src="http://localhost:8080/resources/product_img/iron1.png" alt="" ></a>
                            <!-- Product Tag -->
                            <div class="product-tag">
                                <a href="#">Hot</a>
                            </div>
                            <div class="product-meta d-flex">
                                <a href="#" class="wishlist-btn"><i class="icon_heart_alt"></i></a>
                                <a href="cart.html" class="add-to-cart-btn">Add to cart</a>
                                <a href="#" class="compare-btn"><i class="arrow_left-right_alt"></i></a>
                            </div>
                        </div>
                        <!-- Product Info -->
                        <div class="product-info mt-15 text-center">
                            <a href="shop-details.html">
                                <p>Cactus Flower</p>
                            </a>
                            <h6>$10.99</h6>
                        </div>
                    </div>
                </div>

            
            </div>
        </div>
    </div>




<section class="blog-content-area section-padding-0-100">
        <div class="container">
            <div class="row justify-content-center">
                <!-- Blog Posts Area -->
                <div class="col-12 col-md-12">
                    <div class="blog-posts-area">

                        <!-- Comment Area Start -->
 <!--                        <div class="comment_area clearfix">
                            <h4 class="headline">2 리뷰 출력</h4>

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
                        </div> -->

                        <!-- Leave A Comment -->
<!--                         <div class="leave-comment-area clearfix">
                            <div class="comment-form">
                                <h4 class="headline">리뷰남기기</h4>

                                <div class="contact-form-area">
                                    Comment Form
                                    <form action="#" method="post">
                                        <div class="row">
                                            <div class="col-12 col-md-6">
                                                <div class="form-group">
                                                    <input type="text" class="form-control" id="contact-name" placeholder="Name">
                                                </div>
                                            </div>
                                            <div class="col-12 col-md-6">
                                                <div class="form-group">
                                                    <input type="email" class="form-control" id="contact-email" placeholder="Email">
                                                </div>
                                            </div>
                                            <div class="col-12">
                                                <div class="form-group">
                                                    <textarea class="form-control" name="message" id="message" cols="30" rows="10" placeholder="Comment"></textarea>
                                                </div>
                                            </div>
                                            <div class="col-12">
                                                <button type="submit" class="btn alazea-btn">Post Comment</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div> -->

                    </div>
                </div>

            
            </div>
        </div>
    </section>


    
    <%@ include file="../include/footer.jsp" %>
    
    
    <script>
    
   
    
    </script>
    
    

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