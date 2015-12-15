package tallerweb.sangucheto.modelo;

public class Descuento {
	private Double valorFijo;
	private Double valorPorcentual;

	public Descuento() {}
	
	public Descuento(Double valorFijo, Double valorPorcentual) {
		this.valorFijo = valorFijo;
		this.valorPorcentual = valorPorcentual;
	}
	
	/**
	 * Calcula cuanto se le va a descontar al sangucheto.<br>
	 * @param el precio total del sangucheto.
	 * @return el total del descuento.
	 */
	public Double calcularDescuento(Double precioSangucheto) {
		Double precioConDescuento = precioSangucheto;
		
		if(valorFijo > 0.0)
			precioConDescuento = precioSangucheto - valorFijo;
		
		if(valorPorcentual > 0.0)
			precioConDescuento = precioConDescuento * (valorPorcentual/100);
		
		// El descuento lo obtenemos de la diferencia entre el precio original y el precio con descuento.
		return (precioSangucheto - precioConDescuento);
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
