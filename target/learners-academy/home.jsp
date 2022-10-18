<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Learner's Academy</title>
</head>
<body>
	<center>
		<h1>Learner's Academy</h1>
		<h2>
			<a href="<%=request.getContextPath()%>/home">Home</a>
			&nbsp;&nbsp;&nbsp; 
			<a href="<%=request.getContextPath()%>/logout">Logout</a>
		</h2>
		<h2>
			<a href="<%=request.getContextPath()%>/home/subjects/list">Academy Subjects</a>
			&nbsp;&nbsp;&nbsp; 
			<a href="<%=request.getContextPath()%>/home/teachers/list">Academy Teachers</a>
			&nbsp;&nbsp;&nbsp; 
			<a href="<%=request.getContextPath()%>/home/classes/list">Academy Classes</a>
			&nbsp;&nbsp;&nbsp; 
			<a href="<%=request.getContextPath()%>/home/students/list">Academy Students</a>
		</h2>
	</center>
    <div align="center">
        <form action="home/report" method="post">
        <h2>Class Report</h2>
        <table border="1" cellpadding="5">
            <caption>
            </caption>
            <tr>
                <th>Class : </th>
				<td>
					<select name="classId" required="true">
						<c:forEach var="vClass" items="${classMap}">
							<option value="${vClass.key}">${vClass.value}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Generate Report" />
                </td>
            </tr>
        </table>
        </form>
    </div>
</body>
</html>