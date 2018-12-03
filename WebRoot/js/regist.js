
var	CheckedEmail=false;
var CheckedPassWord=false;
var CheckedPassWordDel=false;

$(function (){
	console.log("sssssssss");
	$("#submit").click(function(){
		console.log("-------------开始注册-------------");
		console.log(CheckedEmail+"     "+CheckedPassWord+"          "+CheckedPassWordDel);
		if(CheckedEmail==CheckedPassWord==CheckedPassWordDel){
			var email=$("#email").val();
			var password=$("#password").val();
			$.post(
			"register.dou",
			{"email":email,"password":password},
			 function(data){ //0/1
				  console.log(data);
				  if(data==1){ 
					  alert("注册成功");
					  location="login.html";
				  }else{ 
					  alert("注册失败");
					  location="register.html";
				  }
			  }
			);
			return true;
		}else{
			return false;
		}
	});
	
	 $('.tip').show();
	
	//邮箱验证
	$("#email").blur(function (){
		//1.获取用户输入的Email
		var email=$("#email").val();
		//2.非空验证
		if(email==""){ 
			$("#emailP").html("Email不允许为空");
			CheckedEmail=false ;
			return ;
		}else{
			$("#emailP").html(""); //清空上面红色提示
			CheckedEmail=true ;
		}
		//3.正则表达式验证 例:zhangsan-001@gmail.com 
		var reg=new RegExp("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$");
		if(!email.match(reg)){
			$(".emailP").html("Email格式不对");
			CheckedEmail=false;
			return ;
		}
		//客户端验证 通过
		//4.服务器验证:AJAX验证
		$.post(
		  "checkedEmail.dou" ,
		  "email="+email ,
		  function(data){ //true/false
			  console.log(data);
			  if(data==1){ 
				  $("#emailP").html("Email可以使用");
				  CheckedEmail=true;
			  }else{ 
				  $("#emailP").html("Email被占用");
				  CheckedEmail=false; 
			  }
		  }
		);
		
	});
	
	
	
	 
	
	$("#password").blur(function (){
		console.log("-------------开始密码验证-------------");
		var passwordde=$("#passwordde").val();
		 var password=$("#password").val();
		console.log(password);
		//2.非空验证
		if(password==""){ 
			$("#passwordP").html("密码不允许为空");
			CheckedPassWord=false ;
			return ;
		}else{
			$("#passwordP").html(""); //清空上面红色提示
			CheckedPassWord=true ;
		}
		//密码强度正则，最少6位，包括至少1个大写字母，1个小写字母，1个数字
		 var reg=new RegExp("^.*(?=.{6,20})(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^&*?\\. ]).*$");
		if(!password.match(reg)){
			$("#passwordP").html("密码格式不对");
			CheckedPassWord=false;
			return ;
		}else{
			$("#passwordP").html("密码格式正确"); 
			CheckedPassWord=true ;
		}
		
	});
	
	$("#passwordde").blur(function (){
		console.log("-------------开始重复密码验证-------------");
		var passwordde=$("#passwordde").val();
		 var password=$("#password").val();
		console.log(passwordde);
		//2.非空验证
		if(passwordde==""){ 
			$("#passworddeP").html("重复密码不允许为空");
			CheckedEmail=false ;
			return ;
		}else{
			$("#passworddeP").html(""); //清空上面红色提示
			CheckedEmail=true ;
		}
		if(password==passwordde){
			$("#passworddeP").html("重复密码正确");
			CheckedPassWordDel=true;
		}else{
			$("#passworddeP").html("重复密码错误");
			CheckedPassWordDel=false;
		}
		
	});
	
	
});



