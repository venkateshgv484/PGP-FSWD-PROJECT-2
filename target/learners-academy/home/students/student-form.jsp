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
        <c:if test="${!isNew}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${isNew}">
            <form action="insert" method="post">
        </c:if>
        <h2>
            <c:if test="${!isNew}">
                Edit Student
            </c:if>
            <c:if test="${isNew}">
                Add New Student
            </c:if>
        </h2>
        <table border="1" cellpadding="5">
            <caption>
            </caption>
                <c:if test="${!isNew}">
                    <input type="hidden" name="id" value="<c:out value='${academyStudent.id}' />" />
                </c:if>           
            <tr>
                <th>Student Name: </th>
                <td>
                    <input type="text" name="studentName" size="45" required="true"
                            value="<c:out value='${academyStudent.studentName}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Email: </th>
                <td>
                    <input type="email" name="email" size="45" required="true"
                            value="<c:out value='${academyStudent.email}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Class : </th>
				<td>
					<select name="classId" required="true">
						<c:forEach var="vClass" items="${classMap}">
					        <c:if test="${academyStudent == null}">
								<option value="${vClass.key}">${vClass.value}</option>
					        </c:if>
					        <c:if test="${academyStudent != null}">
					        	<c:if test="${academyStudent.classId != vClass.key}">
									<option value="${vClass.key}">${vClass.value}</option>
					        	</c:if>
					        	<c:if test="${academyStudent.classId == vClass.key}">
									<option value="${vClass.key}"  selected="true">${vClass.value}</option>
					        	</c:if>
					        </c:if>
						</c:forEach>
					</select> 
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
</body>
</html>
