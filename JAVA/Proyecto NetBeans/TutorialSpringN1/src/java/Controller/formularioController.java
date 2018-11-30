
package Controller;
import Modelo.persona;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class formularioController {
    
    @RequestMapping(value ="formulario.htm", method=RequestMethod.GET)
    public ModelAndView form(){
        
        ModelAndView mav = new ModelAndView("form","command",new persona());
        mav.setViewName("Vista/formulario");
        
        return mav;
    }
    
     @RequestMapping(value="formulario.htm",method=RequestMethod.POST)
    public String form(persona per,ModelMap model)
    {
        model.addAttribute("nombre",per.getNombre());
        model.addAttribute("correo",per.getCorreo());
        model.addAttribute("edad",per.getEdad());
        return "exito";
    }
}
