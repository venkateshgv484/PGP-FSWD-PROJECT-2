package com.academy.student.dao;

import java.util.List;

import org.hibernate.Session;

import com.academy.student.dto.AcademyStudent;
import com.academy.utils.HibernateUtils;

public class AcademyStudentDAO {

	public List<AcademyStudent> listAllStudents() {
		Session session = HibernateUtils.getSessionFactory().openSession();
		return session.createQuery("from AcademyStudent", AcademyStudent.class).list();
	}

	public AcademyStudent getStudent(long id) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		return session.get(AcademyStudent.class, id);
	}

	public List<AcademyStudent> listAllClassStudents(long classId) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		return session
				.createQuery("select acs from AcademyStudent acs where acs.classId = " + classId, AcademyStudent.class)
				.list();
	}

	@SuppressWarnings("deprecation")
	public void insert(AcademyStudent academyStudent) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		try {
			session.save(academyStudent);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			throw e;
		}
	}

	@SuppressWarnings("deprecation")
	public void update(AcademyStudent academyStudent) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		try {
			session.update(academyStudent);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			throw e;
		}
	}

	@SuppressWarnings("deprecation")
	public void delete(AcademyStudent academyStudent) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		try {
			session.delete(academyStudent);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			throw e;
		}
	}

}
