
package com.agendaContactos.repository;

import com.agendaContactos.entities.AgendaContactos;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ContactoRepositorio extends JpaRepository<AgendaContactos, Integer>{
    
}
