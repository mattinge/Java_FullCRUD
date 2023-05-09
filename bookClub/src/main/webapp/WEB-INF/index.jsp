<!doctype html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- form:form -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>

<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Login & Registration</title>
</head>
<body>
	<div>
		<h2>Register</h2>
		<div>
			<form:form action="/register" method="post" modelAttribute="registerUser">
				<div>
					<form:label path="name">Name:</form:label>
					<form:input path="name"/>
					<form:errors path="name"/>
				</div>
				<div>
					<form:label path="email">Email:</form:label>
					<form:input path="email"/>
					<form:errors path="email"/>
				</div>
				<div>
					<form:label path="password">Password:</form:label>
					<form:password path="password"/>
					<form:errors path="password"/>
				</div>
				<div>
					<form:label path="confirmPassword">Confirm Password:</form:label>
					<form:password path="confirmPassword"/>
					<form:errors path="confirmPassword"/>
				</div>
				<input type="submit" value="Register"/>
			</form:form>
		</div>
	</div>
	
	<div>
		<h3>Login</h3>
		<form:form action="/login" method="post" modelAttribute="loginUser">
			<div>
					<form:label path="loginEmail">Email:</form:label>
					<form:input path="loginEmail"/>
					<form:errors path="loginEmail"/>
				</div>
				<div>
					<form:label path="loginPassword">Password:</form:label>
					<form:password path="loginPassword"/>
					<form:errors path="loginPassword"/>
				</div>
				<input type="submit" value="Login"/>
		</form:form>
	</div>
	
</body>
</html>