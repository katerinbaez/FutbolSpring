package com.proyecto1.katerin.app.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.proyecto1.katerin.app.variables.Entrenador;



import com.proyecto1.katerin.app.repository.EntrenadorRepository;


@Controller
public class ControladorEntrenador {
	
	@Autowired
	private EntrenadorRepository entrenadorRepositorio;
	
	@GetMapping("/verEntrenador.html")  
	public String listarEntrenador(Model model) {
		List<Entrenador> listaEntrenador = entrenadorRepositorio.findAll();
		model.addAttribute("listaEntrenador", listaEntrenador);
		
		return "verEntrenador"; 
	}
	
	@GetMapping("formEntrenador.html")
	public String mostrarFormulario(Model model) {
		model.addAttribute("entrenador", new Entrenador());
		
		List<Entrenador> listaEntrenador = entrenadorRepositorio.findAll();
		model.addAttribute("listaEntrenador", listaEntrenador);
		
		return "formEntrenador"; 
	}
	
	@PostMapping("/guardarEntrenador")
	public String guardarEntrenador(Entrenador entrenador) {
		entrenadorRepositorio.save(entrenador);
		return "redirect:/verEntrenador.html";
	}
	
	@GetMapping("/Entrenador/editar/{id}")
	public String modificarEntrenador(@PathVariable("id") Integer id, Model model) {
		Entrenador entrenador = entrenadorRepositorio.findById(id).get();
		model.addAttribute("entrenador", entrenador);
		
		List<Entrenador> listaEntrenador = entrenadorRepositorio.findAll();
		model.addAttribute("listaEntrenador", listaEntrenador);
		
		
		return "formEntrenador";
	}
	
	@GetMapping("/Entrenador/eliminar/{id}")
	public String eliminarEntrenador(@PathVariable("id") Integer id, Model model) {
		entrenadorRepositorio.deleteById(id);
		return "redirect:/verEntrenador.html";
	}
	
	@GetMapping("/entrenador/inicio")
	public String Inicio() {
		return "index.html";
	}
}
