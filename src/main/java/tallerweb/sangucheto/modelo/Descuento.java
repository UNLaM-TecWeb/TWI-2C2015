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
		Double totalDescuento;
		
		totalDescuento = precioSangucheto * (valorPorcentual/100);
		totalDescuento = totalDescuento + valorFijo;
		
		return totalDescuento;
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
