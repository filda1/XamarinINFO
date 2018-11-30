
package Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class homeController {
    
    @RequestMapping("home.htm")
    public ModelAndView home() {
        
        ModelAndView mav = new ModelAndView();
        mav.setViewName("home");
        
        return mav;     
    }
    
}
