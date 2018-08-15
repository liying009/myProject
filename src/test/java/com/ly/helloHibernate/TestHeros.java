package com.ly.helloHibernate;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;

import com.ly.helloHibernate.util.HibernateUtil;

import junit.framework.TestCase;

public class TestHeros extends TestCase{

	public void pageHeros(){
		int curr=1;
		int size=10;
		String sql="from Heros";
		Session session=HibernateUtil.getSession();
		Query q=session.createQuery(sql);
		
		q.setFirstResult((curr-1)*size);
		q.setMaxResults(size);
		List list=q.list();
		
		System.out.println(list);
	}
}
