package com.ly.helloHibernate;

import java.util.List;

import org.hibernate.Query;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.ly.helloHibernate.entity.Dept;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase{
	
	Configuration conf;
	SessionFactory sf;
	Session session;
	Transaction ts;
   
    public void testAdd(){
    	
    	conf=new Configuration().configure();
    	sf=conf.buildSessionFactory();
    	session=sf.openSession();
    	ts=session.beginTransaction();
    	
    	try {
			
    		Dept dept=new Dept();
    		dept.setDept_name("科研部");
    		dept.setDept_loc("六楼");
    		//缓存
    		session.save(dept);
    		//事务提交
    		ts.commit();
    		
		} catch (Exception e) {
			
			e.printStackTrace();
			//回滚
			ts.rollback();
		}
    }
    
    public void testFind(){
    	
    	conf=new Configuration().configure();
    	sf=conf.buildSessionFactory();
    	session=sf.openSession();
    	
    	Dept dept=(Dept) session.get(Dept.class, 1);//没查到  返回null
    	//Dept dept=(Dept) session.load(Dept.class, 10);//没查到  报exception
    	
    	System.out.println(dept);
    	System.out.println(dept.getEmps());
    }
    
    public void testUpdate(){
    	
    	conf=new Configuration().configure();
    	sf=conf.buildSessionFactory();
    	session=sf.openSession();
    	ts=session.beginTransaction();
    	
    	try {
			Dept dept=(Dept) session.get(Dept.class, 6);
    		dept.setDept_name("开发部");
    		session.update(dept);
    		ts.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		}
    }
    
    public void testDelete(){
    	
    	conf=new Configuration().configure();
    	sf=conf.buildSessionFactory();
    	session=sf.openSession();
    	ts=session.beginTransaction();
    	
    	try {
			Dept dept=(Dept) session.get(Dept.class, 6);
			session.delete(dept);
			ts.commit();
    		
		} catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		}
    }
    
    public void testAll(){
    	
    	conf=new Configuration().configure();
    	sf=conf.buildSessionFactory();
    	session=sf.openSession();
    	
    	Query q=session.createQuery("from Dept");
    	
    	List list=q.list();
    	
    	System.out.println(list);
    	session.close();
    	
    }
}
