function GetAjax(url,process) {
	$.ajax({
				type : "Get",
				cache : false,
				url : url,
				success : function(data) {
					process(data);
				}
			});
}

function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构�?�一个含有目标参数的正则表达式对�?
    var r = window.location.search.substr(1).match(reg);  //匹配目标参数
    if (r != null) return unescape(r[2]); return null; //返回参数�?
}