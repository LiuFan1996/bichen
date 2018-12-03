package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import dao.ArticleDao;
import dao.ArticleDaoImpl;
import bean.Article;

public class ArticleAllServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 设置编码方式
		response.setHeader("Access-Control-Allow-Origin", "*");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		// 获取请求地址 
		String uri = request.getRequestURI();
		uri = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		PrintWriter out = response.getWriter();
		System.out.println("请求地址：" + uri);
		ArticleDao dao = new ArticleDaoImpl();
		// 请求地址的分发
		if (uri.equals("/insert")) {// article的添加和修改
			// 获取页面数据
			// 1.访问数据库 获取所有页面数据
			String classify = request.getParameter("classify");
			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String body = request.getParameter("body");
			// 封装成User对象
			Article article = new Article(classify, title, writer, "image/1.jpg", body,
					new Date());
			System.out.println("文章前台信息"+article);
			// 访问数据库将数据插入到数据库
			int result = dao.saveArticle(article);

			if (result == 1) {// 数据插入成功
				out.println(1);
			} else {// 失败
				out.println(0);
			}

		} else if (uri.equals("/delete")) {
			int id = Integer.parseInt(request.getParameter("Id"));
			Article article = new Article();
			article.setId(id);
			System.out.println(article);
			int result = dao.deleteArticle(article);
			if (result == 1) {// 删除成功
				out.println(1);
			} else {// 失败
				out.println(0);
			}
		}
		else if(uri.equals("/update")){
			// 1.访问数据库 获取所有页面数据
			String classify = request.getParameter("classify");
			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String ico = request.getParameter("ico");
			String body = request.getParameter("body");
			// 封装成User对象
			Article article = new Article(classify, title, writer, ico, body,
					new Date());
			
			int id = Integer.parseInt(request.getParameter("Id"));
		
			article.setId(id);
			System.out.println(article);
			// 访问数据库将数据更新到数据库
			int result = dao.updateArticle(article);

			if (result == 1) {// 数据插更新成功
				out.println(1);
			} else {// 失败
				out.println(0);
			}	
		}
		else if(uri.equals("/selectid")){
			int id = Integer.parseInt(request.getParameter("id"));
			Article article = dao.selectIdArticle(id);
			JSONObject json = JSONObject.fromObject(article);
			out.println(json);
		}
		else if(uri.equals("/selectall")){
    		List<Article> list = dao.selectIALLArticle();
    		System.out.println(list);
    		//集合转化成JSONArray
    		JSONArray jsonArray = JSONArray.fromObject(list);
    		
    		out.print(jsonArray);
		}

	}
}
