package com.entity;

public class Xuanzhe {
		private Integer id;
	private String name;
	private String pic;
	private Integer kinfo;
	private Kinfo kinfofk;
	private String a;
	private String b;
	private String c;
	private String d;
	private String daan;
	private Integer fenshu;
	private String jiexi;
	private String ext;

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
	
	public String getPic()
	{
		return pic;
	}
	public void setPic(String pic)
	{
		this.pic = pic;
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
	public String getA()
	{
		return a;
	}
	public void setA(String a)
	{
		this.a = a;
	}
	
	public String getB()
	{
		return b;
	}
	public void setB(String b)
	{
		this.b = b;
	}
	
	public String getC()
	{
		return c;
	}
	public void setC(String c)
	{
		this.c = c;
	}
	
	public String getD()
	{
		return d;
	}
	public void setD(String d)
	{
		this.d = d;
	}
	
	public String getDaan()
	{
		return daan;
	}
	public void setDaan(String daan)
	{
		this.daan = daan;
	}
	
	public Integer getFenshu()
	{
		return fenshu;
	}
	public void setFenshu(Integer fenshu)
	{
		this.fenshu = fenshu;
	}
	
	public String getJiexi()
	{
		return jiexi;
	}
	public void setJiexi(String jiexi)
	{
		this.jiexi = jiexi;
	}
	
	public String getExt()
	{
		return ext;
	}
	public void setExt(String ext)
	{
		this.ext = ext;
	}
	@Override

	public String toString() {

		return "Xuanzhe [id=" + id + ", name=" + name + ", pic=" + pic + ", kinfo=" + kinfo + ", a=" + a + ", b=" + b + ", c=" + c + ", d=" + d + ", daan=" + daan + ", fenshu=" + fenshu + ", jiexi=" + jiexi + ", ext=" + ext + "]";

	}
}