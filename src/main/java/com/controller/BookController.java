package com.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.business.BookService;
import com.model.Book;
import com.model.Category;

/**
 * @author 作者：roll27
 * @version 创建时间：2017年11月7日上午10:00:56
 * 类说明
 */

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	private static final Log logger = LogFactory.getLog(BookController.class);
	
	@RequestMapping(value = "/book_input")
	public String inputBook(Model model){
		List<Category> categories = this.bookService.getAllCategories();
		model.addAttribute("categories", categories);
		model.addAttribute("book", new Book());
		return "BookAddForm";
	}
	
	@RequestMapping(value = "/book_edit/{id}")
	public String editBook(Model model,@PathVariable long id){
		List<Category> categories = bookService.getAllCategories();
		model.addAttribute("categories", categories);
		Book book = bookService.get(id);
		model.addAttribute("book", book);
		return "BookEditForm";
	}
	
	@RequestMapping(value = "/book_save")
	public String saveBook(@ModelAttribute Book book){
		Category category = bookService.getCategory(book.getCategory().getId());
		book.setCategory(category);
		bookService.save(book);
		return "redirect:/book_list";
	}
	
	@RequestMapping(value = "/book_update")
	public String updateBook(@ModelAttribute Book book){
		Category category = bookService.getCategory(book.getCategory().getId());
		book.setCategory(category);
		logger.info("id:"+book.getId()+"/n isbn:"+book.getIsbn());
		bookService.update(book);
		return "redirect:/book_list";
	}
	
	@RequestMapping(value = "/book_list")
	public String listBooks(Model model){
		logger.info("book_list");
		List<Book> books = bookService.getAllBooks();
		model.addAttribute("books",books);
		return "BookList";
	}
	
	
}
