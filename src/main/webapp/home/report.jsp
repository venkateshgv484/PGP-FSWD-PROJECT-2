<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Learner's Academy</title>
</head>
<body style="background-color:#80e5ff;">
	<center>
		<h1>Learner's Academy Class Report</h1>
		<h2>
			<a href="<%=request.getContextPath()%>/home">Home</a>
			&nbsp;&nbsp;&nbsp; <a href="<%=request.getContextPath()%>/logout">Logout</a>
		</h2>
	</center>
	<c:if test="${academyClass != null}">
		<div align="center">
			<h2>Class Details</h2>
			<table border="1" cellpadding="5">
				<caption>
				</caption>
				<tr>
					<th>ID</th>
					<th>Class Code</th>
					<th>Class Name</th>
				</tr>
				<tr>
					<td><c:out value="${academyClass.id}" /></td>
					<td><c:out value="${academyClass.classCode}" /></td>
					<td><c:out value="${academyClass.className}" /></td>
				</tr>
			</table>
		</div>
	</c:if>
	<c:if test="${(classSubjectTeachers != null) && !classSubjectTeachers.isEmpty()}">
		<div align="center">
			<h2>List of Subject and Teachers assigned to the Class</h2>
			<table border="1" cellpadding="5">
				<caption>
				</caption>
				<tr>
					<th>ID</th>
					<th>Subject</th>
					<th>Teacher</th>
				</tr>
				<c:forEach var="classSubjectTeacher" items="${classSubjectTeachers}">
					<tr>
						<td><c:out value="${classSubjectTeacher.id}" /></td>
						<td><c:out
								value="${subjectMap.get(classSubjectTeacher.subjectId)}" /></td>
						<td><c:out
								value="${teacherMap.get(classSubjectTeacher.teacherId)}" /></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</c:if>
	<c:if test="${(classStudents != null) && !classStudents.isEmpty()}">
		<div align="center">
			<h2>List of Students in the Class</h2>
			<table border="1" cellpadding="5">
				<caption>
				</caption>
				<tr>
					<th>ID</th>
					<th>Roll No</th>
					<th>Student Name</th>
					<th>Email ID</th>
				</tr>
				<c:forEach var="academyStudent" items="${classStudents}">
					<tr>
						<td><c:out value="${academyStudent.id}" /></td>
						<td><c:out value="${academyStudent.rollNo}" /></td>
						<td><c:out value="${academyStudent.studentName}" /></td>
						<td><c:out value="${academyStudent.email}" /></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</c:if>
</body>
</html>