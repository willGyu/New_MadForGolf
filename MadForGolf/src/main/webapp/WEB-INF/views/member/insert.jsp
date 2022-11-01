<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %> 
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	
</script>

<!-- ##### Breadcrumb Area Start ##### -->
    <div class="breadcrumb-area">
        <!-- Top Breadcrumb Area -->
        <div class="top-breadcrumb-area bg-img bg-overlay d-flex align-items-center justify-content-center" style="background-image: url(${pageContext.request.contextPath }/resources/img/bg-img/24.jpg);">
            <h2>Join</h2>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-12">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="/member/insert"><i class="fa fa-home"></i> Join</a></li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>
    <!-- ##### Breadcrumb Area End ##### -->


<script>
	$(document).ready(function() {
		$('#join').submit(function() {
			//alert("알럿!");
			if ($('.password2').val() != $('.password').val()) {
				$('.pass2div').html("비밀번호가 다릅니다. 다시 확인하세요.");
				$('.pass2div').focus();
				return false;
			}
			if ($('.password2').val() == $('.password').val()) {
				$('.pass2div').html("비밀번호가 일치합니다.");
			}
			if ($('.password2').val() == '') {
				$('.pass2div').html("비밀번호를 입력하세요.");
			}
			
			
		}); 
		
		//이메일 제어1 - 이메일 중복시 제출 경우
		$('#join').submit(function() {
		if ($('#user_id2').val() == '1') {
				alert('사용 불가능한 이메일입니다.');
				return false;
			}
		});
		
		// 이메일 제어 2
		$('#join').submit(function() {
			if ($('#user_id').val() == '') {
				alert("이메일을 입력하세요.");
				return false;
			}

		});
		
		
		//비밀번호 제어 
		$('#join').submit(function() {
			if ($('#user_pw').val() == '') {
				alert("비밀번호를 입력하세요.");
				return false;
			}

		});
		
		//비밀번호 재확인 제어 
		$('#join').submit(function() {
			if ($('#user_pw1').val() == '') {
				alert("비밀번호를 재확인하세요.");
				return false;
			}

		});
		

		// 이름 제어
		$('#join').submit(function() {
			if ($('#user_name').val() == '') {
				alert("이름을 입력하세요.");
				return false;
			}

		});

		// 휴대전화 제어 - 중복유무 
		$('#join').submit(function() {
			if ($('#user_phone').val() == '') {
				alert("전화번호를 입력하세요.");
				return false;
			}

		});
		
		//휴대전화 제어 
		$('#join').submit(function() {
			if ($('#user_phone1').val() == '1') {
				alert("사용 불가능한 번호입니다.");
				return false;
			}
		});

		//아이디 중복체크
		$('.idCheck').click(function() {
			//alert($("#user_id").val());
			$.ajax({
				url : "/member/idCheck",
				type : "post",
				dataType : "json",
				data : {
					"user_id" : $("#user_id").val()
				},
				success : function(data) {
					//alert(data);
					if (data == 1) {
						$('#user_id2').val(1);
						alert("사용 불가능한 이메일입니다.");
					} else if (data == 0) {
						$('#user_id2').val(0);
						$("#idCheck").attr("value", "Y");
						alert("사용 가능한 이메일입니다.");
					}
				}
			});
		});
	 
	
	
	//전화번호 중복체크
	$('.phoneCheck').click(function() {
			//alert($("#user_id").val());
			$.ajax({
				url : "/member/phoneCheck",
				type : "post",
				dataType : "json",
				data : {
					"user_phone" : $("#user_phone").val()
				},
				success : function(data) {
					//alert(data);
					if (data == 1) {
						$('#user_phone1').val(1);
						alert("사용 불가능한 번호입니다.");
					} else if (data == 0) {
						$('#user_phone1').val(0);
						$("#phoneCheck").attr("value", "Y");
						alert("사용 가능한 번호입니다.");
					}
				}
			}); 
		});

	});
	
	function goPopup(){
	    var pop = window.open("/popup/jusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
	}
	function jusoCallBack(roadFullAddr,roadAddrPart1,addrDetail,roadAddrPart2,engAddr, jibunAddr, zipNo, admCd, rnMgtSn, bdMgtSn
							, detBdNmList, bdNm, bdKdcd, siNm, sggNm, emdNm, liNm, rn, udrtYn, buldMnnm, buldSlno, mtYn, lnbrMnnm, lnbrSlno, emdNo){
		document.form.roadFullAddr.value = roadFullAddr;
	}

	
</script>

					


	<!-- ##### Checkout Area Start ##### -->
	<div class="checkout_area mb-100">
		<div class="container">
			<div class="row justify-content-between">
				<div class="col-12 col-lg-7">
					<div class="checkout_details_area clearfix">
					
						<h1>회원가입</h1> 
						<h2>Join</h2><br><br>
						
						<form name="form" action="/member/insert" id="join" class="totalform" method="post">
							<div class="row">
								<div class="col-12 mb-4">
									<label for="email_address">우리동네(Town) *</label> 
									<input type="hidden" id="confmKey" name="confmKey" value=""  >
									<input type="text" class="form-control" id="roadFullAddr" name="roadFullAddr"  value="" placeholder="주소검색을 눌러 우리동네를 설정하세요." readonly="readonly"><br>
									<button type="button" class="btn alazea-btn w-80" style="width:50pt;height:30pt;" onclick="goPopup();">주소검색</button> <br>
								</div>
								
							
							
							
								<div class="col-12 mb-4"><br>
									<label for="email_address">이메일(Email Address) *</label> 
									<input type="text" name="user_id" class="form-control" id="user_id" value="" placeholder=" @를 포함해서 입력하세요.">
									<input type="hidden" name="user_id2" id="user_id2"><br>
									<button type="button" class="idCheck btn alazea-btn w-80" id="idCheck" value="N" style="width:50pt;height:30pt;">이메일 확인</button>
									<input type="hidden" name="user_id2" id="user_id2" value="0">
								</div>
								
								
								
								
								<div class="col-12 mb-4">
								<br><br>
									<label for="email_address">비밀번호(Password) *</label> 
									<input type="password" name="user_pw" class="password form-control" id="user_pw" value="" placeholder="비밀번호를 입력하세요.">
									<div class="passdiv"></div>
								</div>
								<div class="col-12 mb-4">
									<label for="email_address">비밀번호 재확인(Reconfirm Password) *</label> 
									<input type="password" name="user_pw1" class="password2 form-control" id="user_pw1" value="" placeholder="비밀번호를 재입력하세요."><br>
									<div class="pass2div"></div>
								</div>
								<div class="col-12 mb-4">
									<label for="phone_number">이름(Name) *</label> 
									<input type="text" name="user_name" class="form-control" id="user_name" value="" placeholder="이름을 입력하세요.">
								</div>
								<div class="col-12 mb-4">
									<label for="phone_number">전화번호(Phone) *</label> 
									<input type="text" name="user_phone" class="form-control" id="user_phone" value="" placeholder=" (-)제외후 입력하세요."><br>
									<input type="hidden" name="user_phone1" id="user_phone1">
									<button type="button" class="phoneCheck btn alazea-btn w-80" id="phoneCheck" value="N" style="width:40pt;height:30pt;">확인</button>
									<input type="hidden" name="user_phone1" id="user_phone1" value="0">
								<br><br><br><br>
								</div>
								
								
								
								<button class="btn alazea-btn w-120" style="width:360pt;height:40pt;margin:auto;">회원가입</button>
								
								</div>
								
                        
						</form>
						
					</div>
				</div>
			</div>
		</div>
	</div>

<%@ include file="../include/footer.jsp" %>





	