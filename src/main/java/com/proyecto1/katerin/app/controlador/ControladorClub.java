package com.proyecto1.katerin.app.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.proyecto1.katerin.app.variables.Asociacion;
//import com.proyecto1.katerin.app.variables.Jugador;
import com.proyecto1.katerin.app.variables.Competicion;
import com.proyecto1.katerin.app.variables.Entrenador;
import com.proyecto1.katerin.app.variables.Club;


import com.proyecto1.katerin.app.repository.AsociacionRepository;
import com.proyecto1.katerin.app.repository.ClubRepository;
import com.proyecto1.katerin.app.repository.EntrenadorRepository;
//import com.proyecto1.katerin.app.repository.JugadorRepository;
import com.proyecto1.katerin.app.repository.CompeticionRepository;




@Controller
public class ControladorClub {
	@Autowired
	private ClubRepository clubRepositorio;
	
	@Autowired
	private EntrenadorRepository entrenadorRepositorio;
	
	@Autowired
	private AsociacionRepository asociacionRepositorio;
	
	@Autowired
	private CompeticionRepository competicionRepositorio;
	
	@GetMapping("verClub.html")  
	public String listarClub(Model model) {
		List<Club> listaClub = clubRepositorio.findAll();
		model.addAttribute("listaClub", listaClub);
		
		return "verClub"; 
	}
	
	@GetMapping("formClub.html")
	public String mostrarFormulario(Model model) {
		model.addAttribute("club", new Club());
		
		List<Entrenador> listaEntrenador = entrenadorRepositorio.findAll();
		model.addAttribute("listaEntrenador", listaEntrenador);
		
		List<Asociacion> listaAsociacion = asociacionRepositorio.findAll();
		model.addAttribute("listaAsociacion", listaAsociacion);
		
		List<Competicion> listaCompeticion = competicionRepositorio.findAll();
		model.addAttribute("listaCompeticion", listaCompeticion);
		
		return "formClub"; 
	}
	
	@PostMapping("/guardarClub")
	public String guardarClub(Club club) {
		clubRepositorio.save(club);
		return "redirect:/verClub.html";
	}
	
	@GetMapping("/club/editar/{id}")
	public String modificarClub(@PathVariable("id") Integer id, Model model) {
		Club club = clubRepositorio.findById(id).get();
		model.addAttribute("club", club);
		
		List<Entrenador> listaEntrenador = entrenadorRepositorio.findAll();
		model.addAttribute("listaEntrenador", listaEntrenador);
		
		List<Asociacion> listaAsociacion = asociacionRepositorio.findAll();
		model.addAttribute("listaAsociacion", listaAsociacion);
		
		List<Competicion> listaCompeticion = competicionRepositorio.findAll();
		model.addAttribute("listaCompeticion", listaCompeticion);
		
		return "formClub";
	}
	
	@GetMapping("/club/eliminar/{id}")
	public String eliminarClub(@PathVariable("id") Integer id, Model model) {
		clubRepositorio.deleteById(id);
		return "redirect:/verClub.html";
	}
	
	@GetMapping("/club/inicio")
	public String inicio() {
	    return "index";
	}

}
