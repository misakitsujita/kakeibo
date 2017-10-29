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
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.3.0/Chart.bundle.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container" align="center">

	<c:forEach var="list" items="${paymentList}">
		<p class="category" style="display: none">${list.category}</p>
		<p class="sum" style="display: none">${list.sum}</p>
	</c:forEach>
	
	<c:forEach var="paymentAndIncomeList" items="${paymentAndIncomeList}">
		<p class="income" style="display: none">${paymentAndIncomeList.income}</p>
		<p class="payment" style="display: none">${paymentAndIncomeList.sum}</p>
	</c:forEach>

	<script type="text/javascript">
	
	//カテゴリー別グラフ
	$(function() {
    	const category=new Array();
    	const sum=new Array();

		$(".category").each(function (index) {
			category.push($(this).text());
		});
		console.log(category);

		$(".sum").each(function (index) {
			sum.push($(this).text());
		});
		console.log(sum);

		//円グラフ
		let ctx = document.getElementById("canvas");
		let canvas = new Chart(ctx, {
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
		  },
		  options: {                             //◆オプション
	            responsive: true,                  //グラフ自動設定
	            layout: {                             //レイアウト
	                padding: {                          //余白設定
	                    left: 100,
	                    right: 50,
	                    top: 0,
	                    bottom: 0
	                }
	            }
		  }
		});
	});
	
	//収支グラフ
 	$(function() {
    	const income=new Array();
	const payment=new Array();

		$(".income").each(function (index) {
			income.push($(this).text());
		});
		console.log(income);

		$(".payment").each(function (index) {
			payment.push($(this).text());
		});
		console.log(payment);

		//円グラフ
		let ctx = document.getElementById("canvas2");
		let canvas = new Chart(ctx, {
		  //グラフの種類
		  type: 'doughnut',
		  //データの設定
		  data: {
		      //データ項目のラベル
		      labels: ["収入","支出"],
		      //データセット
		      datasets: [{
		          //背景色
		          backgroundColor: [
		        	  "#0000EE",
		              "#EE0000"
		          ],
		          //枠線の色
		          borderColor: "#EEFFFF",
		          //グラフのデータ
		          data: [income,payment]
		      }]
		  },
		  options: {                             //◆オプション
	            responsive: true,                  //グラフ自動設定
	            layout: {                             //レイアウト
	                padding: {                          //余白設定
	                    left: 100,
	                    right: 50,
	                    top: 0,
	                    bottom: 0
	                }
	            }
		  }
		});
	}); 

	//今月が何月か取得
	window.onload = function(){
		document.getElementById("viewMonth").innerHTML = getNow();
	}

 	function getNow() {
 		let now = new Date();
 		let year = now.getFullYear();
 		let mon = now.getMonth()+1;

 		//出力用
 		const month = mon + "月"; 
 		return month;
 	}
	
	</script>
	
	<h4><span id="viewMonth"></span>分のグラフ</h4>

	<div class="graph-container">
		<canvas id="canvas" class="graph"></canvas>
	</div>
	
	<div class="graph-container">
		<canvas id="canvas2" class="graph"></canvas>
	</div>
	
	<div></div>
	
	<a href="${pageContext.request.contextPath}/top/index?userId=${userList[0].id}">戻る</a>

</div>

</body>
</html>