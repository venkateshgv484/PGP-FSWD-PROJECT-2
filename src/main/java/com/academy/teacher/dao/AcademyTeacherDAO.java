package com.academy.teacher.dao;

import java.util.List;

import org.hibernate.Session;

import com.academy.teacher.dto.AcademyTeacher;
import com.academy.utils.HibernateUtils;

public class AcademyTeacherDAO {

	public List<AcademyTeacher> listAllTeachers() {
		Session session = HibernateUtils.getSessionFactory().openSession();
		return session.createQuery("from AcademyTeacher", AcademyTeacher.class).list();
	}

	public AcademyTeacher getTeaccher(long id) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		return session.get(AcademyTeacher.class, id);
	}

	@SuppressWarnings("deprecation")
	public void insert(AcademyTeacher academyTeacher) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		try {
			session.save(academyTeacher);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			throw e;
		}
	}

	@SuppressWarnings("deprecation")
	public void update(AcademyTeacher academyTeacher) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		try {
			session.update(academyTeacher);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			throw e;
		}
	}

	@SuppressWarnings("deprecation")
	public void delete(AcademyTeacher academyTeacher) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		try {
			session.delete(academyTeacher);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			throw e;
		}
	}

}
