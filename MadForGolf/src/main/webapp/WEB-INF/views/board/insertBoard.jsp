<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>insertBoard.jsp</h1>
	
	<form action="/board/insertBoard" method="post">
	
		<input type="hidden" name="user_id" value="다은쓰">
	
		<div class="">
		
			<div class="">
				<label for="">말머리</label> 
				<select name="board_category" id="">
    				<option value="질문">질문</option>
   					<option value="신고">신고</option>
    				<option value="친목">친목</option>
    				<option value="정보">정보</option>
				</select>
			</div>
			
			<div class="">
				<label for="">제목</label> 
				<input type="text" name="title" class="" id="" placeholder="제목을 작성하세요">
			</div>
			
			
			<div class="">
				<label for="">작성자</label> 
				
				<span name="user_name" class="" id="">세션값에서 이름 받아오기</span>
			</div>
			
			<div class="">
				<label for="">내용</label> 
				<textarea name="content" class=""  rows="10" cols="40" id="" placeholder="내용을 작성하세요"></textarea>
			</div>
		
		</div>

		<div class="">
			<button type="submit" class="btn ">글쓰기</button>
		</div>
	</form>
	
</body>
</html>