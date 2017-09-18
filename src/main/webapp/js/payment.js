/**
 * 
 */
$(function(){
	
	$(document).ready(function(){
		paymentView();
		console.log($("#contextPath").val());
	});
	
	//収入登録（インサート）
	$('#insertIncome').on('click',function(){
		var data = {
				"income" :$('#income').val(),
				"id" :$('#id').val()
		};
		console.log(JSON.stringify(data));
		$.ajax({
			url:$('#contextPath').val()+'/ajax/insertIncome',
			type:'GET',
			data: {jsonUser:JSON.stringify(data)},
			contentType: 'application/JSON',
		    success: function(data){
		    	console.log("成功");
		   	}
		});
	});
	
	//支出登録
	$('#insertPayment').on('click',function(){
		var data = {
				"userId" :$('#id').val(),
				"categoryId" :$('#selectBox').val(),
				"payment" :$('#payment').val(),
				"date" :$('#datepicker').val() //TODO:date型で管理できるように
		};
		console.log(JSON.stringify(data));
		$.ajax({
			url:$('#contextPath').val()+'/ajax/insertPayment',
			type:'GET',
			data: {jsonPayment:JSON.stringify(data)},
			contentType: 'application/JSON',
		    success: function(data){
		    	console.log("成功");
		   	}
		});
	});
	
	//カレンダーの表示
	$("#datepicker").datepicker();
	$("#datepicker").datepicker("option", "showOn", 'both');
    $("#datepicker").datepicker("option", "buttonImageOnly", true);
    $("#datepicker").datepicker("option", "buttonImage", $("#contextPath").val() + '/css/calendar.png');
    
    
    //支出一覧を表示
    function paymentView(json){
		$.ajax({
			url:$('#contextPath').val() + '/ajax/paymentFindAll?userId=' + $('#id').val(),
			type:'GET',
			dataType:'json',
			success: function(json){
 				var Html = "";
				$.each(json, function(i){
					var payments = json[i];
					console.log(payments);
					Html += "<tbody>"
	 				Html += "<tr>"
	 				Html += "<td>" + payments.date + "</td>"
	 				Html += "<td>" + payments.categoryId + "</td>"
	 				Html += "<td>" + payments.payment + "</td>"
	 				Html += "</tr>"
	 					Html += "</tbody>"
					$('#paymentTable').append(Html);
				});
			}
		});
	}
});