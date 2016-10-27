/**
 * 
 */
package au.nla.test.db.dao;

import java.util.List;

import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import au.nla.test.db.User;
import au.nla.test.db.UserMapper;

/**
 * @author patrick
 *
 */
public class UserDaoImpl implements UserDao {

	private UserDao userDao;
	
	

	public UserDaoImpl() {
		init(new JdbiHelper().getDBI());
	}

	private void init(DBI dbi) {
		userDao = dbi.onDemand(UserDao.class);
	}
	
	/* (non-Javadoc)
	 * @see au.nla.test.db.dao.CrudDao#get(int)
	 */
	public User get(int id) {
		return userDao.get(id);
	}

	/* (non-Javadoc)
	 * @see au.nla.test.db.dao.CrudDao#count()
	 */
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see au.nla.test.db.dao.CrudDao#exists(java.lang.Long)
	 */
	public boolean exists(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see au.nla.test.db.dao.CrudDao#save(java.lang.Object)
	 */
	public User save(User instance) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see au.nla.test.db.dao.CrudDao#delete(int)
	 */
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see au.nla.test.db.dao.CrudDao#list()
	 */
	public List<User> list() {
		return userDao.list();
	}

	/* (non-Javadoc)
	 * @see au.nla.test.db.dao.UserDao#findByName(java.lang.String)
	 */
	public List<User> findByName(String name) {
		return userDao.listByName("%"+name+"%");
	}

	@RegisterMapper(UserMapper.class)
	interface UserDao {
		
		@SqlQuery("select * from users where id = :id")
		User get(@Bind("id") int id);
		
		@SqlQuery("select * from users")
		List<User> list();
		
		@SqlQuery("select * from users where name like :name")
		List<User> listByName(@Bind("name") String name);
		
	}
	
	
}
