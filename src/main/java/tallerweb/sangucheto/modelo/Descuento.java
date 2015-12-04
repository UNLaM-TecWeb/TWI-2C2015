package tallerweb.sangucheto.modelo;

public class Descuento {
	private Double precioSanguchetoSinDescuento;
	private Double precioSanguchetoConDescuento;
	private Double ahorro;
	private Double valorFijo;
	private Double valorPorcentual;
	
	public Descuento() {
		this.precioSanguchetoSinDescuento = new Double(0.0);
		this.precioSanguchetoConDescuento = new Double(0.0);
		this.ahorro = new Double(0.0);
		this.valorFijo = new Double(0.0);
		this.valorPorcentual = new Double(0.0);
	}
	
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

	public Double getAhorro() {
		return ahorro;
	}

	public void setAhorro(Double ahorro) {
		this.ahorro = ahorro;
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
