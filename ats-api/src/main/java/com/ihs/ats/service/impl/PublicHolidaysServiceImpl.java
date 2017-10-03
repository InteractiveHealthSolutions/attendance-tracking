package com.ihs.ats.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.ihs.ats.context.ServiceContext;
import com.ihs.ats.api.PublicHoliday;
import com.ihs.ats.api.Tracking;
import com.ihs.ats.model.dao.DAOPublicHoliday;
import com.ihs.ats.model.dao.DAOTracking;
import com.ihs.ats.model.dao.hibernatedimpl.DAOPublicHolidayImpl;
import com.ihs.ats.service.PublicHolidaysService;
import com.ihs.ats.service.TrackingService;

public class PublicHolidaysServiceImpl implements PublicHolidaysService{

	private ServiceContext sc;
	private DAOPublicHoliday daoPublicHolidays;

	public PublicHolidaysServiceImpl(ServiceContext sc, DAOPublicHoliday daoPublicHolidays) {
		super();
		this.sc = sc;
		this.daoPublicHolidays = daoPublicHolidays;
	}

	
	
	@Override
	public Serializable save(PublicHoliday publicHolidays) {
		return daoPublicHolidays.save(publicHolidays);
	}

	@Override
	public void update(PublicHoliday publicHolidays) {
		daoPublicHolidays.update(publicHolidays);
		
	}

	@Override
	public List<PublicHoliday> findByType(String type) {
		List<PublicHoliday> wgt = daoPublicHolidays.findByType(type);
		return wgt;
	}

	@Override
	public List<PublicHoliday> findByDate(Date dateTime) {
		List<PublicHoliday> wgt = daoPublicHolidays.findByDate(dateTime);
		return wgt;
	}

	@Override
	public List<PublicHoliday> getAllPublicHolidays(boolean isreadonly, int firstResult, int fetchsize,
			String[] mappingsToJoin) {
		List<PublicHoliday> wgm = daoPublicHolidays.getAllPublicHolidays(isreadonly, firstResult, fetchsize, mappingsToJoin);
		return wgm;
	}



	@Override
	public List<PublicHoliday> findById(String Id) {
		List<PublicHoliday> wgt = daoPublicHolidays.findById(Id);
		return wgt;
	}

}
