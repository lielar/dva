/**
 * 
 */
package au.dva.test.db.dao;

import java.util.List;

import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import au.gov.dva.test.db.Claim;
import au.gov.dva.test.db.ClaimMapper;
import au.gov.dva.test.db.UserDB;

/**
 * @author patrick
 *
 */
public class ClaimDaoImpl implements ClaimDao {

	private ClaimDao claimDao;

	public ClaimDaoImpl() {
		init(new JdbiHelper().getDBI());
	}

	private void init(DBI dbi) {
		claimDao = dbi.onDemand(ClaimDao.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see au.nla.test.db.dao.CrudDao#get(java.lang.Long)
	 */
	public Claim get(int id) {
		return claimDao.get(id);
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
	 * @see au.dva.test.db.dao.CrudDao#save(java.lang.Object)
	 */
	public Claim save(Claim instance) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see au.dva.test.db.dao.BookDao#findByName(java.lang.String)
	 */
	public List<Claim> findByDescription(String name) {
		return claimDao.getByDescription(name);
	}

	public List<Claim> list() {
		return claimDao.list();
	}

	public void delete(int id) {
		
	}
	
	@RegisterMapper(ClaimMapper.class)
	interface ClaimDao {
		
		@SqlQuery("select * from claims where id = :id")
		Claim get(@Bind("id") int id);

		@SqlQuery("select * from claims where descripiton like :description")
		List<Claim> getByDescription(@Bind("description") String description);
		
		@SqlQuery("select * from claims")
		List<Claim> list();
		
		@SqlQuery("select * from claims where id = :id")		
		List<Claim> findByClaim(@Bind("id") int id);
		
		@SqlQuery("select * from claims where user_id = :userId")		
		List<Claim> findClaimsByUser(@Bind("userId") int userId);
	}

	@Override
	public List<Claim> findByClaim(int claimId) {
		return claimDao.findByClaim(claimId);
	}

	@Override
	public List<Claim> findClaimsByUser(UserDB user) {
		return claimDao.findClaimsByUser(user.getId());
	}
}
