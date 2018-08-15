package com.ly.helloHibernate.entity;

import java.util.HashSet;
import java.util.Set;

public class Project {
	
	private int project_id;
	private String pro_name;
	private String pro_loc;
	
	Set emps=new HashSet();

	public Project() {}

	public Project(int project_id, String pro_name, String pro_loc) {
		super();
		this.project_id = project_id;
		this.pro_name = pro_name;
		this.pro_loc = pro_loc;
	}

	public int getProject_id() {
		return project_id;
	}

	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}

	public String getPro_name() {
		return pro_name;
	}

	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}

	public String getPro_loc() {
		return pro_loc;
	}

	public void setPro_loc(String pro_loc) {
		this.pro_loc = pro_loc;
	}

	public Set getEmps() {
		return emps;
	}

	public void setEmps(Set emps) {
		this.emps = emps;
	}

	@Override
	public String toString() {
		return "Project [project_id=" + project_id + ", pro_name=" + pro_name + ", pro_loc=" + pro_loc + "\n]";
	}
	
}
