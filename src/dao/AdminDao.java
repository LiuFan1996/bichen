package dao;

import bean.Admin;

public interface AdminDao {
	
		//登陆操作
       public Admin login(String  username);
}
