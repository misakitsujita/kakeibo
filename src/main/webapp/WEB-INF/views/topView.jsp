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
	
	<input type="hidden" value="${pageContext.request.contextPath}" id="contextPath">
	
	<div class="formTable">
	
		<div id="incomeForm" align="left">
			<p>収入</p>
			<span id="incomeValidation"></span>
			<input type="text" id="income"> 円 / 月 <input type="hidden" value="${userList[0].id}" id="id">
			<input type="submit" value="登録" id="insertIncome" class="btn btn-default btn-sm">
		</div>
		
		<div></div>
		
		<div id="paymentFrom">
			<p>支出</p>
			<form>
				<select id="selectBox" class="form-control selectpicker" style="width:150px;">
					<option value="1">飲み代</option>
					<option value="2">食費</option>
					<option value="3">生活費</option>
					<option value="4">交通費</option>
				</select>
			</form>
			<nobr><input type="text" id="payment"> 円 / 日付 <input type="text" id="datepicker"> </nobr>
			<input type="submit" value="登録" id="insertPayment" class="btn btn-default btn-sm">
		</div>
	
	</div>
	
	<table id="paymentTable" class="table table-hover">
		<thead id="head">
			<tr>
				<th>日付</th>
				<th>カテゴリー</th>
				<th>値段</th>
			</tr>
		</thead>
	</table>
	
	<a href="${pageContext.request.contextPath}/top/viewGraph?userId=${userList[0].id}">グラフを見る</a>	
	
</div>
	<jsp:include page="userFooter.jsp" />

</html>