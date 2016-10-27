/**
 * 
 */
package au.nla.test.db.dao;

import java.util.List;

import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import au.nla.test.db.Borrower;
import au.nla.test.db.BorrowerMapper;

/**
 * @author patrick
 *
 */
public class BorrowedDaoImpl implements BorrowedDao {

	BorrowerDao dao;
	
	public BorrowedDaoImpl() {
		init(new JdbiHelper().getDBI());
	}

	private void init(DBI dbi) {
		dao = dbi.onDemand(BorrowerDao.class);
	}
	
	/* (non-Javadoc)
	 * @see au.nla.test.db.dao.CrudDao#get(int)
	 */
	@Override
	public Borrower get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see au.nla.test.db.dao.CrudDao#count()
	 */
	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see au.nla.test.db.dao.CrudDao#exists(java.lang.Long)
	 */
	@Override
	public boolean exists(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see au.nla.test.db.dao.CrudDao#save(java.lang.Object)
	 */
	@Override
	public Borrower save(Borrower instance) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see au.nla.test.db.dao.CrudDao#delete(int)
	 */
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see au.nla.test.db.dao.CrudDao#list()
	 */
	@Override
	public List<Borrower> list() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see au.nla.test.db.dao.BorrowedDao#findByUser(int)
	 */
	@Override
	public Borrower findByUser(int userId) {
		// TODO Auto-generated method stub
		return dao.findByUser(userId);
	}
	
	@RegisterMapper(BorrowerMapper.class)
	interface BorrowerDao {
		
		@SqlQuery("select * from borrowers where user_id= :user_id")
		Borrower findByUser(@Bind("user_id") int userId);
		
	}
	

}
