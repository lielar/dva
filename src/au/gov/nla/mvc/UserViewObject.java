package au.gov.nla.mvc;

import java.util.List;

import au.nla.test.db.Book;
import au.nla.test.db.Borrower;
import au.nla.test.db.User;

public class UserViewObject {

	private User user;
	
	private List<Book> booksBorrowed;
	
	private List<Borrower> borrowed;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Book> getBooksBorrowed() {
		return booksBorrowed;
	}

	public void setBooksBorrowed(List<Book> booksBorrowed) {
		this.booksBorrowed = booksBorrowed;
	}

	public List<Borrower> getBorrowed() {
		return borrowed;
	}

	public void setBorrowed(List<Borrower> borrowed) {
		this.borrowed = borrowed;
	}
	
}
