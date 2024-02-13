
package com.agendaContactos.entities;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Contactos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgendaContactos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_agenda;
    
    @Column(name ="Nombre", nullable = false)
    private String nombre;
    
    @Column(name ="Apellido", nullable = false)
    private String apellido;
    
    @Column(name ="Email", nullable = false, unique = true)
    private String email;
    
    @Column(name ="fecha Nacimiento")
    private LocalDate fechaNacimiento;
    
    @Column(name ="fecha Registro")
    private LocalDateTime fechaRegistro;
}
