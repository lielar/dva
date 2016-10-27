package au.nla.test.db.dao;

import au.nla.test.db.Borrower;

public interface BorrowedDao  extends CrudDao<Borrower> {

	public Borrower findByUser(int userId);
	
}
