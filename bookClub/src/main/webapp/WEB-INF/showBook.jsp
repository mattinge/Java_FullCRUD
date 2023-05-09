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
	<title>Book Details</title>
</head>
<body>
	<h1>Welcome <c:out value="${user.name}"/></h1>
	<div>
		<h2>Edit a Book:</h2>
		<p><a href="/logout">Logout</a></p>
		<p><a href="/books">All Books:</a></p>
		<p><a href="/add">Add Book:</a></p>
	</div>
	<div>
		<h4><c:out value="${book.user.name}"/> read <c:out value="${book.title}"/> by <c:out value="${book.author}"/></h4>
	</div>
	<div>
		<h4>Here are their thoughts:</h4>
		<hr />
			<p><c:out value="${book.thoughts}"/></p>
		<hr />
	</div>
</body>
</html>