package au.gov.dva;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import au.gov.dva.mvc.UserViewObject;
import au.gov.dva.test.db.UserDB;
import au.gov.dva.test.db.dao.ClaimDao;
import au.gov.dva.test.db.dao.ClaimDaoImpl;
import au.gov.dva.test.db.dao.UserDao;
import au.gov.dva.test.db.dao.UserDaoImpl;
import au.gov.dva.test.db.Claim;


@Controller
public class ClaimController {

	ClaimDao claimDao = new ClaimDaoImpl();
	UserDao userDao = new UserDaoImpl();

	@RequestMapping(value = "/claims", method = RequestMethod.GET)
	public String list(@ModelAttribute("model") ModelMap model) {
		List<Claim> claimList = claimDao.list();

		model.addAttribute("claimList", claimList);

		return "claims";
	}


	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String listUsers(@ModelAttribute("model") ModelMap model) {
		List<UserDB> usersList = userDao.list();
		List<UserViewObject> userObjects = new ArrayList<UserViewObject>();

		for (UserDB user : usersList) {
			UserViewObject viewObject = new UserViewObject();
			viewObject.setUser(user);
			List<Claim> claimsByUser = claimDao.findClaimsByUser(user);
			viewObject.setClaims(claimsByUser);
			userObjects.add(viewObject);
		}

		model.addAttribute("userlists", userObjects);

		return "users";
	}


}
