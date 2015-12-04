package tallerweb.sanguchetto.modelo;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import tallerweb.sangucheto.modelo.Ingrediente;
import tallerweb.sangucheto.modelo.Sanguchetto;
import tallerweb.sangucheto.modelo.TipoIngrediente;

public class SanguchettoTest {

    @Test
    public void testVaciar() {
    	Sanguchetto.getInstance().agregarIngrediente(new Ingrediente("lechuga", 0.5, TipoIngrediente.INGREDIENTE));
    	Sanguchetto.getInstance().agregarIngrediente(new Ingrediente("tomate", 0.3, TipoIngrediente.INGREDIENTE));
    	Sanguchetto.getInstance().agregarIngrediente(new Ingrediente("jamon", 0.8, TipoIngrediente.INGREDIENTE));
    	Sanguchetto.getInstance().agregarIngrediente(new Ingrediente("mayonesa", 0.4, TipoIngrediente.CONDIMENTO));
    	
    	Sanguchetto.getInstance().vaciar();
        Assert.assertTrue(Sanguchetto.getInstance().verCondimentos().isEmpty());
    }

    @Test
    public void testAgregarIngrediente() {
    	Sanguchetto.getInstance().agregarIngrediente(new Ingrediente("lechuga", 0.5, TipoIngrediente.INGREDIENTE));
    	Sanguchetto.getInstance().agregarIngrediente(new Ingrediente("tomate", 0.3, TipoIngrediente.INGREDIENTE));
    	Sanguchetto.getInstance().agregarIngrediente(new Ingrediente("jamon", 0.8, TipoIngrediente.INGREDIENTE));
    	Sanguchetto.getInstance().agregarIngrediente(new Ingrediente("mayonesa", 0.4, TipoIngrediente.CONDIMENTO));
    	Sanguchetto.getInstance().agregarIngrediente(new Ingrediente("sal", 0.1, TipoIngrediente.CONDIMENTO));
        
        Assert.assertFalse(Sanguchetto.getInstance().verCondimentos().isEmpty()); 
        Sanguchetto.getInstance().vaciar();
    }

    @Test
    public void testVerIngredientes() {
    	Sanguchetto.getInstance().agregarIngrediente(new Ingrediente("lechuga", 0.5, TipoIngrediente.INGREDIENTE));
    	Sanguchetto.getInstance().agregarIngrediente(new Ingrediente("tomate", 0.3, TipoIngrediente.INGREDIENTE));
    	Sanguchetto.getInstance().agregarIngrediente(new Ingrediente("jamon", 0.8, TipoIngrediente.INGREDIENTE));
    	Sanguchetto.getInstance().agregarIngrediente(new Ingrediente("mayonesa", 0.4, TipoIngrediente.CONDIMENTO));
    	Sanguchetto.getInstance().agregarIngrediente(new Ingrediente("sal", 0.1, TipoIngrediente.CONDIMENTO));
    	
        List<Ingrediente> listaDeIngredientes;
        listaDeIngredientes = Sanguchetto.getInstance().verIngredientes();
        
        for (Ingrediente cadaIngrediente : listaDeIngredientes)
        	Assert.assertTrue(cadaIngrediente.getTipo() == TipoIngrediente.INGREDIENTE);  
        
        Sanguchetto.getInstance().vaciar();
    }

    @Test
    public void testVerCondimentos() {
    	Sanguchetto.getInstance().agregarIngrediente(new Ingrediente("lechuga", 0.5, TipoIngrediente.INGREDIENTE));
    	Sanguchetto.getInstance().agregarIngrediente(new Ingrediente("tomate", 0.3, TipoIngrediente.INGREDIENTE));
    	Sanguchetto.getInstance().agregarIngrediente(new Ingrediente("jamon", 0.8, TipoIngrediente.INGREDIENTE));
    	Sanguchetto.getInstance().agregarIngrediente(new Ingrediente("mayonesa", 0.4, TipoIngrediente.CONDIMENTO));
    	Sanguchetto.getInstance().agregarIngrediente(new Ingrediente("sal", 0.1, TipoIngrediente.CONDIMENTO));
    	
        List<Ingrediente> listaDeCondimentos;
        listaDeCondimentos = Sanguchetto.getInstance().verCondimentos();
        
        for (Ingrediente cadaCondimento : listaDeCondimentos)
        	Assert.assertTrue(cadaCondimento.getTipo() == TipoIngrediente.CONDIMENTO);
        
        Sanguchetto.getInstance().vaciar();
    }

    @Test
    public void testGetPrecio() {
    	Sanguchetto.getInstance().agregarIngrediente(new Ingrediente("lechuga", 0.5, TipoIngrediente.INGREDIENTE));
    	Sanguchetto.getInstance().agregarIngrediente(new Ingrediente("tomate", 0.5, TipoIngrediente.INGREDIENTE));
    	Sanguchetto.getInstance().agregarIngrediente(new Ingrediente("jamon", 0.8, TipoIngrediente.INGREDIENTE));
    	Sanguchetto.getInstance().agregarIngrediente(new Ingrediente("mayonesa", 0.5, TipoIngrediente.CONDIMENTO));
    	Sanguchetto.getInstance().agregarIngrediente(new Ingrediente("sal", 0.2, TipoIngrediente.CONDIMENTO));
        
    	Assert.assertTrue(2.5 == Sanguchetto.getInstance().getPrecio());
    	Sanguchetto.getInstance().vaciar();
    }
}
