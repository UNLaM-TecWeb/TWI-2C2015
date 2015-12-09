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
        <title>Sanguchetto S.A.</title>
    <title>Sangucheto&#58; Alta de ingrediente</title>
    
</head>

<body>
	<div class="container">
            <div class="row">
                <div class="col-md-12 at_header">
                    <p>SANGUCHETO</p>
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
		        	<h2>ALTA DE INGREDIENTE</h2>
		        </div>
			</div>

	
<!-- 	<div class="container"> -->
		<form:form class="form-horizontal" method="post" action="crearIngrediente" modelAttribute="ingrediente">
		    <div class = "form-group">
			    <label class="control-label col-sm-2" for="nombre">Nombre:</label>
				  <div class="col-sm-8">
	        			<form:input type="text" class="form-control" placeholder="Ingrese nombre" path="nombre"/>
	      		  </div>
		    </div>
		    
		    <div class = "form-group">
			    <label class="control-label col-sm-2" for="precio">Precio:</label>
				  <div class="col-sm-8">
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
				      <div class="col-sm-8">
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
<!--     </div> -->
    
    </div> <!-- Cierra container -->
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src='<c:url value="/js/jquery-1.11.3.min.js" />' type="text/javascript"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src='<c:url value="/js/bootstrap.min.js" />' type="text/javascript" ></script>
</body>
</html>