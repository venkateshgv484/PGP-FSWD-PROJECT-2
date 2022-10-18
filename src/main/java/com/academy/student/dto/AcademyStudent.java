package com.academy.student.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "ACADEMY_STUDENTS", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "ROLL_NO" }, name = "UK_ACADEMY_STUDENTS") })
public class AcademyStudent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;

	@NotEmpty
	@Size(max = 20)
	@Column(name = "ROLL_NO", length = 20, nullable = false)
	private String rollNo;

	@NotEmpty
	@Column(name = "STUDENT_NAME", length = 512, nullable = false)
	private String studentName;

	@NotEmpty
	@Pattern(regexp = "^(.+)@(.+)$")
	@Column(name = "EMAIL_ID", length = 512, nullable = false)
	private String email;

	@Min(value = 0L)
	@Column(name = "CLASS_ID")
	private long classId;

	public AcademyStudent() {
		super();
	}

	public AcademyStudent(String rollNo, String studentName, String email, long classId) {
		super();
		this.rollNo = rollNo;
		this.studentName = studentName;
		this.email = email;
		this.classId = classId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getClassId() {
		return classId;
	}

	public void setClassId(long classId) {
		this.classId = classId;
	}

	@Override
	public String toString() {
		return "AcademyStudent [id=" + id + ", rollNo=" + rollNo + ", studentName=" + studentName + ", email=" + email
				+ ", classId=" + classId + "]";
	}

}
