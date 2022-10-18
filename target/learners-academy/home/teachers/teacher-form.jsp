<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Learner's Academy</title>
</head>
<body style="background-color:#80e5ff;">
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
        <c:if test="${!isNew}">
            <form action="<%=request.getContextPath()%>/home/teachers/update" method="post">
        </c:if>
        <c:if test="${isNew}">
            <form action="<%=request.getContextPath()%>/home/teachers/insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${!isNew}">
                        Edit Teacher
                    </c:if>
                    <c:if test="${isNew}">
                        Add New Teacher
                    </c:if>
                </h2>
            </caption>
                <c:if test="${!isNew}">
                    <input type="hidden" name="id" value="<c:out value='${academyTeacher.id}' />" />
                </c:if>
			<tr>
				<th>Teacher Code:</th>
				<td><input type="text" name="teacherCode" size="20"
					value="<c:out value='${academyTeacher.teacherCode}' />"
					<c:if test="${!isNew}">
	                    readonly="true"
	                </c:if> />
				</td>
			</tr>
			<tr>
                <th>Teacher Name: </th>
				<td><input type="text" name="teacherName" size="45"
					value="<c:out value='${academyTeacher.teacherName}' />" />
				</td>
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
