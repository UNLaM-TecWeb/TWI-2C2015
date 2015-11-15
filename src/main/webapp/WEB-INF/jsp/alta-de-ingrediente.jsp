<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3c.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="es">
<head>
    <meta http-equiv="Content-Type" content ="text/html; charset=ISO-8859-1" />
    <link href="" type="image/x-icon" rel="shortcut icon" />
    <title>Taller Web I - Sanguchetto</title>
</head>

<body>
    <div class="container">
        
        <div class="header">
            <p>Alta de producto</p>
        </div>

        <div class="body">
            <form:form method="POST" action="crearIngrediente" modelAttribute="ingrediente">
                <form:input path="nombre"/> <br />
                <form:input path="precio"/> <br />
                <form:select path="tipo">
                    <form:option value="Ingrediente" label="Ingrediente" />
                    <form:option value="Condimento" label="Condimento" />
                </form:select> <br />
                <form:input type="submit" /> <input type="reset" />
            </form:form>
        </div>
        
        <div class="footer">
            <p></p>
        </div>
    </div>
</body>
</html>