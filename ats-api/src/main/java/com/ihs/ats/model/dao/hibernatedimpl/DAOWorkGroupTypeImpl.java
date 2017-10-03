package com.ihs.ats.model.dao.hibernatedimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import com.ihs.ats.api.User;
import com.ihs.ats.api.WorkGroupType;
import com.ihs.ats.model.dao.DAOUser;
import com.ihs.ats.model.dao.DAOWorkGroupType;

public class DAOWorkGroupTypeImpl extends DAOHibernateImpl implements DAOWorkGroupType{

	private Session session;
	private Number LAST_QUERY_TOTAL_ROW_COUNT;
	
	public DAOWorkGroupTypeImpl(Session session) {
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

	@Override
	public WorkGroupType findByWorkGroupTypeId(int workGroupTypeId) {
		// TODO Auto-generated method stub
		Criteria criteria = session.createCriteria(WorkGroupType.class).add(Restrictions.eq("workGroupTypeId", workGroupTypeId));
		@SuppressWarnings("unchecked")
		List<WorkGroupType> workGroupType = criteria.list();
		return (workGroupType.size() == 0 ? null : workGroupType.get(0));
	}

	@Override
	public WorkGroupType findByName(String workGroupName) {
		Criteria criteria = session.createCriteria(WorkGroupType.class).add(Restrictions.eq("workGroupName", workGroupName));
		@SuppressWarnings("unchecked")
		List<WorkGroupType> workGroupType = criteria.list();
		return (workGroupType.size() == 0 ? null : workGroupType.get(0));
	}

	@Override
	public List<WorkGroupType> getAllWorkGroupType(boolean isreadonly, int firstResult, int fetchsize,
			String[] mappingsToJoin) {
		Criteria cri = session.createCriteria(WorkGroupType.class).setReadOnly(isreadonly);

		if(mappingsToJoin != null)
			for (String mapping : mappingsToJoin) {
				cri.setFetchMode(mapping, FetchMode.JOIN);
			}
		
		setLAST_QUERY_TOTAL_ROW_COUNT((Number) cri.setProjection(Projections.rowCount()).uniqueResult());
		cri.setProjection(null).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		List<WorkGroupType> list = cri.list();
		return list;
	}

	
	
}
