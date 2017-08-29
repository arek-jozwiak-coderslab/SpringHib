<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Add person</h1>
	<form:form method="post" modelAttribute="person">
	Login:
		<form:input path="login" />
	Password:
		<form:password path="password" />
	Email:				
		<form:input path="email" />
		<input type="submit" value="Save">
	</form:form>
</body>
</html>