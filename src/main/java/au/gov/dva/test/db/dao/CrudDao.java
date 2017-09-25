package au.gov.dva.test.db.dao;

import java.util.List;

/**
 * A generic CRUD interface for DAO's.
 *
 * @author Per Spilling
 */
public interface CrudDao<T> {
    T get(int id);

    int count();

    boolean exists(Long id);

    T save(T instance);

    void delete(int id);
    
    List<T> list();
}
