package com.ribera;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ribera.modelos.Regiones;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";		
	}
	
	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public String menu(@RequestParam String action) {
		if(action.equals("regiones")) {
			logger.info("Elegido regiones");
			verRegiones();
		} else if(action.equals("oficinas")) {
			logger.info("Elegido oficinas");
		} else if(action.equals("representantes")) {
			logger.info("Elegido representantes");
		} else {
			return "home";			
		}

		return "home";
	}
	
	public ModelAndView verRegiones() {
		OperacionesBBDD bbdd = new OperacionesBBDD();
		List<Regiones> regiones = bbdd.getRegiones();
		logger.info("resultados: " + regiones.size());
		return new ModelAndView("regiones", "regionesList", regiones);
	}
	
}
