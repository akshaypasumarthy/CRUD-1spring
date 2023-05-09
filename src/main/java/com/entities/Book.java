package com.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book {
	
	@Override
	public String toString() {
		return "Book [bookcode=" + bookcode + ", bookname=" + bookname + ", author=" + author + ", date=" + date + "]";
	}
	public Book() {
		
	}
	public Book(int bookcode, String bookname, String author, String date) {
		super();
		this.bookcode = bookcode;
		this.bookname = bookname;
		this.author = author;
		this.date = date;
	}
	public Book(int bookcode2) {
		// TODO Auto-generated constructor stub
	}
	public int getBookcode() {
		return bookcode;
	}
	public void setBookcode(int bookcode) {
		this.bookcode = bookcode;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	int bookcode;
	String bookname;
	String author;
	String date;

}
