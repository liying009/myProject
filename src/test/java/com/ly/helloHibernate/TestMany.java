package com.ly.helloHibernate;

import java.util.Set;


import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.ly.helloHibernate.entity.Employee;
import com.ly.helloHibernate.entity.Project;

import junit.framework.TestCase;

/**
 * 测试多对多关联
 * @author lenovo
 *
 */
public class TestMany extends TestCase{
	
	Configuration conf;
	SessionFactory sf;
	Session session;
	Transaction ts;
	
	/**
	 * 查找
	 */
	public void testFind(){
		
		conf=new Configuration().configure();
    	sf=conf.buildSessionFactory();
    	session=sf.openSession();
    	
    	Employee emp = (Employee) session.get(Employee.class, 3);
    	
    	System.out.println(emp);
    	System.out.println(emp.getProjects());
	}
	
	/**
	 * 添加项目，分配员工
	 */
	public void testAdd(){
		
		conf=new Configuration().configure();
    	sf=conf.buildSessionFactory();
    	session=sf.openSession();
    	ts=session.beginTransaction();
    	
    	Project project= new Project(3, "校园图书管理系统", "长沙");
    	
    	Employee emp1= new Employee(6, "钱八", 20);
    	Employee emp2= new Employee(7, "刘九", 20);
    	Employee emp3= new Employee(8,"铁十",30);
    	
    	project.getEmps().add(emp1);
    	project.getEmps().add(emp2);
    	project.getEmps().add(emp3);
    	
    	session.save(project);
    	ts.commit();
	}
	
	/**
	 * 删除员工【1、因为project中设置了级联，所以可以直接删除同时删除中间表内容；
	 *        2、但员工表没有设置级联，必须先在该员工所在的项目中踢出这个员工，也就是先删除中间表，然
	 *          后再删除该员工就可以了，具体操作如下】
	 */
	public void testDel(){
		
		conf=new Configuration().configure();
    	sf=conf.buildSessionFactory();
    	session=sf.openSession();
    	ts=session.beginTransaction();
    	
    	//取得要删除的员工
    	Employee emp = (Employee) session.get(Employee.class, 6);
    	//取得该员工所在的所有项目集合
    	Set<Project> pros = emp.getProjects();  
        for (Project p : pros) {
        	//在有该员工的项目中踢出该员工
            p.getEmps().remove(emp);  
        } 
        //删除员工
    	session.delete(emp);
    	ts.commit();
	}
	
	/**
	 * 修改人员分配【项目中人员调动】
	 */
	public void testUpdate(){
		
		conf=new Configuration().configure();
    	sf=conf.buildSessionFactory();
    	session=sf.openSession();
    	ts=session.beginTransaction();
    	
    	Project project= (Project) session.get(Project.class, 1);
    	
    	Employee emp1=(Employee) session.get(Employee.class, 6);
    	Employee emp2=(Employee) session.get(Employee.class, 7);
    	
    	project.getEmps().add(emp1);
    	project.getEmps().add(emp2);
    	
    	session.update(project);
    	ts.commit();
	}
	
	/**
	 * 增加员工
	 */
	public void testAddEmp(){
		
		conf=new Configuration().configure();
    	sf=conf.buildSessionFactory();
    	session=sf.openSession();
    	ts=session.beginTransaction();
    	
    	Employee emp = new Employee(9, "小丽", 22);
    	
    	session.save(emp);
    	ts.commit();
	}

}
