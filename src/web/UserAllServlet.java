package web;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.json.JSONArray;
import bean.User;
import dao.UserDao;
import dao.UserDaoImpl;

public class UserAllServlet extends HttpServlet{

	
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "Authentication");
		String uri = request.getRequestURI();
		 uri = uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		 //设置编码
		 response.setCharacterEncoding("utf8");
		 response.setContentType("utf8");
		 System.out.println("请求地址："+uri);
		 PrintWriter out = response.getWriter();
		 HttpSession session = request.getSession();
		 //登录
		 if(uri.equals("/login")){
			//获取用户提交的用户名和密码
		    	String email=request.getParameter("email"); 
		    	String password=request.getParameter("password");
		    	System.out.println("email="+email+"password="+password);
		    	//操作数据库
		    	UserDao dao=new UserDaoImpl();
		    	User u=dao.selectEmailUser(email);
		    	System.out.println(u);
		    	if(u!=null){ //用户名正确
		    		if(u.getPassword().equals(password)){ //验证密码
		    			//登录成功,页面跳转到主页面 
		    			session.setAttribute("Login","t");
		    			session.setAttribute("Id", u.getId());
		    			out.println(1);
		    			//response.sendRedirect("index.jsp");
		    			//return ;
		    		}
		    	}else{
		    		out.println(0);
		    	}
		    	//页面跳转到登录页面(重定向)
		    	
		    	//response.sendRedirect("login.html");
		 		}
		//注册
		 else if(uri.equals("/register")){
				//获取用户提交的用户名和密码
			 		String email=request.getParameter("email");
			    	//String username=request.getParameter("username"); 
			    	String password=request.getParameter("password");
			    	//操作数据库
			    	UserDao dao=new UserDaoImpl();
			    	User user = new User("bbb",email,"bbb","bbb","null","bbb",password,333,'t',"bbb",new Date(),"bbb");
			    	int result=dao.saveUser(user);
			    	if(result==1){
			    		//数据插入数据库成功,跳转到登录页面
			    		out.println(1);
			    		//response.sendRedirect("login.html"); //重定向
			    		
			    	}else{
			    		//数据插入数据库失败,页面跳转到注册页面
			    		out.println(0);
			    		//response.sendRedirect("regist.html"); //重定向
			    	}		    	
			    }
		//查询所有
		 else if(uri.equals("/selectall")){
			 UserDao dao = new UserDaoImpl();
			 List<User> users = dao.selectAllUser();
			 JSONArray json = JSONArray.fromObject(users);
			 out.print(json);;
			 
		 }
		//查询（根据ID）
		 else if(uri.equals("/selectid")){
			 System.out.println(request.getParameter("Id"));
			 int id = Integer.parseInt(request.getParameter("Id"));
			 UserDao dao = new UserDaoImpl();
			 User user = dao.selectIdUser(id);
			 System.out.println(user);
			 JSONArray fromObject = JSONArray.fromObject(user);
			 out.print(fromObject);
				
			 
		 	}
		
		//删除
		 else if(uri.equals("/delete")){
				//获取页面提交的数据
			    	int Id=Integer.parseInt(request.getParameter("Id"));
			    	//访问数据库删除数据
			    	UserDao dao=new UserDaoImpl();
			    	int result=dao.deleteUser(Id);
			    	if(result==1){ //删除成功
			    		out.println(1);
			    	}
			    	else{//删除失败,
			    		out.println(0);
			    	}
					 
				 }
		 
		 else if(uri.equals("/insert")){
			 //获取页面数据
			 String company = request.getParameter("company");
			 String email = request.getParameter("email");
			 String job = request.getParameter("job");
			 String education = request.getParameter("education");
			 String username = request.getParameter("username");
			 String nickname = request.getParameter("nickname");
			 String password = request.getParameter("password");
			 int userintegral=Integer.parseInt(request.getParameter("userIntegral"));
			 char isemailverify = request.getParameter("isEmailVerify").charAt(0);
			 String emailverifycode = request.getParameter("emailVerifyCode");
			 String lastloginip = request.getParameter("lastLoginIp");
			 //封装成user对象
			 User user =new User(company,email,job,education,username,nickname,password,userintegral,isemailverify,emailverifycode,new Date(),lastloginip);
			//操作数据库
			 UserDao dao =new UserDaoImpl();
			 int result = dao.saveUser(user);
			 if(result==1){
				 out.println(1);
			 }
			 else{
				 out.println(0); 
			 } 
		 }
		 else if(uri.equals("/update")){
			 System.out.println(request.getParameter("Id"));
			 int Id = Integer.parseInt(request.getParameter("Id"));
			 String company = request.getParameter("company");
			 String email = request.getParameter("email");
			 String job = request.getParameter("job");
			 String education = request.getParameter("education");
			 String username = request.getParameter("username");
			 String nickname = request.getParameter("nickname");
			 String password = request.getParameter("password");
			 int userintegral=Integer.parseInt(request.getParameter("userIntegral"));
			 char isemailverify = request.getParameter("isEmailVerify").charAt(0);
			 String emailverifycode = request.getParameter("emailVerifyCode");
			 String lastloginip = request.getParameter("lastLoginIp");
			 //封装成user对象
			 User user =new User(Id,company,email,job,education,username,nickname,password,userintegral,isemailverify,emailverifycode,new Date(),lastloginip);
			//操作数据库
			 System.out.println(user);
			 UserDao dao =new UserDaoImpl();
			 int result = dao.updateUser(user);
			 if(result==1){//更新成功
				 out.println(1);
			 }
			 else{//更新失败
				 out.println(0);
			 }
		 }else if(uri.equals("/checkedEmail")){
			 System.out.println("邮箱验证");
			 String email = request.getParameter("email");
			 UserDao dao =new UserDaoImpl();
			 User user = dao.selectEmailUser(email);
			 if(user==null){
				 out.println(1);
			 }else{
				 out.println(0);
			 }
		 }else if(uri.equals("/checkedLogin")){
			 Object object = request.getSession().getAttribute("Login");
			 System.out.println(object);
			 if(object!=null&&object=="t"){
				 out.print(1);
			 }else{
				 out.print(0);
			 }
		 }else if(uri.equals("/GEtId")){
			 Object object = request.getSession().getAttribute("Login");
			 System.out.println(object); 
			 if(object!=null&&object=="t"){
				 out.print(session.getAttribute("Id"));
			 }else{
				 out.print(0);
			 }
		 }
		
	}

}