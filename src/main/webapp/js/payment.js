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
	
});