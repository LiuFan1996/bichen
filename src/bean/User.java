package bean;

import java.util.Date;

/**
 * 用户实体类
 */
public class User {
	private int id;
	private String company; // 公司名称
	private String email; // 邮箱
	private String job; // 职位
	private String education;// 学历
	private String username;// 姓名
	private String nickname; // 昵称
	private String password; // 密码
	private int userIntegral; // 用户级别:VIP 普通用户
	private char isEmailVerify; // 是否邮箱验证
	private String emailVerifyCode; // 邮箱验证码
	private Date lastLoginTime; // 最后一次登录时间
	private String lastLoginIp; // 最后一次登录地址ַ

	public User() {
	}

	public User( String company, String email, String job,
			String education, String username, String nickname,
			String password, int userIntegral, char isEmailVerify,
			String emailVerifyCode, Date lastLoginTime, String lastLoginIp) {
		this.company = company;
		this.email = email;
		this.job = job;
		this.education = education;
		this.username = username;
		this.nickname = nickname;
		this.password = password;
		this.userIntegral = userIntegral;
		this.isEmailVerify = isEmailVerify;
		this.emailVerifyCode = emailVerifyCode;
		this.lastLoginTime = lastLoginTime;
		this.lastLoginIp = lastLoginIp;
	}
	
	public User(int id, String company, String email, String job,
			String education, String username, String nickname,
			String password, int userIntegral, char isEmailVerify,
			String emailVerifyCode, Date lastLoginTime, String lastLoginIp) {
		super();
		this.id = id;
		this.company = company;
		this.email = email;
		this.job = job;
		this.education = education;
		this.username = username;
		this.nickname = nickname;
		this.password = password;
		this.userIntegral = userIntegral;
		this.isEmailVerify = isEmailVerify;
		this.emailVerifyCode = emailVerifyCode;
		this.lastLoginTime = lastLoginTime;
		this.lastLoginIp = lastLoginIp;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getCompany() {
		return company;
	}



	public void setCompany(String company) {
		this.company = company;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getJob() {
		return job;
	}



	public void setJob(String job) {
		this.job = job;
	}



	public String getEducation() {
		return education;
	}



	public void setEducation(String education) {
		this.education = education;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getNickname() {
		return nickname;
	}



	public void setNickname(String nickname) {
		this.nickname = nickname;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public int getUserIntegral() {
		return userIntegral;
	}



	public void setUserIntegral(int userIntegral) {
		this.userIntegral = userIntegral;
	}



	public char getIsEmailVerify() {
		return isEmailVerify;
	}



	public void setIsEmailVerify(char isEmailVerify) {
		this.isEmailVerify = isEmailVerify;
	}



	public String getEmailVerifyCode() {
		return emailVerifyCode;
	}



	public void setEmailVerifyCode(String emailVerifyCode) {
		this.emailVerifyCode = emailVerifyCode;
	}



	public Date getLastLoginTime() {
		return lastLoginTime;
	}



	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}



	public String getLastLoginIp() {
		return lastLoginIp;
	}



	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}



	@Override
	public String toString() {
		return "User [company=" + company + ", education=" + education
				+ ", email=" + email + ", emailVerifyCode=" + emailVerifyCode
				+ ", id=" + id + ", isEmailVerify=" + isEmailVerify + ", job="
				+ job + ", lastLoginIp=" + lastLoginIp + ", lastLoginTime="
				+ lastLoginTime + ", nickname=" + nickname + ", password="
				+ password + ", userIntegral=" + userIntegral + ", username="
				+ username + "]";
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return id;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
}
