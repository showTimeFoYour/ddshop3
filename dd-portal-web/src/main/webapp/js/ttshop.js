var TT_SHOP = {
	checkLogin : function(){
		var _ticket = $.cookie("tt_token");
		if(!_ticket){
			return ;
		}
		$.ajax({
			url : "http://localhost:8084/ttshop/user/token/" + _ticket,
			dataType : "jsonp",
			type : "GET",
			success : function(result){
				if(result.success){
					var username = result.data.username;
					var html = username + "，欢迎来到天天商城！<a href=\"http:/localhost:8084/user/logout\" class=\"link-logout\">[退出]</a>";
					$("#loginbar").html(html);
				}
			}
		});
	}
}

$(function(){
	// 查看是否已经登录，如果已经登录查询登录信息
	TT_SHOP.checkLogin();
});