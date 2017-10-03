package com.ihs.ats.context;

import java.sql.Clob;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.ihs.ats.model.dao.*;
import com.ihs.ats.service.*;
import com.ihs.ats.api.Attendance;
import com.ihs.ats.api.PublicHoliday;
import com.ihs.ats.model.dao.hibernatedimpl.*;
import com.ihs.ats.service.impl.*;

public class ServiceContext
{

	private AttendanceService attendanceService;

	public PublicHolidaysService getPublicHolidaysService() {
		return publicHolidaysService;
	}

	public void setPublicHolidaysService(PublicHolidaysService publicHolidaysService) {
		this.publicHolidaysService = publicHolidaysService;
	}

	public TrackingService getTrackingService() {
		return trackingService;
	}
	
	public void setTrackingService(TrackingService trackingService) {
		this.trackingService = trackingService;
	}
	
	private PublicHolidaysService publicHolidaysService;

	private Session session;

	private Transaction transaction;

	private TrackingService trackingService;
//	
//	private UserService userService;

	private WorkGroupService workGroupTypeService;
	
	ServiceContext(SessionFactory sessionObj)
	{
		session = sessionObj.openSession();
		transaction = session.beginTransaction();

		DAOUserImpl udao = new DAOUserImpl(session);
//	
//		DAOPersonImpl persondao = new DAOPersonImpl(session);
//		this.personService = new PersonServiceImpl(this, persondao);
		
		DAOWorkGroupTypeImpl daoWorkGroupTypeImpl = new DAOWorkGroupTypeImpl(session);
		DAOWorkGroupMapperImpl daoWorkGroupMapperImpl = new DAOWorkGroupMapperImpl(session);
		DAOWorkGroupImpl daoWorkGroupImpl = new DAOWorkGroupImpl(session);
		this.workGroupTypeService = new WorkGroupServiceImpl(this, daoWorkGroupTypeImpl,daoWorkGroupMapperImpl,daoWorkGroupImpl);
		
		DAOLeaveImpl daoLeaveManagementImpl = new DAOLeaveImpl(session);
		DAOAttendanceImpl daoAttendanceImpl = new DAOAttendanceImpl(session);
//uncomment this		this.attendanceService = new AttendanceServiceImpl(this, daoLeaveManagementImpl,daoAttendanceImpl);
		
		DAOPublicHolidayImpl daoPublicHolidaysImpl = new DAOPublicHolidayImpl(session);
		this.publicHolidaysService = new PublicHolidaysServiceImpl(this, daoPublicHolidaysImpl);
		
		DAOTrackingImpl daoTrackingImpl = new DAOTrackingImpl(session);
		this.trackingService = new TrackingServiceImpl(this,daoTrackingImpl);

	}

	public void beginTransaction()
	{
		if (transaction == null)
		{
			transaction = session.beginTransaction();
		}
	}

	public void closeSession()
	{
		try
		{
			session.close();
		}
		catch (Exception e)
		{
		}
	}

	public void commitTransaction()
	{
		transaction.commit();
	}

	public Clob createClob(String clobString)
	{
		return Hibernate.getLobCreator(session).createClob(clobString);
	}

	@Override
	protected void finalize() throws Throwable
	{
		closeSession();
	}

	public void rollbackTransaction()
	{
		if (transaction != null)
		{
			transaction.rollback();
		}
	}

	public void flushSession()
	{
		session.flush();
	}

	public AttendanceService getAttendanceService() {
		return attendanceService;
	}
	
	public void setAttendanceService(AttendanceService attendanceService) {
		this.attendanceService = attendanceService;
	}

//	public UserService getUserService()
//	{
//		// if(!session.getTransaction().isActive()) beginTransaction();
//		return userService;
//	}

	public WorkGroupService getWorkGroupTypeService() {
		return workGroupTypeService;
	}

	public void setWorkGroupTypeService(WorkGroupService workGroupTypeService) {
		this.workGroupTypeService = workGroupTypeService;
	}

}