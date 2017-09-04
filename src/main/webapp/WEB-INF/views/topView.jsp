<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="userHeader.jsp">
		<%--
		根本的に使い方が違います。
		jspページの埋め込みをしているのでこの形でパラメータを送る必要はありません。
		<jsp:param value="${userList.name}" name="name" />
		 --%>
	</jsp:include>
	<h1>家計簿トップ画面</h1>

	<jsp:include page="userFooter.jsp" />
</body>
</html>