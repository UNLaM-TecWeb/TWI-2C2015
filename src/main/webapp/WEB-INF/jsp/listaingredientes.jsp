<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Sangucheto&#58; Lista de ingredientes</title>
    <!-- Bootstrap -->
    <link href='<c:url value="/css/bootstrap-theme.min.css" />' type="text/css" rel="stylesheet" media="screen">
    <link href='<c:url value="/css/bootstrap.min.css" />' type="text/css" rel="stylesheet" media="screen">
</head>

<body>
	
    <h1>LISTA DE INGREDIENTES</h1>
	<table class="table table-bordered">
		<tr>
			<td>INGREDIENTE</td>
			<td>PRECIO</td>
			<td>TIPO</td>
			<td>STOCK</td>
		</tr>
		<c:forEach var="ingrediente" items="${mapa}">
			<tr>
				<td>${ingrediente.key.nombre}</td>
				<td>${ingrediente.key.precio}</td>
				<td>${ingrediente.key.tipo}</td>
				<td>${ingrediente.value}</td>
			</tr>
		</c:forEach>
	</table>	
   
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src='<c:url value="/js/jquery-1.11.3.min.js" />' type="text/javascript"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src='<c:url value="/js/bootstrap.min.js" />' type="text/javascript" ></script>
</body>
</html>