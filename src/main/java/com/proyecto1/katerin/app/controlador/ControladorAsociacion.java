package com.proyecto1.katerin.app.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.proyecto1.katerin.app.variables.Asociacion;
import com.proyecto1.katerin.app.repository.AsociacionRepository;

@Controller
public class ControladorAsociacion {
    
    @Autowired
    private AsociacionRepository asociacionRepository;
    
    @GetMapping("/verAsociacion.html")  
    public String listarAsociacion(Model model) {
        List<Asociacion> listaAsociacion = asociacionRepository.findAll();
        model.addAttribute("listaAsociacion", listaAsociacion);
        return "verAsociacion"; 
    }
    
    @GetMapping("/formAsociacion.html")
    public String mostrarFormulario(Model model) {
        model.addAttribute("asociacion", new Asociacion());
        List<Asociacion> listaAsociacion = asociacionRepository.findAll();
        model.addAttribute("listaAsociacion", listaAsociacion);
        return "formAsociacion"; 
    }
    
    @PostMapping("/guardarAsociacion")
    public String guardarAsociacion(Asociacion asociacion) {
        asociacionRepository.save(asociacion);
        return "redirect:/verAsociacion.html";
    }
    
    @GetMapping("/Asociacion/editar/{id}")
    public String modificarAsociacion(@PathVariable("id") Integer id, Model model) {
        Asociacion asociacion = asociacionRepository.findById(id).orElse(null);
        model.addAttribute("asociacion", asociacion);
        List<Asociacion> listaAsociacion = asociacionRepository.findAll();
        model.addAttribute("listaAsociacion", listaAsociacion);
        return "formAsociacion";
    }
    
    @GetMapping("/Asociacion/eliminar/{id}")
    public String eliminarAsociacion(@PathVariable("id") Integer id, Model model) {
        asociacionRepository.deleteById(id);
        return "redirect:/verAsociacion.html";
    }
    
    @GetMapping("/asociacion/inicio")
    public String inicio() {
        return "index.html";
    }
}
