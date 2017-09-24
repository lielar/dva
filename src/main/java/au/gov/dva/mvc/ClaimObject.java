package au.gov.dva.mvc;

public class ClaimObject {

	int id;

	String description;

	float amount;

	UserViewObject user;
	
	String claimDate;

	public String getClaimDate() {
		return claimDate;
	}

	public void setClaimDate(String claimDate) {
		this.claimDate = claimDate;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getAmount() {
		return this.amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public UserViewObject getUser() {
		return this.user;
	}

	public void setUser(UserViewObject user) {
		this.user = user;
	}



}
