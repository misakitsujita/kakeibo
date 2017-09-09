<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<jsp:useBean id="date" class="java.util.Date" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/headerAndFooter.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>家計簿</title>
</head>
<body>
	<div id="header" align="left">
		<span>こんにちは</span>
		<c:out value="${userList[0].name}"/>さん<br>
		現在は<fmt:formatDate value="${date}" pattern="MM月dd日(E) HH時mm分" />です
	</div>
</html>