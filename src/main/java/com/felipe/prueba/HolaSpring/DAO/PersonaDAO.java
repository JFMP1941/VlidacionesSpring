/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.felipe.prueba.HolaSpring.DAO;

import com.felipe.prueba.HolaSpring.domain.Persona;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author felis
 */

public interface PersonaDAO extends CrudRepository<Persona, Integer>{
     
    
}
