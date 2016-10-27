/**
 * 
 */
package au.nla.test.db.dao;

import java.util.List;

import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import au.nla.test.db.Book;
import au.nla.test.db.BookMapper;
import au.nla.test.db.User;

/**
 * @author patrick
 *
 */
public class BookDaoImpl implements BookDao {

	private BookDao bookDao;

	public BookDaoImpl() {
		init(new JdbiHelper().getDBI());
	}

	private void init(DBI dbi) {
		bookDao = dbi.onDemand(BookDao.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see au.nla.test.db.dao.CrudDao#get(java.lang.Long)
	 */
	public Book get(int id) {
		return bookDao.get(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see au.nla.test.db.dao.CrudDao#count()
	 */
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see au.nla.test.db.dao.CrudDao#exists(java.lang.Long)
	 */
	public boolean exists(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see au.nla.test.db.dao.CrudDao#save(java.lang.Object)
	 */
	public Book save(Book instance) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Book> findBorrowedByUser(User u) {
		return bookDao.listBookByUsers(u.getId());
	}
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see au.nla.test.db.dao.BookDao#findByName(java.lang.String)
	 */
	public List<Book> findByTitle(String name) {
		return bookDao.getByTitle(name);
	}

	public List<Book> list() {
		return bookDao.list();
	}

	public void delete(int id) {
		
	}
	
	@RegisterMapper(BookMapper.class)
	interface BookDao {
		
		@SqlQuery("select * from books where id = :id")
		Book get(@Bind("id") int id);

		@SqlQuery("select * from books where title like :title")
		List<Book> getByTitle(@Bind("title") String title);
		
		@SqlQuery("select * from books")
		List<Book> list();
		
		@SqlQuery("select * from books where id in (select book_id from borrowers where user_id = :userId)")
		List<Book> listBookByUsers(@Bind("userId") int userId);
		
		
		
	}
}
