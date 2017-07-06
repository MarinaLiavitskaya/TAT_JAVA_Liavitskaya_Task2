package com.epam.liavitskaya.main.bean;

import com.epam.liavitskaya.main.enums.BookStatus;

public class Book {

	private int bookId;
	private String title;
	private String author;
	private String description;
	private BookStatus bookStatus;
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBookStatus() {
		return bookStatus.name();
	}
	public void setBookStatus(String bookStatus) {
		this.bookStatus = BookStatus.valueOf(bookStatus);
	}
	
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", description=" + description + ", bookStatus="
				+ bookStatus + "]";
	}	
}
