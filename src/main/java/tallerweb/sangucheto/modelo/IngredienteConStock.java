package tallerweb.sangucheto.modelo;

public class IngredienteConStock {
	private String nombre;
	private Integer stock;
	
	public IngredienteConStock() {}
	
	public IngredienteConStock(String nombre, Integer stock) {
		this.nombre = nombre;
		this.stock = stock;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Integer getStock() {
		return stock;
	}
	
	public void setStock(Integer stock) {
		this.stock = stock;
	}
}
