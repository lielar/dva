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
public class UserMapper implements ResultSetMapper<User> {

	public User map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		User u = new User();
		u.setId(r.getInt("id"));
		u.setName(r.getString("name"));
		u.setPhone(r.getString("phone"));
		u.setEmail(r.getString("email"));
		return u;
	}

}
