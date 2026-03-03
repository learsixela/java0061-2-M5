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
      <th scope="col">First</th>
      <th scope="col">Last</th>
      <th scope="col">Handle</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td>Mark</td>
      <td>Otto</td>
      <td>@mdo</td>
    </tr>
    <tr>
      <th scope="row">2</th>
      <td>Jacob</td>
      <td>Thornton</td>
      <td>@fat</td>
    </tr>
    <tr>
      <th scope="row">3</th>
      <td>John</td>
      <td>Doe</td>
      <td>@social</td>
    </tr>
  </tbody>
</table>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
  </body>
</html>