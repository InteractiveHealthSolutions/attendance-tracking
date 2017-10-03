package com.ihs.ats.model.dao.hibernatedimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import com.ihs.ats.api.Attendance;
//import org.ird.unfepi.model.Vaccinator;
import com.ihs.ats.api.WorkGroup;
//
//import com.ihs.ats.model.dao.DAOAttendance;
//import com.ihs.ats.model.dao.DAOWorkGroup;
import com.ihs.ats.model.dao.DAOAttendance;

public class DAOAttendanceImpl extends DAOHibernateImpl implements DAOAttendance{

	private Session session;
	private Number LAST_QUERY_TOTAL_ROW_COUNT;
	public DAOAttendanceImpl(Session session) {
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
	public List<Attendance> findByWorkGroupId(int workGroupId) {
	/*Select * from Attendance where workGroupId = MyGivenId; First attribute is column name and other value to be searched */
		Criteria criteria = session.createCriteria(Attendance.class).add(Restrictions.eq("workGroupId", workGroupId));
		@SuppressWarnings("unchecked")
		List<Attendance> attendance = criteria.list();
		return (attendance.size() == 0 ? null : attendance);
	}

	@Override
	public List<Attendance> findById(int mappedId) {
		// TODO Auto-generated method stub
		/* select * from attendance where mappedId = givenValue; first attribute is column name*/
		Criteria criteria = session.createCriteria(Attendance.class).add(Restrictions.eq("attendanceId", mappedId));
		@SuppressWarnings("unchecked")
		List<Attendance> attendance = criteria.addOrder(Order.asc("checkIn")).list();
		return (attendance.size() == 0 ? null : attendance);
	}

	@Override
	public List<Attendance> findByIdAndGrouped(int IdMapper, int workGroupId) {
		Criteria criteria = session.createCriteria(Attendance.class).add(Restrictions.eq("attendanceId", IdMapper));
		@SuppressWarnings("unchecked")
		List<Attendance> attendance;
		attendance = criteria.list();
		return (attendance.size() == 0 ? null : attendance);
	}

	@Override
	public List<Attendance> getAllAttendance(boolean isreadonly, int firstResult, int fetchsize,
			String[] mappingsToJoin) {
		Criteria cri = session.createCriteria(Attendance.class).setReadOnly(isreadonly);
		setLAST_QUERY_TOTAL_ROW_COUNT((Number) cri.setProjection(Projections.rowCount()).uniqueResult());
		cri.setProjection(null).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		//setLAST_QUERY_TOTAL_ROW_COUNT((Number) cri.setProjection(Projections.rowCount()).uniqueResult());
	//	cri.setProjection(null).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<Attendance> list = cri.list();
		return list;
	}

	@Override
	public List<Attendance> getAttendancebyMonthAndYear(String month, String Year) {
		
		Query q = session.createQuery("from Attendance a WHERE month(checkIn)="+month+" and year(checkIn)="+Year);
		//Query q = session.createQuery("SELECT distinct a.* FROM attendance a WHERE month(checkIn)=3 and year(checkIn)=2014");
		
		System.out.println("--------");
		System.out.println(q.list());
		List<Attendance>  att= q.list();
		return att;
	}
	
	@Override
	public List<Attendance> getAttendancebyMonthAndYearAndId(String month, String Year, int mappedId) {
		Query q = session.createQuery("from Attendance a WHERE month(checkIn)="+month+" and year(checkIn)="+Year+" and attendanceId ="+mappedId);
		//Query q = session.createQuery("SELECT distinct a.* FROM attendance a WHERE month(checkIn)=3 and year(checkIn)=2014");
		
		List<Attendance>  att= q.list();
		
		return att;
	}


	@Override
	public List<Attendance> getAttendancebyMonthAndYearAndWorkGroup(String month, String Year, int workGroupTypeId) {
		Query q = session.createQuery("from Attendance a WHERE month(checkIn)="+month+" and year(checkIn)="+Year+ "and workGroupTypeId="+workGroupTypeId);
		List<Attendance>  att= q.list();
		int my = att.size();
		System.out.println(my);
		return att;
	}

}
