<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Learner's Academy</title>
</head>
<body>
    <div align="center">
        <h1>Learner's Academy - Subject, Teacher Assignment to Class</h1>
		<h2>
			<a href="<%=request.getContextPath()%>/home">Home</a>
			&nbsp;&nbsp;&nbsp; 
            <a href="<%=request.getContextPath()%>/home/classes/list">List All Classes</a>
            &nbsp;&nbsp;&nbsp;
			<a href="<%=request.getContextPath()%>/logout">Logout</a>
		</h2>
		<h2>
			<div align="center">
				<h2>Class Details</h2>
				<table border="1" cellpadding="5">
					<caption>
					</caption>
					<tr>
						<th>ID</th>
						<th>Class Tittle</th>
					</tr>
					<tr>
						<td><c:out value="${academyClass.id}" /></td>
						<td><c:out value="${academyClass.className}" /></td>
					</tr>
				</table>
			</div>
		</h2>
		<h2>
            <a href="<%=request.getContextPath()%>/home/classes/assignment/new?classId=<c:out value='${academyClass.id}' />">Add New Subject and Teacher</a>
            &nbsp;&nbsp;&nbsp;
            <a href="<%=request.getContextPath()%>/home/classes/assignment/list?classId=<c:out value='${academyClass.id}' />">List All Subject and Teachers</a>
             
        </h2>
		<h2>List of Subject and Teachers</h2>
        <table border="1" cellpadding="5">
            <caption></caption>
            <tr>
                <th>ID</th>
                <th>Subject</th>
                <th>Teacher</th>
            </tr>
            <c:forEach var="entity" items="${list}">
                <tr>
                    <td><c:out value="${entity.id}" /></td>
                    <td><c:out value="${subjectMap.get(entity.subjectId)}" /></td>
                    <td><c:out value="${teacherMap.get(entity.teacherId)}" /></td>
                    <td>
                        <a href="<%=request.getContextPath()%>/home/classes/assignment/edit?id=<c:out value='${entity.id}' />&classId=<c:out value='${academyClass.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="<%=request.getContextPath()%>/home/classes/assignment/delete?id=<c:out value='${entity.id}' />&classId=<c:out value='${academyClass.id}' />">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>