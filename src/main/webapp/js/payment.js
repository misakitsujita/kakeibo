/**
 * 
 */
$(function(){
	
	$(document).ready(function(){
		paymentView();
		console.log($("#contextPath").val());
	});
	
	//テキストボックス入力制限：半角数値のみ
	$("[with]").off(".inputcontrol")
    $("[with='numeric']")
        .off(".inputcontrol.numeric")
        .on("keyup.inputcontrol.numeric", function(){
            $(this).val($(this).val().replace(/[^0-9]/g,""));
    })
    //日付の手入力不可
    const datepickerText = document.getElementById("datepicker");
	datepickerText.readOnly = true;
	
	//収入登録（インサート）
	$('#insertIncome').on('click',function(){
	    //値の取得・jsonに変換
		const incomeData = {
				"income" :$('#income').val(),
				"id" :$('#userId').val()
		};
		console.log(JSON.stringify(incomeData));
		$.ajax({
			url:$('#contextPath').val()+'/ajax/insertIncome',
			type:'GET',
			data: {jsonUser:JSON.stringify(incomeData)},
			contentType: 'application/JSON'
		})
		.then(
			function(incomeData){ //通信成功時
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
	    //値の取得・jsonに変換
		const paymentData = {
				"userId" :$('#userId').val(),
				"categoryId" :$('#selectBox').val(),
				"payment" :$('#payment').val(),
				"date" :$('#datepicker').val()
		};
		console.log(JSON.stringify(paymentData));
		$.ajax({
			url:$('#contextPath').val()+'/ajax/insertPayment',
			type:'GET',
			data: {jsonPayment:JSON.stringify(paymentData)},
			contentType: 'application/JSON'
		})
		.then(
			function(paymentData){ //通信成功時
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
			url:$('#contextPath').val() + '/ajax/paymentFindAll?userId=' + $('#userId').val(),
			type:'GET',
			dataType:'json',
			success: function(json){
				for(let i in json){
					let id = json[i].id;
					console.log(id);
					let date = json[i].date;
					console.log(date);
					let category = json[i].category;
					console.log(category);
					let payment = json[i].payment;
					console.log(payment);
					
					let Html = "";
						Html += "<tbody class=\"tbody\" id=" + id + ">"
		 				Html += "<tr>"
		 				Html += "<td>" + date + "</td>"
		 				Html += "<td>" + category + "</td>"
		 				Html += "<td>" + payment + "</td>"
		 				Html += "<td><input type=\"submit\" value=\"削除\" class=\"delete btn btn-default btn-sm\"></td>"
		 				Html += "</tr>"
		 				Html += "</tbody>"
						$('#paymentTable').append(Html);
				}
			}
		});
	}
    
    //支出削除
    	$(document).on('click', '.delete', function(){
    		//削除ボタン行のid取得
    		const paymentId = $(this).parent().parent().parent().attr('id');
    		console.log(paymentId);
    		$.ajax({
    			url:$('#contextPath').val()+'/ajax/deletePayment?id=' + paymentId,
    			type:'GET',
    		})
    		.then(
    			function(paymentData){ //通信成功時
    		    //一覧再描画
    		    removeTbody();
    		    paymentView();
    		    console.log("成功");
    		   	},
    		   	function(){ //通信失敗時
    				alert("削除に失敗しました。");
    		});
    });

});