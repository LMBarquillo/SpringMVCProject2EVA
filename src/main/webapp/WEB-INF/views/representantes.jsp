<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="es">
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.1/css/all.css" crossorigin="anonymous">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/estilos.css">
		
		<title>Proyecto Spring 2EVA - Luis M. Barquillo</title>
	</head>
	<body>
		<div class="container">
			<div class="row">
				<div class="col-12">
					<h1>Gestión de representantes</h1>
				</div>
			</div>
			
			<div class="row">
				<div class="col-12">
					<a href="nuevo"><button class="btn btn-success pull-right"><i class="fas fa-plus"></i>&nbsp;Añadir nuevo representante</button></a>
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
						<c:out value="${repVentas.getOficina()}" />
					</div>
					<div class="col-2">
						<c:out value="${repVentas.getDirector()}" />
					</div>
					<div class="col-1">
						<c:out value="${repVentas.getNumVentas()}" />
					</div>
					<div class="col-1">
						<c:out value="${repVentas.getImpVentas()}" />
					</div>
					<div class="col-2">
						<a href="editar?id=${repVentas.getNumRep()}"><button class="btn btn-primary btn-mini"><i class="fas fa-pencil-alt"></i></button></a>
						<a href="eliminar?id=${repVentas.getNumRep()}"><button class="btn btn-danger btn-mini"><i class="fas fa-times"></i></button></a>
					</div>
				</div>
			</c:forEach>
			
			<div class="row">
				<div class="col-12">
					<a href="/es">Volver al índice</a>
				</div>
			</div>
		</div>
				
		<!-- JavaScript -->
		<script src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/script.js"></script>
	</body>
</html>