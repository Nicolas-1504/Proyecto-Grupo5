<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login</title>
	<link rel="preconnect" href="https://fonts.gstatic.com">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <link href ="images/Login.css" type="text/css" rel="stylesheet" />
    <meta charset="ISO-8859-1">

</head>
<body background="images/int1.jpeg" style="background-size:cover">
	
	<div class="box" >
    <div>
      <div class="card-body" >
				<form class="form-sign" action="./DemoServlet" method="get">
					<div class="form-group text-center">
						<svg xmlns="http://www.w3.org/2000/svg" width="80" height="80" fill="currentColor" class="bi bi-person-bounding-box" viewBox="0 0 16 16">
  						<path d="M1.5 1a.5.5 0 0 0-.5.5v3a.5.5 0 0 1-1 0v-3A1.5 1.5 0 0 1 1.5 0h3a.5.5 0 0 1 0 1h-3zM11 .5a.5.5 0 0 1 .5-.5h3A1.5 1.5 0 0 1 16 1.5v3a.5.5 0 0 1-1 0v-3a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 1-.5-.5zM.5 11a.5.5 0 0 1 .5.5v3a.5.5 0 0 0 .5.5h3a.5.5 0 0 1 0 1h-3A1.5 1.5 0 0 1 0 14.5v-3a.5.5 0 0 1 .5-.5zm15 0a.5.5 0 0 1 .5.5v3a1.5 1.5 0 0 1-1.5 1.5h-3a.5.5 0 0 1 0-1h3a.5.5 0 0 0 .5-.5v-3a.5.5 0 0 1 .5-.5z"/>
  						<path d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm8-9a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
						</svg>
						<br> <br>
						<label><h3>Bienvenidos al Sistema</h3></label>
						<br> <br>
					</div>
					<div class="form-group">
						<label><h5>Usuario:</h5></label>
						<input type="text" name="usuario" class="form-control">
					</div>
					<br>
					<div class="form-group">
						<label><h5>Password:</h5></label>
           				<input type="password" name="password" class="form-control">
					</div>
					<br>
					<div>
						 <input type="submit" name="accion" value="Ingresar" class="btn btn-primary" class="boton" style=" width:100%; height: 50px; border-radius: 20px;"> 
					</div>
				</form>
			</div>		
		</div>
	</div>
</body>
</html>