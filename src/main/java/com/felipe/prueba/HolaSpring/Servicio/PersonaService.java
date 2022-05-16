
package com.felipe.prueba.HolaSpring.Servicio;

import com.felipe.prueba.HolaSpring.domain.Persona;
import java.util.List;


public interface PersonaService {
    
    public List<Persona> ListarPersonas();
    public void Guardar(Persona persona);
    public void Eliminar(Persona persona);
    public Persona encontarPersona(Persona persona);
    
}
