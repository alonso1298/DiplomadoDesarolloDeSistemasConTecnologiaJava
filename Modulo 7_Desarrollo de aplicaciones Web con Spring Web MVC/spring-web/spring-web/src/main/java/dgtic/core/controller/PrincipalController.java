package dgtic.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "spring")
public class PrincipalController {
    @RequestMapping(value = "requestmapping", method = RequestMethod.GET)
    public String mappingCLase(Model model){
        model.addAttribute("contenido", "@RequestMapping Clase");
        return "spring/requestmapping";
    }
    @GetMapping("getmapping")
    public String getMapping(Model model){
        model.addAttribute("contenido", "@Getmapping en metodo");
        return "spring/getmapping";
    }

}
