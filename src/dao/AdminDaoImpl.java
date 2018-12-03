package dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import bean.Admin;

@Repository
public class AdminDaoImpl implements AdminDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public Admin login(String Username) {
		jdbcTemplate=load();
		System.out.println(jdbcTemplate);
		RowMapper<Admin> rowMapper=new BeanPropertyRowMapper<Admin>(Admin.class);
		Admin admin = jdbcTemplate.queryForObject("select * from adminUser where username=?", new Object[]{Username}, rowMapper);
		System.out.println(admin);
		return admin;
	}
	public JdbcTemplate load(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring.xml");
		JdbcTemplate jdbcTemplate = (JdbcTemplate)ac.getBean("jdbcTemplate");
		System.out.println("spring配置数据库模板类为------------------------》"+jdbcTemplate);
		return jdbcTemplate;
	}
	
//	Connection conn=null;
//	String sql="select * from adminUser where username=?";
//	try {
//		conn=JdbcUtils.getConnection();
//		PreparedStatement statement = conn.prepareStatement(sql);
//		statement.setString(1, Username);
//		ResultSet set = statement.executeQuery();
//		Admin admins=new Admin();
//		while (set.next()) {
//			admins.setId(set.getInt("id"));
//			admins.setUsername(set.getString("username"));
//			admins.setPassword(set.getString("password"));
//		}
//		return admins;
//	} catch (Exception e) {
//	}
//	return null;

}
