package filter;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**检查用户是否登录的 过滤器 */
public class LoginFilter implements Filter{

	
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		//强制类型转换
		HttpServletRequest request=(HttpServletRequest) req;
		HttpServletResponse response=(HttpServletResponse) res;
		//获取session对象
		HttpSession session = request.getSession();
		//session对象获取用户数据
		Object user= session.getAttribute("Login");
		String urls = request.getRequestURI();
		if(urls.endsWith("changepassword.html")||urls.endsWith("personalsystem.html")||urls.endsWith("emailaut.html")||urls.endsWith("about.html")
				||urls.endsWith("application.html")||urls.endsWith("contact.html")||urls.endsWith("game.html")||urls.endsWith("honor.html")||urls.endsWith("jidi.html")||urls.endsWith("message.html")
			||urls.endsWith("message.html")||urls.endsWith("news.html")||urls.endsWith("product.html")||urls.endsWith("productcate01.html")||urls.endsWith("productcate02.html")||urls.endsWith("productcateTest.html")
			||urls.endsWith("productcateshow.html")
		)
			
		{
			if(user==null&&user!="t"){  
				//1.用户未登录,重定向到登录页面
				response.sendRedirect("http://localhost:8080/bichen/login.html");
			}else{
				//2.用户登录,继续执行后续的操作
				chain.doFilter(request,response);
			}
		}
		else{
			chain.doFilter(req, res);
			
		}
	}	

	


	public void destroy() {
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("登陆拦截器已经启动");
	}

}
