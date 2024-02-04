<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<link rel="stylesheet"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
		integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
		crossorigin="anonymous">
	<style>
	label
	{
	font-size: 200%;
    font-family: Lucida Handwriting;
    text-align: center;
    color: red;
	}
	h2
	{
	font-family: Lucida Handwriting;
	}
</style>
<body>
	<form action="dologin" method="post">

		<div
			class=" container text-center border border-secondary rounded p-4"
			style="max-width: 37%; max-height: 50%; margin-top: 140px; top: 0;bottom: 0; left: 0; right: 0; position: absolute;">
			<h2>Login Here</h2><br>
			<!-- <img alt="register" src="">  -->
			<div class="form-group">
				<label for="username" class="text-info">Username:</label><br> <input
					type="text" name="username" id="username" class="form-control">
			</div>
			<div class="form-group">
				<label for="password" class="text-info">Password:</label><br> <input
					type="password" name="password" id="password" class="form-control">
			</div> 
			
			<input type="submit" value="Login now" class="btn btn-info"
			style="width: 100%; margin-top: 3vh;">
			<br><a  style="float: left; margin-top: 1vh;" href="/registeruser">Click here to Register</a>
			<a style="float: right;margin-top: 1vh;" href="/forgotpassword">Forgot Password</a>
		</div>

	</form>

</body>

</body>
</html>









	