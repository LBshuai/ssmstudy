package com.entity;

public class Student {
		private Integer id;
	private String username;
	private String name;
	private String sex;
	private String banji;
	private Banji banjifk;
	private String pwd;

	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getSex()
	{
		return sex;
	}
	public void setSex(String sex)
	{
		this.sex = sex;
	}
	
	public String getBanji()
	{
		return banji;
	}
	public void setBanji(String banji)
	{
		this.banji = banji;
	}
	
	public Banji getBanjifk() {
			return banjifk;
	}
	public void setBanjifk(Banji banjifk) {
		this.banjifk = banjifk;
	}
	public String getPwd()
	{
		return pwd;
	}
	public void setPwd(String pwd)
	{
		this.pwd = pwd;
	}
	@Override

	public String toString() {

		return "Student [id=" + id + ", username=" + username + ", name=" + name + ", sex=" + sex + ", banji=" + banji + ", pwd=" + pwd + "]";

	}
}