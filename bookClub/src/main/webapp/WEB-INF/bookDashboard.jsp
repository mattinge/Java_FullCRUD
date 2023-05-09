<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- form:form -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Book Dashboard</title>
</head>
<body>
	<h1>Welcome <c:out value="${user.name}"/></h1>
	<div>
		<h2>Books from all Shelves:</h2>
		<p><a href="/logout">Logout</a></p>
		<p><a href="/addBook">Add Book to your shelf:</a></p>
	</div>
	<div>
		<table>
			<tr>
				<th>Id</th>
				<th>Title</th>
				<th>Author</th>
				<th>Posted by</th>
			</tr>
			<c:forEach var="book" items="${books}">
				<tr>
					<td><c:out value="${book.id}"/></td>
					<td><a href="/books/${book.id}"><c:out value="${book.title}"></c:out></a></td>
					<td><c:out value="${book.author}"/></td>
					<td><c:out value="${book.user.name}"/></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>