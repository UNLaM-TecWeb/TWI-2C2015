<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Sangucheto&#58; Alta de ingrediente</title>
    <!-- Bootstrap -->
    <link href='<c:url value="/css/bootstrap-theme.min.css" />' type="text/css" rel="stylesheet" media="screen">
    <link href='<c:url value="/css/bootstrap.min.css" />' type="text/css" rel="stylesheet" media="screen">
</head>

<body>
	
        	<div class="row">
		        <div class="col-md-2 col-md-offset-5">
		        	<h2>AGREGAR STOCK</h2>
		        </div>
			</div>
        
<div class="container">
        
        <form:form method="post" action="modificarStock?accion=agregar" modelAttribute="ingredienteConStock">
            <div class="col-sm-10">
	            <form:select class="form-control" path="nombre">
					<c:forEach var="each" items="${mapa}">                
	                	<form:option value="${each.key.nombre}" label="${each.key.nombre}, Stock: ${each.value}"/> 
	                </c:forEach>
	            </form:select>
            </div>
            
            <form:input placeholder="Ingrese stock" path="stock"/>
            <input type="submit"/>
        </form:form>
    
    
</div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src='<c:url value="/js/jquery-1.11.3.min.js" />' type="text/javascript"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src='<c:url value="/js/bootstrap.min.js" />' type="text/javascript" ></script>
</body>
</html>