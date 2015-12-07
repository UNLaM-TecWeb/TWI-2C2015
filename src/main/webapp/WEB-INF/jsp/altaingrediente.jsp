<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    	<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="css/bootstrap.min.css" rel="stylesheet">
    <title>Sangucheto&#58; Alta de ingrediente</title>
    
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
		        <li class="nav-item"><a href="eliminaringrediente">Eliminar ingrediente</a></li> 
		    </ul>
	   	</div>
	</nav>
			<div class="row">
		        <div class="col-md-2 col-md-offset-5">
		        	<h2>ALTA DE INGREDIENTE</h2>
		        </div>
			</div>

	
	<div class="container">
		<form:form class="form-horizontal" method="post" action="crearIngrediente" modelAttribute="ingrediente">
		    <div class = "form-group">
			    <label class="control-label col-sm-2" for="nombre">Nombre:</label>
				  <div class="col-sm-10">
	        			<form:input type="text" class="form-control" placeholder="Ingrese nombre" path="nombre"/>
	      		  </div>
		    </div>
		    
		    <div class = "form-group">
			    <label class="control-label col-sm-2" for="precio">Precio:</label>
				  <div class="col-sm-10">
	        			<form:input type="text" class="form-control" placeholder="Ingrese precio" path="precio"/>
	      		  </div>
		    </div>
		        
<!-- 		    <p>Precio</p> -->
<%-- 		    <form:input path="precio"/> --%>
		        
<!-- 		    <p>Tipo</p> -->
<%-- 		    <form:select path="tipo"> --%>
<%-- 		        <form:option value="INGREDIENTE" label="Ingrediente"/> --%>
<%-- 		        <form:option value="CONDIMENTO" label="Condimento"/> --%>
<%-- 		    </form:select> --%>

				<div class="form-group">
			      <label class="control-label col-sm-2">Seleccione uno:</label>
				      <div class="col-sm-10">
					      <form:select class="form-control" path="tipo">
						        <form:option value="INGREDIENTE" label="Ingrediente"/>
						        <form:option value="CONDIMENTO" label="Condimento"/>
						  
						  </form:select>
					   </div>
				</div>
		    
			    
			    <div class="col-md-4 col-md-offset-5">
				    <input class="btn btn-primary" type="submit"/>
				    <input class="btn btn-warning" type="reset"/>
			    </div>
		</form:form>
    </div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src='<c:url value="/js/jquery-1.11.3.min.js" />' type="text/javascript"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src='<c:url value="/js/bootstrap.min.js" />' type="text/javascript" ></script>
</body>
</html>