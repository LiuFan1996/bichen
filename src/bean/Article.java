package bean;

import java.util.Date;
/*
 * 文章实体类
 * */
public class Article {
	private int id;
	private String classify; // 分类
	private String title; // 标题
	private String writer; // 作者
	private String ico; // 缩略图
	private String body; // 内容
	private Date date; // 时间


	public Article() {
	}

	public Article(int id, String classify, String title, String writer, String ico, String body, Date date) {
		super();
		this.id = id;
		this.classify = classify;
		this.title = title;
		this.writer = writer;
		this.ico = ico;
		this.body = body;
		this.date = date;
	}

	public Article(String classify, String title, String writer, String ico, String body, Date date) {
		this.classify = classify;
		this.title = title;
		this.writer = writer;
		this.ico = ico;
		this.body = body;
		this.date = date;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getIco() {
		return ico;
	}

	public void setIco(String ico) {
		this.ico = ico;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", classify=" + classify + ", title=" + title + ", writer=" + writer + ", ico="
				+ ico + ", body=" + body + ", date=" + date + "]";
	}

}
