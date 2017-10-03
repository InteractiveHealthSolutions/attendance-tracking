package com.ihs.ats.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.ihs.ats.api.PublicHoliday;
import com.ihs.ats.api.Tracking;

public interface PublicHolidaysService {

	Serializable save(PublicHoliday publicHolidays);

	void update(PublicHoliday publicHolidays);
	

	List<PublicHoliday> findByType(String type);
	
	List<PublicHoliday> findByDate(Date dateTime);
		
	List<PublicHoliday> findById(String Id);
	
	List<PublicHoliday> getAllPublicHolidays (boolean isreadonly, int firstResult, int fetchsize, String[] mappingsToJoin);
	
	
	
	
}
