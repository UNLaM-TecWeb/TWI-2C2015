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
	
	</div><!-- Cierra container -->  
	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>