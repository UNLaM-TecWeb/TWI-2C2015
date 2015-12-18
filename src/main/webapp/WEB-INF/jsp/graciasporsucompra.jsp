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
    <title>Sangucheto S.A.</title>
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
            <div class="col-md-2 at_navbar_btn"><a href="cargarListaConIngredientes?accion=armatusangucheto&validacion=''">Arma tu<br>sangucheto</a></div>
            <div class="col-md-2 at_navbar_btn"><a href="cargarListaConIngredientes?accion=listaingredientes&validacion=''">Listar<br>ingredientes</a></div>
            <div class="col-md-2 at_navbar_btn"><a href="cargarListaConIngredientes?accion=altaingrediente&validacion=''">Alta de<br>ingredientes</a></div>
            <div class="col-md-2 at_navbar_btn"><a href="cargarListaConIngredientes?accion=bajaingrediente&validacion=''">Baja de<br>ingredientes</a></div>
            <div class="col-md-2 at_navbar_btn"><a href="cargarListaConIngredientes?accion=agregarstock&validacion=''">Agregar stock<br>a ingrediente</a></div>
            <div class="col-md-1"></div>
        </div>
        <div class="row">
            <div class="col-md-12 at_separator"></div>
        </div>
        <div class="row">
            <div class="col-md-12 at_index_msg">
                <p>Gracias por su compra !!!</p>
            </div>
        </div>
        
        <div class="row at_off_box_background">
            <div class="col-md-3"></div>
            <div class="col-md-6 at_sangucheto_box_titulo">
                <div>
                    Compraste un sangucheto con los siguientes ingredientes:
                </div>
            </div>
            <div class="col-md-3"></div>
        </div>
           
                   
        <div class="row at_off_box_background">
            <div class="col-md-3"></div>
            <div class="col-md-6 at_sangucheto_box_lista">
                <div>
                    <c:forEach var="ingrediente" items="${listaDeIngredientesSangucheto}">
                		<form:form method="post" action="quitarDeSangucheto" modelAtribute="IngredienteConStock">
                            <div>
                		        <p>${ingrediente.nombre}, $ ${ingrediente.precio}</p>
                            </div>
                		</form:form>
                	</c:forEach>
                </div>
            </div>
            <div class="col-md-3"></div>
        </div>
        
        <div class="row at_off_box_background">
            <div class="col-md-3"></div>
            <div class="col-md-6 at_sangucheto_box_precio">
                <div>
                    Precio del sangucheto: $ ${precioTotalSangucheto}
                </div>
            </div>
            <div class="col-md-3"></div>
        </div>
        
        <div class="row">
            <div class="col-md-12 at_separator"></div>
        </div>
        
        <div class="row at_off_box_background">
            <div class="col-md-4"></div>
            <div class="col-md-4 at_centrar_texto">
                <a href="/sangucheto" class="btn btn-info btn-md">Volver a la pagina principal</a>
            </div>
            <div class="col-md-4"></div>
        </div>

    </div> <!-- Cierra container -->        
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src='<c:url value="/js/jquery-1.11.3.min.js" />' type="text/javascript"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src='<c:url value="/js/bootstrap.min.js" />' type="text/javascript" ></script>
</body>

</html>