/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.felipe.prueba.HolaSpring.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.Data;

/**
 *
 * @author felis
 */
@Data //se usa para el proyecto lombok y evitar crear los getter setter y crea el constructor
@Entity
@Table(name="persona")
public class Persona implements Serializable{   
    private static final long serialVersionUID = 1L; 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPersona;
    
   @NotEmpty   
    private String nombre;
   @NotEmpty
    private String apellido;
   @NotEmpty
   @Email
    private String email;
    private String telefono;
}
