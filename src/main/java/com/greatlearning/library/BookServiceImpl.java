package com.greatlearning.library;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.RollbackException;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
 

public class BookServiceImpl implements BookService{
	
	private SessionFactory sessionFactory;
	private Session session;
	
	@Autowired
	void BooServiceImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
		
		try 
		{
			session = sessionFactory.getCurrentSession();	
		}
		catch(HibernateException e) {
			
			session = sessionFactory.openSession();
		}
		
		
	}
	
	@Override
	@Transactional
	public List<Book> findAll() {
		List <Book> books = new ArrayList<Book>();
		try {
			
		Transaction tx = (Transaction) session.beginTransaction();
		
		 books = session.createQuery("from Books").list();
		
		
			tx.commit();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return books;

	}

	@Override
	public Book findById(int theId) {
		Book book = new Book();
		try {
			
			Transaction tx = (Transaction) session.beginTransaction();
			// select * from Book where id = id;
			 book = session.get(Book.class, theId);
			
			
				tx.commit();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RollbackException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return book;

	}

	@Override
	public void save(Book book) {
		try {
			
			Transaction tx = (Transaction) session.beginTransaction();
			// select * from Book where id = id;
			//insert into Book values(book object values)
			 session.saveOrUpdate(book);
			
			
				tx.commit();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RollbackException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 

		
	}

	@Override
	public void deleteById(int theId) {
		try {
			
			Transaction tx = (Transaction) session.beginTransaction();
			// select * from Book where id = id;
			//insert into Book values(book object values)
			Book book = session.get(Book.class,theId);
			 session.delete(book);
			
			
				tx.commit();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RollbackException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  

		
	}

	@Override
	public List<Book> searchById(String name, String author) {
		
		List <Book> books = new ArrayList<Book>();
		try {
			
			Transaction tx = (Transaction) session.beginTransaction();
			// select * from Book where id = id;
			//insert into Book values(book object values)
			String query = "";
			if(name.length()!=0 && author.length()!=0) {
				
				query = "from book where name like '%"+author+"%'";
				
			}else if(name.length()!=0) {
				query = "from book where nam like '%"+name+"%'";
			}else if(author.length()!=0) {
				query = "from book where author like '%"+author+"%'" ;
			}else {
				System.out.println("Cannot Search without input");
			}
			
			
		 	
				tx.commit();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RollbackException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		
		 
		return books;

	}
	
}
