
package com.manosenelcodigo.controller;

import com.manosenelcodigo.modelos.Persona;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


public class FormController {
    
    @RequestMapping(value="form.htm",method=RequestMethod.GET)
    public ModelAndView form()
    {
       //return new ModelAndView("form","command",new Persona("César","yo@cesarcancino.com",36)); 
       return new ModelAndView("form","command",new Persona());
    }
    
    @RequestMapping(value="form.htm",method=RequestMethod.POST)
    public String form(Persona per,ModelMap model)
    {
        model.addAttribute("nombre",per.getNombre());
        model.addAttribute("correo",per.getCorreo());
        model.addAttribute("edad",per.getEdad());
        return "exito";
    }
}
