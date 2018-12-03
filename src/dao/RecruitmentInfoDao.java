package dao;

import java.util.List;

import bean.RecruitmentInfo;


public interface RecruitmentInfoDao {
	
	//根据id删除招聘信息
	public int deleteRecruitmentInfo(RecruitmentInfo recruitmentInfo) ;
	
	//保存招聘信息
	public int saveRecruitmentInfo(RecruitmentInfo recruitmentInfo) ;

	//查询所有招聘信息
	public List<RecruitmentInfo> selecteALLRecruitmentInfo() ;
	
	//根据id查询招聘信息
	public RecruitmentInfo selecteIdRecruitmentInfo(RecruitmentInfo recruitmentInfo) ;
	
	//根据id跟新招聘信息
	public int updateRecruitmentInfo(RecruitmentInfo recruitmentInfo) ;

}
