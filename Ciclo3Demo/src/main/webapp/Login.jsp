<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login</title>
	<link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Handlee&family=Indie+Flower&family=Ubuntu+Mono&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    <link href="assets/css/flaticon.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <meta charset="ISO-8859-1">

</head>
<body background="images/imagen1.jpg" style="background-size: contain" style="font-family: 'Gluten', cursive;">
	
	<div class="container mt-4 col-lg-4" >
    <div class="card col-sm-10" style="border-radius: 10px; border: 6px black solid ;margin: 18% 0% 0% 12%; ">
      <div class="card-body" >
				<form class="form-sign" action="./DemoServlet" method="post">
					<div class="form-group text-center">
						<img height="120" src="images/avatar.jpg" >
						<br> <br>
						<label><h3>Bienvenidos al Sistema</h3></label>
						<br> <br>
					</div>
					<div class="form-group">
						<label><h5>Usuario:</h5></label>
						<input type="text" name="usuario" class="form-control" style="border: 2px black solid; border-radius: 10px;">
					</div>
					<br>
					<div class="form-group">
						<label><h5>Password:</h5></label>
           				<input type="password" name="password" class="form-control" style="border: 2px black solid; border-radius: 15px;">
					</div>
					<br>
					<div>
						 <input type="submit" name="accion" value="Ingresar" class="btn btn-primary" style="border-radius: 10px; border: 2px transparent solid; font-size: 22px; color: white; background: green; width:100%; height: 50px "> 
					</div>
				</form>
			</div>		
		</div>
	</div>
</body>
</html>