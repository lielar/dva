/**
 * 
 */
package au.gov.nla.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import au.gov.nla.mvc.BookBorrowedObject;
import au.nla.test.db.Book;
import au.nla.test.db.Borrower;
import au.nla.test.db.User;
import au.nla.test.db.dao.BookDao;
import au.nla.test.db.dao.BookDaoImpl;
import au.nla.test.db.dao.BorrowedDao;
import au.nla.test.db.dao.BorrowedDaoImpl;
import au.nla.test.db.dao.UserDao;
import au.nla.test.db.dao.UserDaoImpl;

/**
 * @author patrick
 *
 */
@RestController
public class BookRestController {

	BookDao bookDao = new BookDaoImpl();
	UserDao userDao = new UserDaoImpl();
	BorrowedDao borrowerDao = new BorrowedDaoImpl();
	
	
	@GetMapping(value="/booksquery/{id}", produces="application/json")
	@ResponseBody
	public Book retrieveBook(@PathVariable(value="id") int id) {
		Book book = bookDao.get(id); 
		
		return book;
	}
	
	@GetMapping(value="/booksquery", headers="Accept=*/*", produces="application/json")
	@ResponseBody
	public List<Book> list() {
		return bookDao.list();
	}
	
	
	@GetMapping(value="/booksquery/userquery/{userId}", headers="Accept=*/*", produces="application/json")
	@ResponseBody
	public List<BookBorrowedObject> retrieveBookForUser(@PathVariable(value="userId") int userId) {
		User u = userDao.get(userId);
		List<Book> borrowed = bookDao.findBorrowedByUser(u);
		
		List<BookBorrowedObject> list = new ArrayList<BookBorrowedObject>();
		
		for (Book book : borrowed) {
			BookBorrowedObject b = new BookBorrowedObject();
			Borrower borrower = borrowerDao.findByUser(userId);
			b.setAuthor(book.getAuthor());
			b.setIsbn(book.getIsbn());
			b.setTitle(book.getTitle());
			b.setBorrowedDate(borrower.getBorrowedDate());
			b.setDueDate(borrower.getDueDate());
			list.add(b);
		}
		
		
		return list;
	}
	
	
	
	
}
