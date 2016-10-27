package au.nla.test.db.dao;

public interface TableCreator {
    void createTable();
    void dropTable();
    void resetTable();
}
