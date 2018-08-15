package com.ly.helloHibernate;

import java.util.Date;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.ly.helloHibernate.entity.Dept;
import com.ly.helloHibernate.entity.Emp;

import junit.framework.TestCase;

public class TestCaseDode extends TestCase{

	Configuration conf;
	SessionFactory sf;
	Session session;
	Transaction ts;
   
    public void testFind(){
    	
    	conf=new Configuration().configure();
    	sf=conf.buildSessionFactory();
    	session=sf.openSession();
    	
    	Emp emp=(Emp) session.get(Emp.class, 1);
    	
    	System.out.println(emp);
    }
    
    public void testAdd(){
    	
    	Dept dept = new Dept();
    	dept.setDept_name("国际部");
    	dept.setDept_loc("上海");
    	
    	Emp e1=new Emp("小飞", "java开发", 0, new Date(), 10000.0, 1000.0);
    	Emp e2=new Emp("小法", "java开发1", 0, new Date(), 10000.0, 1000.0);
    	
    	dept.getEmps().add(e1);
    	dept.getEmps().add(e2);
    	
    	conf=new Configuration().configure();
    	sf=conf.buildSessionFactory();
    	session=sf.openSession();
    	ts=session.beginTransaction();
    	
    	session.save(dept);
    	ts.commit();
    }
    
    public void testDel(){
    	
    	conf=new Configuration().configure();
    	sf=conf.buildSessionFactory();
    	session=sf.openSession();
    	ts=session.beginTransaction();
    	
    	Dept dept = (Dept) session.get(Dept.class, 6);
    	session.delete(dept);
    	
    	ts.commit();
    }
}
