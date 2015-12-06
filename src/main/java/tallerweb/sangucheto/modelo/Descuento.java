package tallerweb.sangucheto.modelo;

public class Descuento {
	Double precioSanguchetoSinDescuento;
	Double precioSanguchetoConDescuento;
	Double ahorro;
	Double valorFijo;
	Double valorPorcentual;
	
	public Descuento() {
		this.precioSanguchetoSinDescuento = 0.0;
		this.precioSanguchetoConDescuento = 0.0;
		this.ahorro = 0.0;
		this.valorFijo = 0.0;
		this.valorPorcentual = 0.0;
	}
	
//	public Descuento(Double valorFijo, Double valorPorcentual) {
//		this.valorFijo = valorFijo;
//		this.valorPorcentual = valorPorcentual;
//	}

	public Double calcularDescuento() {
		precioSanguchetoConDescuento = precioSanguchetoSinDescuento - valorFijo;
		precioSanguchetoConDescuento = precioSanguchetoConDescuento * (1 - (valorPorcentual / 100));
		return precioSanguchetoConDescuento;
	}
	
	public Double calcularAhorro() {
		ahorro = precioSanguchetoSinDescuento - precioSanguchetoConDescuento;
		return ahorro;
	}
	
	public Double getPrecioSanguchetoSinDescuento() {
		return precioSanguchetoSinDescuento;
	}

	public void setPrecioSanguchetoSinDescuento(Double precioSanguchetoSinDescuento) {
		this.precioSanguchetoSinDescuento = precioSanguchetoSinDescuento;
	}

	public Double getPrecioSanguchetoConDescuento() {
		return precioSanguchetoConDescuento;
	}

	public void setPrecioSanguchetoConDescuento(Double precioSanguchetoConDescuento) {
		this.precioSanguchetoConDescuento = precioSanguchetoConDescuento;
	}

	public Double getValorFijo() {
		return valorFijo;
	}

	public void setValorFijo(Double valorFijo) {
		this.valorFijo = valorFijo;
	}

	public Double getValorPorcentual() {
		return valorPorcentual;
	}

	public void setValorPorcentual(Double valorPorcentual) {
		this.valorPorcentual = valorPorcentual;
	}




}
