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
        <h1>Programando Sanguchettoo TEST<br>Taller Web Java</h1>
        <div>
            <%-- Menu de opciones --%>
            <a href="index.jsp" class="btn btn-lg btn-link">Inicio</a> |
            <a href="mostrarStockProducto.jsp" class="btn btn-lg btn-link">Mostrar Stock Producto existente</a> |
            <a href="darAltaProducto.jsp" class="btn btn-lg btn-link">Dar Alta a Producto</a> |
            <a href="agregarStock.jsp" class="btn btn-lg btn-link">Agregar a Stock</a> |
            <a href="eliminarProducto.jsp" class="btn btn-lg btn-link">Eliminar Producto</a>
            <a href="test.jsp" class="btn btn-lg btn-link">Eliminar Producto</a>
        </div>
        <br >
        <div>
            <table border="1">
                <tr style="background-color: chocolate">
                    <td colspan="4">Lista de Productos</td>

                </tr>
                <tr style="background-color: chocolate">
                    <td>Codigo</td>
                    <td>Nombre</td>
                    <td>Precio</td>
                    <td>Proceso</td>
                </tr>
                <%-- Lista de todos los productos --%>
               

            </table>
        </div>


	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="js/jquery-1.11.3.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>

    </body>
</html>