<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix = "sec" uri = "http://www.springframework.org/security/tags" %>

<div class="card">
<div class="container text-center">
<div class=" container text-center border border-secondary rounded p-4"
		style="max-width: 37%; max-height: 120%; margin-top: 25px">
	
<form:form action="proceed"  method="post" modelAttribute="cart"  >
<h1>Checkout form</h1>
  <!-- Name input -->
    <h3 style="color: blue">${message}</h3>
    <div class="form-outline mb-4">
    <input type="text" id="form4Example1" class="form-control" name="user_id" value="${cart.user_id}" readonly="readonly"/>
   <label class="form-label" for="form4Example1">Cart Id</label>
  </div>
  
<div class="form-outline mb-4"> 
    Your total price is <b>${cA }</b>
    <input type="text" id="form4Example1" class="form-control" name="price" value="${cart.price}"  placeholder="enter the price to confirm"/>
    <label class="form-label" for="form4Example1">Enter the Price Once Again to confirm</label>
  </div>
  

  
  
  <div class="form-outline mb-4">
    <input type="text" id="form4Example1" class="form-control" name="payment_type" value="${cart.payment_type}" />
    <label class="form-label" for="form4Example1">Payment_type</label>
  </div>
  
      <div class="form-outline mb-4">
    <input type="text" id="form4Example1" class="form-control" name="order_id" value="${cart.order_id}" readonly="readonly"/>
   <label class="form-label" for="form4Example1">Order Id</label>
  </div>
  
  
    <div class="form-outline mb-4">
    <textarea placeholder="Enter about" name="about" id="about" rows="10" class="form-control"></textarea>
	<label class="form-label" for="form4Example1">Address</label>
	
	</div>	
		
 

  

  <!-- Checkbox -->
 

  <!-- Submit button -->
  <button type="submit" class="btn btn-primary mb-4">Proceed</button>   
  
  </form:form>
</div>

</div>
</div>
