package com.ly.helloHibernate;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;

import com.ly.helloHibernate.entity.Dept;
import com.ly.helloHibernate.entity.Emp;
import com.ly.helloHibernate.entity.Province;
import com.ly.helloHibernate.util.HibernateUtil;

import junit.framework.TestCase;

public class TestHiber extends TestCase{
	
	public void test1(){
		Session session=HibernateUtil.getSession();
		String sql="from Emp";
		Query q=session.createQuery(sql);
		List list=q.list();
		
		System.out.println(list);
	}
	
	public void test2(){
		Session session=HibernateUtil.getSession();
		String sql = "from Emp where job=?";
		Query q=session.createQuery(sql);
		q.setParameter(0, "经理");
		List list=q.list();
		
		System.out.println(list);
	}
	
	public void test3(){
		Session session=HibernateUtil.getSession();
		String sql="from Emp where ename like ?";
		Query q=session.createQuery(sql);
		q.setParameter(0, "小%");
		List list=q.list();
		System.out.println(list);
	}
	
	public void test4(){
		Session session=HibernateUtil.getSession();
		String sql="from Emp where ename like:name";
		Query q=session.createQuery(sql);
		q.setParameter("name", "小%");
		List list=q.list();
		System.out.println(list);
	}
	
	public void test5(){
		Session session=HibernateUtil.getSession();
		String sql="from Emp where hiredate > ?";
		Query q=session.createQuery(sql);
		q.setParameter(0, "2018-10-");
		List list=q.list();
		System.out.println(list);
	}
	
	/**
	 * 查询总数
	 */
	public void test6(){
		Session session=HibernateUtil.getSession();
		String sql="select count(*) from Emp";
		Query q=session.createQuery(sql);
		long n=(Long) q.uniqueResult();
		
		System.out.println(n);
	}
	
	/**
	 * 分页查询
	 */
	public void test7(){
		Session session=HibernateUtil.getSession();
		String sql="from Emp";
		int currPage=1;
		int size=3;
		Query q=session.createQuery(sql);
		q.setFirstResult((currPage-1)*size);//跳过行数
		q.setMaxResults(size);//每页条数
		List list=q.list();
		
		System.out.println(list);
	}
	
	/**
	 * 查询多列
	 */
	public void test8(){
		
		Session session=HibernateUtil.getSession();
		String sql= "select emp_id,ename,job from Emp";
		Query q=session.createQuery(sql);
		List<Object[]> list=q.list();//封装对象
		for(Object[] row:list){
			for(int i=0;i<row.length;i++){
				System.out.print(row[i]+"--");
			}
			System.out.println();
		}
	}
	
	/**
	 * 多条件动态查询
	 * @throws ParseException 
	 * @throws HibernateException 
	 */
	public void test9() throws HibernateException, ParseException{
		
		Session session=HibernateUtil.getSession();
		Criteria c=session.createCriteria(Emp.class);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = sdf.parse("2018-09-10");
		Date date2 = sdf.parse("2018-10-10");
		
		//or一般用于查询两个条件
		//List emps=c.add(Restrictions.or(Restrictions.gt("sal", 20000.0),Restrictions.between("hireDate",date1,date2) ))
        //        .list();
		//List emps=c.add(Restrictions.between("hireDate",date1,date2)).list();
		
		//用disjunction来实现多个or的功能
		Disjunction dis = Restrictions.disjunction();
		
		//用disjunction来实现多个or的功能
		dis.add(Restrictions.eq("job", "经理"));
		dis.add(Restrictions.gt("sal", 30000.0));
		dis.add(Restrictions.between("hireDate",date1,date2));
		c.add(dis);
		List list=c.list();
		System.out.println(list);
		
	}
	
	/**
	 * 相关子查询
	 */
	public void test10(){
		
		String sql="from Province where parent_id=(select area_id from Province where area_name='湖南省')";
		Session session=HibernateUtil.getSession();
		Query q=session.createQuery(sql);
		List<Province> list=q.list();
		for(Province p:list){
			System.out.println(p.getArea_id()+"--"+p.getArea_name());
		}
	}
	
	/**
	 * 内连接查询
	 */
	public void test11(){
		
		String sql="from Emp e inner join e.dept";
		Session session=HibernateUtil.getSession();
		Query q=session.createQuery(sql);
		List<Object[]> list=q.list();
		for(Object obj[]:list){
			Emp emp=(Emp) obj[0];
			Dept dept=(Dept) obj[1];
			System.out.println(emp+"---"+dept);
		}
		
	}
	
	/**
	 * 左外连接
	 */
	public void test12(){
		
		String sql="from Dept d left join d.emps";
		Session session=HibernateUtil.getSession();
		Query q=session.createQuery(sql);
		List<Object[]> list=q.list();
		for(Object obj[]:list){
			Dept dept=(Dept) obj[0];
			Emp emp=(Emp) obj[1];
			System.out.println(emp+"---"+dept);
		}
	}
	
	/**
	 * 原生sql查询
	 */
	public void test13(){
		
		String sql="SELECT e.emp_id,e.ename,e.job,e.sal "
				+ "FROM emp e "
				+ "WHERE e.sal> ? AND e.ename LIKE ?";
		
		Session session=HibernateUtil.getSession();
		SQLQuery sq=session.createSQLQuery(sql);
		sq.setParameter(0, 20000);
		sq.setParameter(1, "小%");
		
		
		List<Object[]> list=sq.list();
		System.out.println(list);
		for (Object[] obj : list) {
			System.out.println(obj[0]+"--"+obj[1]+"--"+obj[2]+"--"+obj[3]);
		}
		
	}

}
