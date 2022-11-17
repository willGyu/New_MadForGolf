

//1.무한스크롤 전역 변수설정
let $currentPageNo=1; // 현재페이지 전역 변수 설정
let $sellerTotalCount=0; //판맨 상품 총 갯수 전역 변수 설정
let $tempEndPage=0; //마지막 페이지 번호  전역 변수 설정
const sellerReview={
		
		
		
		//초기 작업
		init:()=>{
			//sellerReview 객체 파일을 _this 변수에 할당
			const _this=sellerReview;			
			
			
			//리뷰 목록을 불러온다
			_this.list();
			
			
			//2.최초 1번만  sellerProductList 함수를 거치지 않고 실행되는 함수 
			//실행하는 함수 생성 ? 왜냐하면은 $sellerTotalCount , $tempEndPage 변수에 데이터가
			//없기 때문에 이값을 넣기위해 , 만약에 			
			//this.sellerProductList(); 함수 처리를 한다면 $sellerTotalCount  ,  $tempEndPage 값이 없기 때문에 오류 발생
			//판매자 상품 목록불러오기	최초 1번은 	 ajaxSellerProductList() 함수 호출	
			_this.ajaxSellerProductList();
			
			 //3.스크롤 바닥 감지
	        window.onscroll = function(e) {
	            //window height + window scrollY 값이 document height보다 클 경우,
	            if((window.innerHeight + window.scrollY) >= document.body.offsetHeight) {
	            	//4.페이지 번호 증가 처리
	            	$currentPageNo +=1;	    	            	
	                _this.sellerProductList();
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
		

		//스크롤 내리면 실행되는 함수
		sellerProductList:function(){
			 	//5.현재 페이지가 마지막 페이지보다 같거나 작을때까지 실행
		    	if(parseInt($tempEndPage) >=  parseInt($currentPageNo)){	    		
		    		console.log( "현재 페이지  :" ,$currentPageNo , " ,  마지막 페이지 :", $tempEndPage);
		    		sellerReview.ajaxSellerProductList();
		    	}	    	
		   },
	   
	   
	   //페이지 로딩후 최초 1번만 sellerProductList 함수를 거치지 않고 실행되는 함수 
	   ajaxSellerProductList:function(){
		   const sellerId =$("#sellerId").val();
		   
	    	$.ajax({
	    		url:'/product/sellerProductList',
	    		type:"GET",
	    		data:{sellerId:sellerId , page:$currentPageNo},
	    		success:function(res){
	    			//JSON 객체로 변환
	    			const data=JSON.parse(res); 
	    			console.log(data);
	    			if(data.code!=="success"){
	    				console.log("sellerProductList  오류 ");
	    				return;
	    			}
	    			
	    			$sellerTotalCount=parseInt(data.totalCnt); //전체 게시글 갯수 저장
	    			$tempEndPage=parseInt(data.pageMaker.tempEndPage); //마지막 페이지 번호 저장
	    			$("#sellerTotalCount").text(`판매상품 총 ${data.totalCnt}개`);	    				    		
	    			
	                
	    			let html="";
	    			
	    			data.sellerProductList.forEach(item=>{
	    			
	    				
	    				
	    				html +=`
	    				
	    		              <div class="col-12 col-sm-6 col-lg-4">
	                        <div class="single-product-area mb-100">
	                            <!-- Product Image -->
	                            <div class="product-img" >
	                                <a href="/product/seller?prod_num=${item.prod_num}">
                                            <img src="/resources/product_img/${item.prod_img}" alt="">
                                            </a>
	                                <!-- Product Tag -->
	                              
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
