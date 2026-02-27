<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>


<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Manejo de colecciones</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB"
	crossorigin="anonymous">
</head>
<body>
<%
	ArrayList<String[]> mediosDePago = new ArrayList<>();
	mediosDePago.add(new String[]{"Efectivo","0.0"});
	mediosDePago.add(new String[]{"Tarjeta","0.1"});
	mediosDePago.add(new String[]{"Deposito","0.2"});
	
	request.setAttribute("mediosDePago", mediosDePago);
	request.setAttribute("metodoPago", "Tarjeta");//seleccion del usuario
	request.setAttribute("monto", 10000);//valor del producto
	
%>
	<div class="container">
		<c:set var="importe" value="500"  />
		<c:out value="${importe}" />
		<br>
		<c:set var="nombre" value="Profe"  />
		<c:out value="${nombre}" /> - 
		<c:out value="${fn:replace(nombre, 'e', '3')}" /> 
		
		<br>
		<c:set var="iva" value="${importe*.21}"  />
		<c:out value="${iva}" />
		<br>
		
		<c:if test="${iva > 100}">
			<p><strong>¡Que caro!</strong></p>
		</c:if>
		<c:choose>
			<c:when test="${iva < 100}">
				<c:out value="${iva} menor de 100" />
			</c:when>
			<c:when test="${iva < 200}">
				<c:out value="${iva} menor de 200" />
			</c:when>
			<c:otherwise>
				<c:out value="${iva} mayor de 200" />
			</c:otherwise>
		</c:choose>
		
		<c:forEach var="i" items="1,4,5,6,7,8,9" >
    		<p>
    			Item <c:out value="Nº ${i}" />
			</p>
		</c:forEach>
		<hr><br>
		<c:set var="mediosPago" value="'efectivo','tarjeta','deposito'"></c:set>
		<c:out value="${mediosPago}"></c:out>
		<c:set var="monto2" value="10001"></c:set>
		<br>
		<c:forEach var="medio" items="${mediosDePago}">
			<c:out value="${medio}"></c:out> <br>
			<c:choose>
				<c:when test="${medio[0]==metodoPago }">
					<c:set var="interesMonto" value="${ monto2 * medio[1]}"></c:set>
					<c:set var="montoTotal" value="${monto2 + interesMonto }"></c:set>
					
					<p>El monto total a pagar es:  <c:out value="${montoTotal}"></c:out> </p>
					
				</c:when>
			</c:choose>
		</c:forEach>
		<!--  
		mediosDePago= {
			['efectivo',0.0],
			['tarjeta',0.10],
			['deposito',0.20]
		}
		medio = ['efectivo',0.0]
		medio[0]
		-->
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI"
		crossorigin="anonymous"></script>
</body>
</html>