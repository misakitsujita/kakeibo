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

		//棒グラフ
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
		          //凡例
		          label: "数量",
		          //背景色
		          backgroundColor: "rgba(75,192,192,0.4)",
		          //枠線の色
		          borderColor: "rgba(75,192,192,1)",
		          //グラフのデータ
		          data: sum
		      }]
		  }
		});
	});
	
	
	</script>

<canvas id="canvas"></canvas>

</body>
</html>