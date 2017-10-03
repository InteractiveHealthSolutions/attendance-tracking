package com.ihs.ats.model.dao;

import java.util.List;

import com.ihs.ats.api.Attendance;
import com.ihs.ats.api.WorkGroupMapper;

public interface DAOAttendance extends DAO{

	Number LAST_QUERY_TOTAL_ROW_COUNT();
	
	List<Attendance> findByWorkGroupId (int workGroupId);

	List<Attendance> findById(int mappedId);
	List<Attendance> findByIdAndGrouped(int IdMapper,int workGroupId );
	List<Attendance> getAttendancebyMonthAndYearAndWorkGroup (String month, String Year, int workGroupTypeId);

	List<Attendance> getAttendancebyMonthAndYear(String month, String Year);
	List<Attendance> getAllAttendance (boolean isreadonly, int firstResult, int fetchsize, String[] mappingsToJoin);

	List<Attendance> getAttendancebyMonthAndYearAndId(String month, String Year, int mappedId);
	
	
}
