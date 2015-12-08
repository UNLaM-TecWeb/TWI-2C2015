<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    	<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="css/bootstrap.min.css" rel="stylesheet">
    <title>Sangucheto&#58; Baja de ingrediente</title>
    
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
		        	<h2>ELIMINAR STOCK</h2>
		        </div>
		</div>
        
 <div class="container">       
        
        <form:form method="post" action="modificarStock?accion=eliminar" modelAttribute="ingredienteConStock">
          <div class="col-sm-10">
	            <form:select class="form-control" path="nombre">
					<c:forEach var="each" items="${mapa}">                
	                	<form:option value="${each.key.nombre}" label="${each.key.nombre}, Stock: ${each.value}"/> 
	                </c:forEach>
	            </form:select>
            </div>
            <br>
            <br>
            <div class="col-sm-10">
	            <form:input class="form-control" placeholder="Ingrese stock a eliminar" path="stock"/>
	            <br>
	            <input class="btn btn-warning" type="submit"/>
            </div>
        </form:form>
    
    
 </div>  
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src='<c:url value="/js/jquery-1.11.3.min.js" />' type="text/javascript"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src='<c:url value="/js/bootstrap.min.js" />' type="text/javascript" ></script>
</body>
</html>