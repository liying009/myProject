package com.ly.helloHibernate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;

import com.ly.helloHibernate.entity.Emp;
import com.ly.helloHibernate.util.HibernateUtil;

import junit.framework.TestCase;

public class TestDynamic extends TestCase{
	
	public void test() throws ParseException{
		Session session=HibernateUtil.getSession();
		Criteria c=session.createCriteria(Emp.class);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = sdf.parse("2018-09-10");
		Date date2 = sdf.parse("2018-10-10");
		
		Disjunction dis = Restrictions.disjunction();
		//用disjunction来实现多个or的功能
		dis.add(Restrictions.eq("job", "经理")).add(Restrictions.gt("sal", 30000.0)).add(Restrictions.between("hireDate",date1,date2));
		c.add(dis);
		List list=c.list();
		System.out.println(list);
	}

}
