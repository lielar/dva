package au.gov.dva.test.db.dao;

import java.util.List;

import au.gov.dva.test.db.Claim;
import au.gov.dva.test.db.UserDB;

public interface ClaimDao extends CrudDao<Claim>{

	List<Claim> findByClaim(int claimId);

	List<Claim> findClaimsByUser(UserDB user);
	
	List<Claim> findByDescription(String description);

}
