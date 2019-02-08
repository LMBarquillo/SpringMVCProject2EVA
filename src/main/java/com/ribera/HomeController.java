package com.ribera;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ribera.modelos.Regiones;

@Controller
public class HomeController {		
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";		
	}
	
	@RequestMapping(value = "/regiones")
	public String verRegiones(Model model) {
		OperacionesBBDD bbdd = new OperacionesBBDD();
		List<Regiones> regiones = new ArrayList<Regiones>();
		bbdd.getRegiones(regiones);
		
		model.addAttribute("regionesList", regiones);
		return "regiones";
	}	
	
}
