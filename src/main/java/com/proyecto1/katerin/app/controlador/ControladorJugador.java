package com.proyecto1.katerin.app.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.proyecto1.katerin.app.repository.JugadorRepository;
import com.proyecto1.katerin.app.variables.Jugador;

@Controller
public class ControladorJugador {
	
	
	@Autowired
	private JugadorRepository 	jugadorRepositorio;
	
	@GetMapping("/verJugador.html")  
	public String listarJugador(Model model) {
		List<Jugador> listaJugador = jugadorRepositorio.findAll();
		model.addAttribute("listaJugador", listaJugador);
	
		return "verJugador";
	}
	
	@GetMapping("formJugador.html")
	public String mostrarFormulario (Model model) {
		model.addAttribute("Jugador", new Jugador());
		
	
		List<Jugador> listaJugador = jugadorRepositorio.findAll();
		model.addAttribute("listaJugador", listaJugador);
		
	
		
		return "formJugador";
	}
	
	@PostMapping("/guardarJugador")
	public String guardarJugador (Jugador Jugador) {
		jugadorRepositorio.save(Jugador);
		return "redirect:/verJugador.html";
	}
	
	@GetMapping("/Jugador/editar/{id}")
	public String modificarJugador (@PathVariable("id") Integer id, Model model) {
		Jugador Jugador = jugadorRepositorio.findById(id).get();
		model.addAttribute("Jugador", Jugador);
		
	
		List<Jugador> listaJugador = jugadorRepositorio.findAll();
		model.addAttribute("listaJugador", listaJugador);
		
		
		return "formJugador";
	}
	
	@GetMapping("/Jugador/eliminar/{id}")
	public String eliminarJugador(@PathVariable("id") Integer id, Model model) {
		jugadorRepositorio.deleteById(id);
		return "redirect:/verJugador.html";
	}
	
	@GetMapping("/jugador/inicio")
	public String Inicio() {
		return "index.html";
	}
	
}
