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
			<div class="row header">
				<div class="col-12">
					<h1>Listado de Regiones</h1>
				</div>
			</div>
			
			<!-- encabezados -->
			<div class="row table-header">
				<div class="col-1 offset-2 center">
					Cód.Región
				</div>
				<div class="col-3">
					Nombre Región
				</div>
				<div class="col-2 center">
					Núm. Oficinas
				</div>
				<div class="col-2 right">
					Total Ventas
				</div>
			</div>
			
			<!-- filas -->
			<c:forEach items="${regionesList}" var="region">
				<div class="row table-rows">
					<div class="col-1 offset-2 center">
						<c:out value="${region.getCodRegion()}" />
					</div>
					<div class="col-3">
						<c:out value="${region.getNombre()}" />
					</div>
					<div class="col-2 center">
						<c:out value="${region.getNumOficinas()}" />
					</div>
					<div class="col-2 right">
						<c:out value="${region.getTotalVentas()}" />
					</div>
				</div>
			</c:forEach>
			
			<div class="row">
				<div class="col-12 center">
					<a href="/es"><button class="btn btn-primary"><i class="fas fa-undo-alt"></i>&nbsp;Volver al índice</button></a>
				</div>
			</div>
		</div>
				
		<!-- JavaScript -->
		<script src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/script.js"></script>
	</body>
</html>