package com.academy.teacher.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "ACADEMY_TEACHERS", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "TEACHER_CODE" }, name = "UK_ACADEMY_TEACHERS") })
public class AcademyTeacher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;

	@NotEmpty
	@Size(max = 50)
	@Column(name = "TEACHER_CODE", length = 50, nullable = false)
	private String teacherCode;

	@NotEmpty
	@Size(max = 512)
	@Column(name = "TEACHER_NAME", length = 512, nullable = false)
	private String teacherName;

	public AcademyTeacher() {
		super();
	}

	public AcademyTeacher(String teacherCode, String teacherName) {
		super();
		this.teacherCode = teacherCode;
		this.teacherName = teacherName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTeacherCode() {
		return teacherCode;
	}

	public void setTeacherCode(String teacherCode) {
		this.teacherCode = teacherCode;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	@Override
	public String toString() {
		return "AcademyTeacher [id=" + id + ", teacherCode=" + teacherCode + ", teacherName=" + teacherName + "]";
	}

}
