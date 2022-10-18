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

public class HibernateUtils {

	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			synchronized (HibernateUtils.class) {
				try {
					Configuration configuration = new Configuration();

					Properties settings = new Properties();

					settings.put(Environment.DRIVER, "org.h2.Driver");
					settings.put(Environment.URL, "jdbc:h2:mem:LEARNERS_ACADEMY_DB");
					settings.put(Environment.USER, "sa");
					settings.put(Environment.PASS, "");
					settings.put(Environment.POOL_SIZE, "1");
					settings.put(Environment.DIALECT, "org.hibernate.dialect.H2Dialect");

					settings.put(Environment.SHOW_SQL, "true");
					settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
					settings.put(Environment.HBM2DDL_AUTO, "create-drop");

					settings.put("hibernate.dbcp.initialSize", "5");
					settings.put("hibernate.dbcp.maxTotal", "20");
					settings.put("hibernate.dbcp.maxIdle", "10");
					settings.put("hibernate.dbcp.minIdle", "5");
					settings.put("hibernate.dbcp.maxWaitMillis", "-1");

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
