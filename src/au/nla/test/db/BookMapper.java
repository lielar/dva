package au.nla.test.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class BookMapper implements ResultSetMapper<Book>{

	public Book map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		Book b = new Book();
		
		b.setId(r.getInt("id"));
		b.setTitle(r.getString("title"));
		b.setAuthor(r.getString("author"));
		b.setIsbn(r.getString("isbn"));
		return b;
	}

}
