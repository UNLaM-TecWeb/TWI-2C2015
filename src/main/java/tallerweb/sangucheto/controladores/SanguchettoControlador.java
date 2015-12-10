package tallerweb.sangucheto.controladores;

import java.util.Iterator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import tallerweb.sangucheto.modelo.Descuento;
import tallerweb.sangucheto.modelo.Ingrediente;
import tallerweb.sangucheto.modelo.IngredienteConStock;
import tallerweb.sangucheto.modelo.Sanguchetto;
import tallerweb.sangucheto.modelo.Stock;



@Controller
public class SanguchettoControlador {
	
	@RequestMapping("/altaIngrediente") // le pasa a la vista un objeto del tipo Ingrediente.
	public ModelAndView altaDeIngrediente() {
		ModelAndView mav = new ModelAndView("altaingrediente");
		mav.addObject("ingrediente", new Ingrediente());
		mav.addObject("mapa", Stock.getInstance().obtenerStock());
		return mav;
	}
	
	@RequestMapping("/crearIngrediente")
	public ModelAndView crearIngrediente(@ModelAttribute("ingrediente") Ingrediente ingrediente) {
		Stock.getInstance().agregarIngrediente(ingrediente);
		return new ModelAndView("redirect:altaIngrediente");
	}
	
	@RequestMapping("/listaIngredientes")
	public ModelAndView listarIngredientes() {
		ModelAndView mav = new ModelAndView("listaingredientes");
		mav.addObject("mapa", Stock.getInstance().obtenerStock());
		return mav;
	}
	
	@RequestMapping("/modificarStock")
	public ModelAndView eliminarStock(	@ModelAttribute("ingredienteConStock") IngredienteConStock ics,
										@RequestParam("accion") String accion,
										@RequestParam("nombreIngrediente") String nombreIngrediente){
		Ingrediente temporal = new Ingrediente();
		temporal.setNombre(nombreIngrediente);
		
		if (accion.equals("agregar"))
			Stock.getInstance().agregarStock(temporal, ics.getStock());
		else
			Stock.getInstance().comprarIngrediente(temporal, ics.getStock());

		return new ModelAndView("redirect:cargarListaConIngredientes?accion=agregarstock"); 
	}
	
	@RequestMapping("/eliminaringrediente")
	public String eliminarProductos(
			@ModelAttribute("eliminaringrediente") Ingrediente ingrediente, ModelMap modelo) {
		Stock tabla = Stock.getInstance();
		tabla.eliminarIngrediente(ingrediente);
		modelo.put("tabla", tabla.obtenerStock());
		return "eliminaringrediente";
	}
	
	@RequestMapping("/vaciarSangucheto")
	public ModelAndView vaciarSanguchetto() {
		Sanguchetto sangucheto = Sanguchetto.getInstance();
		Stock stock = Stock.getInstance();
		
		// Recorro el carrito y por cada ingrediente que hay en el sumo 1 de stock a su equivalente en el Stock.
		Iterator<Ingrediente> iterator = sangucheto.verIngredientesYCondimentos().iterator();
		while (iterator.hasNext()) {
			Ingrediente cadaElemento = iterator.next();
			stock.agregarStock(stock.obtenerIngredientePorNombre(cadaElemento.getNombre()), 1);
		}
		
		// Luego de recuperar el stock vacío el carrito. Elimino ingredientes y descuentos.
		sangucheto.vaciar();
		sangucheto.vaciarDescuentos();
		
		return new ModelAndView("redirect:cargarListaConIngredientes?accion=armatusangucheto");
	}
	
	@RequestMapping("/cargarListaConIngredientes")
	public ModelAndView elegirIngrediente(@RequestParam("accion") String accion) {
		ModelAndView mav;
		
		if (accion.equals("agregarstock")) 
			mav = new ModelAndView("agregarstock");
		
		else if (accion.equals("eliminarstock"))
			mav = new ModelAndView("eliminarstock");
		
		else { // if (accion.equals("armatusangucheto"))
			mav = new ModelAndView("armatusangucheto");
			mav.addObject("descuento", new Descuento());
			mav.addObject("precioTotalSangucheto", Sanguchetto.getInstance().getPrecioConDescuento());
			mav.addObject("ahorroSangucheto", Sanguchetto.getInstance().calcularDescuentoTotal());
			mav.addObject("listaDeIngredientesSangucheto", Sanguchetto.getInstance().verIngredientesYCondimentos());
		}
		
		mav.addObject("mapa", Stock.getInstance().obtenerStock());
		mav.addObject("ingredienteConStock", new IngredienteConStock());
		return mav;
	}

	@RequestMapping("/agregarIngrediente")
	public ModelAndView agregarIngrediente( @RequestParam("nombreIngrediente") String nombreIngrediente,
											@ModelAttribute("ingredienteConStock") IngredienteConStock cantidadIngrediente) {		
		Ingrediente temporal = new Ingrediente();
		temporal = Stock.getInstance().obtenerIngredientePorNombre(nombreIngrediente);
		
		for (int i = 0; i < cantidadIngrediente.getStock(); i++)
			Sanguchetto.getInstance().agregarIngrediente(temporal);
		Stock.getInstance().comprarIngrediente(temporal, cantidadIngrediente.getStock());

		return new ModelAndView("redirect:cargarListaConIngredientes?accion=armatusangucheto");
	}
	
	@RequestMapping("/agregarDescuento")
	public ModelAndView agregarDescuento(@ModelAttribute("descuento") Descuento descuento) {		
		Sanguchetto.getInstance().agregarDescuento(descuento.getValorFijo(), descuento.getValorPorcentual());
		return new ModelAndView("redirect:cargarListaConIngredientes?accion=armatusangucheto");
	}

//	@RequestMapping("/calcularDescuento")
//	public ModelAndView calcularDescuento(@ModelAttribute("descuento") Descuento descuento) {
//		
//		descuento.setPrecioSanguchetoSinDescuento(Sanguchetto.getInstance().getPrecio());
//		descuento.calcularDescuento();
//		descuento.calcularAhorro();
//		
//		ModelAndView mav = new ModelAndView("armatusangucheto");
//		mav.addObject("ingredienteConStock", new IngredienteConStock());
//		mav.addObject("sangucheto", Sanguchetto.getInstance().verIngredientesYCondimentos());	
//		mav.addObject("descuento", descuento);
//		return mav;
//	}
}
