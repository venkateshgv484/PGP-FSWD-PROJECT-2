package com.academy.subject.dto;

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
@Table(name = "ACADEMY_SUBJECTS", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "SUBJECT_CODE" }, name = "UK_ACADEMY_SUBJECTS") })
public class AcademySubject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;
	
	@NotEmpty
	@Size(max = 50)
	@Column(name = "SUBJECT_CODE", length = 50, nullable = false)
	private String subjectCode;

	@NotEmpty
	@Size(max = 512)
	@Column(name = "SUBJECT_NAME", length = 512, nullable = false)
	private String subjectName;

	public AcademySubject() {
		super();
	}

	public AcademySubject(String subjectCode, String subjectName) {
		super();
		this.subjectCode = subjectCode;
		this.subjectName = subjectName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	@Override
	public String toString() {
		return "AcademySubject [id=" + id + ", subjectCode=" + subjectCode + ", subjectName=" + subjectName + "]";
	}

}
