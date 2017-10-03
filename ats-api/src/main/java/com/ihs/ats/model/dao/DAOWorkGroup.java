package com.ihs.ats.model.dao;

import java.util.List;

import com.ihs.ats.api.WorkGroup;
import com.ihs.ats.api.WorkGroupMapper;

public interface DAOWorkGroup extends DAO {


	Number LAST_QUERY_TOTAL_ROW_COUNT();
	
	WorkGroup findByWorkGroupId (int workGroupId);

	List<WorkGroup> findByDay(String day);
	
	List<WorkGroup> getAllWorkGroup (boolean isreadonly, int firstResult, int fetchsize, String[] mappingsToJoin);
	 List<WorkGroup> getAllWorkGroupByTypeId(int workGroupTypeId);
	
	
}
