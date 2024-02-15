
package com.agendaContactos.service;

import com.agendaContactos.entities.AgendaContactos;
import java.util.List;

public interface AgendaServicio {
    
    //Creamos la interfaz para crear los metodos logicos que tendra el programa
    //leer todos los contactos
    List<AgendaContactos> listarTodos(String palabraClave);
    
    //Encontrar un contacto
    AgendaContactos encontrarContacto(int id);
    
    //Crear un contacto
    AgendaContactos crearContacto(AgendaContactos contacto);
    
    //Actualizar un contacto
    AgendaContactos actualizarContacto(int id, AgendaContactos contacto);
    
    //Eliminar un contacto
    void eliminarContacto(int id);
    
    
    
}
