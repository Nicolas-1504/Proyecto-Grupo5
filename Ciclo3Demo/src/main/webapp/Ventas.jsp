<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<link href ="images/Ventas.css" type="text/css" rel="stylesheet" />
<meta charset="ISO-8859-1">
<title>Ventas</title>
</head>
<body style="font-family:'Gluten', cursive" id="body">
	<div class="row">
		<div class="col-md-5 seccion1">
			<form method="get" action="Controlador">
				<div class="card" id="card">
					<div class="card-body" >
						<div class="form-group">
							<label>Datos Clientes</label>
						</div>
						<input type="hidden" name="menu" value="Ventas">
						<input type="hidden" name="UsuarioActivo" value="${usuarioSeleccionado.getCedula_usuario()}">
						<div class="form-group d-flex">
							<div class="col-sm-6  d-flex">
								<input type="number" name="cedulacliente" class="form-control" placeholder="Cedula cliente" value="${clienteSeleccionado.getCedula_cliente()}">
								<input type="submit" name="accion" value="Buscar Cliente" class="btn btn-info">
							</div>
							<div class="col-sm-6">
								<input type="text" name="nombrecliente" class="form-control" placeholder="Nombre cliente" value="${clienteSeleccionado.getNombre_cliente()}">
							</div>
						</div>
					</div>
				</div>
				<div class="card" id="card">
					<div class="card-body" >
							<div class="form-group">
								<label>Datos Productos</label>
							</div>
							<div>
								<div class="form-group d-flex">
									<div class="col-sm-6 d-flex">
										<input type="number" name="codigoproducto" class="form-control" placeholder="Codigo producto" value="${productoSeleccionado.getCodigo_producto()}">
										<input type="submit" name="accion" class="btn btn-info" value="Buscar Producto">
									</div>
									<div class="col-sm-6">
										<input type="text" name="nombreproducto" class="form-control" placeholder="Nombre producto" value="${productoSeleccionado.getNombre_producto()}">
									</div>
								</div>
								<div class="form-group d-flex">
									<div class="col-sm-6 d-flex">
										<input type="text" name="precioproducto" class="form-control" placeholder="$ 0000.00" value="${productoSeleccionado.getPrecio_venta()}">
									</div>
									<div class="col-sm-3">
										<input type="number" name="cantidadproducto" class="form-control" placeholder="Cantidad">
									</div>
									<div class="col-sm-3">
										<input type="text" name="ivaproducto" class="form-control" placeholder="Valor iva" value="${productoSeleccionado.getIvacompra()}">
									</div>
								</div>
								<div class="form-group d-flex">
									<input type="submit" name="accion" value="Agregar Producto" class="btn btn-primary">
								</div>
							</div>
					</div>
				</div>
			</form>
		</div>
		
		<div class="col-md-7 seccion2">
			<div class="card" id="card">
				<div class="card-header" >
					<div class="form-group row">
						<label class="col-sm-3 col-form-label">Numero de factura</label>
						<input type="text" class="form-control col-md-4" name="numerofactura" value="${numerofactura}">
					</div>
				</div>
				<div class="card-body" id="card">
					<table class="table">
						<thead class="thead-dark">
							<tr>
								<th>#</th>
								<th>Codigo</th>
								<th>Producto</th>
								<th>Precio</th>
								<th>Cantidad</th>
								<th>Iva</th>
								<th>Total</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="lista" items="${listaventas}">
							<tr>
								<th>${lista.getCodigo_detalle_venta()}</th>
								<td>${lista.getCodigo_producto()}</td>
								<td>${lista.getDescripcion_producto()}</td>
								<td>${lista.getPrecio_producto()}</td>
								<td>${lista.getCantidad_producto()}</td>
								<td>${lista.getIvacompra()}</td>
								<td>${lista.getValor_venta()}</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="card-footer d-flex">
					<div class="col-md-4">
						<label>Sub total</label><br>
						<label>Iva</label><br>
						<label>Total a pagar</label>
					</div>
					<div class="col-md-4">
						<input type="text" name="subtotal" class="form-control" placeholder="$ 00.000.00" disabled="disabled" value="${totalsubtotal}">
						<input type="text" name="totaliva" class="form-control" placeholder="$ 00.000.00" disabled="disabled" value="${totaliva}">
						<input type="text" name="totalapagar" class="form-control" placeholder="$ 00.000.00" disabled="disabled" value="${totalapagar}">
					</div>
				</div>
			</div>
			<div class="card-footer d-flex">
				<div class="col-md-8">
					<a class="btn btn-primary" onclick="print()" href="Controlador?menu=Ventas&accion=GenerarVenta&cedulacliente=${clienteSeleccionado.getCedula_cliente()}&UsuarioActivo=${usuarioSeleccionado.getCedula_usuario()}&numerofactura=${numerofactura}">Generar Venta</a>
					<a class="btn btn-info" href="Controlador?menu=Ventas&accion=NuevaVenta">Nueva Venta</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>