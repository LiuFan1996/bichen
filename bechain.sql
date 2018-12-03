--SQL数据库-------------
create database bechain ; 

------------简历表---------
drop table resume;
create table if not exists resume(
id int(20) primary key auto_increment,
name varchar(20),
projecthistory text,
workhistory text,
salary int(20),
wantjob varchar(50),
selfassessment text,
remarks text
);

select * from resume;
------------招聘信息表---------
drop table RecruitmentInfo;
create table RecruitmentInfo(
	id int(20) PRIMARY KEY auto_increment,
	company  varchar(10) NOT NULL ,
	address  varchar(50) NOT NULL,
	workExperience varchar(20)  default 'admin',
	education    varchar(20) NOT NULL,
	salary    varchar(20) NOT NULL,
	isFinancing varchar(20) NOT NULL,
	peopleNumber int(20) NOT NULL,
	companyUser  varchar(50) NOT NULL,
	companyProfile text ,
	jobRequirements text,
	date   datetime
)auto_increment=200000;

select * from RecruitmentInfo;

------------用户表------------
DROP TABLE user;
CREATE TABLE user (
  id int(12) PRIMARY KEY NOT NULL auto_increment,
  company varchar(50) NOT NULL,
  email varchar(50) NOT NULL,
  job varchar(50) ,
  education varchar(50),
  username varchar(50) NOT NULL,
  nickname varchar(50) unique,
  password varchar(50) NOT NULL,
  userintegral int(12) NOT NULL default '0',  
  isemailverify char(3),
  emailverifycode varchar(50) default NULL,
  lastlogintime datetime default NULL,
  lastloginip varchar(15) default NULL,
  UNIQUE KEY email (email)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO USER VALUES(1000,"aaa","1234@qq.com","aaa","aaa","aaa","aaa","123456",111,"aaa","aaa",'1999-9-9 12:12:12',"aaa")
select * from user ;

----------------文章表------------
drop table article;
create table article(
	id int(20) PRIMARY KEY auto_increment,
	classify  varchar(10)  default '�������Ѷ',
	title  varchar(50) NOT NULL,
	writer varchar(20)  default 'admin',
	ico    varchar(50) NOT NULL,
	body   text,
	date   datetime
)auto_increment=100000;

select * from article;

--------------管理员表-------------

drop table adminUser;
create table adminUser(
	id int(20) PRIMARY KEY auto_increment,
	username varchar(50) unique,
	password varchar(50)
)auto_increment=100000;

	insert into adminUser(username,password) values('admin','123456');
	insert into adminUser(username,password) values('admin1','admin1');

select * from adminUser;

