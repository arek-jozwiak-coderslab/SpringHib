<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>List books</h1>
	<table>
		<tr>
			<th>Title</th>
			<th>Author</th>
			<th>rating</th>
			<th>Akcje</th>
		</tr>
		<c:forEach items="${books}" var="boo">
			<tr>
				<td>${boo.title}</td>
				<td>${boo.author}</td>
				<td>${boo.rating}</td>
				<td><a href="">Usuń</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>