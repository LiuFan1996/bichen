package dao;

import java.util.List;

import bean.Resume;


public interface ResumeDao {
	
	
	//保存简历
	public int saveResume(Resume resume) ;

	//根据id删除简历
	public int deleteResume(Resume resume) ;
	
	//根据id更新简历
	public int updateResume(Resume resume) ;

	//根据id查询简历
	public Resume selectResume(Resume resume) ;

	//查询所有简历
	public List<Resume> selectAllResume() ;

}
