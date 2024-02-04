<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="tile" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><tile:insertAttribute name="title" ignore="true"/></title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<center>
	<div>
		<div> 
			<tile:insertAttribute name="header"/> 
		</div>
		
		
		
		<div style="float: right;"> 
			<tile:insertAttribute name="body"/>
		</div>
		
	
	</div>	
</center>
</body>
</html>