<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix = "sec" uri = "http://www.springframework.org/security/tags" %>


<head>
<style>
table
{
height: 40%;
width: 30%;
margin-left: 35%;
margin-right: 15%;
}
</style>
</head>


<div class="row">

	<div class="col-lg-12">
	
		
			<h3>Details here</h3>
			<span>Salon</span> <br>
			<h3>${info }</h3>
			<br>
			
			
	
	</div>
	
	<table border="1" >
	<tr>
			
			<th>Name of Food</th>
			<th>Price</th>
			
		</tr>
	<c:forEach items="${totalorders}" var="rs">
	
	<tr>
					
						<th>${rs.food.name}</th>&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; 
						<th><b>${rs.price}</b></th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</tr>
                    </c:forEach>
                    </table>

</div>