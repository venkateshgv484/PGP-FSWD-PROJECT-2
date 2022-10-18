<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Learner's Academy</title>
</head>
<body style="background-color:#80e5ff;">
    <center>
        <h1>Learner's Academy Classes</h1>
		<h2>
			<a href="<%=request.getContextPath()%>/home">Home</a>
			&nbsp;&nbsp;&nbsp; 
			<a href="<%=request.getContextPath()%>/logout">Logout</a>
		</h2>
        <h2>
            <a href="<%=request.getContextPath()%>/home/classes/new">Add New Class</a>
            &nbsp;&nbsp;&nbsp;
            <a href="<%=request.getContextPath()%>/home/classes/list">List All Classes</a>
             
        </h2>
    </center>
    <div align="center">
		<h2>List of Classes</h2>
        <table border="1" cellpadding="5">
            <caption></caption>
            <tr>
                <th>ID</th>
                <th>Class Code</th>
                <th>Class Name</th>
            </tr>
            <c:forEach var="academyClass" items="${academyClassList}">
                <tr>
                    <td><c:out value="${academyClass.id}" /></td>
                    <td><c:out value="${academyClass.classCode}" /></td>
                    <td><c:out value="${academyClass.className}" /></td>
                    <td>
                        <a href="<%=request.getContextPath()%>/home/classes/edit?id=<c:out value='${academyClass.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="<%=request.getContextPath()%>/home/classes/delete?id=<c:out value='${academyClass.id}' />">Delete</a>                     
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="<%=request.getContextPath()%>/home/classes/assignment/list?classId=<c:out value='${academyClass.id}' />">Assign Subjects & Teachers</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
	<div style= "text-align: center; color: red;">${errors}</div>
</body>
</html>