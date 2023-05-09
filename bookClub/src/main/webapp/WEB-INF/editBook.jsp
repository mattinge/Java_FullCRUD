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
	<title>Edit Book</title>
</head>
<body>
	<h1>Welcome <c:out value="${user.name}"/></h1>
	<div>
		<h2>Edit a Book:</h2>
		<p><a href="/logout">Logout</a></p>
		<p><a href="/books">All Books:</a></p>
	</div>
	<div>
		<h2>Edit Book:</h2>
		<div>
			<form:form action="/edit/${book.id}" method="post" modelAttribute="book">
				<input type="hidden" name="_method" value="put"/>
				<div>
					<form:label path="title">Book Title:</form:label>
					<form:input path="title"/>
					<form:errors path="title"/>
				</div>
				<div>
					<form:label path="author">Author:</form:label>
					<form:input path="author"/>
					<form:errors path="author"/>
				</div>
				<div>
					<form:label path="myThoughts">My Thoughts:</form:label>
					<form:textarea path="myThoughts"/>
					<form:errors path="myThoughts"/>
				</div>
				<div>
					<form:input type="hidden" path="user" value="${user.id}"/>
					
				</div>
				<input type="submit" value="Add Book"/>
			</form:form>
		</div>
	</div>
</body>
</html>