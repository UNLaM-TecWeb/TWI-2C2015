package tallerweb.sanguchetto.modelo;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import tallerweb.sangucheto.modelo.Ingrediente;
import tallerweb.sangucheto.modelo.Sanguchetto;
import tallerweb.sangucheto.modelo.TipoIngrediente;

public class SanguchettoTest {

	private Sanguchetto s = Sanguchetto.getInstance();
	/*
	 * Por mas que defina Sanguchetto s dentro de cada Test su atributos son globales a todos los test, por lo tanto si agregaba lechuga
	 * en un metodo y tomate en otro metod, veia lechuga y tomate en un tercer metodo. O sea, las modificaciones al objeto s persisten
	 * entre los distintos casos de prueba.
	 * Es por los motivos mencionados que decidí definir Sanguchetto s de forma global dentro de la clase.
	 * 
	 * */
	
	
    @Test
    public void testVaciar() {
        s.agregarIngrediente(new Ingrediente("lechuga", 0.5, TipoIngrediente.INGREDIENTE));
        s.agregarIngrediente(new Ingrediente("tomate", 0.3, TipoIngrediente.INGREDIENTE));
        s.agregarIngrediente(new Ingrediente("jamon", 0.8, TipoIngrediente.INGREDIENTE));
        s.agregarIngrediente(new Ingrediente("mayonesa", 0.4, TipoIngrediente.CONDIMENTO));
        
        s.vaciar();
        Assert.assertTrue(s.verCondimentos().isEmpty());
    }

    @Test
    public void testAgregarIngrediente() {
        s.agregarIngrediente(new Ingrediente("lechuga", 0.5, TipoIngrediente.INGREDIENTE));
        s.agregarIngrediente(new Ingrediente("tomate", 0.3, TipoIngrediente.INGREDIENTE));
        s.agregarIngrediente(new Ingrediente("jamon", 0.8, TipoIngrediente.INGREDIENTE));
        s.agregarIngrediente(new Ingrediente("mayonesa", 0.4, TipoIngrediente.CONDIMENTO));
        s.agregarIngrediente(new Ingrediente("sal", 0.1, TipoIngrediente.CONDIMENTO));
        
        Assert.assertFalse(s.verCondimentos().isEmpty());        
    }

    @Test
    public void testVerIngredientes() {
        List<Ingrediente> listaDeIngredientes;
        listaDeIngredientes = s.verIngredientes();
        
        for (Ingrediente cadaIngrediente : listaDeIngredientes)
        	Assert.assertTrue(cadaIngrediente.getTipo() == TipoIngrediente.INGREDIENTE);      	
    }

    @Test
    public void testVerCondimentos() {
        List<Ingrediente> listaDeCondimentos;
        listaDeCondimentos = s.verIngredientes();
        
        for (Ingrediente cadaIngrediente : listaDeCondimentos)
        	Assert.assertTrue(cadaIngrediente.getTipo() == TipoIngrediente.INGREDIENTE);
    }

    @Test
    public void testGetPrecio() {
        Assert.assertTrue(2.1 == s.getPrecio());
    }
}
