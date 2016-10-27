/**
 * 
 */
package au.nla.test.cases;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import au.nla.test.db.User;
import au.nla.test.db.dao.UserDao;
import au.nla.test.db.dao.UserDaoImpl;

/**
 * @author patrick
 *
 */
@ActiveProfiles("dev")
@ContextConfiguration(locations = {"classpath:au/nla/test/config/datasource.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class UserTest {
	
	private static UserDao userDao;

	@Before
	public void init() {
		userDao = new UserDaoImpl();
	}


	@Test
	public void testAllUsers() {
		List<User> list = userDao.list();
		assertFalse("List should not be empty", list.isEmpty());
		assertTrue("List should be 4", list.size() == 4);
	}
	
	@Test
	public void testFirstUser() {
		User user = userDao.get(1);
		assertNotNull("user should not be null", user);
		assertEquals("user should be the Albert", "Albert Sinclair", user.getName());
	}
	
	@Test
	public void testFindByName() {
		List<User> users = userDao.findByName("Smith");
		assertFalse("users should not be empty", users.isEmpty());
		assertTrue("users should have only 1", users.size() == 1);
		assertEquals("users should be Samuel Smith", "Samuel Smith", users.get(0).getName());
	}
	
	
}
