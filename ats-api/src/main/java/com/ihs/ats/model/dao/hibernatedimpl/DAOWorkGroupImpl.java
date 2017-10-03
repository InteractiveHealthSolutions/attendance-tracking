package com.ihs.ats.model.dao.hibernatedimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import com.ihs.ats.model.*;
import com.ihs.ats.model.dao.*;
import com.ihs.ats.api.*;

public class DAOWorkGroupImpl extends DAOHibernateImpl implements DAOWorkGroup {

	private Session session;
	private Number LAST_QUERY_TOTAL_ROW_COUNT;
	
	public DAOWorkGroupImpl(Session session) {
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

	//TODO change the method name to workgrouptypeid
	@Override
	public WorkGroup findByWorkGroupId(int workGroupTypeId) {
		Criteria criteria = session.createCriteria(WorkGroup.class).add(Restrictions.eq("workGroupTypeId", workGroupTypeId));
		@SuppressWarnings("unchecked")
		List<WorkGroup> workGroupMapper = criteria.list();
		return (workGroupMapper.size() == 0 ? null : workGroupMapper.get(0));
	}

	@Override
	public List<WorkGroup> findByDay(String day) {
		
		
			Criteria cri = session.createCriteria(WorkGroup.class).add(Restrictions.eq("day", day));

			
			setLAST_QUERY_TOTAL_ROW_COUNT((Number) cri.setProjection(Projections.rowCount()).uniqueResult());
			cri.setProjection(null).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			
			List<WorkGroup> list = cri.addOrder(Order.desc("dateEnrolled")).list();
			return list;
	}

	@Override
	public List<WorkGroup> getAllWorkGroup(boolean isreadonly, int firstResult, int fetchsize,
			String[] mappingsToJoin) {
		Criteria cri = session.createCriteria(WorkGroup.class).setReadOnly(isreadonly);

		if(mappingsToJoin != null)
			for (String mapping : mappingsToJoin) {
				cri.setFetchMode(mapping, FetchMode.JOIN);
			}
		
		setLAST_QUERY_TOTAL_ROW_COUNT((Number) cri.setProjection(Projections.rowCount()).uniqueResult());
		cri.setProjection(null).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
	
		List<WorkGroup> list = new ArrayList();
		list = cri.list();
		
		return list;
	}

	@Override
	public List<WorkGroup> getAllWorkGroupByTypeId(int workGroupTypeId) {
		Criteria criteria = session.createCriteria(WorkGroup.class).add(Restrictions.eq("workGroupTypeId", workGroupTypeId));
	
		List<WorkGroup> workGroup = criteria.list();
		return (workGroup.size() == 0 ? null : workGroup);
	}

}
