package com.academy.subject.dao;

import java.util.List;

import org.hibernate.Session;

import com.academy.subject.dto.AcademySubject;
import com.academy.utils.HibernateUtils;

public class AcademySubjectDAO {

	public List<AcademySubject> listAllSubjects() {
		Session session = HibernateUtils.getSessionFactory().openSession();
		return session.createQuery("from AcademySubject", AcademySubject.class).list();
	}

	public AcademySubject getSubject(long id) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		return session.get(AcademySubject.class, id);
	}

	@SuppressWarnings("deprecation")
	public void insert(AcademySubject academySubject) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		try {
			session.save(academySubject);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			throw e;
		}
	}

	@SuppressWarnings("deprecation")
	public void update(AcademySubject academySubject) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		try {
			session.update(academySubject);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			throw e;
		}
	}

	@SuppressWarnings("deprecation")
	public void delete(AcademySubject academySubject) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		try {
			session.delete(academySubject);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			throw e;
		}
	}

}
