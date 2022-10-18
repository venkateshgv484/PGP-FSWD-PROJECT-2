package com.academy.classes.dao;

import java.util.List;

import org.hibernate.Session;

import com.academy.classes.dto.AcademyClass;
import com.academy.utils.HibernateUtils;

public class AcademyClassDAO {

	public List<AcademyClass> listAllClasses() {
		Session session = HibernateUtils.getSessionFactory().openSession();
		return session.createQuery("from AcademyClass", AcademyClass.class).list();
	}

	public AcademyClass getClass(long id) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		return session.get(AcademyClass.class, id);
	}

	@SuppressWarnings("deprecation")
	public void insert(AcademyClass academyClass) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		try {
			session.save(academyClass);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			throw e;
		}
	}

	@SuppressWarnings("deprecation")
	public void update(AcademyClass academyClass) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		try {
			session.update(academyClass);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			throw e;
		}
	}

	@SuppressWarnings("deprecation")
	public void delete(AcademyClass academyClass) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		try {
			session.delete(academyClass);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			throw e;
		}
	}

}
