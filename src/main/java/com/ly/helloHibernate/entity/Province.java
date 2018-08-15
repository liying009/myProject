package com.ly.helloHibernate.entity;

public class Province {
	
	private int area_id;
	private String area_name;
	private int area_level;
	private int parent_id;
	
	
	public Province() {}

	public Province(int area_id, String area_name, int area_level, int parent_id) {
		super();
		this.area_id = area_id;
		this.area_name = area_name;
		this.area_level = area_level;
		this.parent_id = parent_id;
	}

	public int getArea_id() {
		return area_id;
	}

	public void setArea_id(int area_id) {
		this.area_id = area_id;
	}

	public String getArea_name() {
		return area_name;
	}

	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}

	public int getArea_level() {
		return area_level;
	}

	public void setArea_level(int area_level) {
		this.area_level = area_level;
	}

	public int getParent_id() {
		return parent_id;
	}

	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}

	@Override
	public String toString() {
		return "Province [area_id=" + area_id + ", area_name=" + area_name + ", area_level=" + area_level
				+ ", parent_id=" + parent_id + "]";
	}
	

}
