<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="es">
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/estilos.css">
		
		<title>Proyecto Spring 2EVA - Luis M. Barquillo</title>
	</head>
	<body>
		<div class="container">
			<div class="row">
				<div class="col-12">
					<h1>Listado de Oficinas</h1>
				</div>
			</div>
			
			<!-- encabezados -->
			<div class="row">
				<div class="col-1">
					Cód.Oficina
				</div>
				<div class="col-3">
					Ciudad
				</div>
				<div class="col-3">
					Región
				</div>
				<div class="col-1">
					Núm.Rep
				</div>
				<div class="col-4">
					Director
				</div>
			</div>
			
			<!-- filas -->
			<c:forEach items="${oficinasList}" var="oficina">
				<div class="row">
					<div class="col-1">
						<c:out value="${oficina.getOficina()}" />
					</div>
					<div class="col-3">
						<c:out value="${oficina.getCiudad()}" />
					</div>
					<div class="col-3">
						<c:out value="${oficina.getRegion()}" />
					</div>
					<div class="col-1">
						<c:out value="${oficina.getNumRepresentantes()}" />
					</div>
					<div class="col-4">
						<c:out value="${oficina.getDirector()}" />
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