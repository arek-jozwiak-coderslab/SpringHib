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
			<th>Name</th>
			<th>LocalName</th>
			<th>rating</th>
			<th>Akcje</th>
		</tr>
		<c:forEach items="${burgers}" var="burger">
			<tr>
				<td>${burger.name}</td>
				<td>${burger.localName}</td>
				<td>${burger.size}</td>
				<td>
			<!-- 	<a href = "<c:url value = "/burger/delete/${burger.id}"/>">USUŃ</a>
				<a href="${pageContext.servletContext.contextPath}/burger/delete/${burger.id}">Usuń</a>
				-->
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>