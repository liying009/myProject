package com.ly.helloHibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class HibernateUtil {

	// 准备会话工厂
	private static SessionFactory factory = null;
	//本地线程
	private static ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();

	static {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Session getSession() {
		// 先尝试到本地线程中获取会话
		Session session = threadLocal.get();
		if (session == null) {
			// 开启新会话
			session = factory.openSession();
			// 将新创建的会话保存到本地线程中
			threadLocal.set(session);
		}
		return session;
	}

	public static void closeSession() {
		Session session = threadLocal.get();
		if (session != null && session.isOpen()) {
			//关闭会话
			session.close();
			//清空本地线程中的会话变量
			threadLocal.set(null);
		}
	}

}
