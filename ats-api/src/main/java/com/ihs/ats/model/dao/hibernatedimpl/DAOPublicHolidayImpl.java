package com.ihs.ats.model.dao.hibernatedimpl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import com.ihs.ats.api.*;
import com.ihs.ats.model.dao.*;

public class DAOPublicHolidayImpl extends DAOHibernateImpl implements DAOPublicHoliday{

	
	private Session session;
	private Number LAST_QUERY_TOTAL_ROW_COUNT;
	
	public DAOPublicHolidayImpl(Session session) {
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
	public List<PublicHoliday> findByDate(Date date) {
		Criteria cri = session.createCriteria(PublicHoliday.class).add(Restrictions.eq("datePH", date));
		setLAST_QUERY_TOTAL_ROW_COUNT((Number) cri.setProjection(Projections.rowCount()).uniqueResult());
		cri.setProjection(null).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<PublicHoliday> list = cri.addOrder(Order.desc("dateEnrolled")).list();
		return list;
	}

	@Override
	public List<PublicHoliday> getAllPublicHolidays(boolean isreadonly, int firstResult, int fetchsize,
			String[] mappingsToJoin) {
		Criteria cri = session.createCriteria(PublicHoliday.class).setReadOnly(isreadonly);

		if(mappingsToJoin != null)
			for (String mapping : mappingsToJoin) {
				cri.setFetchMode(mapping, FetchMode.JOIN);
			}
		
		setLAST_QUERY_TOTAL_ROW_COUNT((Number) cri.setProjection(Projections.rowCount()).uniqueResult());
		cri.setProjection(null).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		List<PublicHoliday> list = cri.list();
		return list;
	}


	@Override
	public List<PublicHoliday> findByType(String type) {
		Criteria cri = session.createCriteria(PublicHoliday.class).add(Restrictions.eq("datePH", type));

		
		setLAST_QUERY_TOTAL_ROW_COUNT((Number) cri.setProjection(Projections.rowCount()).uniqueResult());
		cri.setProjection(null).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		List<PublicHoliday> list = cri.addOrder(Order.desc("dateEnrolled")).list();
		return list;
	}


	@Override
	public List<PublicHoliday> findById(String Id) {
		
		Criteria cri = session.createCriteria(PublicHoliday.class).add(Restrictions.eq("IdPH", Integer.parseInt(Id)));
		setLAST_QUERY_TOTAL_ROW_COUNT((Number) cri.setProjection(Projections.rowCount()).uniqueResult());
		cri.setProjection(null).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		List<PublicHoliday> list = cri.list();
		return list;
	}

}
