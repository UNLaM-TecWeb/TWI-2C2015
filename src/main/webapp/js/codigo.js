function validar(inputId, defaultValue) {
    if (document.getElementById(inputId).value == "")
        document.getElementById(inputId).value = defaultValue;
}

function validarStock(bandera) {
	if (bandera != "")
		alert(bandera);
}