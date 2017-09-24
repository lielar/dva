package au.gov.dva.mvc;

import java.util.List;

import au.gov.dva.test.db.Claim;
import au.gov.dva.test.db.UserDB;


public class UserViewObject {

	private UserDB user;

	private List<Claim> claims;

	public UserDB getUser() {
		return user;
	}

	public void setUser(UserDB user) {
		this.user = user;
	}

	public List<Claim> getClaims() {
		return this.claims;
	}

	public void setClaims(List<Claim> claims) {
		this.claims = claims;
	}

}
