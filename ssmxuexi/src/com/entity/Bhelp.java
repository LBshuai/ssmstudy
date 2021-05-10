package com.entity;

public class Bhelp {
		private Integer id;
	private String title;
	private String neirong;

	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public String getNeirong()
	{
		return neirong;
	}
	public void setNeirong(String neirong)
	{
		this.neirong = neirong;
	}
	@Override

	public String toString() {

		return "Bhelp [id=" + id + ", title=" + title + ", neirong=" + neirong + "]";

	}
}