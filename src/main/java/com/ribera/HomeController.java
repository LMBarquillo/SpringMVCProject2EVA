package com.ribera;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ribera.modelos.OficinasData;
import com.ribera.modelos.RegionesData;
import com.ribera.modelos.RepVentas;
import com.ribera.modelos.RepVentasData;

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
	
	@RequestMapping(value = "/representantes", method = RequestMethod.GET)
	public String gestionarRepresentantes(Model model) {
		List<RepVentasData> repVentas = bbdd.getRepVentasData();
		model.addAttribute("repVentasList", repVentas);
		return "representantes";
	}
	
	/**
	 * Abre la vista con el formulario para insertar un nuevo representante de ventas 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public String nuevoRepresentante(Model model) {
		Map<Integer, String> oficinas = bbdd.getOficinasMap();
		Map<Integer, String> directores = bbdd.getRepVentasMap();
		
		model.addAttribute("oficinasMap", oficinas);			// Mapa de oficinas para el selector
		model.addAttribute("directoresMap", directores);		// Mapa de representantes para el selector del director
		model.addAttribute("nuevoRep", new RepVentas());		// Objeto donde guardaremos los datos.
		return "nuevorep";
	}
	
	@RequestMapping(value = "/nuevo", method = RequestMethod.POST)
	public String submitNuevoRep(@ModelAttribute RepVentas repVentas, Model model) {
		try {
			bbdd.insertRepVentas(repVentas);
			model.addAttribute("mensaje","Se ha insertado correctamente el representante.");
			return "confirmar";
		} catch (SQLException e) {
			model.addAttribute("mensaje","Se ha producido un error al insertar el representante.");
			return "error";
		}		
	}
	
	@RequestMapping(value = "/editar", method = RequestMethod.GET)
	public String editarRepresentante(Model model, @RequestParam String id) {
		
		
		return "editarep";
	}
	
	@RequestMapping(value = "/eliminar", method = RequestMethod.GET)
	public String eliminarRepresentante(Model model, @RequestParam String id) {
		
		
		return "confirmarEliminar";
	}	
}
