
package com.agendaContactos.repository;

import com.agendaContactos.entities.AgendaContactos;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactoRepositorio extends JpaRepository<AgendaContactos, Integer>{
    
    @Query("SELECT c FROM AgendaContactos c WHERE c.nombre LIKE %?1% "
    + " OR c.apellido LIKE %?1% "
    + " OR c.email LIKE %?1% ")
    public List<AgendaContactos> findAll(String palabraClave);
    
}
