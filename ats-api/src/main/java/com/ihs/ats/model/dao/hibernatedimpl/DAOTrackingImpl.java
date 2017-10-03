package com.ihs.ats.model.dao.hibernatedimpl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import com.ihs.ats.api.*;
import com.ihs.ats.model.dao.*;

public class DAOTrackingImpl extends DAOHibernateImpl implements DAOTracking{

	private Session session;
	private Number LAST_QUERY_TOTAL_ROW_COUNT;
	
	public DAOTrackingImpl(Session session) {
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
	public Tracking findByUserId(int mappedId) {
		Criteria criteria = session.createCriteria(Tracking.class).add(Restrictions.eq("userId", mappedId));
		@SuppressWarnings("unchecked")
		List<Tracking> tracking = criteria.list();
		return (tracking.size() == 0 ? null : tracking.get(0));
	}

	@Override
	public List<Tracking> findByDate(Date date) {
		Criteria cri = session.createCriteria(Tracking.class).add(Restrictions.eq("dateTime", date));

		
		setLAST_QUERY_TOTAL_ROW_COUNT((Number) cri.setProjection(Projections.rowCount()).uniqueResult());
		cri.setProjection(null).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		List<Tracking> list = cri.addOrder(Order.desc("dateEnrolled")).list();
		return list;
	}

	@Override
	public List<Tracking> getAllTracking(boolean isreadonly, int firstResult, int fetchsize, String[] mappingsToJoin) {
		
		Criteria cri = session.createCriteria(Tracking.class).setReadOnly(isreadonly);

		if(mappingsToJoin != null)
			for (String mapping : mappingsToJoin) {
				cri.setFetchMode(mapping, FetchMode.JOIN);
			}
		
		setLAST_QUERY_TOTAL_ROW_COUNT((Number) cri.setProjection(Projections.rowCount()).uniqueResult());
		cri.setProjection(null).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		List<Tracking> list = cri.list();
		return list;
	}

	@Override
	public Tracking findByIdAndDate(int mappedId, Date date) {
		Query q = session.createQuery("from Tracking a WHERE dateTime = "+date+" and userId ="+mappedId);
		//Query q = session.createQuery("SELECT distinct a.* FROM attendance a WHERE month(checkIn)=3 and year(checkIn)=2014");
	
		List<Tracking>  list= q.list();
		
		
		
		return (list.size() == 0 ? null : list.get(0));
	}

}
