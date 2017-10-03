package com.ihs.ats.model.dao.hibernatedimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import com.ihs.ats.api.WorkGroupMapper;

import com.ihs.ats.model.*;
import com.ihs.ats.model.dao.*;
import com.ihs.ats.api.*;

public class DAOWorkGroupMapperImpl extends DAOHibernateImpl implements DAOWorkGroupMapper {

	private Session session;
	private Number LAST_QUERY_TOTAL_ROW_COUNT;
	
	public DAOWorkGroupMapperImpl(Session session) {
		super(session);
		this.session = session;
	}

	private void setLAST_QUERY_TOTAL_ROW_COUNT(int LAST_QUERY_TOTAL_ROW_COUNT) {
		this.LAST_QUERY_TOTAL_ROW_COUNT = LAST_QUERY_TOTAL_ROW_COUNT;
		
	}
	
	private void setLAST_QUERY_TOTAL_ROW_COUNT(Number LAST_QUERY_TOTAL_ROW_COUNT) {
		this.LAST_QUERY_TOTAL_ROW_COUNT = LAST_QUERY_TOTAL_ROW_COUNT;
	}

	
	@Override
	public Number LAST_QUERY_TOTAL_ROW_COUNT() {
		return LAST_QUERY_TOTAL_ROW_COUNT;

	}

	//TODO modify the method change to workgrouptypeID
	@Override
	public WorkGroupMapper findByWorkGroupId(int workGroupId) {
		Criteria criteria = session.createCriteria(WorkGroupMapper.class).add(Restrictions.eq("workGroupId", workGroupId));
		@SuppressWarnings("unchecked")
		List<WorkGroupMapper> workGroupMapper = criteria.list();
		return (workGroupMapper.size() == 0 ? null : workGroupMapper.get(0));
	}

	
	@Override
	public WorkGroupMapper findByUserId(int IdMapper) {
		Criteria criteria = session.createCriteria(WorkGroupMapper.class).add(Restrictions.eq("UserId", IdMapper));
		@SuppressWarnings("unchecked")
		List<WorkGroupMapper> workGroupMapper = criteria.list();
		return (workGroupMapper.size() == 0 ? null : workGroupMapper.get(0));
	}

	@Override
	public List<WorkGroupMapper> getAllWorkGroupMapper(boolean isreadonly, int firstResult, int fetchsize,
			String[] mappingsToJoin) {
		Criteria cri = session.createCriteria(WorkGroupMapper.class).setReadOnly(isreadonly);

		if(mappingsToJoin != null)
			for (String mapping : mappingsToJoin) {
				cri.setFetchMode(mapping, FetchMode.JOIN);
			}
		
		setLAST_QUERY_TOTAL_ROW_COUNT((Number) cri.setProjection(Projections.rowCount()).uniqueResult());
		cri.setProjection(null).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		List<WorkGroupMapper> list = cri.addOrder(Order.desc("dateEnrolled")).list();
		return list;
	}

}
