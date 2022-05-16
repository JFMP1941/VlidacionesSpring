
package com.felipe.prueba.HolaSpring.Servicio;
import com.felipe.prueba.HolaSpring.DAO.PersonaDAO;
import com.felipe.prueba.HolaSpring.domain.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonaServiceImpl implements PersonaService{
@Autowired
    private PersonaDAO personaDAO;
    
    @Override
    @Transactional(readOnly = true)//como solo lee informacion se crea la transaccion de solo lectura 
    public List<Persona> ListarPersonas() {
        
        return (List<Persona>) personaDAO.findAll();
    }

    @Override
    @Transactional//como es un metodo de escritura entonces debe crearse la transaccion para modificar 
    public void Guardar(Persona persona) {
        personaDAO.save(persona);
    }

    @Override
    @Transactional//como es un metodo de escritura entonces debe crearse la transaccion para modificar 
    public void Eliminar(Persona persona) {
        personaDAO.delete(persona);
    }

    @Override
    @Transactional(readOnly = true)//como solo lee informacion se crea la transaccion de solo lectura 
    public Persona encontarPersona(Persona persona) {
        return personaDAO.findById(persona.getIdPersona()).orElse(null); //en caso de que no encuentre el objeto regresa le vsalor de null
    }
    
}
