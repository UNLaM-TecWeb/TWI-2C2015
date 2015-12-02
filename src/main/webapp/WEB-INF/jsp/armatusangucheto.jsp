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
        <h1>Arma tu sangucheto</h1>
        
		<form:form method="post" action="agregarasangucheto" modelAttribute="ingredienteConStock">
            <h1>Eleg&iacute; tus ingredientes favoritos.</h1>
            <h3>Ingredientes:</h3>
            <form:select path="nombre">
				<c:forEach var="each" items="${mapa}">                
                	<form:option value="${each.key.nombre}" label="${each.key.nombre}, Precio: ARS${each.key.precio}, Stock: ${each.value}"/> 
                </c:forEach>
            </form:select>
            <h3>Cantidad:</h3>
            <form:input path="stock"/>
            <br>
            <input type="submit" value="agregar"/>
            <input type="reset"/>
        </form:form>
        
        <form:form method="post" action="agregarasangucheto" modelAttribute="ingredienteConStock">
        	<h1>Mir&aacute; como esta quedando tu sangucheto:</h1>
	        <form:select path="nombre" multiple="true">
				<c:forEach var="each" items="${sangucheto}">                
					<form:option value="${each.nombre}" label="${each.nombre}"/> 
				</c:forEach>
	        </form:select>
        </form:form>
        
        <form:form method="post" action="agregarasangucheto" modelAttribute="descuento">
	        <h3>Descuentos:</h3>
	        <p>Monto fijo</p> <form:input path="valorFijo"/>
	        <p>Monto porcentual</p> <form:input path="valorPorcentual"/>
	        
	        <p>Costo del sangucheto: ${descuento.precioSanguchetoSinDescuento}</p>
	        <p>Costo con descuento del sangucheto: ${descuento.precioSanguchetoConDescuento}</p>
	        <p>Estas ahorrando:</p>
			<input type="submit" value="Aplicar descuento"/>
            <input type="reset"/>   
        </form:form>
        
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="js/jquery-1.11.3.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>

    </body>
</html>