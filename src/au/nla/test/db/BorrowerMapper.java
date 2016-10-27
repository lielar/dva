/**
 * 
 */
package au.nla.test.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

/**
 * @author patrick
 *
 */
public class BorrowerMapper implements ResultSetMapper<Borrower> {

	public Borrower map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		Borrower b = new Borrower();
		b.setId(r.getInt("id"));
		b.setBookId(r.getInt("book_id"));
		b.setUserId(r.getInt("user_id"));
		b.setBorrowedDate(r.getDate("borrowed_date"));
		b.setDueDate(r.getDate("due_date"));
		
		return b;
	}

}
