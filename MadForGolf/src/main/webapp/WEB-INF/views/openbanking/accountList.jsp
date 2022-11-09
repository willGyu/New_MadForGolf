<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
   <!-- ##### Breadcrumb Area Start ##### -->
    <div class="breadcrumb-area">
        <!-- Top Breadcrumb Area -->
        <div class="top-breadcrumb-area bg-img bg-overlay d-flex align-items-center justify-content-center" style="background-image: url(${pageContext.request.contextPath }/resources/img/bg-img/24.jpg);">
            <h2>Account List</h2>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-12">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="#"><i class="fa fa-home"></i> Home</a></li>
                            <li class="breadcrumb-item"><a href="#">My Page</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Account List</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>
    <!-- ##### Breadcrumb Area End ##### -->
    
    
    <div class="container">
    
	<table>
			<tr>
				<th>계좌번호</th><th>은행명</th><th>예금주명</th>
			</tr>
			<%-- accountList 객체에 저장되어 있는 계좌 목록(res_list) 가져와서 반복하여 복수개 계좌 접근 --%>
			<c:forEach var="account" items="${accountList.res_list }">
				<tr>
					<td>${account.account_num_masked }</td>
					<td>${account.bank_name }</td>
					<td>${account.account_num }</td>
					<td>${account.account_holder_name }</td>
				</tr>
			</c:forEach>
			
		</table>
			<h3>이름 : ${accountList.user_name }</h3>
	
	</div>
<%@ include file="../include/footer.jsp" %>