<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../header.jsp" />  
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
	<h1>List books ółąśżź</h1>
	<table class="table table-striped table-bordered table-hover dataTable no-footer dtr-inline">
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
	</div>
	</div>
	</div>
<jsp:include page="../footer.jsp" />  