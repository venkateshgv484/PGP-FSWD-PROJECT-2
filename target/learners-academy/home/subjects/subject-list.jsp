<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Learner's Academy</title>
</head>
<body style="background-color:#80e5ff;">
    <center>
        <h1>Learner's Academy Subjects</h1>
		<h2>
			<a href="<%=request.getContextPath()%>/home">Home</a>
			&nbsp;&nbsp;&nbsp; 
			<a href="<%=request.getContextPath()%>/logout">Logout</a>
		</h2>
        <h2>
            <a href="<%=request.getContextPath()%>/home/subjects/new">Add New Subject</a>
            &nbsp;&nbsp;&nbsp;
            <a href="<%=request.getContextPath()%>/home/subjects/list">List All Subjects</a>
             
        </h2>
    </center>
    <div align="center">
    	<h2>List of Subjects</h2>
        <table border="1" cellpadding="5">
            <caption></caption>
            <tr>
                <th>ID</th>
                <th>Subject Code</th>
                <th>Subject Title</th>
            </tr>
            <c:forEach var="academySubject" items="${academySubjectList}">
                <tr>
                    <td><c:out value="${academySubject.id}" /></td>
                    <td><c:out value="${academySubject.subjectCode}" /></td>
                    <td><c:out value="${academySubject.subjectName}" /></td>
                    <td>
                        <a href="<%=request.getContextPath()%>/home/subjects/edit?id=<c:out value='${academySubject.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="<%=request.getContextPath()%>/home/subjects/delete?id=<c:out value='${academySubject.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
    <div style= "text-align: center; color: red;">${errors}</div>
</body>
</html>