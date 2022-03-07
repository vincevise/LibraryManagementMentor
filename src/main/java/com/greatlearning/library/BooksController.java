package com.greatlearning.library;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/books")
public class BooksController {
	@Autowired
	private BookService bookService;
	
	//http://localhost:8080/LibraryManagementMentor/books/list
	@RequestMapping("/list")
	public String listBooks(Model theModel) {
		
		List <Book> books = bookService.findAll();
		theModel.addAttribute("Books",books);
		return "list-Books";
		
	}
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Book theBook = new Book();
		
		theModel.addAttribute("Books",theBook);
		return "Book-form";
	}
	
	@RequestMapping("/save")
	public String saveBook(@RequestParam("id") int id,
			@RequestParam("name") String name,
			@RequestParam("category") String category,
			@RequestParam("author") String author) 
	
	{
		
		System.out.println(id);
		Book theBook;
		if(id!=0) {
			
			theBook = bookService.findById(id);
			theBook.setName(name);
			theBook.setCategory(category);
			theBook.setAuthor(author);
			
		}else {
			theBook = new Book(name,category,author);
		
		}
		bookService.save(theBook);
				return "redirect:/books/list";
		
	}
	
	@RequestMapping("/delete")
	public String deleteBook(@RequestParam("bookId") int id) {
			bookService.deleteById(id);
			return " redirect:/books/list";
	}
	
	@RequestMapping("/search")
	public String SearchBook(@RequestParam("name") String name,@RequestParam("author") String author,Model theModel) {
		if(name.trim().isEmpty() && author.trim().isEmpty()) {
			return "redirect:/books/list";
		}else {
			List <Book> books = bookService.searchById(name, author);
			theModel.addAttribute("Books",books);
			return "list-Books";
		}
				
	}
	
}
