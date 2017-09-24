package au.gov.dva.test.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class ClaimMapper implements ResultSetMapper<Claim>{

	public Claim map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		Claim c = new Claim();
		c.setId(r.getInt("id"));
		c.setDescription(r.getString("description"));
		c.setAmount(r.getFloat("amount"));
		c.setClaimDate(r.getTimestamp("claim_date"));
		return c;
	}

}
