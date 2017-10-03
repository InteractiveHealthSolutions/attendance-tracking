package com.ihs.ats.model.dao;

import java.util.Date;
import java.util.List;


import com.ihs.ats.api.Tracking;

public interface DAOTracking extends DAO {

	Number LAST_QUERY_TOTAL_ROW_COUNT();
	
	Tracking findByUserId (int mappedId);

	List<Tracking> findByDate(Date date);
	
	List<Tracking> getAllTracking (boolean isreadonly, int firstResult, int fetchsize, String[] mappingsToJoin);
	
	Tracking findByIdAndDate (int mappedId, Date date);
	
	
	
}