<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<link href ="images/Ventas.css" type="text/css" rel="stylesheet" />
<meta charset="ISO-8859-1">
<title>Reportes</title>
</head>
<body style="font-family:'Gluten', cursive" id="body">
	<div class="row">
		<div class="col-md-5 seccion1">
			<form action="Controlador" method="get">
				<div class="card" id="card">
					<div class="card-body">
						<div class="form-group">
							<label>Seleccione el tipo de reporte</label>
						</div>
						<br>
						<input type="hidden" name="menu" value="Reportes">
						<div class="form-group d-flex">
							<div class="col-sm-6 d-flex">
								<input type="submit" name="accion" value="ReporteUsuarios" class="btn btn-info">
								<input type="submit" name="accion" value="ReporteClientes" class="btn btn-info">
								<input type="submit" name="accion" value="ReporteVentas" class="btn btn-info">
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
		<div class="col-md-7 seccion2">
			<div class="card" id="card">
				<div class="card-body">
					<div class="form-group">
						<label>Detalle de reporte</label>
					</div>
					<br>
					<table>
					<c:if test="${opcion==1}">
						<thead class="thead-dark">
						<tr>
			                <th scope="col">Cedula</th>
			                <th scope="col">Nombre</th>
			                <th scope="col">Email</th>
			                <th scope="col">Usuario</th>
						</tr>
						</thead>
						<tbody>
						<c:forEach var="lista" items="${listaUsuarios}">
							<tr>
								<td>${lista.getCedula_usuario()}</td>
								<td>${lista.getNombre_usuario()}</td>
								<td>${lista.getEmail_usuario()}</td>
								<td>${lista.getUsuario()}</td>
							</tr>
						</c:forEach>
						</tbody>
					</c:if>
					<c:if test="${opcion==2}">
						<thead class="thead-dark">
						<tr>
				                <th scope="col">Cedula</th>
				                <th scope="col">Direccion</th>
				                <th scope="col">Email</th>
				                <th scope="col">Nombre</th>
				                <th scope="col">Telefono</th>
						</tr>
						</thead>
						<tbody>
						<c:forEach var="lista1" items="${listaClientes}">
							<tr>
								<td>${lista1.getCedula_cliente()}</td>
								<td>${lista1.getDireccion_cliente()}</td>
								<td>${lista1.getEmail_cliente()}</td>
								<td>${lista1.getNombre_cliente()}</td>
								<td>${lista1.getTelefono_cliente()}</td>
							</tr>
						</c:forEach>
						</tbody>
					</c:if>
					<c:if test="${opcion==3}">
					<thead class="thead-dark">
						<tr>
								<th>Codigo Venta</th>
  								<th>Cedula Cliente</th>
								<th>Cedula Usuario</th>
								<th>Iva</th>
								<th>Total Venta</th>
								<th>Valor Venta</th>
						</tr>
						</thead>
						<tbody>
						<c:forEach var="lista2" items="${listaVentas}">
							<tr>
								<th>${lista2.getCodigo_venta()}</th>
								<td>${lista2.getCedula_cliente()}</td>
								<td>${lista2.getCedula_usuario()}</td>
								<td>${lista2.getIvaventa()}</td>
								<td>${lista2.getTotal_venta()}</td>
								<td>${lista2.getValor_venta()}</td>
							</tr>
						</c:forEach>
						</tbody>
					</c:if>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>