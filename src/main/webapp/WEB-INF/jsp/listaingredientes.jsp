<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
     	<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="css/bootstrap.min.css" rel="stylesheet">
    <title>Sangucheto&#58; Lista de ingredientes</title>
   
</head>

<body>
	<nav class="navbar navbar-inverse" style="background-color: green">
		<a class="navbar-brand" href="/sangucheto">Sangucheto</a>
		<div>
			<ul class="nav navbar-nav">
		        <li class="nav-item"><a href="cargarListaConIngredientes?accion=armatusangucheto">Arma tu Sangucheto</a></li>
		        <li class="nav-item"><a href="listaIngredientes">Listar Ingredientes</a></li>
		        <li class="nav-item"><a href="altaIngrediente">Alta de Ingredientes</a></li> 
		        <li class="nav-item"><a href="cargarListaConIngredientes?accion=agregarstock">Agregar stock a ingredientes</a></li> 
		        <li class="nav-item"><a href="cargarListaConIngredientes?accion=eliminarstock">Quitar stock a ingrediente</a></li> 
		    </ul>
	   	</div>
	</nav>
    <h1>LISTA DE INGREDIENTES</h1>
	<table class="table table-bordered">
		<tr>
			<td>INGREDIENTE</td>
			<td>PRECIO</td>
			<td>TIPO</td>
			<td>STOCK</td>
		</tr>
		<c:forEach var="ingrediente" items="${mapa}">
			<tr>
				<td>${ingrediente.key.nombre}</td>
				<td>${ingrediente.key.precio}</td>
				<td>${ingrediente.key.tipo}</td>
				<td>${ingrediente.value}</td>
			</tr>
		</c:forEach>
	</table>	
   
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src='<c:url value="/js/jquery-1.11.3.min.js" />' type="text/javascript"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src='<c:url value="/js/bootstrap.min.js" />' type="text/javascript" ></script>
</body>
</html>