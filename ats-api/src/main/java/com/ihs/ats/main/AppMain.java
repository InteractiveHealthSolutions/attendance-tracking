package com.ihs.ats.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ihs.ats.model.dao.hibernatedimpl.HibernateUtil;

public class AppMain {

	public static void main(String[] args) {
		System.out.println("I am here");
		SessionFactory factory=HibernateUtil.getSessionFactory(null, null);	
		Session session=factory.openSession();	
		org.hibernate.Transaction t= session.beginTransaction();
//		session.close();
		System.out.println("Close");
		
//		ApplicationContext ctx = SpringApplication.run(AppMain.class, args);
//
//		// Fetch all contact entities from DB
//		ContactDao contactDao = (ContactDao) ctx.getBean("contactDao");
////		System.out.println(contactDao.getAll());
////
////		// Find entity by primary key ID
////		Contacts c1 = contactDao.get("23");
//		System.out.println("Heree");
////		System.out.println(c1.toString());
//
////		create(contactDao, "11");
////		update(contactDao, "11");
////		delete(contactDao, "11");
//
//		((ConfigurableApplicationContext) ctx).close();
	}

//	// Create new contact
//	private static void create(ContactDao contactDao, String id) {
//		Contacts cNew = new Contacts();
//		cNew.setId(id);
//		cNew.setFirstName("John");
//		cNew.setLastName("Smith");
//		cNew.setPhone("8897762242");
//		cNew.setEmail("testemail@gm.com");
//
//		contactDao.create(cNew);
//	}
//
//	// Update contact
//	private static void update(ContactDao contactDao, String id) {
//		Contacts c = find(contactDao, id);
//		c.setLastName("SmithUpd");
//		contactDao.update(c);
//	}
//
//	// Delete contact
//	private static void delete(ContactDao contactDao, String id) {
//		Contacts c = find(contactDao, id);
//		contactDao.delete(c);
//	}

	// Find contact
//	private static Contacts find(ContactDao contactDao, String id) {
//		return contactDao.get(id);
//	}

}
