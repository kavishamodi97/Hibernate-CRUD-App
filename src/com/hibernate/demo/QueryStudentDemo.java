package com.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// save java object

			// start transaction
			session.beginTransaction();

			// Query Students

			List<Student> stList = session.createQuery("from Student").list();

			displayStudents(stList);

			// query students: last name is "doe"

			stList = session.createQuery("from Student s where s.lastName='doe'").list();

			displayStudents(stList);

			// query students: whose first name :yash OR last name:S
			stList = session.createQuery("from Student s where s.lastName='S'" + " OR s.firstName='Yash'").list();

			displayStudents(stList);

			// Like Keyword in HQL
			stList = session.createQuery("from Student s where s.email LIKE '%luv2code.com'").list();

			displayStudents(stList);

			// Like Pattern in gmail.com
			System.out.println("Students Whose email ends with gmail.com");
			stList = session.createQuery("from Student s where s.email LIKE '%gmail.com'").list();

			displayStudents(stList);

			// commit
			session.getTransaction().commit();

			System.out.println("Done!!");

		} finally {
			session.close();
		}

	}

	private static void displayStudents(List<Student> stList) {
		for (Student tempStudent : stList) {
			System.out.println("Retrieve Student Data: " + tempStudent);
		}
	}

}
