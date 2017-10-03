package com.ihs.ats.model.dao;

import java.util.List;

import com.ihs.ats.api.WorkGroupType;

public interface DAOWorkGroupType extends DAO {
		
		Number LAST_QUERY_TOTAL_ROW_COUNT();
		
		WorkGroupType findByWorkGroupTypeId (int workGroupTypeId);

		WorkGroupType findByName(String workGroupName);
		
		List<WorkGroupType> getAllWorkGroupType (boolean isreadonly, int firstResult, int fetchsize, String[] mappingsToJoin);
		

}
