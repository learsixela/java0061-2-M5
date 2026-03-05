<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<nav class="navbar navbar-expand-lg bg-body-tertiary rounded"
	aria-label="Thirteenth navbar example">
	<div class="container-fluid">
		<button class="navbar-toggler" type="button"
			data-bs-toggle="collapse" data-bs-target="#navbarsExample11"
			aria-controls="navbarsExample11" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse d-lg-flex"
			id="navbarsExample11">
			<a class="navbar-brand col-lg-3 me-0" href="/">Biblioteca Digital</a>
			<ul class="navbar-nav col-lg-6 justify-content-lg-center">
				<c:if test="${not empty sessionScope.emailSession}">
					<li class="nav-item">
					<a class="nav-link active"
						aria-current="page" href="dashboard">Dashboard</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="libros">Libros</a></li>
					<li class="nav-item"><a class="nav-link" href="prestamos">Prestamos</a></li>
				</c:if>
				<li class="nav-item dropdown">
					<a
					class="nav-link dropdown-toggle" href="#"
					data-bs-toggle="dropdown" aria-expanded="false">
                    <c:if test="${empty sessionScope.emailSession}">
                        Invitado
                    </c:if>
                    <c:if test="${not empty sessionScope.emailSession}">
						${sessionScope.nickSession}
					</c:if>
					</a>
					<ul class="dropdown-menu">
						<c:if test="${empty sessionScope.emailSession}">
							<li><a class="dropdown-item" href="login">Login</a></li>
							<li><a class="dropdown-item" href="registrar">Registro</a></li>
						</c:if>
						<c:if test="${not empty sessionScope.emailSession}">
							<li><a class="dropdown-item" href="usuario/editar">Editar perfil</a></li>
							<li><a class="dropdown-item" href="logout">Cierre de Sesión</a></li>
						</c:if>
					</ul>
				</li>
			</ul>
		</div>
	</div>
</nav>