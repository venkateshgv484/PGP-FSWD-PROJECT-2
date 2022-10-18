<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Learner's Academy</title>
</head>
<body>
	<center>
		<h1>Learner's Academy Classes</h1>
		<h2>
			<a href="<%=request.getContextPath()%>/home">Home</a>
			&nbsp;&nbsp;&nbsp; <a href="<%=request.getContextPath()%>/logout">Logout</a>
		</h2>
		<h2>
			<a href="<%=request.getContextPath()%>/home/classes/new">Add New
				Class</a> &nbsp;&nbsp;&nbsp; <a
				href="<%=request.getContextPath()%>/home/classes/list">List All
				Classes</a>

		</h2>
	</center>
	<div align="center">
		<c:if test="${!isNew}">
			<form action="update" method="post">
		</c:if>
		<c:if test="${isNew}">
			<form action="insert" method="post">
		</c:if>
		<h2>
			<c:if test="${!isNew}">
                Edit Class
            </c:if>
			<c:if test="${isNew}">
                Add New Class
            </c:if>
		</h2>
		<table border="1" cellpadding="5">
			<caption></caption>
			<c:if test="${!isNew}">
				<input type="hidden" name="id"
					value="<c:out value='${academyClass.id}' />" />
			</c:if>
			<tr>
				<th>Class Code:</th>
				<td><input type="text" name="classCode" size="20"
					value="<c:out value='${academyClass.classCode}' />"
					<c:if test="${!isNew}">
						readOnly="true"
					</c:if> /></td>
			</tr>
			<tr>
				<th>Class Name:</th>
				<td><input type="text" name="className" size="45"
					value="<c:out value='${academyClass.className}' />" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Save" /></td>
			</tr>
		</table>
		</form>
	</div>
	<div style= "text-align: center; color: red;">${errors}</div>
</body>
</html>
