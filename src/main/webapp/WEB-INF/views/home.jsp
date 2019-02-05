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
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/estilos.css">
		
		<title>Proyecto Spring 2EVA - Luis M. Barquillo</title>
	</head>
	<body>
		<div class="container">
			<div class="row">
				<div class="col-4 offset-4">
					<h1>Menú principal</h1>
					<form method="GET" action="menu">
						<button type="submit" class="btn btn-primary" name="action" value="regiones">Listar regiones</button><br/>
						<button type="submit" class="btn btn-primary" name="action" value="oficinas">Listar oficinas</button><br/>
						<button type="submit" class="btn btn-primary" name="action" value="representantes">Gestionar representantes</button><br/>
					</form>					
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