package com.dao;

import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.entities.*;
import org.hibernate.query.Query;



@Repository
public class LoginDao {
	
	@RequestMapping("/users")
	public boolean checkUser(String uname,String pass) {
		SessionFactory factory = new Configuration().configure("hibernateV.cfg.xml").addAnnotatedClass(Users.class).buildSessionFactory();
		
		Session session = factory.openSession();
		session.beginTransaction();
		Query<?> squery = session.createQuery("from Users where username=:uname AND password=:pass");
		squery.setParameter("uname",uname );
		squery.setParameter("pass", pass);
		
		Users user = (Users) squery.uniqueResult();
		if(user!=null) {
			session.getTransaction().commit();
			session.close();
			return true;
		}
		session.getTransaction().commit();
		session.close();
		return false;
	}

}
