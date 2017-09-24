/**
 *
 */
package au.gov.dva.rest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import au.gov.dva.mvc.ClaimObject;
import au.gov.dva.mvc.UserViewObject;
import au.gov.dva.test.db.UserDB;
import au.gov.dva.test.db.Claim;
import au.dva.test.db.dao.ClaimDao;
import au.dva.test.db.dao.ClaimDaoImpl;
import au.dva.test.db.dao.UserDao;
import au.dva.test.db.dao.UserDaoImpl;

/**
 * @author patrick
 *
 */
@RestController
public class ClaimRestController {

	ClaimDao claimDao = new ClaimDaoImpl();
	UserDao userDao = new UserDaoImpl();


	@GetMapping(value="/claimsquery/{id}", produces="application/json")
	@ResponseBody
	public Claim retrieveClaim(@PathVariable(value="id") int id) {
		Claim claim = claimDao.get(id);

		return claim;
	}

	@GetMapping(value="/claimsquery", headers="Accept=*/*", produces="application/json")
	@ResponseBody
	public List<Claim> list() {
		return claimDao.list();
	}


	@GetMapping(value="/claimsquery/userquery/{userId}", headers="Accept=*/*", produces="application/json")
	@ResponseBody
	public List<ClaimObject> retrieveClaimForUser(@PathVariable(value="userId") int userId) {
		UserDB u = userDao.get(userId);
		List<Claim> claims = claimDao.findClaimsByUser(u);
		UserViewObject vObj = getUserViewObject(u);

		List<ClaimObject> list = new ArrayList<ClaimObject>();

		for (Claim claim : claims) {
			ClaimObject c = new ClaimObject();
			c.setUser(vObj);
			c.setAmount(claim.getAmount());
			c.setDescription(claim.getDescription());
			c.setId(claim.getId());
			c.setClaimDate(getDateString(claim.getClaimDate()));
			list.add(c);
		}


		return list;
	}


	protected UserViewObject getUserViewObject(UserDB user) {
		UserViewObject vObj = new UserViewObject();
		vObj.setUser(user);
		return vObj;
	}

	
	protected String getDateString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMMMMM yyyy");
		return sdf.format(date);
	}

}
