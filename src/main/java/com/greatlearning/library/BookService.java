package com.greatlearning.library;

import java.util.List;

public interface BookService {
	
	public List<Book> findAll();
	
	public Book findById(int theId);
	
	public void save(Book book);
	
	public void deleteById(int theId);
	
	public List<Book> searchById(String name ,String author);
	

}
