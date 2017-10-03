package com.ihs.ats.model.dao;

import java.util.List;

import com.ihs.ats.api.WorkGroupMapper;
import com.ihs.ats.api.WorkGroupType;

public interface DAOWorkGroupMapper extends DAO {

	Number LAST_QUERY_TOTAL_ROW_COUNT();
	
	WorkGroupMapper findByWorkGroupId (int workGroupId);

	WorkGroupMapper findByUserId(int IdMapper);
	
	List<WorkGroupMapper> getAllWorkGroupMapper (boolean isreadonly, int firstResult, int fetchsize, String[] mappingsToJoin);
	
}
