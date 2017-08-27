<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>支出入力画面</h1>
	<form:form modelAttribute="inputPaymentForm" action="${pageContent.request.contextPath}/inputPaymanet/payment">
	支出：<form:input path="payment"/><br>
		カテゴリー：<form:select path="categoryId" items="${categoryList}" itemValue="category"/><br>
		<input type="submit" value="送信">
	</form:form>
</body>
</html>