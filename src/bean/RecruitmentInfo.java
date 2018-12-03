package bean;

import java.util.Date;

/**
 * 招聘信息实体类
 */

public class RecruitmentInfo {

	
	private String company; 		 // 公司名
	private String address; 		 // 地址
	private String workExperience; 	 // 工作经验
	private String education; 		 // 学历
	private String salary; 			  // 支付报酬
	private Date date; 				 // 发布日期
	private boolean isFinancing; 	 // 是否融资
	private int peopleNumber;        // 公司规模
	private String companyUserId;    // 职位发布者
	private String companyProfile;   // 公司简介
	private String  jobRequirements; // 任职要求
	private long Id;
	public long getId() {
		return Id;
	}

	
	public String getJobRequirements() {
		return jobRequirements;
	}


	public void setJobRequirements(String jobRequirements) {
		this.jobRequirements = jobRequirements;
	}


	public void setId(long id) {
		Id = id;
	}

	public String getCompany() {
		return company;
	}
	
	public RecruitmentInfo(){}
	
	
	public RecruitmentInfo(String company, String address, String workExperience, String education, String salary,
			Date date, boolean isFinancing, int peopleNumber, String companyUser, String companyProfile) {
		super();
		this.company = company;
		this.address = address;
		this.workExperience = workExperience;
		this.education = education;
		this.salary = salary;
		this.date = date;
		this.isFinancing = isFinancing;
		this.peopleNumber = peopleNumber;
		this.companyUserId = companyUser;
		this.companyProfile = companyProfile;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getWorkExperience() {
		return workExperience;
	}
	public void setWorkExperience(String workExperience) {
		this.workExperience = workExperience;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isFinancing() {
		return isFinancing;
	}
	public void setFinancing(boolean isFinancing) {
		this.isFinancing = isFinancing;
	}
	public int getPeopleNumber() {
		return peopleNumber;
	}
	public void setPeopleNumber(int peopleNumber) {
		this.peopleNumber = peopleNumber;
	}
	public String getCompanyUser() {
		return companyUserId;
	}
	public void setCompanyUser(String companyUser) {
		this.companyUserId = companyUser;
	}
	public String getCompanyProfile() {
		return companyProfile;
	}
	public void setCompanyProfile(String companyProfile) {
		this.companyProfile = companyProfile;
	}
	@Override
	public String toString() {
		return "RecruitmentInfo [company=" + company + ", address=" + address + ", workExperience=" + workExperience
				+ ", education=" + education + ", salary=" + salary + ", date=" + date + ", isFinancing=" + isFinancing
				+ ", peopleNumber=" + peopleNumber + ", companyUser=" + companyUserId + ", companyProfile="
				+ companyProfile + "]";
	}
	
}
