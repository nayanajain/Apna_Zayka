<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<script async defer
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDjXFbnfNLNTih5ok-9HBivrMCLngRDByQ&callback=initMap"></script>



<div id="map" style="width: 500px;height: 500px;"></div>



<br>

<script>
	
function initMap() {
	
	var options={
				zoom: 8,
				center: {lat:-97.6547, lng: 123.87}
	}
	
	var map=new google.maps.Map(document.getElementById("map"), options );
	
	google.maps.event.addListener(map,'click', function(event){
		addMarker({coords:event.latLng});
	});


<c:forEach 
var="data" items='${partnerSaloons }'>
//alert('${data.lat}');
  addMarker
  (
		  {
			  coords:{ 
				  lat: ${data.lat}, lng: ${data.lng}
				  }, 
	  iconImage: 'https://developers.google.com/maps/documentation/javascript/examples/full/images/beachflag.png',
	  content: '<h1>${data.address}</h1>'
	  }
   );
  </c:forEach>
  
  for(i=0;i<markers.length;i++)
	  {
	  addMarker(markers[i]);
	  }


function addMarker(props)
{
	var marker=new google.maps.Marker({
		position: props.coords,
		map: map,
		//icon:props.iconImage
	});
	
	if(props.iconImage)
		{
		marker.setIcon(props.iconImage);
		}
	if(props.content)
	{
	var infoWindow = new google.maps.InfoWindow({
	content: props.content
	});
	
	marker.addListener('click', function(){
		infoWindow.open(map, marker);
	});
}
}
}function initMap() {
	
	var options={
				zoom: 8,
				center: {lat:-97.6547, lng: 123.87}
	}
	
	var map=new google.maps.Map(document.getElementById("map"), options );
	
	google.maps.event.addListener(map,'click', function(event){
		addMarker({coords:event.latLng});
	});


//alert('${data.lat}');
  addMarker
  (
		  {
			  coords:{ 
				  lat: -97.1123, lng: 125.34
				  }, 
	  iconImage: 'https://developers.google.com/maps/documentation/javascript/examples/full/images/beachflag.png',
	  content: '<h1>Apna Dhaba, near Shubh Shree Palace, Pratapgarh</h1>'
	  }
   );
  
  
  for(i=0;i<markers.length;i++)
	  {
	  addMarker(markers[i]);
	  }


function addMarker(props)
{
	var marker=new google.maps.Marker({
		position: props.coords,
		map: map,
		//icon:props.iconImage
	});
	
	if(props.iconImage)
		{
		marker.setIcon(props.iconImage);
		}
	if(props.content)
	{
	var infoWindow = new google.maps.InfoWindow({
	content: props.content
	});
	
	marker.addListener('click', function(){
		infoWindow.open(map, marker);
	});
}
}
}
	</script>





<select>
	<c:forEach var="data" items="${partnerSaloons }">
		<option value="${data.lat } }">${data.lat }
	</c:forEach>
</select>

<select>
	<c:forEach var="data" items="${partnerSaloons }">
		<option value="${data.lng } ">${data.lng }
	</c:forEach>
</select>

