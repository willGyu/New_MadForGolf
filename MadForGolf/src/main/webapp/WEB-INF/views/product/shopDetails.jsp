<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../include/header.jsp" %>

<style type="text/css">
#button, #button2 {
	width: 150px; height: 46px;
	font-weight: 600;
	border: none;
	margin-left: 15px;
	cursor: pointer;
}

#button2:hover {
	background-color: white;
	color: #70C745;
	border-color: #70C745;
	cursor: pointer;
	border: 1px solid;
}
</style>

<script src="https://t1.kakaocdn.net/kakao_js_sdk/2.0.0/kakao.min.js"
  integrity="sha384-PFHeU/4gvSH8kpvhrigAPfZGBDPs372JceJq3jAXce11bVA6rMvGWzvP4fMQuBGL" crossorigin="anonymous"></script>
  
<script>
  Kakao.init('8bac8b97f338b46658e0afc74127913e'); // 사용하려는 앱의 JavaScript 키 입력
</script>


<script>
function shareMessage() {
/*     var like_count = ${product.like_count}; */
/*     const like = parseInt(like_count); */
   
	const like = parseInt(${product.like_count}); //like_count int로 변환해야 나와서 바꿈 
    
	Kakao.Share.sendDefault({
      objectType: 'feed',
      content: {
        title: '${product.prod_name}',
        description: '${product.detail}',
        imageUrl: 'https://cdn.pixabay.com/photo/2017/01/07/17/25/golfer-1960998_960_720.jpg',
        //대표 이미지 주소 넣을 예정 -> 상품별 이미지 불러오기 어려브..
        link: {
          mobileWebUrl: 'http://localhost:8088/',
          webUrl: 'http://localhost:8088/',
          //http://itwillbs7.cafe24.com/MadForGolf 
          //최종 호스팅하고 주소 넣을 예정 
        },
      },
      social: {
        likeCount: like,
      },
      buttons: [
        {
          title: '웹으로 보기',
          link: {
            mobileWebUrl: 'https://developers.kakao.com',
            webUrl: 'https://developers.kakao.com',
          },
        },
        {
          title: '앱으로 보기',
          link: {
            mobileWebUrl: 'https://developers.kakao.com',
            webUrl: 'https://developers.kakao.com',
          },
        },
      ],
    });
  }
</script>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
/*         var like_count = ${product.like_count};
        const like = parseInt(like_count);
		
        alert(like); //parsrInt시, int변환 값 넘어오는지 확인용 */
        
//=================찜하기 버튼 클릭 시 alert창 
		$('#like_heart').click(function() {
			var result = confirm('상품을 찜하시겠습니까?');

			if (result) {
				//yes
				location.href='/';
				//찜 리스트 페이지 생성 후 -> 찜리스트 페이지 이동으로 변경 
			} else { 
				//no
			}
		});
//==================찜하기 버튼 클릭 시 alert창 

//==================거래 전 버튼 클릭시, 채팅하기 구매하기 버튼 비활성화
        
		$('#deal').click(function(){
			const target1 = document.getElementById('button');
			target1.disabled = true;
			
			const target2 = document.getElementById('addtocart');
			target2.disabled = true; //input type submit이라 안먹는 듯....샹 ....ㅠㅠ 찾아보자 
		});
			  

	});
//==================거래 전 버튼 클릭시, 채팅하기 구매하기 버튼 비활성화



//==================거래전 버튼 -> 거래후 변경
function changeBtnName()  {
  const btnElement = document.getElementById('deal');
  
  btnElement.value = "거래후"; //버튼 value바꿈 
  
}
//==================거래전 버튼 -> 거래후 변경 

</script>



    <!-- ##### Breadcrumb Area Start ##### -->
    <div class="breadcrumb-area">
        <!-- Top Breadcrumb Area -->
        <div class="top-breadcrumb-area bg-img bg-overlay d-flex align-items-center justify-content-center" style="background-image: url(${pageContext.request.contextPath }/resources/img/bg-img/24.jpg);">
            <h2>SHOP DETAILS</h2>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-12">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="#"><i class="fa fa-home"></i> Home</a></li>
                            <li class="breadcrumb-item"><a href="#">Shop</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Shop Details</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>
    <!-- ##### Breadcrumb Area End ##### -->

    <!-- ##### Single Product Details Area Start ##### -->
    <section class="single_product_details_area mb-50">
        <div class="produts-details--content mb-50">
            <div class="container">
                <div class="row justify-content-between">

                    <div class="col-12 col-md-6 col-lg-5">
                        <div class="single_product_thumb">
                            <div id="product_details_slider" class="carousel slide" data-ride="carousel">
                                <div class="carousel-inner">
                                    <div class="carousel-item active">
                                        <a class="product-img" href="${pageContext.request.contextPath }/resources/product_img/${product.prod_img }" title="Product Image">
                                        <img src="${pageContext.request.contextPath }/resources/product_img/${product.prod_img }" alt="1" style="height: 440px; width: 308px; margin-left: 80px;">
                                    </a>
                                    </div>
                                    <!-- 이미지 여러개 넣을 시 주석 풀고 사용 -->
