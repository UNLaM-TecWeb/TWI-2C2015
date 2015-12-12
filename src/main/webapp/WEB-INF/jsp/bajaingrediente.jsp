<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
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
            <div class="col-md-2 at_navbar_btn"><a href="cargarListaConIngredientes?accion=listaingredientes">Listar<br>ingredientes</a></div>
            <div class="col-md-2 at_navbar_btn"><a href="cargarListaConIngredientes?accion=altaingrediente">Alta de<br>ingredientes</a></div>
            <div class="col-md-2 at_navbar_btn"><a href="cargarListaConIngredientes?accion=bajaingrediente">Baja de<br>ingredientes</a></div>
            <div class="col-md-2 at_navbar_btn"><a href="cargarListaConIngredientes?accion=agregarstock">Agregar stock<br>a ingrediente</a></div>
            <div class="col-md-1"></div>
        </div>
        <div class="row">
            <div class="col-md-12 at_page_header">Eleg&iacute; el ingrediente o condimento que quieras hacer boleta !!!</div>
        </div>
        <div class="row">
            <div class="col-sm-4 at_list_header">Ingrediente</div>
            <div class="col-sm-2 at_list_header">Precio $</div>
            <div class="col-sm-2 at_list_header">Tipo</div>
            <div class="col-sm-2 at_list_header">Stock</div>
            <div class="col-sm-2 at_list_header">Acci&oacute;n</div>
        </div>
        <c:forEach var="ingrediente" items="${mapa}">
            <div class="row resaltado">
                <form method="post" action="bajaIngrediente?nombreIngrediente=${ingrediente.key.nombre}">
                    <div class="col-sm-4 at_list_item">
                        ${ingrediente.key.nombre}
                    </div>
                    <div class="col-sm-2 at_list_item">
                        ${ingrediente.key.precio}
                    </div>
                    <div class="col-sm-2 at_list_item">
                        ${ingrediente.key.tipo}
                    </div>
                    <div class="col-sm-2 at_list_item">
                        ${ingrediente.value}
                    </div>
                    <div class="col-sm-2 at_list_item">
                        <input type="submit" class="btn btn-danger btn-xs" value="Eliminar"/>	
                    </div>
                </form>
            </div>
        </c:forEach>
	</div><!-- Cierra container -->  
	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>