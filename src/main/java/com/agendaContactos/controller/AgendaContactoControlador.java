
package com.agendaContactos.controller;


import com.agendaContactos.entities.AgendaContactos;
import com.agendaContactos.service.AgendaServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class AgendaContactoControlador {
    
    @Autowired
    private AgendaServicio servicio;
    //Ller los datos
    @GetMapping
    public String leerTodosContactos(Model model){
        
        List<AgendaContactos> todosContactos = servicio.listarTodos();
        model.addAttribute("listacontactos", todosContactos);
        
        return "index";
    }
    //mostrar formulario para crear
    @GetMapping("/nueva")
    public String mostrarFormualrio(Model model){
        AgendaContactos contacto = new AgendaContactos();
        model.addAttribute("contacto",contacto);
        model.addAttribute("accion", "/nueva");
        
        return "nuevo-contacto";
    }
    //guardar los datos en la bd
    @PostMapping("/nueva")
    public String guargarContacto(@ModelAttribute AgendaContactos contacto){
        servicio.crearContacto(contacto);
        return "redirect:/";
    }
    
    //editar contacto
    @GetMapping("/editar/{id}")
    public String editarContacto(@PathVariable int id, Model model){
        
        AgendaContactos contactodbb = servicio.encontrarContacto(id);
        model.addAttribute("contacto", contactodbb);
        model.addAttribute("accion", "/editar/" + id);
        
        return "actualizarContacto";
    }
    
    @PostMapping("/editar/{id}")
    public String actualizarContacto(@PathVariable int id,@ModelAttribute AgendaContactos contacto){
        servicio.actualizarContacto(id, contacto);
        return "redirect:/";
    }
    
    //Eliminar Datos
    @GetMapping("/eliminar/{id}")
    public String eliminarContacto(@PathVariable int id){
        servicio.eliminarContacto(id);
        return "redirect:/";
    }
}
