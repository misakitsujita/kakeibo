/**
 * 
 */
$(function(){
	
	$(document).ready(function(){
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
				//"id" :$('#id').val()
				"categoryId" :$('#selectBox').val(),
				"payment" :$('#payment').val(),
				"date" :$('#datepicker').val()
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
	
});