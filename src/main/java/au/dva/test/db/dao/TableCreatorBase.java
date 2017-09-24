/**
 * 
 */
package au.dva.test.db.dao;

/**
 * @author patrick
 *
 */
public class TableCreatorBase implements TableCreator {
    protected JdbiHelper jdbiHelper;
    private String tableName;
    private String createTableSql;

    public TableCreatorBase(String tableName, String createTableSql) {
        this.tableName = tableName;
        this.createTableSql = createTableSql;
        this.jdbiHelper = new JdbiHelper();
    }

    public void createTable() {
        jdbiHelper.createTableIfNotExist(tableName, createTableSql);
    }

    public void dropTable() {
        jdbiHelper.dropTableIfExist(tableName);
    }

    public void resetTable() {
        jdbiHelper.resetTable(tableName, createTableSql);
    }
}
