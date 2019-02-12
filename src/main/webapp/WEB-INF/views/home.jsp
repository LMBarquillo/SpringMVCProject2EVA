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
			<div class="row header">
				<div class="col-12">
					<h1>Menú principal</h1>				
				</div>
			</div>
			<div class="row">
				<div class="col-4 offset-4 main-menu">
					<a href="regiones"><button class="btn btn-primary btn-block">Listar regiones</button></a>
					<a href="oficinas"><button class="btn btn-primary btn-block">Listar oficinas</button></a>
					<a href="representantes"><button class="btn btn-primary btn-block">Gestionar representantes</button></a>
				</div>
			</div>
		</div>
				
		<!-- JavaScript -->
		<script src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/script.js"></script>
	</body>
</html>