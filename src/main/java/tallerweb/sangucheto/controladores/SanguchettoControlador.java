package tallerweb.sangucheto.controladores;

import java.util.Iterator;

import org.springframework.stereotype.Controller;
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
	
	@RequestMapping("/crearIngrediente")
	public ModelAndView crearIngrediente(@ModelAttribute("ingrediente") Ingrediente ingrediente) {
		Stock.getInstance().agregarIngrediente(ingrediente);
		return new ModelAndView("redirect:cargarListaConIngredientes?accion=altaingrediente&validacion=''");
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

		return new ModelAndView("redirect:cargarListaConIngredientes?accion=agregarstock&validacion=''"); 
	}
	
	@RequestMapping("/bajaIngrediente")
	public ModelAndView eliminarProductos(@RequestParam("nombreIngrediente") String nombreIngrediente) {
		Ingrediente temporal = new Ingrediente();
		temporal = Stock.getInstance().obtenerIngredientePorNombre(nombreIngrediente);
		Stock.getInstance().eliminarIngrediente(temporal);
		return new ModelAndView("redirect:cargarListaConIngredientes?accion=bajaingrediente&validacion=''");
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
		
		// Luego de recuperar el stock vac�o el carrito. Elimino ingredientes y descuentos.
		sangucheto.vaciar();
		sangucheto.vaciarDescuentos();
		
		return new ModelAndView("redirect:cargarListaConIngredientes?accion=armatusangucheto&validacion=''");
	}
	
	@RequestMapping("/cargarListaConIngredientes")
	public ModelAndView elegirIngrediente(	@RequestParam("accion") String accion, 
											@RequestParam("validacion") String validacion) {
		ModelAndView mav;
		
		if (accion.equals("comprarSangucheto")) {
			mav = new ModelAndView("graciasporsucompra");
			mav.addObject("listaDeIngredientesSangucheto", Sanguchetto.getInstance().verIngredientesYCondimentos());
			mav.addObject("precioTotalSangucheto", Sanguchetto.getInstance().getPrecioConDescuento());
			
			// Luego de comprar debo vaciar la lista de ingredientes y de descuentos.
			Sanguchetto.getInstance().vaciar();
			Sanguchetto.getInstance().vaciarDescuentos();
		}
		
		else if (accion.equals("listaingredientes"))
			mav = new ModelAndView("listaingredientes");
		
		else if (accion.equals("altaingrediente")) {
			mav = new ModelAndView("altaingrediente");
			mav.addObject("ingrediente", new Ingrediente());
		}
		
		else if (accion.equals("agregarstock")) {
			mav = new ModelAndView("agregarstock");
			mav.addObject("ingredienteConStock", new IngredienteConStock());
		}
		
		else if (accion.equals("bajaingrediente")) {
			mav = new ModelAndView("bajaingrediente");
		}
		
		else { // if (accion.equals("armatusangucheto"))
			mav = new ModelAndView("armatusangucheto");
			mav.addObject("descuento", new Descuento());
			mav.addObject("precioConDescuentoSangucheto", Sanguchetto.getInstance().getPrecioConDescuento());
			mav.addObject("ahorroSangucheto", Sanguchetto.getInstance().calcularDescuentoTotal());
			mav.addObject("listaDeIngredientesSangucheto", Sanguchetto.getInstance().verIngredientesYCondimentos());
			mav.addObject("ingredienteConStock", new IngredienteConStock());
			
			if (validacion.equals("faltaStock"))
				mav.addObject("faltaStock", new String("No hay stock suficiente para la cantidad que desea comprar."));
			else
				mav.addObject("faltaStock", new String(""));
		}
		
		// La vista "graciasporsucompra" no usa este Object.
		mav.addObject("mapa", Stock.getInstance().obtenerStock());
		return mav;
	}

	@RequestMapping("/agregarIngrediente")
	public ModelAndView agregarIngrediente( @RequestParam("nombreIngrediente") String nombreIngrediente,
											@RequestParam("cantidadIngrediente") Integer cantidadIngrediente) {		
		Ingrediente temporal = new Ingrediente();
		temporal = Stock.getInstance().obtenerIngredientePorNombre(nombreIngrediente);
		
		for (int i = 0; i < cantidadIngrediente; i++)
			Sanguchetto.getInstance().agregarIngrediente(temporal);
		Stock.getInstance().comprarIngrediente(temporal, cantidadIngrediente);

		return new ModelAndView("redirect:cargarListaConIngredientes?accion=armatusangucheto&validacion=''");
	}
	
	@RequestMapping("/agregarDescuento")
	public ModelAndView agregarDescuento(@ModelAttribute("descuento") Descuento descuento) {		
		Sanguchetto.getInstance().agregarDescuento(descuento.getValorFijo(), descuento.getValorPorcentual());
		return new ModelAndView("redirect:cargarListaConIngredientes?accion=armatusangucheto&validacion=''");
	}
	
	@RequestMapping("/validarExistenciaDeStock")
	public ModelAndView validarExistenciaDeStock(	@RequestParam("nombreIngrediente") String nombreIngrediente,
													@ModelAttribute("ingredienteConStock") IngredienteConStock cantidadIngrediente) {
		Ingrediente temporal = Stock.getInstance().obtenerIngredientePorNombre(nombreIngrediente);
		Integer stockActual = Stock.getInstance().obtenerStockDisponible(temporal);
		
		// Si la cantidad que se desea comprar no supera nuestro stock agregamos los ingredientes al sangucheto...
		if (stockActual >= cantidadIngrediente.getStock())
			return new ModelAndView("redirect:agregarIngrediente?nombreIngrediente=" + nombreIngrediente + "&cantidadIngrediente=" + cantidadIngrediente.getStock());
		
		// Si la cantidad supera nuestro stock cancelamos la operaci�n e informamos al usuario...
		else
			return new ModelAndView("redirect:cargarListaConIngredientes?accion=armatusangucheto&validacion=faltaStock");
	}
}
