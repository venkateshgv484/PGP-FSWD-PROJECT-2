<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Learner's Academy</title>
</head>
<body>
    <center>
        <h1>Learner's Academy Students</h1>
		<h2>
			<a href="<%=request.getContextPath()%>/home">Home</a>
			&nbsp;&nbsp;&nbsp; 
			<a href="<%=request.getContextPath()%>/logout">Logout</a>
		</h2>
        <h2>
            <a href="<%=request.getContextPath()%>/home/students/new">Add New Student</a>
            &nbsp;&nbsp;&nbsp;
            <a href="<%=request.getContextPath()%>/home/students/list">List All Students</a>
             
        </h2>
    </center>
    <div align="center">
		<h2>List of Students</h2>
        <table border="1" cellpadding="5">
            <caption></caption>
            <tr>
                <th>ID</th>
                <th>Student Name</th>
                <th>Email</th>
                <th>Class</th>
            </tr>
            <c:forEach var="academyStudent" items="${academyStudentList}">
                <tr>
                    <td><c:out value="${academyStudent.id}" /></td>
                    <td><c:out value="${academyStudent.studentName}" /></td>
                    <td><c:out value="${academyStudent.email}" /></td>
                    <td><c:out value="${classMap.get(academyStudent.classId)}" /></td>
                    <td>
                        <a href="<%=request.getContextPath()%>/home/students/edit?id=<c:out value='${academyStudent.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="<%=request.getContextPath()%>/home/students/delete?id=<c:out value='${academyStudent.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>