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

import bean.RecruitmentInfo;

import dao.RecruitmentInfoDao;
import dao.RecruitmentInfoDaoImpl;



public class RecruitmentInfoAllServlet extends HttpServlet{

	/**
	 *所有招聘信息请求处理
	 *请求以.don结尾
	 */
	
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		String uri=request.getRequestURI();
    	uri=uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
    	System.out.println("请求地址是: "+uri);
    	
    	request.setCharacterEncoding("utf8");
		//设置编码
		response.setCharacterEncoding("utf8");
		
		//获取输出流,输入写给浏览器
		PrintWriter out = response.getWriter();
    	
    	
    	RecruitmentInfoDao rinfo=new RecruitmentInfoDaoImpl();
    	
    	//查询所有的招聘信息			
    	if(uri.equals("/selectall")){
    		List<RecruitmentInfo> list = rinfo.selecteALLRecruitmentInfo();
    		JSONArray jsonArr = JSONArray.fromObject(list);
    		out.println(jsonArr); 
    	}
    	//删除招聘信息			
    	else if(uri.equals("/delete")){
    		long id = Long.parseLong(request.getParameter("Id"));
    		RecruitmentInfo r=new RecruitmentInfo();
    		r.setId(id);
    		int result = rinfo.deleteRecruitmentInfo(r);
    		if(result==1){
    	    	out.println("1");
    	    }else{
    	    	out.println("0");
    	    }
    	}
    	//根据id查询招聘信息			
    	else if(uri.equals("/selectid")){
    		long id = Long.parseLong(request.getParameter("id"));
    		RecruitmentInfo r=new RecruitmentInfo();
    		r.setId(id);
    		RecruitmentInfo rf = rinfo.selecteIdRecruitmentInfo(r);
    		JSONObject jsonrf=JSONObject.fromObject(rf);
    		out.println(jsonrf);
    	}
		/*insert.don?company=""&address=""
			&workExperience=""&education=""
			&salary=""&isFinancing&peopleNumber=""
			&companyProfile=""&jobRequirements=""*/
    	//插入招聘信息
    	else if(uri.equals("/insert")){
    		//获取参数
    		String company = request.getParameter("company");
    		System.out.println(company);
    		String address = request.getParameter("address");
    		String workExperience = request.getParameter("workExperience");
    		String education = request.getParameter("education");
    		String salary = request.getParameter("salary");
    		boolean isFinancing = Boolean.parseBoolean(request.getParameter("isFinancing"));
    		int peopleNumber = Integer.parseInt(request.getParameter("peopleNumber"));
    		System.out.println(peopleNumber);
    		String companyProfile = request.getParameter("companyProfile");
    		String jobRequirements = request.getParameter("jobRequirements");
    		//参数打包
    		RecruitmentInfo r=new RecruitmentInfo(company, address, workExperience, education, salary,new Date(),isFinancing,peopleNumber,"马云",companyProfile);
    	    r.setJobRequirements(jobRequirements);
    	    //操作数据库
    	    int result = rinfo.saveRecruitmentInfo(r);
    	    System.out.println(result);
    	    if(result==1){
    	    	out.println("1");
    	    }else{
    	    	out.println("0");
    	    }
    	}
    	/*update.don?company=""&address=""&workExperience=""&
        education=""&salary=""&isFinancing&peopleNumber=""&
        companyProfile=""&jobRequirements=""*/
		//更新新招聘信息			
    	else if(uri.equals("/update")){
    		//获取参数
    		int  Id = Integer.parseInt(request.getParameter("Id"));
    		String company = request.getParameter("company");
    		String address = request.getParameter("address");
    		String workExperience = request.getParameter("workExperience");
    		String education = request.getParameter("education");
    		String salary = request.getParameter("salary");
    		boolean isFinancing = Boolean.parseBoolean(request.getParameter("isFinancing"));
    		int peopleNumber = Integer.parseInt(request.getParameter("peopleNumber"));
    		String companyProfile = request.getParameter("companyProfile");
    		String jobRequirements = request.getParameter("jobRequirements");
    		//参数打包
    		RecruitmentInfo r=new RecruitmentInfo(company, address, workExperience, education, salary,new Date(),isFinancing,peopleNumber,"11234",companyProfile);
    		r.setId(Id);
    		System.out.println(r);
    	    r.setJobRequirements(jobRequirements);
    	    //操作数据库
    	    int result = rinfo.updateRecruitmentInfo(r);
    	    if(result==1){
    	    	out.println("1");
    	    }else{
    	    	out.println("0");
    	    }
    	}



	}
}
