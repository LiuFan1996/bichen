package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;
import util.JdbcUtils;

import bean.RecruitmentInfo;

public class RecruitmentInfoDaoImpl implements RecruitmentInfoDao{

	

	//根据id删除招聘信息
	public int deleteRecruitmentInfo(RecruitmentInfo recruitmentInfo) {
		String sql="delete from RecruitmentInfo where id=?";
		Connection conn=null;
		try {
			conn = JdbcUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, recruitmentInfo.getId());
			int result = ps.executeUpdate();
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	//保存招聘信息
	public int saveRecruitmentInfo(RecruitmentInfo recruitmentInfo) {
		String sql="insert into RecruitmentInfo(company,address,workExperience,education,salary,isFinancing,peopleNumber,companyUser,companyProfile,jobRequirements,date) values(?,?,?,?,?,?,?,?,?,?,?)";
		Connection conn=null;
		try {
			conn=JdbcUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, recruitmentInfo.getCompany());
			ps.setString(2, recruitmentInfo.getAddress());
			ps.setString(3, recruitmentInfo.getWorkExperience());
			ps.setString(4, recruitmentInfo.getEducation());
			ps.setString(5, recruitmentInfo.getSalary());
			ps.setString(6, recruitmentInfo.isFinancing()+"");
			ps.setInt(7, recruitmentInfo.getPeopleNumber());
			ps.setString(8, recruitmentInfo.getCompanyUser());
			ps.setString(9, recruitmentInfo.getCompanyProfile());
			ps.setString(10, recruitmentInfo.getJobRequirements());
			ps.setDate(11, new java.sql.Date (recruitmentInfo.getDate().getTime()));
			return ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	//查询所有招聘信息
	public List<RecruitmentInfo> selecteALLRecruitmentInfo() {
		String sql="select * from RecruitmentInfo";
		Connection conn=null;
		List<RecruitmentInfo> list=new ArrayList<RecruitmentInfo>();
		try {
			conn=JdbcUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			RecruitmentInfo rinfo=null;
			while(rs.next()){
				rinfo=new RecruitmentInfo();
				rinfo.setId(rs.getLong("id"));
				rinfo.setCompany(rs.getString("company"));
				rinfo.setAddress(rs.getString("address"));
				rinfo.setWorkExperience(rs.getString("workExperience"));
				rinfo.setEducation(rs.getString("education"));
				rinfo.setSalary(rs.getString("salary"));
				rinfo.setFinancing(Boolean.parseBoolean(rs.getString("isFinancing")));
				rinfo.setPeopleNumber(rs.getInt("peopleNumber"));
				rinfo.setCompanyUser(rs.getString("companyUser"));
				rinfo.setCompanyProfile(rs.getString("companyProfile"));
				rinfo.setJobRequirements(rs.getString("jobRequirements"));
				//rinfo.setDate(rs.getDate("date"));
				list.add(rinfo);
			}
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	//根据id查询招聘信息
	public RecruitmentInfo selecteIdRecruitmentInfo(RecruitmentInfo recruitmentInfo) {
		String sql="select * from RecruitmentInfo where id=?";
		Connection conn=null;
		try {
			conn = JdbcUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, recruitmentInfo.getId());
			ResultSet rs = ps.executeQuery();
			RecruitmentInfo rinfo=null;
			while(rs.next()){
				rinfo=new RecruitmentInfo();
				rinfo.setId(rs.getLong("id"));
				rinfo.setCompany(rs.getString("company"));
				rinfo.setAddress(rs.getString("address"));
				rinfo.setWorkExperience(rs.getString("workExperience"));
				rinfo.setEducation(rs.getString("education"));
				rinfo.setSalary(rs.getString("salary"));
				rinfo.setFinancing(Boolean.parseBoolean(rs.getString("isFinancing")));
				rinfo.setPeopleNumber(rs.getInt("peopleNumber"));
				rinfo.setCompanyUser(rs.getString("companyUser"));
				rinfo.setCompanyProfile(rs.getString("companyProfile"));
				rinfo.setJobRequirements(rs.getString("jobRequirements"));
				rinfo.setDate(rs.getDate("date"));
			}
			return rinfo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	//根据id跟新招聘信息/**companyProfile=? jobRequirements=? */
	public int updateRecruitmentInfo(RecruitmentInfo recruitmentInfo) {
		String sql="update RecruitmentInfo set company=?,address=?,workExperience=?,education=?,salary=?,isFinancing=?,peopleNumber=?,companyUser=?,companyProfile=?,jobRequirements=?,date=? where id=?";
		Connection conn=null;
		try {
			conn=JdbcUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, recruitmentInfo.getCompany());
			ps.setString(2, recruitmentInfo.getAddress());
			ps.setString(3, recruitmentInfo.getWorkExperience());
			ps.setString(4, recruitmentInfo.getEducation());
			ps.setString(5, recruitmentInfo.getSalary());
			ps.setString(6, recruitmentInfo.isFinancing()+"");
			ps.setInt(7, recruitmentInfo.getPeopleNumber());
			ps.setString(8, recruitmentInfo.getCompanyUser());
			ps.setString(9, recruitmentInfo.getCompanyProfile());
			ps.setString(10, recruitmentInfo.getJobRequirements());
			ps.setDate(11, new java.sql.Date (recruitmentInfo.getDate().getTime()));
			ps.setLong(12, recruitmentInfo.getId());
			return ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
