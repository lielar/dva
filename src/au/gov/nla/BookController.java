package au.gov.nla;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import au.gov.nla.mvc.UserViewObject;
import au.nla.test.db.Book;
import au.nla.test.db.dao.BookDao;
import au.nla.test.db.dao.BookDaoImpl;
import au.nla.test.db.dao.UserDao;
import au.nla.test.db.dao.UserDaoImpl;
import au.nla.test.db.User;

@Controller
public class BookController {

	BookDao bookDao = new BookDaoImpl();
	UserDao userDao = new UserDaoImpl();
	
	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public String list(@ModelAttribute("model") ModelMap model) {
		List<Book> bookList = bookDao.list();
		
		model.addAttribute("booklist", bookList);
		
		return "books";
	}
	
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String listUsers(@ModelAttribute("model") ModelMap model) {
		List<User> usersList = userDao.list();
		List<UserViewObject> userObjects = new ArrayList<UserViewObject>();
		
		for (User user : usersList) {
			UserViewObject viewObject = new UserViewObject();
			viewObject.setUser(user);
			List<Book> booksBorrowed = bookDao.findBorrowedByUser(user);
			viewObject.setBooksBorrowed(booksBorrowed);
			userObjects.add(viewObject);
		}
		
		model.addAttribute("userlists", userObjects);
		
		return "users";
	}
	
	
}
