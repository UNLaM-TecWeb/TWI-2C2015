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
        
        <div class="row">
	        <div class="col-md-2 col-md-offset-5"><h1>Sanguchetto</h1></div>
	        </div>
		        <div>
		            <%-- Menu de opciones --%>
		            <li>
		            <a href="listaIngredientes" class="btn btn-lg btn-primary">Listar ingredientes</a>
		            </li>
		            <br>
		            <li>
		            <a href="altaIngrediente" class="btn btn-lg btn-primary">Alta de ingredientes</a>
		            </li>
		            <br>
		            <li>
		            <a <a href="cargarListaConIngredientes?accion=agregar" class="btn btn-lg btn-primary">Agregar Stock</a>
		            </li>
		            <br>
		            <li>
		            <a href="cargarListaConIngredientes?accion=eliminar" class="btn btn-lg btn-primary">Eliminar stock</a>
		        	</li>
		        </div>
        </div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="js/jquery-1.11.3.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>

    </body>
</html>