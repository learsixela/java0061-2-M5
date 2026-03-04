<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Registro Usuario</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
  </head>
  <body>
    <div class="container">
		<jsp:include page="/WEB-INF/jsp/include/navbar.jsp"></jsp:include>
		<br>
		<h1>Registro de usuario</h1>
		<form action="registrar" method="post">
			<div class="mb-3">
				<label for="nick" class="form-label">Nick Name</label> 
				<input type="text" class="form-control" id="nick" name="nick">
				<c:if test="${nickError != null}">
					<div class="alert alert-danger" role="alert">
						<c:out value="${nickError}"></c:out>
					</div>
				</c:if>
			</div>
			<div class="mb-3">
				<label for="email" class="form-label">Email</label> 
				<input type="email" class="form-control" id="email" name="email">
				<c:if test="${emailError != null}">
					<div class="alert alert-danger" role="alert">
						<c:out value="${emailError}"></c:out>
					</div>
				</c:if>
			</div>
			<div class="mb-3">
				<label for="password" class="form-label">Password</label>
				<input type="password" class="form-control" id="password" name="password">
				<c:if test="${passError != null}">
					<div class="alert alert-danger" role="alert">
						<c:out value="${passError}"></c:out>
					</div>
				</c:if>
			</div>
			<div class="mb-3">
				<label for="edad" class="form-label">Edad</label>
				<input type="number" class="form-control" id="edad" name="edad" min="1" max="100">
			</div>
			<div class="mb-3">
				<label for="f_nac" class="form-label">Fecha Nacimiento</label>
				<input type="date" class="form-control" id="f_nac" name="f_nac">
			</div>
			<div class="mb-3">
				<select name="sexo" class="form-select" aria-label="Default select example">
				  <option value="0" selected>Seleccione su sexo</option>
				  <option value="1">Femenino</option>
				  <option value="2">Masculino</option>
				  <option value="3">Prefiero no decir</option>
				</select>
			</div>
			
			<button type="submit" class="btn btn-primary">Registrar Usuario</button>
		</form>
	</div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
  </body>
</html>