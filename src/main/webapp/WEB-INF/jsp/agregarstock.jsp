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
                 <p><a href="/sangucheto" style="color: yellow">SANGUCHETO</a></p>
            </div>
        </div>
        <div class="row">
            <div class="col-md-1"></div>
            <div class="col-md-2 at_navbar_btn"><a href="cargarListaConIngredientes?accion=armatusangucheto">Arma tu<br>sangucheto</a></div>
            <div class="col-md-2 at_navbar_btn"><a href="listaIngredientes">Listar<br>ingredientes</a></div>
            <div class="col-md-2 at_navbar_btn"><a href="altaIngrediente">Alta de<br>ingredientes</a></div>
            <div class="col-md-2 at_navbar_btn"><a href="eliminaringrediente">Baja de<br>ingredientes</a></div>
            <div class="col-md-2 at_navbar_btn"><a href="cargarListaConIngredientes?accion=agregarstock">Agregar stock<br>a ingrediente</a></div>
            <div class="col-md-1"></div>
        </div>
        <div class="row">
            <div class="col-sm-12 at_page_header">
                <p>Agregar stock a ingrediente.</p>
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
            <div class="row">
                <form:form method="post" action="modificarStock?accion=agregar&nombreIngrediente=${ingrediente.key.nombre}" modelAttribute="ingredienteConStock">
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
                        <input type="submit" class="btn btn-success btn-sm" value="Agregar"/>	
                    </div>
                </form:form>
            </div>
        </c:forEach>
    </div> <!-- Cierra container --> 
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src='<c:url value="/js/jquery-1.11.3.min.js" />' type="text/javascript"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src='<c:url value="/js/bootstrap.min.js" />' type="text/javascript" ></script>
</body>
</html>