<!--                                     <div class="carousel-item"> -->
<%--                                         <a class="product-img" href="${pageContext.request.contextPath }/resources/img/bg-img/49.jpg" title="Product Image"> --%>
<%--                                         <img class="d-block w-100" src="${pageContext.request.contextPath }/resources/img/bg-img/49.jpg" alt="1"> --%>
<!--                                     </a> -->
<!--                                     </div> -->
<!--                                     <div class="carousel-item"> -->
<%--                                         <a class="product-img" href="${pageContext.request.contextPath }/resources/img/bg-img/49.jpg" title="Product Image"> --%>
<%--                                         <img class="d-block w-100" src="${pageContext.request.contextPath }/resources/img/bg-img/49.jpg" alt="1"> --%>
<!--                                     </a> -->
<!--                                     </div> -->
                                </div>
<!--                                 <ol class="carousel-indicators"> -->
<%--                                     <li class="active" data-target="#product_details_slider" data-slide-to="0" style="background-image: url(${pageContext.request.contextPath }/resources/img/bg-img/49.jpg);"> --%>
<!--                                     </li> -->
<%--                                     <li data-target="#product_details_slider" data-slide-to="1" style="background-image: url(${pageContext.request.contextPath }/resources/img/bg-img/49.jpg);"> --%>
<!--                                     </li> -->
<%--                                     <li data-target="#product_details_slider" data-slide-to="2" style="background-image: url(${pageContext.request.contextPath }/resources/img/bg-img/49.jpg);"> --%>
<!--                                     </li> -->
<!--                                 </ol> -->
                            </div>
                        </div>
                    </div>

                    <div class="col-12 col-md-6">
                        <div class="single_product_desc" style="width: 410px;">
                            <h4 class="title">${product.prod_name }</h4>
                            <h4 class="price"><fmt:formatNumber value="${product.price }"/>원</h4>
                            <div class="short_overview">
                                <p>${product.detail }</p>
                            </div>

                            <div class="cart--area d-flex flex-wrap align-items-center">
                                <!-- Add to Cart Form -->
                                <form class="cart clearfix d-flex align-items-center" method="post">
                                <!-- Wishlist & Compare -->
                                <div class="wishlist-compare d-flex flex-wrap align-items-center">
                                    <a href="#" class="wishlist-btn ml-15"><i id="like_heart" class="icon_heart_alt"></i></a>
                                    <input type="hidden" id="prod_img" value="${product.prod_img }">
                                    <input type="hidden" id="like_count" value="${product.like_count }">
                                    
                                    <input type="button" id="button" value="채팅하기" onclick="">
<!--                                     <input type="button" id="deal" value="거래전" onclick="changeBtnName();">
 -->                                </div>
                                    <input type="submit" name="addtocart" value="구매하기" class="btn alazea-btn ml-15">
                                </form>
                            </div>

                            <div class="products--meta">
                                <p><span>Condition:</span> <span>${product.condition }</span></p>
                                <p><span>Gender:</span> <span><c:if test="${product.gender eq 1}">남</c:if><c:if test="${product.gender eq 2}">여</c:if></span></p>
                                <p><span>Category:</span> <span>${product.category }</span></p>
                                <p>
                                    <span>Share on:</span>
                                    <span>
                                   <!--  <a href="#"><i class="fa fa-facebook" onclick="shareMessage();"></i></a> -->
                                    <a href="#" onclick="shareMessage();"><img style="width: 17px; height: 17x;" src="${pageContext.request.contextPath }/resources/product_img/kakao.png"></a>
                                </span>
                                </p>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="product_details_tab clearfix" style="border-bottom: none;">
                    	<!-- 탭 사용 시 주석풀고 사용 -->
                        <!-- Tabs -->
<!--                         <ul class="nav nav-tabs" role="tablist" id="product-details-tab"> -->
<!--                             <li class="nav-item"> -->
<!--                                 <a href="#description" class="nav-link active" data-toggle="tab" role="tab">Description</a> -->
<!--                             </li> -->
<!--                             <li class="nav-item"> -->
<!--                                 <a href="#addi-info" class="nav-link" data-toggle="tab" role="tab">Additional Information</a> -->
<!--                             </li> -->
<!--                             <li class="nav-item"> -->
<!--                                 <a href="#reviews" class="nav-link" data-toggle="tab" role="tab">Reviews <span class="text-muted">(1)</span></a> -->
<!--                             </li> -->
<!--                         </ul> -->
                        <!-- Tab Content -->
                        <div class="tab-content">
                            <div role="tabpanel" class="tab-pane fade show active" id="description"  style="text-align: center;">
                                <div class="description_area">
                                    <input type="button" id="button2" value="목록으로" onclick="history.back();">
                                    
                                    <!-- 수정하기 get  -->
                                    <input type="button" id="button2" value="수정하기" onclick="location.href='${pageContext.request.contextPath }/product/modify?prod_num=${product.prod_num}'">
                                    <!-- 수정하기 get  -->
                                    
                                    
                                    
                                    <input type="button" id="button2" value="삭제하기" onclick="location.href='${pageContext.request.contextPath }/product/remove?prod_num=${product.prod_num}&category=${product.category }'">
                                    
                                    
