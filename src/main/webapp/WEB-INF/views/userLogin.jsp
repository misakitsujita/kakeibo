<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container" align="center">
		<h2>ログイン</h2>
		<form:form modelAttribute="userLoginForm"
			action="${pageContext.request.contextPath}/userLogin/login">
			<table class="table table-hover">
				<tr>
					<td class="center">名前 <form:errors path="name" cssStyle="color:red" element="div"></form:errors></td>
					<td class="center"><form:input path="name" /></td>
				</tr>
				<tr>

					<td class="center">パスワード <form:errors path="password" cssStyle="color:red" element="div"></form:errors></td>
					<td class="center"><form:input path="password" /></td>
				</tr>
			</table>
			<br>
			<input type="submit" value="ログイン" class="btn btn-info">
		</form:form>

		<div class="space"></div>
		
		<form:form modelAttribute="userInsertForm"
			action="${pageContext.request.contextPath}/userLogin/insert">
			<h2>新規登録</h2>
			<table class="table table-hover">
				<tr>
					<td class="center">名前 <form:errors path="name" cssStyle="color:red" element="div"></form:errors></td>
					<td class="center"><form:input path="name" /></td>
				</tr>
				<tr>

					<td class="center">パスワード <form:errors path="password" cssStyle="color:red" element="div"></form:errors></td>
					<td class="center"><form:input path="password" /></td>
				</tr>
			</table>
			<br>
			<input type="submit" value="登録" class="btn btn-info">
			<div>
				<c:out value="${message}"></c:out>
			</div>
		</form:form>
		
		<div class="space"></div>
		
		<a href="${pageContext.request.contextPath}/userLogin/update">パスワードをお忘れの方はこちら</a>
	</div>
</body>
</html>