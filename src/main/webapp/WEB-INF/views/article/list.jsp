<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>List atricles</h1>
	<table>
		<tr>
			<th>Id</th>
			<th>Content</th>
			<th>Author</th>
			<th>category</th>
		</tr>
		<c:forEach items="${articles}" var="article">
			<tr>
				<td>${article.id}</td>
				<td>${article.content}</td>
				<td>${article.author}</td>
				<td>${article.category}</td>
			</tr>
		</c:forEach>
	</table>
	
	<h1>List categories</h1>
	<table>
		<tr>
			<th>Id</th>
			<th>Category</th>
			<th>Akcja</th>
			
		</tr>
		<c:forEach items="${categories}" var="category">
			<tr>
				<td>${category.id}</td>
				<td>${category.name}</td>
				<td><a href="<c:url value = "/ex5/category/${category.id}"/>">pokaż artykuły z kategorii</a></td>
			</tr>
		</c:forEach>
	</table>
	
	
</body>
</html>