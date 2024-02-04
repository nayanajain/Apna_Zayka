<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	<style>
	body
	{
	font-weight: bold;
	align-items: center;

	background: linear-gradient(rgba(0,49,67,0.2),rgba(67,67,0,0.8));
	background-image: url("https://us.123rf.com/450wm/kishivan/kishivan1901/kishivan190100311/116675770-image-of-wooden-table-in-front-of-abstract-blurred-background-of-resturant-lights.jpg?ver=6");
	background-size: cover;
	color: white;
	}
	</style>
	
<body>
<form action="process-forgot-password" method="post">

 	<div class=" container text-center border border-secondary rounded p-4"
		style="max-width: 37%; max-height: 120%; margin-top: 75px">
		<h2>Forgot Password?</h2>
		<!-- <img alt="register" src="">  -->
        <p>Enter the email address associated with your account</p>
		<h6 style="color: blue;font-weight: bold;">${message }</h6>
		
		<input type="email" name="email" placeholder="Enter your email"  
			class="form-control" />
		<br />
		<input type="submit" value="Submit" class="btn btn-info"
			style="width: 100%; margin-top: 3vh;">

	</div>
 
</form>
</body>