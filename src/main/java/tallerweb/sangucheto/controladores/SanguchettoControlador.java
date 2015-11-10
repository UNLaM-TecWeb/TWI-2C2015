package tallerweb.sangucheto.controladores;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import tallerweb.sangucheto.modelo.Ingrediente;
import tallerweb.sangucheto.modelo.Stock;
import tallerweb.sangucheto.modelo.TipoIngrediente;


@Controller
@RequestMapping("/stock")


public class SanguchettoControlador {
	
	@RequestMapping("/aloja")
	 public ModelAndView test(){
		 return new ModelAndView("aloja");
	 }
	
	private Stock s = Stock.getInstance();
	// Se trata de implementar "Una pantalla que muestre el stock de todos los productos existentes"
	
	@RequestMapping(value= "/productos", method=RequestMethod.GET)
	
	public ModelAndView stockProdExistentes(){
		
		Map<Ingrediente, Integer> stock;
		stock = s.obtenerStock();
		
		ModelAndView mav = new ModelAndView("stock");
		mav.addObject("verStock", new Ingrediente("Tomate", 0.5, TipoIngrediente.INGREDIENTE));
		
		return mav;
		
	}
	
	 
}
