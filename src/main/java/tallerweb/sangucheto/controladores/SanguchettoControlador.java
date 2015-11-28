package tallerweb.sangucheto.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import tallerweb.sangucheto.modelo.Ingrediente;
import tallerweb.sangucheto.modelo.IngredienteConStock;
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
		
		if (accion.equals("agregar"))
			mav = new ModelAndView("agregarstock");
		else
			mav = new ModelAndView("eliminarstock");
		
		mav.addObject("mapa", Stock.getInstance().obtenerStock());
		mav.addObject("ingredienteConStock", new IngredienteConStock());
		return mav;
	}
}
