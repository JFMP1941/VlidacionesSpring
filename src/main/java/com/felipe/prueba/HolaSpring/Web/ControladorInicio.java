
package com.felipe.prueba.HolaSpring.Web;
import com.felipe.prueba.HolaSpring.DAO.PersonaDAO;
import com.felipe.prueba.HolaSpring.Servicio.PersonaService;
import com.felipe.prueba.HolaSpring.domain.Persona;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller // para hacerlo con un controlador de tipo MVC
@Slf4j // aqui ya tenemos acceso a las variables de log para guardar los log

public class ControladorInicio {
    @Autowired//inyectamos la interface de persona DAO
    //private PersonaDAO personaDAO;
    private  PersonaService personaService;
    @GetMapping("/")
    
    public String Incio(Model model) {
        var personas = personaService.ListarPersonas();//buscar todas las personas
        //var personas = personaDAO.findAll();//buscar todas las personas
        log.info("ejecutando el servicio de inicio en el controlador");//mostramos como mensaje informativo lo que pasa en el controlador
        model.addAttribute("personas",personas);//agregamos las personas aun modelo para que pueda ser mapeado por el index

        return "index";
    }
    
    @GetMapping("/agregar")
    public String agregar(Persona persona)
    {
        
        return "modificar";
    }
    
    @PostMapping("/guardar")
    public String guardar(@Valid Persona persona, Errors error, Model modelo){
        if(error.hasErrors())
        {
            return "modificar";
        }
        personaService.Guardar(persona);//buscar todas las personas
        return "redirect:/";//para redireccionar al inicio
    }
    
    //@GetMapping("/editar/{idPersona}")//aqui se le pasa el id de la persona mapeandolo en el index
    //@GetMapping("/editar")//aqui se le pasa el id de la persona pero por query parameter
    @GetMapping("/editar")
    public String Editar(Persona persona, Model modelo){
       persona = personaService.encontarPersona(persona);
        modelo.addAttribute("persona",persona);
        return "modificar";
        
    } 
    
    //@GetMapping("/eliminar/{idPersona}")//aqui se le pasa el id de la persona mapeandolo en el index
    @GetMapping("/eliminar") //aqui se le pasa el id de la persona pero por query parameter
    public String Eliminar(Persona persona, Model modelo){
      personaService.Eliminar(persona);
       // modelo.addAttribute("persona",persona);
        return "redirect:/";
        
    }
    
    

}
