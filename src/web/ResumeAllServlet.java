package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import bean.Resume;
import dao.ResumeDao;
import dao.ResumeDaoImpl;


public class ResumeAllServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 所有简历请求处理
	 * 请求以.dor结尾
	 */
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		String uri = request.getRequestURI();
		 uri = uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		 //设置编码
		 response.setHeader("Access-Control-Allow-Origin", "*");
		 response.setCharacterEncoding("utf8");
		 response.setContentType("utf8");
		 System.out.println("请求地址："+uri);
		 PrintWriter out = response.getWriter();
		 if(uri.equals("/insert")){
			 	//获取页面提交的数据
			 	String name=request.getParameter("name");
		    	String projectHistory=request.getParameter("projectHistory");
		    	String workHistory=request.getParameter("workHistory");
		    	int salary=Integer.parseInt(request.getParameter("salary"));
		    	String wantJob=request.getParameter("wantJob");
		    	String selfAssessment=request.getParameter("selfAssessment");
		    	String remarks=request.getParameter("remarks");
		    	
		    	//封装成Resume对象
		    	Resume resume = new Resume(name,projectHistory,workHistory,salary,wantJob,selfAssessment,remarks);
		    	//调用dao将数据插入到数据库
		    	ResumeDao dao=new ResumeDaoImpl();
		    	int result=dao.saveResume(resume);
		    	if(result==1){ //插入数据成功
		    		out.println(1);
		    		
		    	}else{//转发
		    		out.println(0);
		    		
		    	}
			 
		 }
		 else if(uri.equals("/selectall")){
			 ResumeDao dao = new ResumeDaoImpl();
			 List<Resume> list = dao.selectAllResume();
			 JSONArray json = JSONArray.fromObject(list);
			 System.out.println(json);
			 out.print(json);
			 
		 }
		 
		 
		 else if(uri.equals("/delete")){
				//获取页面提交的数据
			    	int Id=Integer.parseInt(request.getParameter("Id"));
			    	//访问数据库删除数据
			    	ResumeDao dao=new ResumeDaoImpl();
			    	Resume resume = new Resume();
			    	resume.setId(Id);
			    	int result=dao.deleteResume(resume);
			    	if(result==1){ //删除成功
			    		out.println(1);
			    	}
			    	else{//删除失败
			    		out.println(0);
			    	}
					 
				 }
		 else if(uri.equals("/update")){
			 	int Id=Integer.parseInt(request.getParameter("Id"));
			 	String name=request.getParameter("name");
			 	String projectHistory=request.getParameter("projectHistory");
		    	String workHistory=request.getParameter("workHistory");
		    	int salary=Integer.parseInt(request.getParameter("salary"));
		    	String wantJob=request.getParameter("wantJob");
		    	String selfAssessment=request.getParameter("selfAssessment");
		    	String remarks=request.getParameter("remarks");
		    	
		    	//封装成Resume对象
		    	Resume resume = new Resume(Id,name,projectHistory,workHistory,salary,wantJob,selfAssessment,remarks);
		    	//调用dao将数据插入到数据库
		    	ResumeDao dao=new ResumeDaoImpl();
		    	int result=dao.updateResume(resume);
		    	if(result==1){ //插入数据成功
		    		out.println(1);
		    	}else{//转发
		    		out.println(0);
		    	}
					 
				 }
			 
		 }
	}
