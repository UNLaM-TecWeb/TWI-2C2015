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
            <form:select path="nombre">
				<c:forEach var="each" items="${mapa}">                
                	<form:option value="${each.key.nombre}" label="${each.key.nombre}, Precio: ARS${each.key.precio}, Stock: ${each.value}"/> 
                </c:forEach>
            </form:select>
            <form:input path="stock"/>
            <input type="submit" value="agregar"/>
            <input type="reset"/>
        </form:form>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="js/jquery-1.11.3.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>

    </body>
</html>