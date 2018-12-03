package dao;

import java.util.List;

import bean.User;

public interface UserDao {
	//保存用户
	public int saveUser(User user);
	
	//删除用户
	public int deleteUser(int id);
	
	//更新用户
	public int updateUser(User user);
	
	//查询所有用户
	public List<User> selectAllUser();
	
	//根据Email查询用户
	public User selectEmailUser(String email);
	//根据id查询用户
	public User selectIdUser(int id);
	
	//根据用户名查询用户
	public User selectNameUser(String name);

}
