package bean;

/**
 *简历实体类
 */
public class Resume {
	private int id;
	private String name;
	private String projectHistory; // 项目经验
	private String workHistory;// 工作经历
	private int salary; // 薪资
	private String wantJob; // 想要找的岗位
	private String selfAssessment;// 自我评价
	private String remarks; // 备注ע

	public Resume(){}
	
	
	public Resume(String name, String projectHistory, String workHistory,
			int salary, String wantJob, String selfAssessment, String remarks) {
		super();
		this.name = name;
		this.projectHistory = projectHistory;
		this.workHistory = workHistory;
		this.salary = salary;
		this.wantJob = wantJob;
		this.selfAssessment = selfAssessment;
		this.remarks = remarks;
	}


	public Resume(int id, String name, String projectHistory,
			String workHistory, int salary, String wantJob,
			String selfAssessment, String remarks) {
		super();
		this.id = id;
		this.name = name;
		this.projectHistory = projectHistory;
		this.workHistory = workHistory;
		this.salary = salary;
		this.wantJob = wantJob;
		this.selfAssessment = selfAssessment;
		this.remarks = remarks;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Resume(int id, String projectHistory, String workHistory, int salary, String wantJob, String selfAssessment,
			String remarks) {
		super();
		this.id = id;
		this.projectHistory = projectHistory;
		this.workHistory = workHistory;
		this.salary = salary;
		this.wantJob = wantJob;
		this.selfAssessment = selfAssessment;
		this.remarks = remarks;
	}


	public Resume(String projectHistory, String workHistory, int salary, String wantJob, String selfAssessment,
			String remarks) {
		super();
		this.projectHistory = projectHistory;
		this.workHistory = workHistory;
		this.salary = salary;
		this.wantJob = wantJob;
		this.selfAssessment = selfAssessment;
		this.remarks = remarks;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProjectHistory() {
		return projectHistory;
	}

	public void setProjectHistory(String projectHistory) {
		this.projectHistory = projectHistory;
	}

	public String getWorkHistory() {
		return workHistory;
	}

	public void setWorkHistory(String workHistory) {
		this.workHistory = workHistory;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getWantJob() {
		return wantJob;
	}

	public void setWantJob(String wantJob) {
		this.wantJob = wantJob;
	}

	public String getSelfAssessment() {
		return selfAssessment;
	}

	public void setSelfAssessment(String selfAssessment) {
		this.selfAssessment = selfAssessment;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "Resum [id=" + id + ", projectHistory=" + projectHistory + ", workHistory=" + workHistory + ", salary="
				+ salary + ", wantJob=" + wantJob + ", selfAssessment=" + selfAssessment + ", remarks=" + remarks + "]";
	}

}
