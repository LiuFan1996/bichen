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

public class AdminFilter implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chian) throws IOException, ServletException {
			HttpServletResponse response=(HttpServletResponse) res;          
			HttpServletRequest request=(HttpServletRequest) req;
			StringBuffer url = request.getRequestURL();
			String urls=url.toString();
			urls=urls.substring(urls.indexOf("bichen/")+7,urls.length());
			System.out.println(urls);
			if(urls.contains("/insert.html")||urls.contains("/delete.html")||urls.contains("/update.html")){
				Object admin = request.getSession().getAttribute("Admin");
				if(admin!=null||admin=="t"){
					System.out.println("请求参数是："+urls);
					chian.doFilter(req, res);
				}else{
					System.out.println("请求参数是："+urls);
					response.sendRedirect("../admin.html");
				}
			}else{
				chian.doFilter(req, res);
			}
			
			
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("Admin拦截器已经启动");
	}

}
