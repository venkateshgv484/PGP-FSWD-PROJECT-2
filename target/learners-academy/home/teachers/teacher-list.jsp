<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Learner's Academy</title>
</head>
<body>
    <center>
        <h1>Learner's Academy Teachers</h1>
		<h2>
			<a href="<%=request.getContextPath()%>/home">Home</a>
			&nbsp;&nbsp;&nbsp; 
			<a href="<%=request.getContextPath()%>/logout">Logout</a>
		</h2>
        <h2>
            <a href="<%=request.getContextPath()%>/home/teachers/new">Add New Teacher</a>
            &nbsp;&nbsp;&nbsp;
            <a href="<%=request.getContextPath()%>/home/teachers/list">List All Teachers</a>
             
        </h2>
    </center>
    <div align="center">
		<h2>List of Teachers</h2>
        <table border="1" cellpadding="5">
            <caption></caption>
            <tr>
                <th>ID</th>
                <th>Teacher Code</th>
                <th>Teacher Name</th>
            </tr>
            <c:forEach var="academyTeacher" items="${academyTeacherList}">
                <tr>
                    <td><c:out value="${academyTeacher.id}" /></td>
                    <td><c:out value="${academyTeacher.teacherCode}" /></td>
                    <td><c:out value="${academyTeacher.teacherName}" /></td>
                    <td>
                        <a href="<%=request.getContextPath()%>/home/teachers/edit?id=<c:out value='${academyTeacher.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="<%=request.getContextPath()%>/home/teachers/delete?id=<c:out value='${academyTeacher.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
	<div style= "text-align: center; color: red;">${errors}</div>
</body>
</html>