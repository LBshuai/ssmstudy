package com.entity;

public class Ziliao {
		private Integer id;
	private String name;
	private String leixing;
	private Leixing leixingfk;
	private Integer kinfo;
	private Kinfo kinfofk;
	private String zfile;
	private String jieshao;
	private String addtime;
	private String uname;

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
	
	public String getLeixing()
	{
		return leixing;
	}
	public void setLeixing(String leixing)
	{
		this.leixing = leixing;
	}
	
	public Leixing getLeixingfk() {
			return leixingfk;
	}
	public void setLeixingfk(Leixing leixingfk) {
		this.leixingfk = leixingfk;
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
	public String getZfile()
	{
		return zfile;
	}
	public void setZfile(String zfile)
	{
		this.zfile = zfile;
	}
	
	public String getJieshao()
	{
		return jieshao;
	}
	public void setJieshao(String jieshao)
	{
		this.jieshao = jieshao;
	}
	
	public String getAddtime()
	{
		return addtime;
	}
	public void setAddtime(String addtime)
	{
		this.addtime = addtime;
	}
	
	public String getUname()
	{
		return uname;
	}
	public void setUname(String uname)
	{
		this.uname = uname;
	}
	@Override

	public String toString() {

		return "Ziliao [id=" + id + ", name=" + name + ", leixing=" + leixing + ", kinfo=" + kinfo + ", zfile=" + zfile + ", jieshao=" + jieshao + ", addtime=" + addtime + ", uname=" + uname + "]";

	}
}