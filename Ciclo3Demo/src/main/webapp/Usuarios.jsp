<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="co.edu.unbosque.ciclo3demo.Usuario"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<link href ="images/Principal.css" type="text/css" rel="stylesheet" />
<meta charset="ISO-8859-1">
<title>Creacion de Usuario</title>
</head>
<body  style="font-family:'Gluten', cursive">
<div class="row">
   <div class="card col-md-4" id="BoxUsuario">
       <div class="card-body">
           <h4 class="card-title">Usuarios</h4>
           <br>
           <p class="card-subtitle">En este panel podras gestionar los datos de los usuarios del sistema</p>
           <br>
           <div>
     		 <form class="form-sign" method="get" action="Controlador">
      		      
		        <div class="form-group">
		         <input type="hidden" name="menu" value="Usuarios">
		         <label>Cedula:</label>
		         <input type="text" name="cedula" class="form-control" value="${usuarioSeleccionado.getCedula_usuario()}">
		        </div>
		        <div class="form-group">
		         <label>Nombre:</label>
				<input type="text" name="nombre" class="form-control" value="${usuarioSeleccionado.getNombre_usuario()}">
		        </div>
		        <div class="form-group">
		         <label>Email:</label>
		         <input type="text" name="email" class="form-control" value="${usuarioSeleccionado.getEmail_usuario()}">
		        </div>
		        <div class="form-group">
		         <label>Usuario:</label>
		         <input type="text" name="usuario" class="form-control" value="${usuarioSeleccionado.getUsuario()}">
                   </div>
		        <div class="form-group">
		        <label>Password:</label>
		         <input type="password" name="password" class="form-control" value="${usuarioSeleccionado.getPassword()}">
		        </div>
		        <br>
		        <input type="submit" class="btn btn-primary" name="accion" value="Agregar">
		        <input type="submit" class="btn btn-info" name="accion" value="Actualizar">
       	 </form>
    </div>
  </div>
  </div>
 <div class="col-md-8">
    <table class="table">
        <thead class="thead-dark">
            <tr>
                <th scope="col">Cedula</th>
                <th scope="col">Nombre</th>
                <th scope="col">Email</th>
                <th scope="col">Usuario</th>
                <th scope="col">Password</th>
           </tr>
        </thead>
        <tbody>
            <% ArrayList<Usuario> lista= (ArrayList<Usuario>) request.getAttribute("lista");
			for (Usuario usuario:lista){
			%>
			<tr>
				<td><%=usuario.getCedula_usuario()%></td>
				<td><%=usuario.getNombre_usuario()%></td>
				<td><%=usuario.getEmail_usuario()%></td>
				<td><%=usuario.getUsuario()%></td>
				<td><%=usuario.getPassword()%></td>
				<td> 
	               <a class="btn btn-warning" href="Controlador?menu=Usuarios&accion=Cargar&id=<%=usuario.getCedula_usuario()%>">Editar</a>
	               <a class="btn btn-danger" href="Controlador?menu=Usuarios&accion=Eliminar&id=<%=usuario.getCedula_usuario()%>">Eliminar</a>
            	</td>
            </tr>
            <%}%>
        </tbody>
    </table>
</div>
<!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script> </body> </html>
		         