package au.nla.test.db.dao;

import java.util.List;

import au.nla.test.db.Book;
import au.nla.test.db.User;

public interface BookDao extends CrudDao<Book>{

	List<Book> findByTitle(String name);
	
	List<Book> findBorrowedByUser(User user);
	
}
