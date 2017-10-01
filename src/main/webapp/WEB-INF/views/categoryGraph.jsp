<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.3.0/Chart.bundle.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</head>
<body>

	<c:forEach var="list" items="${paymentList}">
		<p class="category" style="display: none">${list.category}</p>
		<p class="sum" style="display: none">${list.sum}</p>
	</c:forEach>

	<script type="text/javascript">
	
	$(function() {
    	var category=new Array();
		var sum=new Array();

		$(".category").each(function (index) {
			category.push($(this).text());
		});
		console.log(category);

		$(".sum").each(function (index) {
			sum.push($(this).text());
		});
		console.log(sum);

		//円グラフ
		var ctx = document.getElementById("canvas");
		var canvas = new Chart(ctx, {
		  //グラフの種類
		  type: 'pie',
		  //データの設定
		  data: {
		      //データ項目のラベル
		      labels: category,
		      //データセット
		      datasets: [{
		          //背景色
		          backgroundColor: [
		        	  "#FFCE56",
		              "#36A2EB",
		              "#FF6384",
		              "#33CC99"
		          ],
		          //枠線の色
		          borderColor: "#EEFFFF",
		          //グラフのデータ
		          data: sum
		      }]
		  }
		});
	});
	
	
	</script>

<canvas id="canvas"></canvas>
<div></div>

<a href="${pageContext.request.contextPath}/top/index?userId=${userList[0].id}">戻る</a>

</body>
</html>