package com.academy.classsubjectteacher.dto;

import javax.validation.constraints.Min;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "ACADEMY_CLASS_SUBJECT_TEACHERS", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "CLASS_ID", "SUBJECT_ID" }, name = "UK_ACADEMY_CLASS_SUBJECT_TEACHERS") })
public class AcademyClassSubjectTeacher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;

	@Min(value = 0L)
	@Column(name = "CLASS_ID", nullable = false)
	private long classId;
	
	@Min(value = 0L)
	@Column(name = "SUBJECT_ID", nullable = false)
	private long subjectId;
	
	@Min(value = 0L)
	@Column(name = "TEACHER_ID", nullable = false)
	private long teacherId;

	public AcademyClassSubjectTeacher() {
		super();
	}

	public AcademyClassSubjectTeacher(long classId, long subjectId, long teacherId) {
		super();
		this.classId = classId;
		this.subjectId = subjectId;
		this.teacherId = teacherId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getClassId() {
		return classId;
	}

	public void setClassId(long classId) {
		this.classId = classId;
	}

	public long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}

	public long getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(long teacherId) {
		this.teacherId = teacherId;
	}

	@Override
	public String toString() {
		return "AcademyClassSubjectTeacher [id=" + id + ", classId=" + classId + ", subjectId=" + subjectId
				+ ", teacherId=" + teacherId + "]";
	}

}
