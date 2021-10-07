<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="co.edu.unbosque.ciclo3demo.Proveedor"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Creacion de Proveedor</title>
</head>
<body>
<div class="row">
   <div class="card col-md-4">
       <div class="card-body">
           <h5 class="card-title">Proveedores</h5>
           <h6 class="card-subtitle mb-2 text-muted">En este panel podras gestionar los datos de los proveedores del sistema</h6>
           <div>
     		 <form class="form-sign" method="get" action="Controlador">
     		 <div class="form-group">
		         <input type="hidden" name="menu" value="Proveedores">
		         <label>Nit:</label>
		         <input type="text" name="nit" class="form-control" value="${usuarioSeleccionado.getNitproveedor()}">
		        </div>
		        <div class="form-group">
		         <label>Ciudad:</label>
				<input type="text" name="ciudad" class="form-control" value="${usuarioSeleccionado.getCiudad_proveedor()}">
		        </div>
		        <div class="form-group">
		         <label>Direccion:</label>
		         <input type="text" name="direccion" class="form-control" value="${usuarioSeleccionado.getDireccion_proveedor()}">
		        </div>
		        <div class="form-group">
		         <label>Nombre:</label>
		         <input type="text" name="nombre" class="form-control" value="${usuarioSeleccionado.getNombre_proveedor()}">
                   </div>
		        <div class="form-group">
		        <label>Telefono:</label>
		         <input type="text" name="telefono" class="form-control" value="${usuarioSeleccionado.getTelefono_proveedor()}">
		        </div>
		        <input type="submit" class="btn btn-primary" name="accion" value="Agregar">
		        <input type="submit" class="btn btn-success" name="accion" value="Actualizar">
       	 </form>
       	 </div>
  </div>
  </div>
 <div class="col-md-8">
    <table class="table">
        <thead class="thead-dark">
            <tr>
                <th scope="col">Nit</th>
                <th scope="col">Ciudad</th>
                <th scope="col">Direccion</th>
                <th scope="col">Nombre</th>
                <th scope="col">Telefono</th>
           </tr>
        </thead>
        <tbody>
            <% ArrayList<Proveedor> lista= (ArrayList<Proveedor>) request.getAttribute("lista");
			for (Proveedor proveedor:lista){
			%>
			<tr>
				<td><%=proveedor.getNitproveedor()%></td>
				<td><%=proveedor.getCiudad_proveedor()%></td>
				<td><%=proveedor.getDireccion_proveedor()%></td>
				<td><%=proveedor.getNombre_proveedor()%></td>
				<td><%=proveedor.getTelefono_proveedor()%></td>
				<td> 
	               <a class="btn btn-warning" href="Controlador?menu=Proveedores&accion=Cargar&id=<%=proveedor.getNitproveedor()%>">Editar</a>
	               <a class="btn btn-danger" href="Controlador?menu=Proveedores&accion=Eliminar&id=<%=proveedor.getNitproveedor()%>">Eliminar</a>
            	</td>
            </tr>
            <%}%>
        </tbody>
    </table>
</div>
<!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script> 
        </body> 
        </html>