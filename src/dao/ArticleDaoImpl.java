package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.JdbcUtils;

import bean.Article;

public class ArticleDaoImpl implements ArticleDao{

	@Override
	public int deleteArticle(Article article) {
		String sql="delete from article where id=?";
		Connection conn=null;
		try {
			conn= JdbcUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, article.getId());
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public int saveArticle(Article article) {
		String sql="insert into article(classify,title,writer,ico,body,date) values(?,?,?,?,?,?)";
		Connection conn=null;
		try {
			conn=JdbcUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, article.getClassify());
			ps.setString(2, article.getTitle());
			ps.setString(3, article.getWriter());
			ps.setString(4,article.getIco());
			ps.setString(5,article.getBody());
			ps.setDate(6, new java.sql.Date(article.getDate().getTime()));
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.close(conn);
		}
		return 0;
	}
	@Override
	public List<Article> selectIALLArticle() {
		List<Article> list=new ArrayList<Article>();
		String sql="select * from article";
		Connection conn=null;
		try {
			conn=JdbcUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			Article article=null;
			while(rs.next()){
				article=new Article();
				article.setId(rs.getInt("id"));
				article.setClassify(rs.getString("classify"));
				article.setTitle(rs.getString("title"));
				article.setWriter(rs.getString("writer"));
				article.setIco(rs.getString("ico"));
				article.setBody(rs.getString("body"));
				//article.setDate(rs.getDate("date"));
				list.add(article);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.close(conn);
		}
		return null;
	}

	@Override
	public Article selectIdArticle(int id) {
		String sql="select * from article where id=?";
		Connection conn=null;
		try {
			conn=JdbcUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			Article article=null;
			while(rs.next()){
				article=new Article();
				article.setId(rs.getInt("id"));
				article.setClassify(rs.getString("classify"));
				article.setTitle(rs.getString("title"));
				article.setWriter(rs.getString("writer"));
				article.setIco(rs.getString("ico"));
				article.setBody(rs.getString("body"));
				//article.setDate(rs.getDate("date"));
			}
			return article;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.close(conn);
		}
		return null;
	}

	@Override
	public int updateArticle(Article article) {
		String sql="update article set classify=?,title=?,writer=?,body=? where id=?";
		Connection conn=null;
		try {
			conn= JdbcUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, article.getClassify());
			ps.setString(2, article.getTitle());
			ps.setString(3, article.getWriter());
			//ps.setString(4,article.getIco());
			ps.setString(4,article.getBody());
			//ps.setDate(6,new java.sql.Date(article.getDate().getTime()));
			ps.setInt(5, article.getId());
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
