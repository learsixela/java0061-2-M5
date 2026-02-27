<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
  </head>
<body>
	<div class="container">
<jsp:include page="/WEB-INF/jsp/include/navbar.jsp"></jsp:include>


		<%	java.util.Date d = new java.util.Date();%>
		<p><%= java.text.DateFormat.getDateInstance().format(d)%></p>
		<p><%= new java.util.Date() %> </p>
		<!-- c:out -->
		<% String mensaje = "Esto es un mensaje";%>
		<c:set var="mensaje3" value="Esto es un tercer mensaje" ></c:set>
		<c:out value="${mensaje3}"></c:out>
		
		<c:set var="edad" value="15"></c:set>
		
		<c:if test="${ edad >=18}">
			<p>Eres mayor de edad</p>
		</c:if>
		
		<c:choose>
			<c:when test="${ edad >=18}">
				<h2>Eres mayor de edad en choose</h2>
			</c:when>
			<c:when test="${edad >0 && edad < 18 }">
				<h3>Eres menor de edad</h3>
			</c:when>
		</c:choose>
		
	</div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
  </body>
</html>