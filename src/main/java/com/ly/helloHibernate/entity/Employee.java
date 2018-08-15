package com.ly.helloHibernate.entity;

import java.util.HashSet;
import java.util.Set;

public class Employee {
	
	private int emp_id;
	private String e_name;
	private int e_age;
	
	Set projects = new HashSet();

	public Employee() {}

	public Employee(int emp_id, String e_name, int e_age) {
		super();
		this.emp_id = emp_id;
		this.e_name = e_name;
		this.e_age = e_age;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getE_name() {
		return e_name;
	}

	public void setE_name(String e_name) {
		this.e_name = e_name;
	}

	public int getE_age() {
		return e_age;
	}

	public void setE_age(int e_age) {
		this.e_age = e_age;
	}

	public Set getProjects() {
		return projects;
	}

	public void setProjects(Set projects) {
		this.projects = projects;
	}

	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", e_name=" + e_name + ", e_age=" + e_age + "\n]";
	}

}
