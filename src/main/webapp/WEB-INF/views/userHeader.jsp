<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:useBean id="date" class="java.util.Date" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/headerAndFooter.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="header" align="left">
		<span>こんにちは</span>
		<%--今回はuserListを配列で取ってきているので0番目を指定してください --%>
		<c:out value="${userList[0].name}"/>さん<br>
		現在は<fmt:formatDate value="${date}" pattern="MM月dd日(E) HH時mm分" />です
	</div>
</body>
</html>