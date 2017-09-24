/**
 * 
 */
package au.gov.dva.test.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import au.gov.dva.test.db.UserDB;

/**
 * @author patrick
 *
 */
public class UserMapper implements ResultSetMapper<UserDB> {

	public UserDB map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		UserDB u = new UserDB();
		u.setId(r.getInt("id"));
		u.setName(r.getString("name"));
		u.setPhone(r.getString("phone"));
		u.setEmail(r.getString("email"));
		return u;
	}

}
