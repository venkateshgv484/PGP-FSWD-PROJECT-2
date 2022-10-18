package com.academy.classes.dto;

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
@Table(name = "ACADEMY_CLASSES", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "CLASS_CODE" }, name = "UK_ACADEMY_CLASSES") })
public class AcademyClass {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;

	@NotEmpty
	@Size(max = 50)
	@Column(name = "CLASS_CODE", length = 50, nullable = false)
	private String classCode;

	@NotEmpty
	@Size(max = 512)
	@Column(name = "CLASS_NAME", length = 512, nullable = false)
	private String className;

	public AcademyClass() {
		super();
	}

	public AcademyClass(String classCode, String className) {
		super();
		this.classCode = classCode;
		this.className = className;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Override
	public String toString() {
		return "AcademyClass [id=" + id + ", classCode=" + classCode + ", className=" + className + "]";
	}

}
