package com.ihs.ats.model.dao;

import java.util.List;

import com.ihs.ats.api.WorkGroup;
import com.ihs.ats.api.Attendance;
import com.ihs.ats.api.Leave;

public interface DAOLeave extends DAO{

	
	
	Number LAST_QUERY_TOTAL_ROW_COUNT();
	List<Leave>  findByLeaveId (int LeaveId);

	List<Leave > findByType(String leaveType);
	List<Leave> getLeavebyMonthAndYearAndUserId(String month, String Year, int UserId);
	List<Leave > getAllLeave (boolean isreadonly, int firstResult, int fetchsize, String[] mappingsToJoin);

}