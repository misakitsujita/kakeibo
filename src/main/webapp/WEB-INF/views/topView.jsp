<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
	<jsp:include page="userHeader.jsp">
		<jsp:param value="${userList[0].name}" name="name" />
	</jsp:include>

<div class="container" align="center">
	<h1>家計簿トップ画面</h1>
	
	<div align="left">
	<p>収入</p>
	<input type="text"> 円 / 月 <input type="submit" value="登録" class="btn btn-default btn-sm">
	
	<div></div>
	
	<p>支出</p>
	<form action="">
	<select class="form-control selectpicker" style="width:150px;">
	<option value="飲み代">飲み代</option>
	<option value="食費">食費</option>
	<option value="生活費">生活費</option>
	<option value="交通費">交通費</option>
	</select>
	</form>
	<input type="text"> 円 <input type="submit" value="登録" class="btn btn-default btn-sm">
	</div>
	
	
</div>
	<jsp:include page="userFooter.jsp" />

</html>