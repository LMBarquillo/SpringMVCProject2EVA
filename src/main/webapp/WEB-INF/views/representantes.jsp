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
					<h1>Gesti�n de representantes</h1>
				</div>
			</div>
			
			<div class="row right">
				<a href="nuevo"><button class="btn btn-success pull-right"><i class="fas fa-plus"></i>&nbsp;A�adir nuevo representante</button></a>
			</div>

			<!-- encabezados -->
			<div class="row table-header">
				<div class="col-1 center">
					Num.Rep
				</div>
				<div class="col-2">
					Nombre
				</div>
				<div class="col-1 right">
					Edad
				</div>
				<div class="col-2">
					Oficina
				</div>
				<div class="col-2">
					Director
				</div>
				<div class="col-1 right">
					Num.Ventas
				</div>
				<div class="col-1 right">
					Tot.Ventas
				</div>
				<div class="col-2 center">
					Acciones
				</div>
			</div>
			
			<!-- filas -->
			<c:forEach items="${repVentasList}" var="repVentas">
				<div class="row table-rows">
					<div class="col-1 center">
						<c:out value="${repVentas.getNumRep()}" />
					</div>
					<div class="col-2">
						<c:out value="${repVentas.getNombre()}" />
					</div>
					<div class="col-1 right">
						<c:out value="${repVentas.getEdad()}" />
					</div>
					<div class="col-2">
						<c:out value="${repVentas.getOficina()}" />
					</div>
					<div class="col-2">
						<c:out value="${repVentas.getDirector()}" />
					</div>
					<div class="col-1 right">
						<c:out value="${repVentas.getNumVentas()}" />
					</div>
					<div class="col-1 right">
						<c:out value="${repVentas.getImpVentas()}" />
					</div>
					<div class="col-2 center">
						<a href="editar?id=${repVentas.getNumRep()}"><button class="btn btn-primary btn-mini"><i class="fas fa-pencil-alt"></i></button></a>
						<button class="btn btn-danger btn-mini" data-toggle="modal" data-target="#modal_confirmar" data-name="${repVentas.getNombre()}" data-id="${repVentas.getNumRep()}">
							<i class="fas fa-times"></i>
						</button>
					</div>
				</div>
			</c:forEach>
			
			<div class="row">
				<div class="col-12 center">
					<a href="/es"><button class="btn btn-primary"><i class="fas fa-undo-alt"></i>&nbsp;Volver al �ndice</button></a>
				</div>
			</div>
		</div>
		
		<div class="modal fade" id="modal_confirmar" tabindex="-1" role="dialog" aria-labelledby="modal" aria-hidden="true">
			<div class="modal-dialog" role="document">
		    	<div class="modal-content">
		      		<div class="modal-header">
		        		<h5 class="modal-title" id="titulo_modal">�Atenci�n!</h5>
		      		</div>
		      		<div class="modal-body">
		        		<p>&iquest;Est� seguro que desea eliminar a <span id="nombrerep"></span>?</p>
		      		</div>
		      		<div class="modal-footer">
		        		<button type="button" class="btn btn-danger" data-dismiss="modal">No</button>
		        		<a id="eliminar_link"><button type="button" class="btn btn-success">S�</button></a>
					</div>
				</div>
			</div>
		</div>
				
		<!-- JavaScript -->
		<script src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/script.js"></script>
	</body>
</html>