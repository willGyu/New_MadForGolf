<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

    
	<h2>인증 완료</h2>
	<h3>엑세스 토큰 : ${responseToken.access_token}</h3>
	<h3>사용자 번호 : ${responseToken.user_seq_no}</h3>
	<h3>token_type : ${responseToken.token_type}</h3>
	<h3>expires_in : ${responseToken.expires_in}</h3>
	<h3>refresh_token : ${responseToken.refresh_token}</h3>
	<h3>scope : ${responseToken.scope}</h3>
	${responseToken}
	
	
<%@ include file="../include/footer.jsp" %>