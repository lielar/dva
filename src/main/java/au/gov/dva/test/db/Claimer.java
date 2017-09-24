package au.gov.dva.test.db;

import java.util.Date;

import au.gov.dva.User;

public class Claimer {

	int id;

	Claim claim;

	User user;

	Date claimDate;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Claim getClaim() {
		return claim;
	}

	public void setClaim(Claim claim) {
		this.claim = claim;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getClaimDate() {
		return claimDate;
	}

	public void setClaimDate(Date claimDate) {
		this.claimDate = claimDate;
	}

}
