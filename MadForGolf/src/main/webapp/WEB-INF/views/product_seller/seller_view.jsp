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
            <h2>Checkout</h2>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-12">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="#"><i class="fa fa-home"></i> Home</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Checkout</li>
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
                        <h5>Product currently on Sale</h5>
                                               
                        
                        <input type="hidden" name="prodNum" id="prodNum" value=" ${sellerInfo.prod_num}">
                        <input type="hidden" name="home" id="home" value="${pageContext.request.contextPath}" >
                              <img src="${pageContext.request.contextPath}/resources/product_img/${sellerInfo.prod_img}" 
                              style="width:150px  ; height: auto"> <br>
                        
                         <%-- ${sellerInfo} --%>
                        
                        <form action="#" method="post">
                            <div class="row">
                                <div class="col-md-6 mb-4">
                                    <label for="seller_Id">SellerID *</label>
                                    <input type="text" class="form-control" id="sellerId" name="sellerId" value="${sellerInfo.user_id}" required>
                                </div>
                                <div class="col-md-6 mb-4">
                                    <label for="seller_name">Seller Name *</label>
                                    <input type="text" class="form-control" id="seller_name" name="seller_name" value="${sellerInfo.user_name}" required>
                                </div>
                                <div class="col-12 mb-4">
                                    <label for="">Seller Contanct Number *</label>
                                    <input type="hidden" class="form-control" id="seller_phone" name="seller_phone" value="${sellerInfo.user_phone}">
                                    <input type="tel" class="realphoneN" id="realphoneN" name="realphoneN" value="${ hide_number}">
                                </div>
                                <div class="col-12 mb-4">
                                    <label for="sellerRegdate">판매자 가입한 날짜 *</label>
                                    <input type="datetime" class="sellerRegdate" id="sellerRegdate" name="sellerRegdate" value="${sellerInfo.reg_date}">
                                </div>
                                <div class="col-12 mb-4">
                                    <label for="sellerScore">Sales Score</label>
                                    <input type="text" class="sellerScore" id="sellerScore" name="sellerScore" value="${sellerInfo.score}">
                                </div>
                                <div class="col-12 mb-4">
                                    <label for="sellerLocation">Seller Location *</label>
                                    <input type="text" class="sellerLocation" id="sellerLocation" id="sellerLocation" value="">
                                </div>
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
                        
                        <h2>리뷰 출력란</h2>
                        	
                        	<div id="sellerReviewList" >
                        	
                        </div>
                        
                        
                        
                         <h2>리뷰 출력란 끝</h2>

                <div class="col-12 col-lg-4">
                    <div class="checkout-content">
                        <h5 class="title--">Your Order</h5>
                        <div class="products">
                            <div class="products-data">
                                <h5>Products:</h5>
                                <div class="single-products d-flex justify-content-between align-items-center">
                                    <p>Recuerdos Plant</p>
                                    <h5>$9.99</h5>
                                </div>
                            </div>
                        </div>
                        <div class="subtotal d-flex justify-content-between align-items-center">
                            <h5>Subtotal</h5>
                            <h5>$9.99</h5>
                        </div>
                        <div class="shipping d-flex justify-content-between align-items-center">
                            <h5>Shipping</h5>
                            <h5>$3.00</h5>
                        </div>
                        <div class="order-total d-flex justify-content-between align-items-center">
                            <h5>Order Total</h5>
                            <h5>$12.99</h5>
                        </div>
                        <div class="checkout-btn mt-30">
                            <a href="#" class="btn alazea-btn w-100">Place Order</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- ##### Checkout Area End ##### -->

    
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