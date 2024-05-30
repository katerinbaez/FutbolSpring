package com.proyecto1.katerin.app.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.proyecto1.katerin.app.repository.CompeticionRepository;
import com.proyecto1.katerin.app.variables.Competicion;

@Controller
public class ControladorCompeticion {
	
		
	@Autowired
	private CompeticionRepository competicionRepository;
	
	
	
	@GetMapping("/verCompeticion.html")  
	public String listarCompeticion(Model model) {
		List<Competicion> listaCompeticion = competicionRepository.findAll();
		model.addAttribute("listaCompeticion", listaCompeticion);
	
		return "verCompeticion";
	}
	
	@GetMapping("formCompeticion.html")
	public String mostrarFormulario (Model model) {
		model.addAttribute("Competicion", new Competicion());
		
		
		List<Competicion> listaCompeticion = competicionRepository.findAll();
		model.addAttribute("listaCompeticion", listaCompeticion);
		
		
		return "formCompeticion";
	}
	
	@PostMapping("/guardarCompeticion")
	public String guardarCompeticion (Competicion Competicion) {
		competicionRepository.save(Competicion);
		return "redirect:/verCompeticion.html";
	}
	
	@GetMapping("/Competicion/editar/{id}")
	public String modificarCompeticion (@PathVariable("id") Integer id, Model model) {
		Competicion Competicion = competicionRepository.findById(id).get();
		model.addAttribute("Competicion", Competicion);
				
		List<Competicion> listaCompeticion = competicionRepository.findAll();
		model.addAttribute("listaCompeticion", listaCompeticion);
		
		return "formCompeticion";
	}
	
	@GetMapping("/Competicion/eliminar/{id}")
	public String eliminarCompeticion(@PathVariable("id") Integer id, Model model) {
		competicionRepository.deleteById(id);
		return "redirect:/verCompeticion.html";
	}
	@GetMapping("/competicion/inicio")
	public String inicio() {
	    return "index";
	}
	
}
