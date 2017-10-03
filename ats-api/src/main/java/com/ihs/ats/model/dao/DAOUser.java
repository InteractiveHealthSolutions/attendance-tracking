package com.ihs.ats.model.dao;

import java.util.List;

import com.ihs.ats.api.User;

public interface DAOUser extends DAO {
	Number LAST_QUERY_TOTAL_ROW_COUNT();
	
	User findById (int personId);
	
	List<User> getAllUser(boolean isreadonly, int firstResult, int fetchsize, String[] mappingsToJoin);
	
	List<User> getAllPersons ();
	
	User findById(int personId, boolean isreadonly, String[] mappingsToJoin);
	
	List<User> getAllUser (boolean isreadonly, String[] mappingsToJoin);

/*	Person findPersonByIdentifier(String programId, boolean isreadonly, String[] mappingsToJoin);
		
	List<Person> getPersonByRole (String roleID,boolean isreadonly, String[] mappingsToJoin);
*/
}
