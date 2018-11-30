package Controller;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class principalController {
    
    
    @RequestMapping("principal.htm")
    public ModelAndView principal(HttpServletRequest request){
        
        ModelAndView mav = new ModelAndView();
        mav.setViewName("principal");
        
        String var1= request.getParameter("id");   //=====================> Obtengo variable id de la URL( http......pagin.htm?id=X&id2=y
        mav.addObject("id", var1);                 // ====================> mando a la vista
      
        String var2=request.getParameter("id2");
        mav.addObject("id2", var2);
        
        return mav;             
    }
   
}
