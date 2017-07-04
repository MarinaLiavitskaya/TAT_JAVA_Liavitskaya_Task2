package com.epam.liavitskaya.main.service;

import java.util.List;

import com.epam.liavitskaya.main.bean.Book;

public interface LibraryService {

	void addNewBookService(String request);                  //add
	void addEditedBookService(String request);         // edit
	List<Book> bookFondReviewService();      // select
	void orderBookService(String request);	          
	void editBookDescriptionService(String request);	// update set where
	void changeBookStatuServices(String request);       // update
	void deleteBookService(String request);			// delete
	
}
