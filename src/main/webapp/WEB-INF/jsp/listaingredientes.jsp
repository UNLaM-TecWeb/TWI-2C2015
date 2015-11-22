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
    <link href="../../css/bootstrap-theme.min.css" type="text/css" rel="stylesheet" media="screen">
    <link href="../../css/bootstrap.min.css" type="text/css" rel="stylesheet" media="screen">
</head>

<body>
	
    <h1>LISTA DE INGREDIENTES</h1>
	<table border="1">
		<tr>
			<td>INGREDIENTE</td>
			<td>PRECIO</td>
			<td>TIPO</td>
			<td>STOCK</td>
		</tr>
		<c:forEach var="each" items="${lista}">
			<tr>
				<td>${each.nombre}</td>
				<td>${each.precio}</td>
				<td>&#45;<!--{each.tipo}--></td>
				<td>&#45;<!--{each.stock}--></td>
			</tr>
		</c:forEach>
	</table>	
   
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="../../js/jquery-1.11.3.min.js" type="text/javascript"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="../../js/bootstrap.min.js" type="text/javascript" ></script>
</body>
</html>