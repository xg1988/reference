/**
 * 
 */

/*$(window).load(function() {
	const url = "http://jobsjo88.cafe24.com/svc/api/templete/coupang?cmd=goldbox";
	const data = "";
	callAjax(url, data, (data)=>{
		console.log(data)
	});
});*/

$(document).ready(function(){
	const url = "http://jobsjo88.cafe24.com/svc/api/templete/coupang?cmd=goldbox";
	const data = "";
	callAjax(url, data, (data)=>{
		console.log(data)
	});	
});

function callAjax (url, data, callback) {
	$.ajax(
		{ url: url
		, type: "POST"
		, cache: false
		, dataType: "jsonp"
		, data: data
		, success: function(json) { 
			console.log("[json]: "+ json);
			callback(json);
		}, error: function(request, status, error) { 
			alert("[에러발생]: "+ error);
		} });
}