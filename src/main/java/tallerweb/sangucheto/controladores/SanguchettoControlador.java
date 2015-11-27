package tallerweb.sangucheto.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import tallerweb.sangucheto.modelo.Ingrediente;
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
	
	@RequestMapping("/agregarStock")
	public ModelAndView agregarStock(@RequestParam("ingrediente") Ingrediente ingrediente, @RequestParam("stock") Integer stock) {
		return null;
	}

}
