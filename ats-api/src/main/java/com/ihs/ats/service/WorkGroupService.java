package com.ihs.ats.service;

import java.io.Serializable;
import java.util.List;

import com.ihs.ats.api.WorkGroup;
import com.ihs.ats.api.WorkGroupMapper;
import com.ihs.ats.api.WorkGroupType;

public interface WorkGroupService {

	Serializable save(WorkGroupType workGroup);

	void update(WorkGroupType workGroup);
	
	WorkGroupType findByWorkGroupTypeId (int findByWorkGroupTypeId);
	
	WorkGroupType findByName(String workGroupName);
		
	List<WorkGroupType> getAllworkGroup (boolean isreadonly, int firstResult, int fetchsize, String[] mappingsToJoin);
	
	Serializable saveWorkGroupMapper(WorkGroupMapper workGroupMapper);

	void updateWorkGroupMapper(WorkGroupMapper workGroupMapper);
	
	WorkGroupMapper findByworkGroupId (int workGroupId);
	
	WorkGroupMapper findByUserId(int idMapper);
		
	List<WorkGroupMapper> getAllWorkGroupMapper (boolean isreadonly, int firstResult, int fetchsize, String[] mappingsToJoin);
	

	
	Serializable saveWorkGroup(WorkGroup workGroup );

	void updateWorkGroup(WorkGroup workGroup);
	
	WorkGroup findDetailsByworkGroupId (int workGroupId);
	
	List<WorkGroup> getAllWorkGroupByTypeId (int workGroupTypeId);

		
	List<WorkGroup> getAllWorkGroup (boolean isreadonly, int firstResult, int fetchsize, String[] mappingsToJoin);
	
	
	
	
	
}
