package com.amsidh.hibernate.app;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.amsidh.hibernate.domains.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query query = session
				.createQuery("from userdetails user where user.userId=1");
		query.setCacheable(true); 
		
		List<UserDetails> users = (List<UserDetails>) query.list();

		session.getTransaction().commit();
		session.close();

		
		
		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();

		Query query2 = session2.createQuery("from userdetails user where user.userId=1");
		query2.setCacheable(true);
		List<UserDetails> users2 = (List<UserDetails>) query2.list();
		session2.getTransaction().commit();
		session2.close();

	}

}
