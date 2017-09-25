/**
 * 
 */
package au.gov.dva.test.cases;


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

import au.gov.dva.test.db.UserDB;
import au.gov.dva.test.db.dao.UserDaoImpl;
import au.gov.dva.test.db.dao.UserDao;

/**
 * @author patrick
 *
 */
@ActiveProfiles("dev")
@ContextConfiguration(locations = {"classpath:au/gov/dva/test/cases/config/datasource.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class UserTest {
	
	private static UserDao userDao;

	@Before
	public void init() {
		userDao = new UserDaoImpl();
	}


	@Test
	public void testAllUsers() {
		List<UserDB> list = userDao.list();
		assertFalse("List should not be empty", list.isEmpty());
		assertTrue("List should be 4", list.size() == 4);
	}
	
	@Test
	public void testFirstUser() {
		UserDB user = userDao.get(1);
		assertNotNull("user should not be null", user);
		assertEquals("user should be the Albert", "Albert Sinclair", user.getName());
	}
	
	@Test
	public void testFindByName() {
		List<UserDB> users = userDao.findByName("Smith");
		assertFalse("users should not be empty", users.isEmpty());
		assertTrue("users should have only 1", users.size() == 1);
		assertEquals("users should be Samuel Smith", "Samuel Smith", users.get(0).getName());
	}
	
	
}
