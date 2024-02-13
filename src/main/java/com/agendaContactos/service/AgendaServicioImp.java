
package com.agendaContactos.service;

import com.agendaContactos.entities.AgendaContactos;
import com.agendaContactos.repository.ContactoRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;


public class AgendaServicioImp implements AgendaServicio{
    
    
    @Autowired
    private ContactoRepositorio repositorio;
    
    @Override
    public List<AgendaContactos> listarTodos() {
        return repositorio.findAll();
    }

    @Override
    public AgendaContactos encontrarContacto(int id) {
        return repositorio.findById(id).orElse(null);
    }

    @Override
    public AgendaContactos crearContacto(AgendaContactos contacto) {
        return repositorio.save(contacto);
    }

    @Override
    public AgendaContactos actualizarContacto(int id, AgendaContactos contacto) {
        
        AgendaContactos contactoddbb = repositorio.findById(id).orElse(null);
        
        if (contactoddbb != null) {
            contactoddbb.setNombre(contacto.getNombre());
            contactoddbb.setApellido(contacto.getApellido());
            contactoddbb.setEmail(contacto.getEmail());
            contactoddbb.setFechaNacimiento(contacto.getFechaNacimiento());
            contactoddbb.setFechaRegistro(contacto.getFechaRegistro());
            repositorio.save(contactoddbb);
        }
        return null;
    }

    @Override
    public void eliminarContacto(int id) {
        repositorio.deleteById(id);
    }
    
}
