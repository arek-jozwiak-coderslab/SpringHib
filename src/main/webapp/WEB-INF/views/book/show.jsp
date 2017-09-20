<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Book details</h1>
	<p>${book.title}</p>
	<p>Author: ${book.author}</p>
	<p>Publisher: ${book.publisher}</p>
	<p>Authors: ${book.authors}</p>
</body>
</html>