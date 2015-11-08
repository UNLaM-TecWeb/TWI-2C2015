package tallerweb.sangucheto.modelo;

import java.util.LinkedList;
import java.util.List;

public class Sanguchetto {

	private static Sanguchetto instance = new Sanguchetto();
	private List<Ingrediente> ingredientes = new LinkedList<Ingrediente>();
	
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
	 * Agrega un ingrediente al carrito.<br>
	 * @param ingrediente
	 */
	public void agregarIngrediente(Ingrediente ingrediente){
		ingredientes.add(ingrediente);
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
		Double precioTotal = (double) 0;
		
		for (Ingrediente cadaElemento : ingredientes)
			precioTotal += cadaElemento.getPrecio();
		
		return precioTotal;
	}
}
