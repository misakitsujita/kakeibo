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
			contentType: 'application/JSON'
		})
		.then(
			function(data){ //通信成功時
			alert("収入" + $('#income').val() + "円を登録しました。");
		    //textBoxリセット
		    $('#income').val("");
		    console.log("成功");
			},
			function(){ //通信失敗時
				alert("登録に失敗しました。");
		});
	});
	
	//支出登録
	$('#insertPayment').on('click',function(){
		var data = {
				"userId" :$('#id').val(),
				"categoryId" :$('#selectBox').val(),
				"payment" :$('#payment').val(),
				"date" :$('#datepicker').val()
		};
		console.log(JSON.stringify(data));
		$.ajax({
			url:$('#contextPath').val()+'/ajax/insertPayment',
			type:'GET',
			data: {jsonPayment:JSON.stringify(data)},
			contentType: 'application/JSON'
		})
		.then(
			function(data){ //通信成功時
		    //textBoxリセット
		    $('#payment').val("");
		    $('#datepicker').val("");
		    //一覧再描画
		    removeTbody();
		    paymentView();
		    console.log("成功");
		   	},
		   	function(){ //通信失敗時
				alert("登録に失敗しました。");
		});
	});
	
	//カレンダーの表示
	$("#datepicker").datepicker();
	$("#datepicker").datepicker("option", "showOn", 'both');
	$("#datepicker").datepicker("option", "dateFormat", 'yy-mm-dd');
    $("#datepicker").datepicker("option", "buttonImageOnly", true);
    $("#datepicker").datepicker("option", "buttonImage", $("#contextPath").val() + '/css/calendar.png');
    
    //支出一覧の再描画用
    function removeTbody(){
    	$(".tbody").remove();
    }
    
    //支出一覧を表示
    function paymentView(){
    	//removeTbody();
		$.ajax({
			url:$('#contextPath').val() + '/ajax/paymentFindAll?userId=' + $('#id').val(),
			type:'GET',
			dataType:'json',
			success: function(json){
				for(var i in json){
					let date = json[i].date;
					//console.log(date);
					let category = json[i].category;
					//console.log(category);
					let payment = json[i].payment;
					//console.log(payment);
					
					let Html = "";
						Html += "<tbody class=\"tbody\">"
		 				Html += "<tr>"
		 				Html += "<td>" + date + "</td>"
		 				Html += "<td>" + category + "</td>"
		 				Html += "<td>" + payment + "</td>"
		 				Html += "</tr>"
		 				Html += "</tbody>"
						$('#paymentTable').append(Html);
				}
			}
		});
	}

});