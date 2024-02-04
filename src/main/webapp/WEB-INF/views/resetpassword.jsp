<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<meta charset="ISO-8859-1">
<title>Forgot Password</title>
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
</head>
<body>

<form action="process-reset-password" method="post">
   
   <input type="hidden" name="token" value="${token }"/>
	<div class=" container text-center border border-secondary rounded p-3" style="max-width: 350px; margin-top: 40px;" >
		<h5>${message}</h5>
		<h5>${errorMsg}</h5>
		<h5>${successMsg }</h5>
		<h2>Reset Password</h2>
		
		<p>
		<input type="password" name="pwd1"  class="form-control" placeholder="Enter new password" required="required">
		</p>
		<p>
		<input type="password" name="pwd2"  class="form-control" placeholder="confirm new password" required="required" ">
		</p>
		
		<input type="submit" value="Change Password"  class="btn btn-info"  style="width: 100%; margin-top: 3vh;">
			</button>
		</div>

</form>




</body>
</html>