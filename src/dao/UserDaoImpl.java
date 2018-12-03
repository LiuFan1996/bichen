package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.JdbcUtils;

import bean.User;

public class UserDaoImpl implements UserDao{
	
	public User userUtil(ResultSet rs){
		return null;
	}
	
	
	@Override
	public int deleteUser(int id) {
		String sql="delete from user where id=?";
		Connection con = null;
		try {
			con=JdbcUtils.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.close(con);
		}
		return 0;
	}

	@Override
	public int saveUser(User user) {
		String sql="insert into user values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Connection con = null;
		try {
			con=JdbcUtils.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, user.getId());
			ps.setString(2, user.getCompany());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getJob());
			ps.setString(5, user.getEducation());
			ps.setString(6, user.getUsername());
			ps.setString(7, user.getNickname());
			ps.setString(8, user.getPassword());
			ps.setInt(9, user.getUserIntegral());
			ps.setString(10, user.getIsEmailVerify()+"");
			ps.setString(11, user.getEmailVerifyCode());
			ps.setDate(12, new java.sql.Date(user.getLastLoginTime().getTime()));
			ps.setString(13, user.getLastLoginIp());
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.close(con);
		}
		return 0;
	}

	@Override
	public List<User> selectAllUser() {
		List<User> list=new ArrayList<User>();
		String sql="select * from user";
		Connection con = null;
		User user=null;
		try {
			con=JdbcUtils.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				user=new User();
				user.setId(rs.getInt("id"));
				user.setCompany(rs.getString("company"));
				user.setEmail(rs.getString("email"));
				user.setJob(rs.getString("job"));
				user.setEducation(rs.getString("education"));
				user.setUsername(rs.getString("username"));
				user.setNickname(rs.getString("nickname"));
				user.setPassword(rs.getString("password"));
				user.setUserIntegral(rs.getInt("userintegral"));
				user.setIsEmailVerify(rs.getString("isemailverify").charAt(0));
				user.setEmailVerifyCode(rs.getString("emailverifycode"));
				//user.setLastLoginTime(rs.getDate("lastlogintime"));
				user.setLastLoginIp(rs.getString("lastloginip"));
				list.add(user);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.close(con);
		}
		return null;
	}

	@Override
	public User selectIdUser(int id) {
		String sql="select * from user where id=?";
		Connection con = null;
		User user=null;
		try {
			con=JdbcUtils.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				user=new User();
				user.setId(rs.getInt("id"));
				user.setCompany(rs.getString("company"));
				user.setEmail(rs.getString("email"));
				user.setJob(rs.getString("job"));
				user.setEducation(rs.getString("education"));
				user.setUsername(rs.getString("username"));
				user.setNickname(rs.getString("nickname"));
				user.setPassword(rs.getString("password"));
				user.setUserIntegral(rs.getInt("userintegral"));
				user.setIsEmailVerify(rs.getString("isemailverify").charAt(0));
				user.setEmailVerifyCode(rs.getString("emailverifycode"));
				//user.setLastLoginTime(rs.getDate("lastlogintime"));
				user.setLastLoginIp(rs.getString("lastloginip"));
			}
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.close(con);
		}
		return null;
	}
	
	@Override
	public User selectEmailUser(String email) {
		String sql="select * from user where email=?";
		Connection con = null;
		User user=null;
		try {
			con=JdbcUtils.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				user=new User();
				user.setId(rs.getInt("id"));
				user.setCompany(rs.getString("company"));
				user.setEmail(rs.getString("email"));
				user.setJob(rs.getString("job"));
				user.setEducation(rs.getString("education"));
				user.setUsername(rs.getString("username"));
				user.setNickname(rs.getString("nickname"));
				user.setPassword(rs.getString("password"));
				user.setUserIntegral(rs.getInt("userintegral"));
				user.setIsEmailVerify(rs.getString("isemailverify").charAt(0));
				user.setEmailVerifyCode(rs.getString("emailverifycode"));
				user.setLastLoginTime(rs.getDate("lastlogintime"));
				user.setLastLoginIp(rs.getString("lastloginip"));
			}
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.close(con);
		}
		return null;
	}


	@Override
	public User selectNameUser(String name) {
		String sql="select * from user where username=?";
		Connection con = null;
		User user=null;
		try {
			con=JdbcUtils.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				user=new User();
				user.setId(rs.getInt("id"));
				user.setCompany(rs.getString("company"));
				user.setEmail(rs.getString("email"));
				user.setJob(rs.getString("job"));
				user.setEducation(rs.getString("education"));
				user.setUsername(rs.getString("username"));
				user.setNickname(rs.getString("nickname"));
				user.setPassword(rs.getString("password"));
				user.setUserIntegral(rs.getInt("userintegral"));
				user.setIsEmailVerify(rs.getString("isemailverify").charAt(0));
				user.setEmailVerifyCode(rs.getString("emailverifycode"));
				user.setLastLoginTime(rs.getDate("lastlogintime"));
				user.setLastLoginIp(rs.getString("lastloginip"));
			}
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.close(con);
		}
		return null;
	}

	@Override
	public int updateUser(User user) {
		String sql="update user set company=?,email=?,job=?,education=?,username=?,nickname=?,password=?,userIntegral=?,isEmailVerify=?,emailVerifyCode=?,lastLoginTime=?,lastLoginIp=? where id=?";
		Connection con = null;
		try {
			con=JdbcUtils.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(13, user.getId());
			ps.setString(1, user.getCompany());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getJob());
			ps.setString(4, user.getEducation());
			ps.setString(5, user.getUsername());
			ps.setString(6, user.getNickname());
			ps.setString(7, user.getPassword());
			ps.setInt(8, user.getUserIntegral());
			ps.setString(9, user.getIsEmailVerify()+"");
			ps.setString(10, user.getEmailVerifyCode());
			ps.setDate(11, new java.sql.Date(user.getLastLoginTime().getTime()));
			ps.setString(12, user.getLastLoginIp());
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.close(con);
		}
		return 0;
	}


}
