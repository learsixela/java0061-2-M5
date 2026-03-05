<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
    
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Solicitid Prestamo Libro</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
  </head>
  <body>
    <div class="container">
    <jsp:include page="/WEB-INF/jsp/include/navbar.jsp"></jsp:include>
    <h1>Solicitud prestamo libro</h1>
        <!-- formulario de creacion -->
    <form action="${pageContext.request.contextPath}/solicitud/prestamo" method="post">
	    <div class="mb-3">
		  <label for="cliente" class="form-label">Cliente</label>
			<select class="form-select" name="cliente" id="cliente">
				<option value="0" selected>Seleccione el solicitante</option>
				<c:forEach var="cliente" items="${listaClientes}">
					<option value="${cliente.id}" >
						<c:out value="${cliente.nick}"></c:out>
					</option>
				</c:forEach>
			</select>
		</div>
	    <div class="mb-3">
		  <label for="libro" class="form-label">Libro</label>
			<select class="form-select" name="libro" id="libro">
				<option value="0" selected>Seleccione el libro</option>
				<c:forEach var="libro" items="${listaLibros}">
					<c:if test="${libro.stock > 0}">
						<option value="${libro.id}" >
							<c:out value="${libro.titulo}"></c:out> - <c:out value="${libro.autor.nombre}"></c:out> - (<c:out value="${libro.stock}"></c:out>)
						</option>
					</c:if>
				</c:forEach>
			</select>
		</div>

		<br>
	  <button type="submit" class="btn btn-primary">Realizar Prestamo</button>
	</form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
  </body>
</html>