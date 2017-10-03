package com.ihs.ats.model.dao;

import java.util.Date;
import java.util.List;

import com.ihs.ats.api.PublicHoliday;
import com.ihs.ats.api.Tracking;
import com.ihs.ats.api.*;

public interface DAOPublicHoliday extends DAO {
	
	Number LAST_QUERY_TOTAL_ROW_COUNT();
	
	List<PublicHoliday> findByType(String type);

	List<PublicHoliday> findByDate(Date date);
	
	List<PublicHoliday> findById(String Id);
	
	List<PublicHoliday> getAllPublicHolidays (boolean isreadonly, int firstResult, int fetchsize, String[] mappingsToJoin);

}
