<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container" align="center">
	<h1>ログイン画面</h1>
	<form:form modelAttribute="userLoginForm" action="${pageContext.request.contextPath}/userLogin/login">
		<table>
				<tr>
					<td>名前 : <form:errors path="name" cssStyle="color:red" element="div"></form:errors></td>
					<td><form:input path="name"/></td>
				</tr>
				<tr>
					<td>パスワード : <form:errors path="name" cssStyle="color:red" element="div"></form:errors></td>
					<td><form:input path="password"/></td>
				</tr>
		</table>
		<br><input type="submit" value="ログイン" class="btn btn-info">
	</form:form>
	</div>
</body>
</html>