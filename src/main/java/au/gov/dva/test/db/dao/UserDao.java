/**
 * 
 */
package au.gov.dva.test.db.dao;

import java.util.List;

import au.gov.dva.test.db.UserDB;




/**
 * @author patrick
 *
 */
public interface UserDao extends CrudDao<UserDB> {
	List<UserDB> findByName(String name);

	
}
