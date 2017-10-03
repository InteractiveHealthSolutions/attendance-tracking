package com.ihs.ats.model.dao.hibernatedimpl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.ihs.ats.api.*;
import com.ihs.ats.model.dao.DAOLeave;
import com.ihs.ats.model.dao.DAOWorkGroup;

public class DAOLeaveImpl extends DAOHibernateImpl implements DAOLeave{

	private Session session;
	private Number LAST_QUERY_TOTAL_ROW_COUNT;
	
	public DAOLeaveImpl(Session session) {
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
	public List<Leave> findByLeaveId(int LeaveId) {
		Criteria criteria = session.createCriteria(Leave.class).add(Restrictions.eq("leaveId", LeaveId));
		@SuppressWarnings("unchecked")
		List<Leave> leaveManagement = criteria.list();
		return leaveManagement;
	}

	@Override
	public List<Leave> findByType(String leaveType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Leave> getAllLeave(boolean isreadonly, int firstResult, int fetchsize,
			String[] mappingsToJoin) {
		Criteria cri = session.createCriteria(Leave.class).setReadOnly(isreadonly);

		if(mappingsToJoin != null)
			for (String mapping : mappingsToJoin) {
				cri.setFetchMode(mapping, FetchMode.JOIN);
			}
		List<Leave> list = null;
		if(cri.list() != null){
			list = cri.list();

		}
		return list;
	}

	@Override
	public List<Leave> getLeavebyMonthAndYearAndUserId(String month, String Year, int lId) {
		Query q = session.createQuery("from LeaveManagement a WHERE month(leaveDate)="+month+" and year(leaveDate)="+Year+ " and userId ="+lId);

		List<Leave> leave= q.list();
		return leave;
	}

}
