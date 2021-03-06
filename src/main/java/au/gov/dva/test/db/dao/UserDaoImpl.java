/**
 * 
 */
package au.gov.dva.test.db.dao;

import java.util.List;

import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import au.gov.dva.test.db.UserMapper;
import au.gov.dva.test.db.UserDB;


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
	public UserDB get(int id) {
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
	public UserDB save(UserDB instance) {
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
	public List<UserDB> list() {
		return userDao.list();
	}

	/* (non-Javadoc)
	 * @see au.nla.test.db.dao.UserDao#findByName(java.lang.String)
	 */
	public List<UserDB> findByName(String name) {
		return userDao.listByName("%"+name+"%");
	}

	@RegisterMapper(UserMapper.class)
	interface UserDao {
		
		@SqlQuery("select * from users where id = :id")
		UserDB get(@Bind("id") int id);
		
		@SqlQuery("select * from users")
		List<UserDB> list();
		
		@SqlQuery("select * from users where name like :name")
		List<UserDB> listByName(@Bind("name") String name);
		
	}
	
	
}
