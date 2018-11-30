
package com.manosenelcodigo.controller;

import com.manosenelcodigo.modelos.Persona;
import com.manosenelcodigo.modelos.PersonaValidar;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("form.htm")
public class FormController 
{
    private PersonaValidar personaValidar;

    public FormController() 
    {
        this.personaValidar=new PersonaValidar();
    }
    
    
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView form()
    {
        ModelAndView mav=new ModelAndView();
        mav.setViewName("form");
        mav.addObject("persona",new Persona());
        return mav;
    }
    
    //recibimos y validamos los datos de nuestro formulario
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView form
                            (
                               @ModelAttribute("persona") Persona p,
                               BindingResult result,
                               SessionStatus status
                            )
    {
        this.personaValidar.validate(p, result);
        if(result.hasErrors())
        {
            //acá volvemos al formulario
            //porque los datos ingresados por el usuario
            //no son correctos es decir que se ejecutó la validación
            ModelAndView mav=new ModelAndView();
            mav.setViewName("form");
            mav.addObject("persona",new Persona());
            return mav;
        }else
        {
            //acá entramos si el usuario ingresó bien los datos
            ModelAndView mav=new ModelAndView();
            mav.setViewName("exito");
            mav.addObject("nombre",p.getNombre());
            mav.addObject("correo",p.getCorreo());
            mav.addObject("pais",p.getPais());
            return mav;
        }
    }
    
    //método para poblar nuestro select
    @ModelAttribute("paisLista")
    public Map<String,String> listadoPaises()
    {
        Map<String,String> pais=new LinkedHashMap<>();
        pais.put("1","Chile");
        pais.put("2","México");
        pais.put("3","Colombia");
        pais.put("4","Bolivia");
        pais.put("5","España");
        pais.put("6","Argentina");
        return pais;
    }
    
}
