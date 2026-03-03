<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
    
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Libros::</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
  </head>
  <body>
    <div class="container">
    <jsp:include page="/WEB-INF/jsp/include/navbar.jsp"></jsp:include>
    <br>
    <h2>Crear Libro</h2>
    <!-- formulario de creacion -->
    <form action="libros" method="post">
	  <div class="mb-3">
	    <label for="isbn" class="form-label">ISBN</label>
	    <input type="text" class="form-control" id="isbn" name="isbn">
	  </div>
	  <div class="mb-3">
	    <label for="titulo" class="form-label">Titulo</label>
	    <input type="text" class="form-control" id="titulo" name="titulo">
	  </div>
	  <div class="mb-3">
	  <label for="autor" class="form-label">Autor</label>
		<select class="form-select" name="autor" id="autor">
			<option value="0" selected>Seleccione el Autor</option>
			<c:forEach var="autor" items="${listaAutores}">
				<option value="${autor.id}" >
					<c:out value="${autor.nombre}"></c:out>
				</option>
			</c:forEach>
		</select>
		</div>
		<br>
	  <button type="submit" class="btn btn-primary">Crear Libro</button>
	</form>
	<br>
	<hr>
	<h2>Listado de Libros</h2>
    <!-- tabla con libros -->
    <table class="table">
	  <thead>
	    <tr>
	      <th scope="col">#</th>
	      <th scope="col">ISBN</th>
	      <th scope="col">Titulo</th>
	      <th scope="col">Nombre Autor</th>
	      <th scope="col">Nacionalidad Autor</th>
	      <th scope="col-2">Acciones</th>
	    </tr>
	  </thead>
	  <tbody>
	  	<c:forEach var="libro" items="${listaLibros}">
		    <tr>
		      <td><c:out value="${libro.id}"></c:out></td>
		      <td><c:out value="${libro.isbn}"></c:out></td>
		      <td><c:out value="${libro.titulo}"></c:out></td>
		      <td><c:out value="${libro.autor.nombre}"></c:out></td>
		      <td><c:out value="${libro.autor.nacionalidad}"></c:out></td>
		      <td>
		      	<a href="${pageContext.request.contextPath}/libros/eliminar?id="+${libro.id}
		      	
		      	class="btn btn-warning disabled" role="button" aria-disabled="true">Editar</a>
				
				<form action="${pageContext.request.contextPath}/libros/eliminar" method="post">
					<input type="hidden" name="id" value="${libro.id}">
					<button type="submit" class="btn btn-danger"
					onclick="return confirm('Quieres eliminar el libro?');"
					>Eliminar</button>
				</form>
		      
		      </td>	
		    </tr>
		</c:forEach>

	  </tbody>
	</table>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
  </body>
</html>