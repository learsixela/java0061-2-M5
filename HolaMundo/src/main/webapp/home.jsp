<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
    
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Tags Lib</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
  </head>
  <body>
  <jsp:include page="/WEB-INF/jsp/include/navbar.jsp"></jsp:include>
    <h1>Hello, world <c:out value="${nombreHijo}"></c:out> !!</h1>
    
    <c:choose>
		<c:when test="${ edadHijo >=18}">
			<div class="alert alert-primary" role="alert">
			  <h2>Eres mayor de edad en choose</h2>
			</div>
			
		</c:when>
		<c:when test="${edadHijo >0 && edadHijo < 18 }">
			<div class="alert alert-danger" role="alert">
			  <h3>Eres menor de edad, tienes <c:out value="${edadHijo}"></c:out> años</h3>
			</div>
			
		</c:when>
	</c:choose>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
  </body>
</html>