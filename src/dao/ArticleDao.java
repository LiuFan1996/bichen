package dao;

import java.util.List;

import bean.Article;

public interface ArticleDao {
	//保存用户
	public int saveArticle(Article article);
	
	//根据id删除文章
	public int deleteArticle(Article article);
	
	//根据id更新文章
	public int updateArticle(Article article);
	
	//根据id查询文章
	public Article selectIdArticle(int id);
	
	//查询所有文章
	public List<Article> selectIALLArticle();
}
