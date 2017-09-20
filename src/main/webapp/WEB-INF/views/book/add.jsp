<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.error {
	background-color: red;
	color: white;
}
</style>
</head>

<body>
	<h1>Add book</h1>
	<form:form method="post" modelAttribute="book">
		<div>
			Title:
			<form:input path="title" />
			<form:errors path="title" cssClass="error" />
		</div>
		<div>
			Description:
			<form:textarea path="description" />
		</div>
		<div>
			Publisher:
			<form:select itemValue="id" itemLabel="name" path="publisher"
				items="${publishers}" />
		</div>
		<div>
		Active:
			<form:radiobutton path="active" value="true" />
			<form:radiobutton path="active" value="false" />
		</div>
		<div>
			<input type="submit" value="Save">
		</div>
	</form:form>
</body>
</html>