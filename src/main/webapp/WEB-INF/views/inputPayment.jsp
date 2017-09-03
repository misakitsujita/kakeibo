<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container" align="center">
		<jsp:include page="userHeader.jsp">
			<jsp:param value="${userList.name}" name="name" />
		</jsp:include>
		<h1>支出入力画面</h1>
		<form:form modelAttribute="inputPaymentForm"
			action="${pageContext.request.contextPath}/inputPayment/payment">
            <hiddun id="userId" value ="${userList.id}">
			<table>
				<tr>
					<td>支出：</td>
					<td><form:input path="payment" /></td>
				</tr>
				<tr>
					<td>カテゴリー：</td>
					<td><form:select path="categoryId">
							<form:options items="${categoryList}" itemLabel="category"
								itemValue="id" />
						</form:select></td>
				</tr>
			</table>
			<input type="submit" value="送信" class="btn btn-info">
		</form:form>
		<jsp:include page="userFooter.jsp" />
	</div>
</body>
</html>
