<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
        <meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="css/bootstrap.min.css" rel="stylesheet">
        <title>Sanguchetto S.A.</title>
    </head>
    <body>
        
    <div class="row">
	    <div class="col-md-2 col-md-offset-5">
	    	<h1>Sanguchetto</h1>
	    </div>
	</div>

	<nav class="navbar navbar-inverse" style="background-color: green">
		<div>
			<ul class="nav navbar-nav">
		        <li class="nav-item"><a href="cargarListaConIngredientes?accion=armatusangucheto">Arma tu Sangucheto</a></li>
		        <li class="nav-item"><a href="listaIngredientes">Listar Ingredientes</a></li>
		        <li class="nav-item"><a href="altaIngrediente">Alta de Ingredientes</a></li> 
		        <li class="nav-item"><a href="cargarListaConIngredientes?accion=agregarstock">Agregar stock a ingredientes</a></li> 
		        <li class="nav-item"><a href="cargarListaConIngredientes?accion=eliminarstock">Quitar stock a ingrediente</a></li> 
		        <li class="nav-item"><a href="eliminaringrediente">Eliminar ingrediente</a></li>
		    </ul>
	   	</div>
	</nav>
	<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-8">
			<h2>
				Producto - <small>Eliminar</small>
			</h2>
			<table class="table table-striped">
				<tr>
					<td>Nombre</td>
					<td>Precio</td>
					<td>Cantidad</td>
					<td>Enviar</td>
				</tr>
				<c:forEach items="${tabla}" var="ingrediente">
					<form action="eliminaringrediente" method="POST">
						<tr>
							<td>${ingrediente.key.nombre}</td>
							<input type="text" name="nombre" value="${ingrediente.key.nombre}"
								id="nombre" hidden />
							<td>$ ${ingrediente.key.precio}</td>
							<input type="text" name="precio" value="${ingrediente.key.precio}"
								id="precio" hidden />
							<td>Cant: ${ingrediente.value}</td>
							<td><input type="submit" value="Eliminar"></td>
						</tr>
					</form>
				</c:forEach>
			</table>
		</div>
		<div class="col-md-2"></div>
	</div>
	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>