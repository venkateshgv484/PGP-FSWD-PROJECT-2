package com.academy.classsubjectteacher.dao;

import java.util.List;

import org.hibernate.Session;

import com.academy.classsubjectteacher.dto.AcademyClassSubjectTeacher;
import com.academy.utils.HibernateUtils;

public class AcademyClassSubjectTeacherDAO {

	public List<AcademyClassSubjectTeacher> listAllClassSubjectTeachers() {
		Session session = HibernateUtils.getSessionFactory().openSession();
		return session.createQuery("from AcademyClassSubjectTeacher", AcademyClassSubjectTeacher.class).list();
	}

	public List<AcademyClassSubjectTeacher> listAllClassSubjectTeachers(long classId) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		return session.createQuery("select acst from AcademyClassSubjectTeacher acst where acst.classId = " + classId,
				AcademyClassSubjectTeacher.class).list();
	}

	public AcademyClassSubjectTeacher getClassSubjectTeacher(long id) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		return session.get(AcademyClassSubjectTeacher.class, id);
	}

	@SuppressWarnings("deprecation")
	public void insert(AcademyClassSubjectTeacher academyClass) {
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
	public void update(AcademyClassSubjectTeacher academyClass) {
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
	public void delete(AcademyClassSubjectTeacher academyClass) {
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

	@SuppressWarnings("deprecation")
	public void deleteByClassId(long classId) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		try {
			session.createQuery("delete AcademyClassSubjectTeacher where classId = " + classId)
					.executeUpdate();
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			throw e;
		}
	}

}
