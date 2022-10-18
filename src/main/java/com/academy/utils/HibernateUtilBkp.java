package com.academy.utils;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.academy.classes.dto.AcademyClass;
import com.academy.classsubjectteacher.dto.AcademyClassSubjectTeacher;
import com.academy.student.dto.AcademyStudent;
import com.academy.subject.dto.AcademySubject;
import com.academy.teacher.dto.AcademyTeacher;

public class HibernateUtilBkp {

	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			synchronized (HibernateUtilBkp.class) {
				try {
					Configuration configuration = new Configuration();

					Properties settings = new Properties();

					settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
					settings.put(Environment.URL, "jdbc:mysql://localhost:3306/LEARNERS_ACADEMY_DB?useSSL=false");
					settings.put(Environment.USER, "root");
					settings.put(Environment.PASS, "Abc@54321");
					settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

					settings.put(Environment.SHOW_SQL, "true");
					settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
					settings.put(Environment.HBM2DDL_AUTO, "create-drop");

					configuration.setProperties(settings);

					configuration.addAnnotatedClass(AcademySubject.class);
					configuration.addAnnotatedClass(AcademyTeacher.class);
					configuration.addAnnotatedClass(AcademyClass.class);
					configuration.addAnnotatedClass(AcademyClassSubjectTeacher.class);
					configuration.addAnnotatedClass(AcademyStudent.class);

					ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
							.applySettings(configuration.getProperties()).build();

					sessionFactory = configuration.buildSessionFactory(serviceRegistry);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return sessionFactory;
	}

}
