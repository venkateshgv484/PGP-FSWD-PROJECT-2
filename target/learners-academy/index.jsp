<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Learner's Academy</title>
</head>
<body style="background-color:#80e5ff;">
	<div align="center">
		<h1>Learner's Academy Login Portal</h1>
	</div>
	<div align="center">
		<form action="<%=request.getContextPath()%>/login" method="post">
			<table border="1" cellpadding="5">
				<tr>
					<th>User Name:</th>
					<td><input type="text" name="username" size="45" /></td>
				</tr>
				<tr>
					<th>Password:</th>
					<td><input type="password" name="password" size="45" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Login" /></td>
				</tr>
			</table>
		</form>
	</div>
	<div style="text-align: center; color: red;">${errors}</div>
</body>
</html>
