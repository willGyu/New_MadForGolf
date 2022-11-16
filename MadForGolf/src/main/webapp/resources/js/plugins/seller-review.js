let currentPageNo=1;

const sellerReview={
		
		
		
		//초기 작업
		init:()=>{
			//sellerReview 객체 파일을 _this 변수에 할당
			const _this=sellerReview;			
			
			
			//리뷰 목록을 불러온다
			_this.list();
			
			
			//판매자 상품 목록불러오기
			_this.sellerProductList(currentPageNo);
			
			  //스크롤 바닥 감지
	        window.onscroll = function(e) {
	            //window height + window scrollY 값이 document height보다 클 경우,
	            if((window.innerHeight + window.scrollY) >= document.body.offsetHeight) {                        	                   
	                _this.sellerProductList(currentPageNo);
	            }
	        };
		},
		
		
		list:function(pageUrl){
			const prodNum =$("#prodNum").val();
			const home=$("#home").val();
			
			if(!pageUrl){
				pageUrl =`${home}/api/review/listall/${prodNum}`
			}
			
			
			console.log("판매자 리뷰 가져오기 상품 번호 :" , prodNum);
			//`` 역따옴표 백태그는 jsp 파일에서 사용하면 아되며 js 파일에서만 적용 .${변수}  jsp 하고 동일!!.
			$.get(pageUrl , function(data,status){
				const getData=JSON.parse(data);
				console.log("판매자 리뷰 data :", JSON.parse(data));
				let html="";
				$("#reviews .headline").html(`리뷰 ${getData.totalCount}`);
				$("#review-totcnt").html(`(${getData.totalCount})`);
				

				
				console.log(" sellerReview", getData.pagination);
				
				getData.serList.forEach(item=>{
					let year=new Date(item.review_date).getFullYear();
					let month=new Date(item.review_date).getMonth()+1;
					let day =new Date(item.review_date).getDate();
					
					const formatDate=year+"-"+(("00"+month.toString()).slice(-2))+"-"+(("00"+day.toString()).slice(-2)); 
									
					html +=`
					
						
                         <li class="single_comment_area" ${item.prod_num}>
                                    <div class="comment-wrapper d-flex">
                                        <!-- Comment Meta -->
                                        <div class="comment-author">
                                        	<a href="/product/seller?prod_num=${item.prod_num}">
                                            <img src="/resources/product_img/${item.prod_img}" alt="">
                                            </a>
                                        </div>
                                        <!-- Comment Content -->
                                        <div class="comment-content" >
                                            <div class="d-flex align-items-center justify-content-between">
                                                <h5>${item.buyer_name}</h5>
                                                <span class="comment-date">${formatDate}</span>
                                            </div>
                                            <p> ${item.content}</p>
                                          
                                        </div>
                                                                                									
                                    </div>
                          </li>
 
             				
					`;
					
				});
				
				//아이가 sellerReviewList 에 html 로 뿌려 준다.
				$("#reviews  ol").html(html);

				
				//페이징 처리
				$("#review-pagination").html(getData.pagination);
				
				$(".page-link").on("click", function(e){
					e.preventDefault();
					sellerReview.list( e.target.dataset.href);
					
				})
			})
		},
		

		
	sellerProductList:function(currentPageNo){
	    	const sellerId =$("#sellerId").val();
	    	if(!currentPageNo)currentPageNo=1;
	    	
	    	$.ajax({
	    		url:'/product/sellerProductList',
	    		type:"GET",
	    		data:{sellerId:sellerId , page:currentPageNo},
	    		success:function(res){
	    			console.log(res);
	    			
	    			//**** 서버에서 계산된 마지막 페이지 번호가  자사스크립트 currentPageNo 작을 경우 중단처리
	                //if(currentPageNo >res.paginationInfo.lastPageNo)return;                                  
	                //console.log(" currentPageNo {} - {}",res.paginationInfo.lastPageNo , currentPageNo , res.paginationInfo.currentPageNo);
	                currentPageNo++;
	                
	    			let html="";
	    			
	    			res.forEach(item=>{
	    				
	    				console.log(" item : ", item);
	    				
	    				html +=`
	    				
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
	                                    <p>${item.prod_name}</p>
	                                </a>
	                                <h6>${item.price}</h6>
	                            </div>
	                        </div>
	                    </div>

	    				
	    				
	    				`;
	    				
	    			})
	    				 
	    			$("#sellerProductList").append(html);
	    			
	    		},
	    		error:function(err){
	    			console.log(err);
	    		}    		
	    		
	    	})
	    	
	   }
		
}


//private Integer review_num;
//private Integer prod_num;
//private String content;
//private String review_img;
//private Integer score;
//private Timestamp review_date;

//sellerReview init() 함수 호출
sellerReview.init();
