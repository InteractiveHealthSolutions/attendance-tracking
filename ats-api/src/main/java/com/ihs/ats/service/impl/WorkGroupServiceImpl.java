package com.ihs.ats.service.impl;

import java.io.Serializable;
import java.util.List;
import com.ihs.ats.context.*;
import com.ihs.ats.api.WorkGroup;
import com.ihs.ats.api.WorkGroupMapper;
import com.ihs.ats.api.WorkGroupType;
import com.ihs.ats.model.dao.DAOLeave;
import com.ihs.ats.model.dao.DAOWorkGroup;
import com.ihs.ats.model.dao.DAOWorkGroupMapper;
import com.ihs.ats.model.dao.DAOWorkGroupType;
import com.ihs.ats.service.WorkGroupService;

public class WorkGroupServiceImpl implements WorkGroupService{

	private ServiceContext sc;

	private DAOWorkGroupType daoWorkGroupType;
	private DAOWorkGroupMapper daoWorkGroupMapper;
	private DAOWorkGroup daoWorkGroup;


	
	public WorkGroupServiceImpl(ServiceContext sc, DAOWorkGroupType daoWorkGroupType,DAOWorkGroupMapper daoWorkGroupMapper,DAOWorkGroup daoWorkGroup){
		
		this.sc = sc;
		this.daoWorkGroupType=daoWorkGroupType;
		this.daoWorkGroupMapper=daoWorkGroupMapper;
		this.daoWorkGroup=daoWorkGroup;
	}

	
	@Override
	public Serializable save(WorkGroupType workGroup) {
		return daoWorkGroupType.save(workGroup);
	}

	@Override
	public void update(WorkGroupType workGroup) {
	
		daoWorkGroupType.update(workGroup);
		
	}

	@Override
	public WorkGroupType findByWorkGroupTypeId(int workGroupTypeId) {
		WorkGroupType wgt = daoWorkGroupType.findByWorkGroupTypeId(workGroupTypeId);
		return wgt;
	}

	@Override
	public WorkGroupType findByName(String workGroupName) {
		WorkGroupType wgt = daoWorkGroupType.findByName(workGroupName);
		return wgt;
	}

	@Override
	public List<WorkGroupType> getAllworkGroup(boolean isreadonly, int firstResult, int fetchsize,
			String[] mappingsToJoin) {
		// TODO Auto-generated method stub
		List<WorkGroupType> wgt = daoWorkGroupType.getAllWorkGroupType(isreadonly, firstResult, fetchsize, mappingsToJoin);
		return wgt;
	}


	@Override
	public Serializable saveWorkGroupMapper(WorkGroupMapper workGroupMapper) {
		return daoWorkGroupMapper.save(workGroupMapper);

	}


	@Override
	public void updateWorkGroupMapper(WorkGroupMapper workGroupMapper) {
		daoWorkGroupMapper.update(workGroupMapper);
		
	}


	@Override
	public WorkGroupMapper findByworkGroupId(int workGroupId) {
		WorkGroupMapper wgm = daoWorkGroupMapper.findByWorkGroupId(workGroupId);
		return wgm;
	}


	@Override
	public WorkGroupMapper findByUserId(int idMapper) {
		WorkGroupMapper wgm = daoWorkGroupMapper.findByUserId(idMapper);
		return wgm;
	}


	@Override
	public List<WorkGroupMapper> getAllWorkGroupMapper(boolean isreadonly, int firstResult, int fetchsize,
			String[] mappingsToJoin) {
		List<WorkGroupMapper> wgm = daoWorkGroupMapper.getAllWorkGroupMapper(isreadonly, firstResult, fetchsize, mappingsToJoin);
		return wgm;
	}


	@Override
	public Serializable saveWorkGroup(WorkGroup workGroup) {
		// TODO Auto-generated method stub
		return daoWorkGroup.save(workGroup);
		
	}


	@Override
	public void updateWorkGroup(WorkGroup workGroup) {
		daoWorkGroup.update(workGroup);		
	}


	@Override
	public WorkGroup findDetailsByworkGroupId(int workGroupId) {
		WorkGroup wgm = daoWorkGroup.findByWorkGroupId(workGroupId);
		return wgm;
	}


	@Override
	public List<WorkGroup> getAllWorkGroup(boolean isreadonly, int firstResult, int fetchsize,
			String[] mappingsToJoin) {
		List<WorkGroup> wgm = daoWorkGroup.getAllWorkGroup(isreadonly, firstResult, fetchsize, mappingsToJoin);
		return wgm;
	}


	@Override
	public List<WorkGroup> getAllWorkGroupByTypeId(int workGroupTypeId) {
		List<WorkGroup> wgm = daoWorkGroup.getAllWorkGroupByTypeId(workGroupTypeId);
		return wgm;
	}





}
