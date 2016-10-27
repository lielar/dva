/**
 * 
 */
package au.nla.test.cases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import au.nla.test.db.Book;
import au.nla.test.db.User;
import au.nla.test.db.dao.BookDao;
import au.nla.test.db.dao.BookDaoImpl;
import au.nla.test.db.dao.UserDao;
import au.nla.test.db.dao.UserDaoImpl;

/**
 * @author patrick
 *
 */
@ActiveProfiles("dev")
@ContextConfiguration(locations = {"classpath:au/nla/test/config/datasource.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class BookTest {
	private static BookDao bookDao;
	
	private static UserDao userDao;

	@Before
	public void init() {
		bookDao = new BookDaoImpl();
		userDao = new UserDaoImpl();
	}
	
	
	@Test
	public void loadFirstUser() {
		Book book = bookDao.get(1);
		assertNotNull(book);
		assertEquals("Name should be the same", "Stephen King", book.getAuthor());
	}
	
	@Test
	public void loadAllUsers() {
		List<Book> list = bookDao.list();
		assertFalse("list should not be empty", list.isEmpty());
		assertTrue("list should have 5", list.size() == 5);
	}
	
	@Test
	public void loadByTitle() {
		List<Book> titles = bookDao.findByTitle("%of%");
		assertFalse("list should not be empty", titles.isEmpty());
		assertTrue("list should be 2", titles.size() == 2);
	}
	
	@Test
	public void testBorrowedBooks() {
		User u = userDao.get(3);
		List<Book> books = bookDao.findBorrowedByUser(u);
		assertFalse("Borrowed books should not be empty", books.isEmpty());
		assertTrue("Should be 3", books.size() == 3);
	}

	
}
