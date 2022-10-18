<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Learner's Academy</title>
</head>
<body>
    <center>
        <h1>Learner's Academy Classes</h1>
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
    </center>
    <div align="center">
        <c:if test="${entity != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${entity == null}">
            <form action="insert" method="post">
        </c:if>
        <input type="hidden" name="classId" value="<c:out value='${academyClass.id}' />" />
        <h2>
            <c:if test="${entity != null}">
                Edit Subject and Teacher
            </c:if>
            <c:if test="${entity == null}">
                Add New Subject and Teacher
            </c:if>
        </h2>
        <table border="1" cellpadding="5">
            <caption>
            </caption>
            <c:if test="${entity != null}">
                <input type="hidden" name="id" value="<c:out value='${entity.id}' />" />
            </c:if>
            <tr>
                <th>Subject Title: </th>
				<td>
					<select name="subjectId" required="true">
						<c:forEach var="vSubject" items="${subjectMap}">
					        <c:if test="${entity == null}">
								<option value="${vSubject.key}">${vSubject.value}</option>
					        </c:if>
					        <c:if test="${entity != null}">
					        	<c:if test="${entity.subjectId != vSubject.key}">
									<option value="${vSubject.key}">${vSubject.value}</option>
					        	</c:if>
					        	<c:if test="${entity.subjectId == vSubject.key}">
									<option value="${vSubject.key}" selected="true">${vSubject.value}</option>
					        	</c:if>
					        </c:if>
						</c:forEach>
					</select> 
				</td>
			</tr>
            <tr>
                <th>Teacher Title: </th>
				<td>
					<select name="teacherId" required="true">
						<c:forEach var="vTeacher" items="${teacherMap}">
					        <c:if test="${entity == null}">
								<option value="${vTeacher.key}">${vTeacher.value}</option>
					        </c:if>
					        <c:if test="${entity != null}">
					        	<c:if test="${entity.teacherId != vTeacher.key}">
									<option value="${vTeacher.key}">${vTeacher.value}</option>
					        	</c:if>
					        	<c:if test="${entity.teacherId == vTeacher.key}">
									<option value="${vTeacher.key}"  selected="true">${vTeacher.value}</option>
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
