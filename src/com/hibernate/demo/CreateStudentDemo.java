package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// save java object
			Student student1 = new Student("Yash", "S", "yash99@yahoo.com");

			// start transaction
			session.beginTransaction();

			// save student object
			session.save(student1);

			// commit
			session.getTransaction().commit();

			System.out.println("Done!!");

		} finally {
			session.close();
		}

	}

}
