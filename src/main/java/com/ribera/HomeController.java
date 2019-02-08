package com.ribera;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ribera.modelos.OficinasData;
import com.ribera.modelos.RegionesData;

@Controller
public class HomeController {
	private OperacionesBBDD bbdd;
	
	public HomeController() {
		bbdd = new OperacionesBBDD();
	}	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";		
	}
	
	@RequestMapping(value = "/regiones", method = RequestMethod.GET)
	public String verRegiones(Model model) {
		List<RegionesData> regiones = bbdd.getRegionesData();		
		model.addAttribute("regionesList", regiones);
		return "regiones";
	}	
	
	@RequestMapping(value = "/oficinas", method = RequestMethod.GET)
	public String verOficinas(Model model) {
		List<OficinasData> oficinas = bbdd.getOficinasData();
		model.addAttribute("oficinasList", oficinas);
		return "oficinas";
	}
	
}
