package com.epam.liavitskaya.main.dao;

import java.util.List;

import com.epam.liavitskaya.main.bean.Book;

public interface BookDAO {

	void addBook();
	void editBookDescription();
	List<Book> bookFondReview();
	void changeBookStatus();
	void deleteBook();
	void delete();
}
