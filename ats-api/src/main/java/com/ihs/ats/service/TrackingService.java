package com.ihs.ats.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ihs.ats.api.Tracking;



public interface TrackingService {

	
	

	Serializable save(Tracking tracking);

	void update(Tracking tracking);
	
	Tracking findById (int mappedId);
	
	List<Tracking> findByDate(Date dateTime);
		
	Tracking findByDateAndId(Date dateTime, int mappedId);
	
	List<Tracking> getAllTracking (boolean isreadonly, int firstResult, int fetchsize, String[] mappingsToJoin);
	
	
	
	
	
	
	
}
