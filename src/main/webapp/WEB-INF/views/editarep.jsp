<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="miform"%>
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
					<h1>Modificar Representante de Ventas</h1>
				</div>
			</div>
			
			<miform:form method="POST" action="editar" modelAttribute="editaRep">
			<div class="row">
				<div class="col-2">
					<label>ID:</label>
					<miform:input class="readonly" type="text" name="id" placeholder="ID" path="numRep" required="true" readonly="true"/>
				</div>
				<div class="col-8">
					<label>Nombre:</label><br/>
					<miform:input type="text" name="nombre" placeholder="Nombre" path="nombre" required="true" maxlength="15"/>
				</div>
				<div class="col-2">
					<label>Edad:</label><br/>
					<miform:input type="number" name="edad" placeholder="Edad" path="edad" required="true"/>
				</div>
				<div class="col-3">
					<label>Oficina:</label><br/>
					<miform:select path="oficina">
						<miform:option value="0" label="--- ELIGE ---" />
						<miform:options items="${oficinasMap}" />
					</miform:select>
				</div>
				<div class="col-3">
					<label>Director:</label><br/>
					<miform:select path="director">
						<miform:option value="0" label="--- ELIGE ---" />
						<miform:options items="${directoresMap}" />
					</miform:select>
				</div>
				<div class="col-3">
					<label>Núm. Ventas:</label><br/>
					<miform:input type="text" name="ventas" placeholder="0" path="numVentas" required="true"/>
				</div>
				<div class="col-3">
					<label>Total Ventas:</label><br/>
					<miform:input type="text" name="total" placeholder="0" path="impVentas" required="true"/>
				</div>
			</div>
			
			<div class="row">
				<div class="col-6">
					<a href="representantes"><button type="button" class="btn btn-danger"><i class="fas fa-times"></i>&nbsp;Cancelar</button></a>
				</div>
				<div class="col-6">					
					<button type="submit" class="btn btn-success pull-right"><i class="fas fa-check"></i>&nbsp;Aceptar</button>
				</div>
			</div>
			</miform:form>
			
			
		</div>
				
		<!-- JavaScript -->
		<script src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/script.js"></script>
	</body>
</html>