<%--                                     <!-- 삭제하기 post  -->
                                    <form action="${pageContext.request.contextPath }/product/remove" method="post">
                                    <input type="hidden" value="${product.prod_num }">
                                    <input type="submit" value="삭제하기">
                         			</form>
                                    <!-- 삭제하기 post  --> --%>
                         			
                                </div>
                            </div>
                            <div role="tabpanel" class="tab-pane fade" id="addi-info">
                                <div class="additional_info_area">
                                    <p>What should I do if I receive a damaged parcel?
                                        <br> <span>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reprehenderit impedit similique qui, itaque delectus labore.</span></p>
                                    <p>I have received my order but the wrong item was delivered to me.
                                        <br> <span>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Facilis quam voluptatum beatae harum tempore, ab?</span></p>
                                    <p>Product Receipt and Acceptance Confirmation Process
                                        <br> <span>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dolorum ducimus, temporibus soluta impedit minus rerum?</span></p>
                                    <p>How do I cancel my order?
                                        <br> <span>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nostrum eius eum, minima!</span></p>
                                </div>
                            </div>
                            <div role="tabpanel" class="tab-pane fade" id="reviews">
                                <div class="reviews_area">
                                    <ul>
                                        <li>
                                            <div class="single_user_review mb-15">
                                                <div class="review-rating">
                                                    <i class="fa fa-star" aria-hidden="true"></i>
                                                    <i class="fa fa-star" aria-hidden="true"></i>
                                                    <i class="fa fa-star" aria-hidden="true"></i>
                                                    <i class="fa fa-star" aria-hidden="true"></i>
                                                    <i class="fa fa-star" aria-hidden="true"></i>
                                                    <span>for Quality</span>
                                                </div>
                                                <div class="review-details">
                                                    <p>by <a href="#">Colorlib</a> on <span>12 Sep 2018</span></p>
                                                </div>
                                            </div>
                                            <div class="single_user_review mb-15">
                                                <div class="review-rating">
                                                    <i class="fa fa-star" aria-hidden="true"></i>
                                                    <i class="fa fa-star" aria-hidden="true"></i>
                                                    <i class="fa fa-star" aria-hidden="true"></i>
                                                    <i class="fa fa-star" aria-hidden="true"></i>
                                                    <i class="fa fa-star" aria-hidden="true"></i>
                                                    <span>for Design</span>
                                                </div>
                                                <div class="review-details">
                                                    <p>by <a href="#">Colorlib</a> on <span>12 Sep 2018</span></p>
                                                </div>
                                            </div>
                                            <div class="single_user_review">
                                                <div class="review-rating">
                                                    <i class="fa fa-star" aria-hidden="true"></i>
                                                    <i class="fa fa-star" aria-hidden="true"></i>
                                                    <i class="fa fa-star" aria-hidden="true"></i>
                                                    <i class="fa fa-star" aria-hidden="true"></i>
                                                    <i class="fa fa-star" aria-hidden="true"></i>
                                                    <span>for Value</span>
                                                </div>
                                                <div class="review-details">
                                                    <p>by <a href="#">Colorlib</a> on <span>12 Sep 2018</span></p>
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
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- ##### Single Product Details Area End ##### -->

    <!-- ##### Related Product Area Start ##### -->
<!--     <div class="related-products-area"> -->
<!--         <div class="container"> -->
<!--             <div class="row"> -->
<!--                 <div class="col-12"> -->
<!--                     Section Heading -->
<!--                     <div class="section-heading text-center"> -->
<!--                         <h2>Related Products</h2> -->
<!--                     </div> -->
<!--                 </div> -->
<!--             </div> -->

<!--             <div class="row"> -->

