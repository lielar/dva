/**
 * 
 */
package au.nla.test.db.dao;

import java.util.List;

import au.nla.test.db.User;

/**
 * @author patrick
 *
 */
public interface UserDao extends CrudDao<User> {
	List<User> findByName(String name);

	
}
