package com.business;

import java.util.List;

import com.model.Book;
import com.model.Category;

/**
 * @author 作者：roll27
 * @version 创建时间：2017年11月7日上午10:01:41 类说明
 */
public interface BookService {

	public List<Category> getAllCategories();

	public Category getCategory(int id);

	public List<Book> getAllBooks();

	public Book save(Book book);
	
	public Book update(Book book);

	public Book get(long id);

	public long getNextId();
}
