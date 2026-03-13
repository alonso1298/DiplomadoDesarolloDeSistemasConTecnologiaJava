package dgtic.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InicioController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String inicio(Model model){
        return "index";
    }
}
