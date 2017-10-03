package com.ihs.ats.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ihs.ats.context.ServiceContext;
import com.ihs.ats.api.Tracking;
import com.ihs.ats.api.WorkGroupMapper;
import com.ihs.ats.api.WorkGroupType;
import com.ihs.ats.model.dao.DAOTracking;
import com.ihs.ats.model.dao.DAOWorkGroup;
import com.ihs.ats.model.dao.DAOWorkGroupMapper;
import com.ihs.ats.model.dao.DAOWorkGroupType;
import com.ihs.ats.service.TrackingService;


public class TrackingServiceImpl implements TrackingService{

	
	private ServiceContext sc;


	private DAOTracking daoTracking;

	
	public TrackingServiceImpl(ServiceContext sc, DAOTracking daoTracking) {
		super();
		this.sc = sc;
		this.daoTracking=daoTracking;
	}

	@Override
	public Serializable save(Tracking tracking) {
		return daoTracking.save(tracking);
	}

	@Override
	public void update(Tracking tracking) {
		daoTracking.update(tracking);
		
	}

	@Override
	public Tracking findById(int mappedId) {
		Tracking wgt = daoTracking.findByUserId(mappedId);
		return wgt;
	}

	@Override
	public List<Tracking> findByDate(Date dateTime) {
		List<Tracking> wgt = daoTracking.findByDate(dateTime);
		return wgt;
	}

	@Override
	public Tracking findByDateAndId(Date dateTime, int mappedId) {
		Tracking wgt = daoTracking.findByIdAndDate(mappedId, dateTime);
		return wgt;
	}

	@Override
	public List<Tracking> getAllTracking(boolean isreadonly, int firstResult, int fetchsize, String[] mappingsToJoin) {
		List<Tracking> wgm = daoTracking.getAllTracking(isreadonly, firstResult, fetchsize, mappingsToJoin);
		return wgm;
		
	}

}
