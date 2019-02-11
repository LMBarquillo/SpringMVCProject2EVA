package com.ribera;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ribera.modelos.OficinasData;
import com.ribera.modelos.RegionesData;
import com.ribera.modelos.RepVentas;

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
	
	/*
	 * Gestionar Representantes de ventas. Esta opción mostrará un formulario para insertar, borrar o modificar un representante. 
	 * Utiliza listas desplegables para seleccionar la oficina del representante y el director del representante. 
	 * Añadir un enlace o botón para volver al índice inicial.
	 */
	
	@RequestMapping(value = "/representantes", method = RequestMethod.GET)
	public String gestionarRepresentantes(Model model) {
		List<RepVentas> repVentas = bbdd.getRepVentas();
		model.addAttribute("repVentasList", repVentas);
		return "representantes";
	}
	
}
