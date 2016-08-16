$.ajax({
	async : false,
	type : "GET",
	dataType : "jsonp",
	jsonp : "callback",
	url : "http://localhost:8080/ajax/test",
	timeout : 1000,
	success : function(data) {
		$("#myDiv").text("이름은 : " + data.name);
	},
	error : function() {
		
	},
	complete : function() {
		
	}
});