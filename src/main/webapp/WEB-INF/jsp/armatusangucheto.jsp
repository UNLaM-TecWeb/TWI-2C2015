<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="css/bootstrap.min.css" rel="stylesheet">
        <title>Sanguchetto S.A.</title>
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
	    
	    <div class="row">
		    <div class="col-md-offset-4">
	        <h1>Arma tu sangucheto</h1>
	        </div>
	    </div>
	     
	    
 <div class="container">
			
		<div class = "form-group">
			<form:form class="form-horizontal" method="post" action="agregarasangucheto" modelAttribute="ingredienteConStock">
	            <h1>Eleg&iacute; tus ingredientes favoritos.</h1>
	         
	         
	         <div class="form-group">
	         	<label class="control-label col-sm-2" for="Ingredientes">Ingredientes:</label>
	        	 <div class="col-sm-10">
	        	<form:select class="form-control" path="nombre">
					<c:forEach var="each" items="${mapa}">                
	                	<form:option value="${each.key.nombre}" label="${each.key.nombre}, Precio: ARS${each.key.precio}, Stock: ${each.value}"/> 
	                </c:forEach>
            	</form:select>
            	</div>
            </div>
            
             <div class = "form-group">
			    <label class="control-label col-sm-2" for="cantidad">Cantidad:</label>
				  <div class="col-sm-10">
	        			<form:input type="text" class="form-control" placeholder="Ingrese cantidad" path="stock"/>
	      		  </div>
		    </div>
            
            <br>
            <div class="col-md-4 col-md-offset-5">
	            <input class="btn btn-primary" type="submit" value="agregar"/>
	            <input class="btn btn-warning" type="reset"/>
            </div>
            <br>
	    	<br>   
        </form:form>
        
        
	        <form:form class="form-horizontal" method="post" action="agregarasangucheto" modelAttribute="ingredienteConStock">
	        	<h2>Mir&aacute; como esta quedando tu sangucheto:</h2>
		        
		        <div class="form-group">
			        <div class="col-sm-10">
			        <form:select class="form-control" path="nombre" multiple="true">
						<c:forEach var="each" items="${sangucheto}">                
							<form:option value="${each.nombre}" label="${each.nombre}"/> 
						</c:forEach>
			        </form:select>
			        </div>
			     </div>
	        </form:form>
        
        <form:form method="post" action="calcularDescuento" modelAttribute="descuento">
	        <h3>Descuentos:</h3>
	        <p>Monto fijo</p> <form:input path="valorFijo"/>
	        <p>Monto porcentual</p> <form:input path="valorPorcentual"/>
	        
	        <p>Costo del sangucheto: ${descuento.precioSanguchetoConDescuento}</p>
	        <p>Costo con descuento del sangucheto: ${descuento.precioSanguchetoConDescuento}</p>
	        <p>Estas ahorrando:</p>
			<input type="submit" value="Aplicar descuento"/>
            <input type="reset"/>   
        </form:form>
        
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="js/jquery-1.11.3.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>
		</div>
		
</div>		
    </body>
</html>