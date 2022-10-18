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
        <c:if test="${!isNew}">
            <form action="<%=request.getContextPath()%>/home/classes/assignment/update" method="post">
        </c:if>
        <c:if test="${isNew}">
            <form action="<%=request.getContextPath()%>/home/classes/assignment/insert" method="post">
        </c:if>
        <input type="hidden" name="classId" value="<c:out value='${academyClass.id}' />" />
        <h2>
            <c:if test="${!isNew}">
                Edit Subject and Teacher
            </c:if>
            <c:if test="${isNew}">
                Add New Subject and Teacher
            </c:if>
        </h2>
        <table border="1" cellpadding="5">
            <caption>
            </caption>
            <c:if test="${!isNew}">
                <input type="hidden" name="id" value="<c:out value='${academyClassSubjectTeacher.id}' />" />
            </c:if>
            <tr>
                <th>Select Subject: </th>
				<td>
					<select name="subjectId" required="true">
						<c:forEach var="vSubject" items="${subjectMap}">
					        <c:if test="${academyClassSubjectTeacher == null}">
								<option value="${vSubject.key}">${vSubject.value}</option>
					        </c:if>
					        <c:if test="${academyClassSubjectTeacher != null}">
					        	<c:if test="${academyClassSubjectTeacher.subjectId != vSubject.key}">
									<option value="${vSubject.key}">${vSubject.value}</option>
					        	</c:if>
					        	<c:if test="${academyClassSubjectTeacher.subjectId == vSubject.key}">
									<option value="${vSubject.key}" selected="true">${vSubject.value}</option>
					        	</c:if>
					        </c:if>
						</c:forEach>
					</select> 
				</td>
			</tr>
            <tr>
                <th>Select Teacher: </th>
				<td>
					<select name="teacherId" required="true">
						<c:forEach var="vTeacher" items="${teacherMap}">
					        <c:if test="${academyClassSubjectTeacher == null}">
								<option value="${vTeacher.key}">${vTeacher.value}</option>
					        </c:if>
					        <c:if test="${academyClassSubjectTeacher != null}">
					        	<c:if test="${academyClassSubjectTeacher.teacherId != vTeacher.key}">
									<option value="${vTeacher.key}">${vTeacher.value}</option>
					        	</c:if>
					        	<c:if test="${academyClassSubjectTeacher.teacherId == vTeacher.key}">
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
	<div style= "text-align: center; color: red;">${errors}</div>
</body>
</html>
