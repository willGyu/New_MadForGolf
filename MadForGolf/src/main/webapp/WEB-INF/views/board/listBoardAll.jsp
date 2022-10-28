<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>listBoardAll.jsp</h1>
	
	<table class="table">
		<tbody>
		
			<tr>
				<th>No</th>
				<th>Category</th>
				<th>Title</th>
				<th>Writer</th>
				<th>Date</th>
				<th>Count</th>
			</tr>
	
		<c:forEach var="vo" items="${boardList }">
			<tr>
				<td>${vo.board_num }</td>
				<td>${vo.board_category }</td>
				<td>
					<a href="/board/getBoard?board_num=${vo.board_num}">${vo.title }</a></td>
				<td>세션으로 조인해오기</td>
				<td>
					<fmt:formatDate value="${vo.write_date }" pattern="yy-MM-dd HH:mm"/>
				</td>
				<td>${vo.readcount}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
</body>
</html>