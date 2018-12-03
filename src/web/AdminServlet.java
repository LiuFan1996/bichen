package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.faces.application.Application;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import bean.Admin;

import dao.AdminDao;
import dao.AdminDaoImpl;
@Controller
public class AdminServlet extends HttpServlet{

	/**
	 *管理员管理Servlet 
	 */
	
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setHeader("Access-Control-Allow-Origin", "*");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		// 获取请求地址 
		String uri = request.getRequestURI();
		uri = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		PrintWriter out = response.getWriter();
		if(uri.equals("/admin")){
			Object object = request.getSession().getAttribute("Admin");
			if(object==null||object!="t"){
				response.sendRedirect("web/admin.html");
			}else{
				response.sendRedirect("web/article/insert.html");
			}
		}else if(uri.equals("/login")){
			String username = request.getParameter("username");
			String password =request.getParameter("password");
			AdminDao dao=new AdminDaoImpl();
			Admin login = dao.login(username);
			if(login!=null){
				if(password.equals(login.getPassword())){
					request.getSession().setAttribute("Admin", "t");
					out.print(1);
				}else{
					out.print(0);
				}
			}else{
				out.print(0);
			}
		}else if(uri.equals("/quit")){
			request.getSession().setAttribute("Admin", "f");
			out.print(1);
		}
	}

}
