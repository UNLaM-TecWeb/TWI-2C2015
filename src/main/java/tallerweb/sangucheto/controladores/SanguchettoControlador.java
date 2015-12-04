package tallerweb.sangucheto.controladores;

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
	
	@RequestMapping("/altaIngrediente")
	public ModelAndView altaDeIngrediente() {
		ModelAndView mav = new ModelAndView("altaingrediente");
		mav.addObject("ingrediente", new Ingrediente());
		return mav;
	}
	
	@RequestMapping("/crearIngrediente")
	public ModelAndView crearIngrediente(@ModelAttribute("ingrediente") Ingrediente ingrediente) {
		Stock.getInstance().agregarIngrediente(ingrediente);
		return new ModelAndView("redirect:listaIngredientes");
	}
	
	@RequestMapping("/listaIngredientes")
	public ModelAndView listarIngredientes() {
		ModelAndView mav = new ModelAndView("listaingredientes");
		mav.addObject("mapa", Stock.getInstance().obtenerStock());
		return mav;
	}
	
	@RequestMapping("/modificarStock")
	public ModelAndView eliminarStock(	@ModelAttribute("ingredienteConStock") IngredienteConStock ics,
										@RequestParam("accion") String accion){
		Ingrediente temporal = new Ingrediente();
		temporal.setNombre(ics.getNombre());
		
		if (accion.equals("agregar"))
			Stock.getInstance().agregarStock(temporal, ics.getStock());
		else
			Stock.getInstance().comprarIngrediente(temporal, ics.getStock());

		return new ModelAndView("redirect:listaIngredientes"); 
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
			mav.addObject("sangucheto", Sanguchetto.getInstance().verIngredientesYCondimentos());			
			mav.addObject("descuento", new Descuento());
		}
		
		mav.addObject("mapa", Stock.getInstance().obtenerStock());
		mav.addObject("ingredienteConStock", new IngredienteConStock());
		return mav;
	}

	@RequestMapping("/agregarasangucheto")
	public ModelAndView agregarASangucheto(	@ModelAttribute("ingredienteConStock") IngredienteConStock ics) {		
		Ingrediente temporal = new Ingrediente();
		temporal = Stock.getInstance().obtenerIngredientePorNombre(ics.getNombre());
		
		for (int i = 0; i < ics.getStock(); i++)
			Sanguchetto.getInstance().agregarIngrediente(temporal);
		Stock.getInstance().comprarIngrediente(temporal, ics.getStock());

		return new ModelAndView("redirect:cargarListaConIngredientes?accion=armatusangucheto");
	}

	@RequestMapping("/calcularDescuento")
	public ModelAndView calcularDescuento(@ModelAttribute("descuento") Descuento descuento) {
		
		descuento.setPrecioSanguchetoSinDescuento(Sanguchetto.getInstance().getPrecio());
		descuento.calcularDescuento();
		descuento.calcularAhorro();
		
		ModelAndView mav;
		mav = new ModelAndView("armatusangucheto");
		mav.addObject("ingredienteConStock", new IngredienteConStock());
		mav.addObject("sangucheto", Sanguchetto.getInstance().verIngredientesYCondimentos());	
		ModelAndView mav = new ModelAndView("redirect:cargarListaConIngredientes?accion=armatusangucheto");
		mav.addObject("descuento", descuento);
		return mav;
	}
}
