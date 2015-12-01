package tallerweb.sangucheto.modelo;

public class Descuento {
	Double valor;
	TipoDescuento tipo;
	
	public Descuento(Double valor, TipoDescuento tipo) {
		this.valor = valor;
		this.tipo = tipo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public TipoDescuento getTipo() {
		return tipo;
	}

	public void setTipo(TipoDescuento tipo) {
		this.tipo = tipo;
	}
}
