package com.ihs.ats.model.dao.hibernatedimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.ihs.ats.api.User;
import com.ihs.ats.model.dao.DAOUser;

public class DAOUserImpl extends DAOHibernateImpl implements DAOUser {

	private Session session;
	private Number LAST_QUERY_TOTAL_ROW_COUNT;
	
	public DAOUserImpl(Session session) {
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
	public User findById(int mappedId) {
		// TODO Auto-generated method stub
		Criteria criteria = session.createCriteria(User.class).add(Restrictions.eq("userId", mappedId));
		@SuppressWarnings("unchecked")
		List<User> person = criteria.list();
		return (person.size() == 0 ? null : person.get(0));
	}

	@SuppressWarnings("unchecked")
	@Override
	public User findById(int mappedId, boolean isreadonly, 
			String[] mappingsToJoin) {
		
			Criteria cri = session.createCriteria(User.class).setReadOnly(isreadonly)
					.add(Restrictions.eq("userId", mappedId));
				
			if(mappingsToJoin != null)
				for (String mapping : mappingsToJoin) {
					cri.setFetchMode(mapping, FetchMode.JOIN);
				}
			
			List<User> list = cri.list();
			setLAST_QUERY_TOTAL_ROW_COUNT(list.size());
			return (list.size() == 0 ? null : list.get(0));
	}
	
	@Override
	public List<User> getAllUser(boolean isreadonly, int firstResult, int fetchsize, String[] mappingsToJoin) {
		// TODO Auto-generated method stub
		Criteria cri = session.createCriteria(User.class).setReadOnly(isreadonly);

		if(mappingsToJoin != null)
			for (String mapping : mappingsToJoin) {
				cri.setFetchMode(mapping, FetchMode.JOIN);
			}
		
		setLAST_QUERY_TOTAL_ROW_COUNT((Number) cri.setProjection(Projections.rowCount()).uniqueResult());
		cri.setProjection(null).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		@SuppressWarnings("unchecked")
		List<User> list = cri.addOrder(Order.desc("name")).setFirstResult(firstResult).setMaxResults(fetchsize).list();
		return list;
	}

	@Override
	public List<User> getAllUser(boolean isreadonly, String[] mappingsToJoin) {
		// TODO Auto-generated method stub
		Criteria cri = session.createCriteria(User.class).setReadOnly(isreadonly);

		if(mappingsToJoin != null)
			for (String mapping : mappingsToJoin) {
				cri.setFetchMode(mapping, FetchMode.JOIN);
			}
		
		setLAST_QUERY_TOTAL_ROW_COUNT((Number) cri.setProjection(Projections.rowCount()).uniqueResult());
		cri.setProjection(null).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		List<User> list = cri.addOrder(Order.desc("name")).list();
		return list;
	}
	
	@Override
	public List<User> getAllPersons(){
		Criteria cri = session.createCriteria(User.class);
		
		setLAST_QUERY_TOTAL_ROW_COUNT((Number)cri.setProjection(Projections.rowCount()).uniqueResult());
		cri.setProjection(null).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List <User> personList = cri.addOrder(Order.desc("name")).list();
		return personList ;
	}
	
/*	@SuppressWarnings("unchecked")
	@Override
	public Person findPersonByIdentifier(String programId, boolean isreadonly, String[] mappingsToJoin) {
		Criteria cri = session.createCriteria(Person.class).setReadOnly(isreadonly)
				.setFetchMode("idMapper",FetchMode.JOIN)
				.createAlias("idMapper.identifiers", "idm")
				.add(Restrictions.eq("idm.identifier", programId));
		if(mappingsToJoin != null)
			for (String mapping : mappingsToJoin) {
				cri.setFetchMode(mapping, FetchMode.JOIN);
			}
		
		List<Person> list = cri.list();
		setLAST_QUERY_TOTAL_ROW_COUNT(list.size());
		return (list.size() == 0 ? null : list.get(0));
	}
*/
/*	@SuppressWarnings("unchecked")
	@Override
	public List<Person> getPersonByRole(String roleID, boolean isreadonly, String[] mappingsToJoin) {
		
			
			Criteria cri = session.createCriteria(Person.class).setReadOnly(isreadonly)
					.add(Restrictions.eq("roleId", Integer.parseInt(roleID)));
				
			if(mappingsToJoin != null)
				for (String mapping : mappingsToJoin) {
					cri.setFetchMode(mapping, FetchMode.JOIN);
				}
			
			
			List<Person> list = cri.list();
			return list;
	}*/

}
