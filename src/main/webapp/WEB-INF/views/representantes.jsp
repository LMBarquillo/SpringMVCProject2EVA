<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="es">
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/jquery-ui.min.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/jquery-ui.structure.min.css">		
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/jquery-ui.theme.min.css">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.1/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/estilos.css">
		
		<title>Proyecto Spring 2EVA - Luis M. Barquillo</title>
	</head>
	<body>
		<div class="container">
			<div class="row">
				<div class="col-12">
					<h1>Gesti�n de representantes</h1>
				</div>
			</div>

			<!-- encabezados -->
			<div class="row">
				<div class="col-1">
					Num.Rep
				</div>
				<div class="col-2">
					Nombre
				</div>
				<div class="col-1">
					Edad
				</div>
				<div class="col-2">
					Oficina
				</div>
				<div class="col-2">
					Director
				</div>
				<div class="col-1">
					Num.Ventas
				</div>
				<div class="col-1">
					Tot.Ventas
				</div>
				<div class="col-2">
					Acciones
				</div>
			</div>
			
			<!-- filas -->
			<c:forEach items="${repVentasList}" var="repVentas">
				<div class="row">
					<div class="col-1">
						<c:out value="${repVentas.getNumRep()}" />
					</div>
					<div class="col-2">
						<c:out value="${repVentas.getNombre()}" />
					</div>
					<div class="col-1">
						<c:out value="${repVentas.getEdad()}" />
					</div>
					<div class="col-2">
						<c:out value="${repVentas.getOficina().getCiudad()}" />
					</div>
					<div class="col-2">
						<c:out value="${repVentas.getDirector().getNombre()}" />
					</div>
					<div class="col-1">
						<c:out value="${repVentas.getNumVentas()}" />
					</div>
					<div class="col-1">
						<c:out value="${repVentas.getImpVentas()}" />
					</div>
					<div class="col-2">
						<button class="btn btn-primary btn-mini"><i class="fas fa-pencil-alt"></i></button>
						<button class="btn btn-danger btn-mini"><i class="fas fa-times"></i></button>
					</div>
				</div>
			</c:forEach>
			
			<div class="row">
				<div class="col-12">
					<a href="/es">Volver al �ndice</a>
				</div>
			</div>
		</div>
				
		<!-- JavaScript -->
		<script src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/jquery.color-2.1.2.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/jquery-ui.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/script.js"></script>
	</body>
</html>