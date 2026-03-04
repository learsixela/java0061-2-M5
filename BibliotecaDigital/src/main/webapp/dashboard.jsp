<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
    
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
  </head>
  <body> 
    <div class="container">
    <jsp:include page="/WEB-INF/jsp/include/navbar.jsp"></jsp:include>
    
    <h1>Hola ${sessionScope.emailSession}</h1>
    
    <div class="card" style="width: 18rem;">
	  <div class="card-body">
	    <h5 class="card-title">CRUD Libro</h5>
	    <p class="card-text">Sección para la creacion, busqueda, edición y eliminación de libros</p>
	    <a href="libros" class="btn btn-primary">Sección Libros</a>
	  </div>
	</div>
    
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
  </body>
</html>