<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>


<head>
<style>
table
{

margin-left: 35%;
margin-right: 15%;
}
</style>
</head>


<div class="row" style="align-content: center;">

	<div class="col-lg-4">

		<h3>Details here</h3>

		<h3>${info }</h3>
		<br>
	</div>
	<table border="1" >
	<tr>
			
			<th>Name of Food</th>
			<th>Price</th>
			<th>Button</th>
			
		</tr>
	<div class="col-lg-4">
		<c:choose>

			<c:when test="${cart.size() > 0}">
				<c:forEach items="${cart}" var="rs">
                    
					<tr>
					
						<th>${rs.food.name}</th>&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; 
						<th><b>${rs.price}</b></th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						
						<td><a href="/user/api/addtocart/removefoodFromCart/${rs.id}">
						<button class="btn btn-info">Remove From Cart</button></a></td>
					</tr>
   




					
				</c:forEach>
			</c:when>


			<c:otherwise>
				<tr align="center">
					<td colspan="8">No more items available</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</div>
	</table>
</div>

<a href="/user/api/addtocart/checkout">
	<button class="btn btn-warning">Checkout</button>
</a>





<c:if test="${cart.size() > 0}">
	<div class="panel-footer">
		<b>Showing ${currentpage+1} of ${totalpages}</b>

	</div>
</c:if>


<!-- pagination -->
<nav aria-label="Page navigation example">
	<ul class="pagination">
		<a class="page-link"
			href="/user/api/addtocart/viewCart/${currentpage-1}">Previous</a>
		<a class="page-link"
			href="/user/api/addtocart/viewCart/${currentpage+1}">Next</a>
	</ul>
</nav>