<!--                 Single Product Area -->
<!--                 <div class="col-12 col-sm-6 col-lg-3"> -->
<!--                     <div class="single-product-area mb-100"> -->
<!--                         Product Image -->
<!--                         <div class="product-img"> -->
<%--                             <a href="shop-details.html"><img src="${pageContext.request.contextPath }/resources/img/bg-img/40.png" alt=""></a> --%>
<!--                             Product Tag -->
<!--                             <div class="product-tag"> -->
<!--                                 <a href="#">Hot</a> -->
<!--                             </div> -->
<!--                             <div class="product-meta d-flex"> -->
<!--                                 <a href="#" class="wishlist-btn"><i class="icon_heart_alt"></i></a> -->
<!--                                 <a href="cart.html" class="add-to-cart-btn">Add to cart</a> -->
<!--                                 <a href="#" class="compare-btn"><i class="arrow_left-right_alt"></i></a> -->
<!--                             </div> -->
<!--                         </div> -->
<!--                         Product Info -->
<!--                         <div class="product-info mt-15 text-center"> -->
<!--                             <a href="shop-details.html"> -->
<!--                                 <p>Cactus Flower</p> -->
<!--                             </a> -->
<!--                             <h6>$10.99</h6> -->
<!--                         </div> -->
<!--                     </div> -->
<!--                 </div> -->

<!--                 Single Product Area -->
<!--                 <div class="col-12 col-sm-6 col-lg-3"> -->
<!--                     <div class="single-product-area mb-100"> -->
<!--                         Product Image -->
<!--                         <div class="product-img"> -->
<%--                             <a href="shop-details.html"><img src="${pageContext.request.contextPath }/resources/img/bg-img/41.png" alt=""></a> --%>
<!--                             <div class="product-meta d-flex"> -->
<!--                                 <a href="#" class="wishlist-btn"><i class="icon_heart_alt"></i></a> -->
<!--                                 <a href="cart.html" class="add-to-cart-btn">Add to cart</a> -->
<!--                                 <a href="#" class="compare-btn"><i class="arrow_left-right_alt"></i></a> -->
<!--                             </div> -->
<!--                         </div> -->
<!--                         Product Info -->
<!--                         <div class="product-info mt-15 text-center"> -->
<!--                             <a href="shop-details.html"> -->
<!--                                 <p>Cactus Flower</p> -->
<!--                             </a> -->
<!--                             <h6>$10.99</h6> -->
<!--                         </div> -->
<!--                     </div> -->
<!--                 </div> -->

<!--                 Single Product Area -->
<!--                 <div class="col-12 col-sm-6 col-lg-3"> -->
<!--                     <div class="single-product-area mb-100"> -->
<!--                         Product Image -->
<!--                         <div class="product-img"> -->
<%--                             <a href="shop-details.html"><img src="${pageContext.request.contextPath }/resources/img/bg-img/42.png" alt=""></a> --%>
<!--                             <div class="product-meta d-flex"> -->
<!--                                 <a href="#" class="wishlist-btn"><i class="icon_heart_alt"></i></a> -->
<!--                                 <a href="cart.html" class="add-to-cart-btn">Add to cart</a> -->
<!--                                 <a href="#" class="compare-btn"><i class="arrow_left-right_alt"></i></a> -->
<!--                             </div> -->
<!--                         </div> -->
<!--                         Product Info -->
<!--                         <div class="product-info mt-15 text-center"> -->
<!--                             <a href="shop-details.html"> -->
<!--                                 <p>Cactus Flower</p> -->
<!--                             </a> -->
<!--                             <h6>$10.99</h6> -->
<!--                         </div> -->
<!--                     </div> -->
<!--                 </div> -->

<!--                 Single Product Area -->
<!--                 <div class="col-12 col-sm-6 col-lg-3"> -->
<!--                     <div class="single-product-area mb-100"> -->
<!--                         Product Image -->
<!--                         <div class="product-img"> -->
<%--                             <a href="shop-details.html"><img src="${pageContext.request.contextPath }/resources/img/bg-img/43.png" alt=""></a> --%>
<!--                             Product Tag -->
<!--                             <div class="product-tag sale-tag"> -->
<!--                                 <a href="#">Hot</a> -->
<!--                             </div> -->
<!--                             <div class="product-meta d-flex"> -->
<!--                                 <a href="#" class="wishlist-btn"><i class="icon_heart_alt"></i></a> -->
<!--                                 <a href="cart.html" class="add-to-cart-btn">Add to cart</a> -->
<!--                                 <a href="#" class="compare-btn"><i class="arrow_left-right_alt"></i></a> -->
<!--                             </div> -->
<!--                         </div> -->
<!--                         Product Info -->
<!--                         <div class="product-info mt-15 text-center"> -->
<!--                             <a href="shop-details.html"> -->
<!--                                 <p>Cactus Flower</p> -->
<!--                             </a> -->
<!--                             <h6>$10.99</h6> -->
<!--                         </div> -->
<!--                     </div> -->
<!--                 </div> -->

<!--             </div> -->
<!--         </div> -->
<!--     </div> -->
    <!-- ##### Related Product Area End ##### -->

<%@ include file="../include/footer.jsp" %>