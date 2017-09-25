package au.gov.dva.test.db.dao;

public interface TableCreator {
    void createTable();
    void dropTable();
    void resetTable();
}
