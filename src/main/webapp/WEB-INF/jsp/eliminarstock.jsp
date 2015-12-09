<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    	<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href='<c:url value="/css/bootstrap-theme.min.css"/>' type="text/css" rel="stylesheet" media="screen">
        <link href='<c:url value="/css/bootstrap.min.css"/>' type="text/css" rel="stylesheet" media="screen">
        <link href='<c:url value="/css/estilos.css"/>' type="text/css" rel="stylesheet" media="screen">
        
    	<title>Sangucheto&#58; Baja de ingrediente</title>
    
</head>

<body>
	<div class="container">
            <div class="row">
                <div class="col-md-12 at_header">
                     <p><a href="/sangucheto">SANGUCHETO</a></p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-2 at_navbar_btn"><a href="cargarListaConIngredientes?accion=armatusangucheto">Arma tu<br>sangucheto</a></div>
                <div class="col-md-2 at_navbar_btn"><a href="listaIngredientes">Listar<br>ingredientes</a></div>
                <div class="col-md-2 at_navbar_btn"><a href="altaIngrediente">Alta de<br>ingredientes</a></div>
                <div class="col-md-2 at_navbar_btn"><a href="eliminaringrediente">Baja de<br>ingredientes</a></div>
                <div class="col-md-2 at_navbar_btn"><a href="cargarListaConIngredientes?accion=agregarstock">Agregar stock<br>a ingrediente</a></div>
                <div class="col-md-2 at_navbar_btn"><a href="cargarListaConIngredientes?accion=eliminarstock">Quitar stock<br>a ingrediente</a></div>
            </div>
          
            <div class="row">
                <div class="col-md-12 at_separator"></div>
            </div>
	
       <div class="row">
		        <div class="col-md-2 col-md-offset-5">
		        	<h2>ELIMINAR STOCK</h2>
		        </div>
		</div>
        
<!--  <div class="container">        -->
        
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
    
    
<!--  </div>   -->

	</div> <!-- Cierra container --> 
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src='<c:url value="/js/jquery-1.11.3.min.js" />' type="text/javascript"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src='<c:url value="/js/bootstrap.min.js" />' type="text/javascript" ></script>
</body>
</html>