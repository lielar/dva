package au.nla.test.db.dao;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.h2.jdbcx.JdbcConnectionPool;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;

/**
 * @author Per Spilling
 */
public class JdbiHelper {
    public enum DbType {H2, Postgres}

    private DbType dbType;
    private DBI dbi;

    public JdbiHelper() {
        dbType = DbType.valueOf(DbProperties.DB_TYPE.val());
    }

    // used with Spring
    public JdbiHelper(DBI dbi) {
        this.dbi = dbi;
    }

    public DBI getDBI() {
        if (dbi != null) return dbi;

        if (dbType == DbType.H2) {
            JdbcConnectionPool jdbcConnectionPool =
                    JdbcConnectionPool.create(
                            DbProperties.DB_URL.val(),
                            DbProperties.DB_USERNAME.val(),
                            DbProperties.DB_PASSWORD.val());
            dbi = new DBI(jdbcConnectionPool);
        } else {
        	throw new IllegalArgumentException("Not supported");
        }
        return dbi;
    }

    /**
     * Return a handle suitable for use in a transaction operation, i.e. with
     * autoCommit = false.
     */
    public Handle getTxHandle() {
        Handle handle = getDBI().open();
        try {
            handle.getConnection().setAutoCommit(false);
        } catch (SQLException e) {
            throw new IllegalStateException("Caught an SQLException. errorCode=" + e.getErrorCode());
        }
        return handle;
    }

    public void createTableIfNotExist(String tableName, String createTableSql) {
        try {
            DBI dbi = getDBI();
            DatabaseMetaData dbm = dbi.open().getConnection().getMetaData();
            ResultSet tables = dbm.getTables(null, null, tableName, null);
            if (!tables.next()) {
                Handle handle = dbi.open();
                handle.execute(createTableSql);
                handle.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropTableIfExist(String tableName) {
        DBI dbi = getDBI();
        Handle handle = dbi.open();
        if (dbType == DbType.H2) {
            handle.createCall("DROP TABLE " + tableName + " IF EXISTS CASCADE").invoke();
        } else {
            handle.createCall("DROP TABLE IF EXISTS " + tableName + " CASCADE").invoke();
        }
    }

    public void resetTable(String tableName, String createTableSql) {
        DBI dbi = getDBI();
        Handle handle = dbi.open();
        if (dbType == DbType.H2) {
            handle.createCall("DROP TABLE " + tableName + " IF EXISTS CASCADE").invoke();
        } else {
            handle.createCall("DROP TABLE IF EXISTS " + tableName + " CASCADE").invoke();
        }
        handle.execute(createTableSql);
        handle.close();
    }
}
