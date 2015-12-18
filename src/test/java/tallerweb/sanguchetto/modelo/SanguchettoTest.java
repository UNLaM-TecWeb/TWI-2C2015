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
    	Sanguchetto.getInstance().vaciar();
    	Sanguchetto.getInstance().agregarIngrediente(new Ingrediente("lechuga", 0.5, TipoIngrediente.INGREDIENTE));
    	Sanguchetto.getInstance().agregarIngrediente(new Ingrediente("tomate", 0.3, TipoIngrediente.INGREDIENTE));
    	Sanguchetto.getInstance().agregarIngrediente(new Ingrediente("jamon", 0.8, TipoIngrediente.INGREDIENTE));
    	Sanguchetto.getInstance().agregarIngrediente(new Ingrediente("mayonesa", 0.4, TipoIngrediente.CONDIMENTO));
    	Sanguchetto.getInstance().vaciar();
        Assert.assertTrue(Sanguchetto.getInstance().verCondimentos().isEmpty());
    }

    @Test
    public void testAgregarIngrediente() {
    	Sanguchetto.getInstance().vaciar();
    	Sanguchetto.getInstance().agregarIngrediente(new Ingrediente("lechuga", 0.5, TipoIngrediente.INGREDIENTE));
    	Sanguchetto.getInstance().agregarIngrediente(new Ingrediente("tomate", 0.3, TipoIngrediente.INGREDIENTE));
    	Sanguchetto.getInstance().agregarIngrediente(new Ingrediente("jamon", 0.8, TipoIngrediente.INGREDIENTE));
    	Sanguchetto.getInstance().agregarIngrediente(new Ingrediente("mayonesa", 0.4, TipoIngrediente.CONDIMENTO));
    	Sanguchetto.getInstance().agregarIngrediente(new Ingrediente("sal", 0.1, TipoIngrediente.CONDIMENTO));
        Integer cantidadIngredientes = 3;
        Integer contadorIngredientes = 0;
        Integer cantidadCondimentos = 2;
        Integer contadorCondimentos = 0;
        
    	// Revisamos que se hayan agregado la cantidad de ingredientes correspondiente y contamos...
    	List<Ingrediente> listaDeIngredientes;
        listaDeIngredientes = Sanguchetto.getInstance().verIngredientes();
        
        for (Ingrediente cadaIngrediente : listaDeIngredientes) {
        	Assert.assertTrue(cadaIngrediente.getTipo() == TipoIngrediente.INGREDIENTE);
        	contadorIngredientes++;
        }
 
        // Revisamos que se hayan agregado la cantidad de condimentos correspondiente y contamos...
        List<Ingrediente> listaDeCondimentos;
        listaDeCondimentos = Sanguchetto.getInstance().verCondimentos();
	  
        for (Ingrediente cadaCondimento : listaDeCondimentos) {
        	Assert.assertTrue(cadaCondimento.getTipo() == TipoIngrediente.CONDIMENTO);
        	contadorCondimentos++;
        }
        
        // Comparamos la cantidad de ingredientes/condimentos contados con la cantidad ingresada...
        Assert.assertTrue(contadorIngredientes == cantidadIngredientes);
        Assert.assertTrue(contadorCondimentos == cantidadCondimentos);
        
        Sanguchetto.getInstance().vaciar();
    }

    @Test
    public void testVerIngredientes() {
    	Sanguchetto.getInstance().vaciar();
    	Sanguchetto.getInstance().agregarIngrediente(new Ingrediente("lechuga", 0.5, TipoIngrediente.INGREDIENTE));
    	Sanguchetto.getInstance().agregarIngrediente(new Ingrediente("tomate", 0.3, TipoIngrediente.INGREDIENTE));
    	Sanguchetto.getInstance().agregarIngrediente(new Ingrediente("jamon", 0.8, TipoIngrediente.INGREDIENTE));
    	Sanguchetto.getInstance().agregarIngrediente(new Ingrediente("mayonesa", 0.4, TipoIngrediente.CONDIMENTO));
    	Sanguchetto.getInstance().agregarIngrediente(new Ingrediente("sal", 0.1, TipoIngrediente.CONDIMENTO));
    	
    	Integer contador = 0;
    	Integer cantidadIngredientes = 3;
        List<Ingrediente> listaDeIngredientes;
        listaDeIngredientes = Sanguchetto.getInstance().verIngredientes();
        
        for (Ingrediente cadaIngrediente : listaDeIngredientes) {
        	Assert.assertTrue(cadaIngrediente.getTipo() == TipoIngrediente.INGREDIENTE);  
        	contador++;
        }
        
        Assert.assertTrue(contador == cantidadIngredientes);
        Sanguchetto.getInstance().vaciar();
    }

    @Test
    public void testVerCondimentos() {
    	Sanguchetto.getInstance().vaciar();
    	Sanguchetto.getInstance().agregarIngrediente(new Ingrediente("lechuga", 0.5, TipoIngrediente.INGREDIENTE));
    	Sanguchetto.getInstance().agregarIngrediente(new Ingrediente("tomate", 0.3, TipoIngrediente.INGREDIENTE));
    	Sanguchetto.getInstance().agregarIngrediente(new Ingrediente("jamon", 0.8, TipoIngrediente.INGREDIENTE));
    	Sanguchetto.getInstance().agregarIngrediente(new Ingrediente("mayonesa", 0.4, TipoIngrediente.CONDIMENTO));
    	Sanguchetto.getInstance().agregarIngrediente(new Ingrediente("sal", 0.1, TipoIngrediente.CONDIMENTO));
    	
    	Integer contador = 0;
    	Integer cantidadCondimentos = 2;
        List<Ingrediente> listaDeCondimentos;
        listaDeCondimentos = Sanguchetto.getInstance().verCondimentos();
        
        // Contamos la cantidad de Condimentos que encuentra en la lista...
        for (Ingrediente cadaCondimento : listaDeCondimentos) {
        	Assert.assertTrue(cadaCondimento.getTipo() == TipoIngrediente.CONDIMENTO);
        	contador++;
        }
        
        // Verificamos que la cantidad de ingredientes contada coincida con las cantidad ingresada.
        Assert.assertTrue(contador == cantidadCondimentos);
        Sanguchetto.getInstance().vaciar();
    }

    @Test
    public void testGetPrecio() {
    	Sanguchetto.getInstance().vaciar();
    	Sanguchetto.getInstance().agregarIngrediente(new Ingrediente("lechuga", 0.5, TipoIngrediente.INGREDIENTE));
    	Sanguchetto.getInstance().agregarIngrediente(new Ingrediente("tomate", 0.5, TipoIngrediente.INGREDIENTE));
    	Sanguchetto.getInstance().agregarIngrediente(new Ingrediente("jamon", 0.8, TipoIngrediente.INGREDIENTE));
    	Sanguchetto.getInstance().agregarIngrediente(new Ingrediente("mayonesa", 0.5, TipoIngrediente.CONDIMENTO));
    	Sanguchetto.getInstance().agregarIngrediente(new Ingrediente("sal", 0.2, TipoIngrediente.CONDIMENTO));
        
    	Assert.assertTrue(2.5 == Sanguchetto.getInstance().getPrecio());
    	Sanguchetto.getInstance().vaciar();
    }
    
    @Test
    public void testAgregarDescuento() {
    	// Me aseguro de comenzar con un carrito limpio.
    	Sanguchetto.getInstance().vaciar();
    	Sanguchetto.getInstance().vaciarDescuentos();
    	
    	// Veo que no haya descuentos...
    	Assert.assertTrue(Sanguchetto.getInstance().verDescuentos().isEmpty());
    	
    	// Agrego un descuento y lo verifico.
    	Sanguchetto.getInstance().agregarDescuento(1.0, 50.0);    	
    	Assert.assertFalse(Sanguchetto.getInstance().verDescuentos().isEmpty());
    	
    	// Limpio el espacio de trabajo.
    	Sanguchetto.getInstance().vaciar();
    	Sanguchetto.getInstance().vaciarDescuentos();
    }
    
    @Test
    public void testVaciarDescuento() {
    	// Me aseguro de comenzar con un carrito limpio.
    	Sanguchetto.getInstance().vaciar();
    	Sanguchetto.getInstance().vaciarDescuentos();
    	
    	// Me aseguro de agregar correctamente un descuento...
    	Sanguchetto.getInstance().agregarDescuento(1.0, 50.0);    	
    	Assert.assertFalse(Sanguchetto.getInstance().verDescuentos().isEmpty());
    	
    	// Vacio la lista de descuentos y lo verifico...
    	Sanguchetto.getInstance().vaciarDescuentos();
    	Assert.assertTrue(Sanguchetto.getInstance().verDescuentos().isEmpty());

    	// Limpio el espacio de trabajo.
    	Sanguchetto.getInstance().vaciar();
    	Sanguchetto.getInstance().vaciarDescuentos();
    }
    
    @Test
    public void testGetPrecioConDescuento() {
    	// Me aseguro de comenzar con un carrito limpio.
    	Sanguchetto.getInstance().vaciar();
    	Sanguchetto.getInstance().vaciarDescuentos();
    	
    	Sanguchetto.getInstance().agregarIngrediente(new Ingrediente("lechuga", 1.0, TipoIngrediente.INGREDIENTE));
    	Sanguchetto.getInstance().agregarIngrediente(new Ingrediente("tomate", 1.0, TipoIngrediente.INGREDIENTE));
    	Sanguchetto.getInstance().agregarIngrediente(new Ingrediente("jamon", 1.0, TipoIngrediente.INGREDIENTE));
    	Sanguchetto.getInstance().agregarIngrediente(new Ingrediente("mayonesa", 1.0, TipoIngrediente.CONDIMENTO));
    	Sanguchetto.getInstance().agregarIngrediente(new Ingrediente("sal", 1.0, TipoIngrediente.CONDIMENTO)); 
    	
    	Sanguchetto.getInstance().agregarDescuento(1.0, 50.0);
    	Assert.assertTrue(2.0 == Sanguchetto.getInstance().getPrecioConDescuento());
    	
    	// Limpio el area de trabajo...
    	Sanguchetto.getInstance().vaciar();
    	Sanguchetto.getInstance().vaciarDescuentos();
    }
    
    @Test
    public void testVerDescuentos() {
    	// Me aseguro de comenzar con un carrito limpio.
    	Sanguchetto.getInstance().vaciar();
    	Sanguchetto.getInstance().vaciarDescuentos();
    	
    	// Agregamos un par de descuentos y verificamos...
    	Sanguchetto.getInstance().agregarDescuento(1.0, 50.0);
    	Sanguchetto.getInstance().agregarDescuento(8.0, 10.0);
        Integer cantidadDescuentos = 2;
          
        Assert.assertTrue(Sanguchetto.getInstance().verDescuentos().size() == cantidadDescuentos);
    	
    	// Limpio el area de trabajo...
    	Sanguchetto.getInstance().vaciar();
    	Sanguchetto.getInstance().vaciarDescuentos();
    }
    
    @Test
    public void testVerIngredientesYCondimentos() {
    	Sanguchetto.getInstance().vaciar();

    	Sanguchetto.getInstance().agregarIngrediente(new Ingrediente("lechuga", 0.5, TipoIngrediente.INGREDIENTE));
    	Sanguchetto.getInstance().agregarIngrediente(new Ingrediente("jamon", 0.8, TipoIngrediente.INGREDIENTE));
    	Sanguchetto.getInstance().agregarIngrediente(new Ingrediente("mayonesa", 0.5, TipoIngrediente.CONDIMENTO));
    	Sanguchetto.getInstance().agregarIngrediente(new Ingrediente("sal", 0.2, TipoIngrediente.CONDIMENTO));
    	
        Integer contadorIngredientesYCondimentos = 	Sanguchetto.getInstance().verIngredientes().size() +
        											Sanguchetto.getInstance().verCondimentos().size();
    	Assert.assertTrue(Sanguchetto.getInstance().verIngredientesYCondimentos().size() == contadorIngredientesYCondimentos);
    	Sanguchetto.getInstance().vaciar();
    }
    
    @Test
    public void testCalcularDescuentoTotal() {
    	// Me aseguro de comenzar con un carrito limpio.
    	Sanguchetto.getInstance().vaciar();
    	Sanguchetto.getInstance().vaciarDescuentos();   
    	
    	// Agregamos un par de descuentos y productos...
    	Sanguchetto.getInstance().agregarDescuento(10.0, 15.0);
    	Sanguchetto.getInstance().agregarDescuento(30.0, 35.0);
    	Sanguchetto.getInstance().agregarIngrediente(new Ingrediente("jamon", 45.0, TipoIngrediente.INGREDIENTE));
    	Sanguchetto.getInstance().agregarIngrediente(new Ingrediente("mayonesa", 55.0, TipoIngrediente.CONDIMENTO));
    	
    	// El jamón y la mayonesa cuestan 100 pesos en total. Hay 40 pesos fijos de descuento y un 50% de descuento 
    	// sobre el total restante (30). 
    	// El monto total de descuento asciende a 70 pesos.
    	Assert.assertTrue(Sanguchetto.getInstance().calcularDescuentoTotal() == 70.0);
    	
    	// Limpio el area de trabajo.
    	Sanguchetto.getInstance().vaciar();
    	Sanguchetto.getInstance().vaciarDescuentos();  
    }
}
