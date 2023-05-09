package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entities.Book;

public class BookDao {

	
	@RequestMapping("/book")
	public boolean insertbook(int bookcode,String bookname,String author,String date) {
		SessionFactory factory = new Configuration().configure("hibernateC.cfg.xml").addAnnotatedClass(Book.class).buildSessionFactory();
		
		Session session = factory.openSession();
		session.beginTransaction();

		Book book = new Book();
		book.setBookcode(bookcode);
		book.setBookname("bookname");
		book.setAuthor("author");
		book.setDate("date");

		session.persist(book);
		System.out.println("add");
		session.getTransaction().commit();
		session.close();
		return true;
		/*
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
		*/
	}

}
