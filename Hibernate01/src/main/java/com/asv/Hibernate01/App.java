package com.asv.Hibernate01;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		Alien alien = new Alien();
		alien.setAid(102);
		alien.setAname("Varun");
		alien.setColor("Blue");

		Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
		
		StandardServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		
		SessionFactory sf = con.buildSessionFactory(reg);
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		session.save(alien);
		
		tx.commit();
	}
}
