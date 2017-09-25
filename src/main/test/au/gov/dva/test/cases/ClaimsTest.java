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

import au.gov.dva.test.db.Claim;
import au.gov.dva.test.db.UserDB;
import au.gov.dva.test.db.dao.ClaimDao;
import au.gov.dva.test.db.dao.ClaimDaoImpl;
import au.gov.dva.test.db.dao.UserDao;
import au.gov.dva.test.db.dao.UserDaoImpl;


/**
 * @author patrick
 *
 */
@ActiveProfiles("dev")
@ContextConfiguration(locations = {"classpath:au/gov/dva/test/cases/config/datasource.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class ClaimsTest {
	private static ClaimDao claimDao;
	
	private static UserDao userDao;

	@Before
	public void init() {
		claimDao = new ClaimDaoImpl();
		userDao = new UserDaoImpl();
	}
	
	
	@Test
	public void loadFirstClaim() {
		Claim claim = claimDao.get(1);
		assertNotNull(claim);
		assertEquals("Description should be the same", "Claim 1", claim.getDescription());
	}
	
	@Test
	public void loadAllClaims() {
		List<Claim> list = claimDao.list();
		assertFalse("list should not be empty", list.isEmpty());
		assertTrue("list should have 5", list.size() == 5);
	}
	
	@Test
	public void loadByDescription() {
		List<Claim> titles = claimDao.findByDescription("Claim 5");
		assertFalse("list should not be empty", titles.isEmpty());
		assertTrue("list should be 1", titles.size() == 1);
	}
	
	@Test
	public void testClaimByUser() {
		UserDB u = userDao.get(1);
		List<Claim> claims = claimDao.findClaimsByUser(u);
		assertFalse("Borrowed books should not be empty", claims.isEmpty());
		assertTrue("Should be 2", claims.size() == 2);
	}

	
}
