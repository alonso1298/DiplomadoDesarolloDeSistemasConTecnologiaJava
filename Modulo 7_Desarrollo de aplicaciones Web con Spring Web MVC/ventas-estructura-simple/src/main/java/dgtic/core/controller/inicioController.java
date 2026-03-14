package dgtic.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class inicioController {



    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String inicio(Model model){
        model.addAttribute("contenido","Hola Spring MVC");
        return "index";
    }
    @GetMapping("principal")
    public String principal(Model model){
        model.addAttribute("contenido","Sistema de Consulta León");
        return "principal/principal";
    }



}
