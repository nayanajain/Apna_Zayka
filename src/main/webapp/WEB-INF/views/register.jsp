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
	background-image: url("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSoUaWuJ25Fm3avjEi9qej4AzjsJabhY9IOtg&usqp=CAU");
	background-size: cover;
	color: white;
	}
	</style>
	
<body>
<form:form action="doregister" method="post" modelAttribute="restaurent">

	<div class=" container text-center border border-secondary rounded p-4"
		style="max-width: 37%; max-height: 120%; margin-top: 25px">
		<h2>Create Account</h2>
		<!-- <img alt="register" src="">  -->

		<h6 style="color: blue;font-weight: bold;">${message }</h6>
		
		<form:input type="number" path="id" placeholder="Enter your name"  
			class="form-control" readonly="true"/>
		<br />
		
		<form:input ty="text" path="name" placeholder="Enter your name" value="${restaurent.name}"
			class="form-control" required="required" />
		<br />
		
		
		<form:input type="text" path="price"
			placeholder="Enter your price" class="form-control" value="${restaurent.price}"
			required="required" />
		<br />
		<form:input type="text" path="catagory" placeholder="Enter your catagory i.e fruit, salad,starter, lunch" value="${restaurent.catagory}"
			class="form-control" required="required" />
		<br />
		
		<div class="form-check">

			<input class="form-check-input" type="radio" name="type" id="t1" value="veg"
				checked="checked" />&nbsp; &nbsp; &nbsp; 
			Veg  &nbsp; &nbsp;
			<input class="form-check-input" type="radio" name="type" id="t2" value="Non-Veg" />&nbsp; &nbsp; &nbsp; 
			Non Veg

		</div>
		
		
		
		 	


		<input type="submit" value="Submit" class="btn btn-info"
			style="width: 100%; margin-top: 3vh;">

	</div>

</form:form>
</body>