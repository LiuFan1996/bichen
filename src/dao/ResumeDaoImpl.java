package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.JdbcUtils;

import bean.Resume;

public class ResumeDaoImpl implements ResumeDao{

	@Override
	public int deleteResume(Resume resume) {
		String sql="delete from resume where id=?";
		Connection conn=null;
		try {
			conn= JdbcUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, resume.getId());
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int saveResume(Resume resume) {
		String sql="insert into resume(projecthistory,workhistory,salary,wantjob,selfassessment,remarks,name) values(?,?,?,?,?,?,?)";
		Connection conn=null;
		try {
			conn=JdbcUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, resume.getProjectHistory());
			ps.setString(2, resume.getWorkHistory());
			ps.setInt(3, resume.getSalary());
			ps.setString(4,resume.getWantJob());
			ps.setString(5,resume.getSelfAssessment());
			ps.setString(6,resume.getRemarks());
			ps.setString(7,resume.getName());
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.close(conn);
		}
		return 0;
	}

	@Override
	public List<Resume> selectAllResume() {
		List<Resume> list=new ArrayList<Resume>();
		String sql="select * from resume";
		Connection conn=null;
		try {
			conn=JdbcUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			Resume resume=null;
			while(rs.next()){
				resume=new Resume();
				resume.setId(rs.getInt("id"));
				resume.setProjectHistory(rs.getString("projecthistory"));
				resume.setWorkHistory(rs.getString("workHistory"));
				resume.setSalary(rs.getInt("salary"));
				resume.setWantJob(rs.getString("wantJob"));
				resume.setSelfAssessment(rs.getString("selfAssessment"));
				resume.setRemarks(rs.getString("remarks"));
				resume.setName(rs.getString("name"));
				list.add(resume);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.close(conn);
		}
		return null;
	}

	@Override
	public Resume selectResume(Resume resume) {
		String sql="select * from resume where id=?";
		Connection conn=null;
		try {
			conn=JdbcUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,resume.getId());
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				resume=new Resume();
				resume.setId(rs.getInt("id"));
				resume.setProjectHistory(rs.getString("projecthistory"));
				resume.setWorkHistory(rs.getString("workHistory"));
				resume.setSalary(rs.getInt("salary"));
				resume.setWantJob(rs.getString("wantJob"));
				resume.setSelfAssessment(rs.getString("selfAssessment"));
				resume.setRemarks(rs.getString("remarks"));
				resume.setName(rs.getString("name"));
			}
			return resume;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.close(conn);
		}
		return null;
	}


	@Override
	public int updateResume(Resume resume) {
		String sql="update resume set projecthistory=?,workhistory=?,salary=?,wantjob=?,selfassessment=?,remarks=?,name=?where id=?";
		Connection conn=null;
		try {
			conn= JdbcUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, resume.getProjectHistory());
			ps.setString(2, resume.getWorkHistory());
			ps.setInt(3, resume.getSalary());
			ps.setString(4, resume.getWantJob());
			ps.setString(5, resume.getSelfAssessment());
			ps.setString(6, resume.getRemarks());
			ps.setString(7, resume.getName());
			ps.setInt(8, resume.getId());
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
