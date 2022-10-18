<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Learner's Academy</title>
</head>
<body>
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
        <c:if test="${!isNew}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${isNew}">
            <form action="insert" method="post">
        </c:if>
        <h2>
            <c:if test="${!isNew}">
                Edit Subject
            </c:if>
            <c:if test="${isNew}">
                Add New Subject
            </c:if>
        </h2>
        <table border="1" cellpadding="5">
            <caption>
            </caption>
                <c:if test="${!isNew}">
                    <input type="hidden" name="id" value="<c:out value='${academySubject.id}' />" />
                </c:if>
			<tr>
				<th>Subject Code:</th>
				<td><input type="text" name="subjectCode" size="20" 
					value="<c:out value='${academySubject.subjectCode}' />"
					<c:if test="${!isNew}">
						readOnly=”true”
                	</c:if> />
                </td>
			</tr>
			<tr>
                <th>Subject Title: </th>
                <td><input type="text" name="subjectName" size="45"
					value="<c:out value='${academySubject.subjectName}' />" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
        </table>
        </form>
    </div>
    <div style= "text-align: center; color: red;">${errors}</div>
</body>
</html>
