package com.ly.helloHibernate.entity;

import java.util.HashSet;
import java.util.Set;


public class Dept {
	
	private int dept_id;
	private String dept_name;
	private String dept_loc;
	
	private Set<Emp> emps=new HashSet();
	
	public Dept() {	}
	
	public Dept(int dept_id, String dept_name, String dept_loc) {
		super();
		this.dept_id = dept_id;
		this.dept_name = dept_name;
		this.dept_loc = dept_loc;
	}
	
	public int getDept_id() {
		return dept_id;
	}
	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public String getDept_loc() {
		return dept_loc;
	}
	public void setDept_loc(String dept_loc) {
		this.dept_loc = dept_loc;
	}
	
	public Set<Emp> getEmps() {
		return emps;
	}

	public void setEmps(Set<Emp> emps) {
		this.emps = emps;
	}

	@Override
	public String toString() {
		return "Dept [dept_id=" + dept_id + ", dept_name=" + dept_name + ", dept_loc=" + dept_loc + "\n]";
	}
	
}
