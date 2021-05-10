package com.entity;

public class Video {
		private Integer id;
	private String name;
	private String fujian;
	private Integer kinfo;
	private Kinfo kinfofk;
	private String jieshao;
	private String uname;
	private String addtime;

	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getFujian()
	{
		return fujian;
	}
	public void setFujian(String fujian)
	{
		this.fujian = fujian;
	}
	
	public Integer getKinfo()
	{
		return kinfo;
	}
	public void setKinfo(Integer kinfo)
	{
		this.kinfo = kinfo;
	}
	
	public Kinfo getKinfofk() {
			return kinfofk;
	}
	public void setKinfofk(Kinfo kinfofk) {
		this.kinfofk = kinfofk;
	}
	public String getJieshao()
	{
		return jieshao;
	}
	public void setJieshao(String jieshao)
	{
		this.jieshao = jieshao;
	}
	
	public String getUname()
	{
		return uname;
	}
	public void setUname(String uname)
	{
		this.uname = uname;
	}
	
	public String getAddtime()
	{
		return addtime;
	}
	public void setAddtime(String addtime)
	{
		this.addtime = addtime;
	}
	@Override

	public String toString() {

		return "Video [id=" + id + ", name=" + name + ", fujian=" + fujian + ", kinfo=" + kinfo + ", jieshao=" + jieshao + ", uname=" + uname + ", addtime=" + addtime + "]";

	}
}