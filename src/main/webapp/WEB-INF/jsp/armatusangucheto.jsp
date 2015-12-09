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
                <div class="col-sm-12 at_page_header">
                    <p>Elej&iacute; los ingredientes para tu Sangucheto !!!</p>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-4 at_list_header">Ingrediente</div>
                <div class="col-sm-2 at_list_header">Precio $</div>
                <div class="col-sm-2 at_list_header">Stock</div>
                <div class="col-sm-2 at_list_header">Cantidad</div>
                <div class="col-sm-2 at_list_header">Acci&oacute;n</div>
            </div>
            <c:forEach var="ingrediente" items="${mapa}">
	            <c:if test="${ingrediente.value > 0}">
		            <div class="row">
		            	<form:form method="post" action="agregarIngrediente?nombreIngrediente=${ingrediente.key.nombre}" modelAttribute="ingredienteConStock">
			                <div class="col-sm-4 at_list_item">
			                	${ingrediente.key.nombre}
			                </div>
			                <div class="col-sm-2 at_list_item">
			                	${ingrediente.key.precio}
			                </div>
			                <div class="col-sm-2 at_list_item">
			                	${ingrediente.value}
			                </div>
			                <div class="col-sm-2 at_list_item">
			                	<form:input path="stock" type="text" class="form-control input-sm"/>
			                </div>
			                <div class="col-sm-2 at_list_item">
			                	<input type="submit" class="btn btn-success btn-xs" value="Agregar"/>	
			                </div>
		            	</form:form>
		            </div>
	            </c:if>
            </c:forEach>
            <div class="row">
                <div class="col-md-12 at_separator"></div>
            </div>
            <div class="row at_off_box_background">
                <div class="col-md-4 at_off_box">
                    <div class="at_off_box_title">
                        <p>Precio $ ${precioTotalSangucheto} / Ahorro $ ${ahorroSangucheto}</p>
                    </div>
                    <div>
                        <p>¿T&eacute;nes un descuento? Ingresalo ac&aacute;:</p>
                    </div>
                    <form:form method="post" action="agregarDescuento" modelAttribute="descuento">
                        <div>
	                        <form:input path="valorFijo" type="text" class="form-control input-sm" placeholder="Monto fijo"/>
	                    </div>
                        <div>
	                        <form:input path="valorPorcentual" type="text" class="form-control input-sm" placeholder="Monto porcentual"/>
	                    </div>
	                    <div>
	                        <input type="submit" class="btn btn-success btn-md" value="Agregar"/>
	                    </div>
                    </form:form>
                </div>
                <div class="col-md-4 at_sangucheto_box">
                    <div class="at_off_box_title">
                        <p>As&iacute; esta quedando tu sangucheto !</p>
                    </div>
                	<c:forEach var="ingrediente" items="${listaDeIngredientesSangucheto}">
                		<form:form method="post" action="quitarDeSangucheto" modelAtribute="IngredienteConStock">
                            <div>
                		        <p>${ingrediente.nombre}, $ ${ingrediente.precio}</p>
                            </div>
                		</form:form>
                	</c:forEach>
                </div>
                <div class="col-md-4"></div>
                
					<form action="vaciarSanguchetto" method="POST">
						<input type="submit" class="btn btn-default"
							value="A la mierda todo.">
					</form>
				
            </div>
        </div> <!-- Cierra container -->        
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src='<c:url value="/js/jquery-1.11.3.min.js" />' type="text/javascript"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src='<c:url value="/js/bootstrap.min.js" />' type="text/javascript" ></script>
    </body>
</html>