package tallerweb.sangucheto.modelo;

import java.util.LinkedList;
import java.util.List;

public class Sanguchetto {

	private static Sanguchetto instance = new Sanguchetto();
	private List<Ingrediente> ingredientes = new LinkedList<Ingrediente>();
	private List<Descuento> descuentos = new LinkedList<Descuento>();
	
	private Sanguchetto(){}
	
	public static Sanguchetto getInstance(){
		return instance;
	}
	
	/**
	 * Elimina todos los ingredientes del sanguchetto.<br>
	 */
	public void vaciar(){
		ingredientes.clear();
	}
	
	/**
	 * Elimina todos los descuentos del sanguchetto.<br>
	 */
	public void vaciarDescuentos() {
		descuentos.clear();
	}
	
	/**
	 * Agrega un ingrediente al carrito.<br>
	 * @param ingrediente
	 */
	public void agregarIngrediente(Ingrediente ingrediente){
		ingredientes.add(ingrediente);
	}
	
	/**
	 * Lista todos los ingredientes y condimentos que forman parte del sanguchetto.<br>
	 * @return
	 */
	public List<Ingrediente> verIngredientesYCondimentos(){
		List<Ingrediente> listaDeIngredientes = new LinkedList<Ingrediente>();
		
		for (Ingrediente cadaElemento : ingredientes)
			listaDeIngredientes.add(cadaElemento);
		
		return listaDeIngredientes;
	}
	
	/**
	 * Lista todos los ingredientes que forman parte del sanguchetto.<br>
	 * @return
	 */
	public List<Ingrediente> verIngredientes(){
		List<Ingrediente> listaDeIngredientes = new LinkedList<Ingrediente>();
		
		for (Ingrediente cadaElemento : ingredientes)
			if (cadaElemento.getTipo() == TipoIngrediente.INGREDIENTE)
				listaDeIngredientes.add(cadaElemento);
		
		return listaDeIngredientes;
	}
	
	/**
     * Lista todos los condimentos que forman parte del sanguchetto.<br>
     * @return
     */
    public List<Ingrediente> verCondimentos(){
    	List<Ingrediente> listaDeCondimentos = new LinkedList<Ingrediente>();

    	for (Ingrediente cadaElemento : ingredientes)
			if (cadaElemento.getTipo() == TipoIngrediente.CONDIMENTO)
				listaDeCondimentos.add(cadaElemento);
		
        return listaDeCondimentos;
    }
	
	/**
	 * Devuelve el precio total del sanguchetto.<br>
	 * @return
	 */
	public Double getPrecio(){
		Double precioTotal = 0.0;
		
		for (Ingrediente cadaElemento : ingredientes)
			precioTotal += cadaElemento.getPrecio();
		
		return precioTotal;
	}

	public void agregarDescuento(Double valorFijo, Double valorPorcentual) {
		descuentos.add(new Descuento(valorFijo, valorPorcentual));
	}
	
	/**
	 * Calcula el total de descuento de todos los descuentos.
	 * @return la sumatoria de todos los descuentos.
	 * */
	public Double calcularDescuentoTotal() {
		Double montoFijoTotal = 0.0;
		Double montoPorcentualTotal = 0.0;
		
		// Primero buscamos todos los descuentos de monto fijo y monto porcentual...
		for (Descuento cadaDescuento : descuentos) {
			montoFijoTotal += cadaDescuento.getValorFijo();
			montoPorcentualTotal += cadaDescuento.getValorPorcentual();
		}
		
		// ... una vez que tenemos esos datos calculamos el descuento. 
		Descuento descuentoTotal = new Descuento(montoFijoTotal, montoPorcentualTotal);
		return descuentoTotal.calcularDescuento(this.getPrecio());
	}
	
	public Double getPrecioConDescuento() {
		return (this.getPrecio() - this.calcularDescuentoTotal());
	}
	
	public List<Descuento> verDescuentos(){
		List<Descuento> listaDeDescuentos = new LinkedList<Descuento>();
		
		for (Descuento cadaElemento : descuentos)
			listaDeDescuentos.add(cadaElemento);
		
		return listaDeDescuentos;
	}
}
