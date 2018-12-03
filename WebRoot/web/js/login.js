//实现整个注册页面的表单验证

//JSON数据类型定义
var checkFlag={	
	"checkNickname":false ,	
	"checkPassword":false 
};

		//昵称验证
		$(function(){
			$("#txtNickName").blur(function(){
				var nickname=$("#txtNickName").val();
				
				//1.非空判断  email.info
				if(nickname==""){
					$("#name\\.info").html("昵称不能为空");
					checkFlag.checkNickname=false;
			        return;
				}else{
					$("#name\\.info").html("");  //清空 
				}
				
				//2.正则表达式验证  例:zhangsan-001@gmail.com 
				var reg=new RegExp("[A-Za-z0-9_\-\u4e00-\u9fa5]{4-20}+");
				if(!nickname.match(reg)){
					$("#name\\.info").html("昵称格式不对");
					checkFlag.checkNickname=false;
					return ;
				}
				
				//设置标记位
				checkFlag.checkNickname=true;
				
				//3.服务器验证:AJAX验证
				$.post(
				   "http://localhost:8080/tjs/username.do" ,
				   "nickname="+nickname ,
					function(data){
					  if(data==1){
						  $("#name\\.info").html("用户名可以使用");
						  //设置标记位
						  checkFlag.checkNickname=true;
					  }else{
						  $("#name\\.info").html("用户名被占用"); 
						  checkFlag.checkNickname=false;
						  
					  }
				    });
			});
		});
	
		//验证密码
		$(function(){
			$("#txtPassword").blur(function(){
				var password=$("#txtPassword").val();
				//1.非空验证
				if(password==""){
					$("#password\\.info").html("密码不能为空!");
					checkFlag.checkPassword=false;
					return;
				}else{
					$("#password\\.info").html("");
					
				}
				
				//2.正则表达式验证  例:zhangsan-001@gmail.com 
				var reg=new RegExp("^[0-9a-zA-Z]{6,20}$");
				if(!password.match(reg)){
					$("#password\\.info").html("密码格式不对");
					checkFlag.checkPassword=false;
					return ;
				}
				
				
				
			});
		});
		

		
	//<form>表单添加绑定事件:
	$("#form").submit(function(){
		//每个表单验证都通过,才允许提交数据给服务器
		if(checkFlag.checkNickname&&checkFlag.checkPassword){
			return true ;   //允许表单提交
		}else{
			return false ;  //不允许表单提交
		}
	});
	

