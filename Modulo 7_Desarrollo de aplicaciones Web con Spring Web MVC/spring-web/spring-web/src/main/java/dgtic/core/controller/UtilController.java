package dgtic.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

@Controller
@RequestMapping(value = "utilerias")
public class UtilController {

    @Autowired
    private MessageSource mensaje;

    @GetMapping("error_particular_uno")
    public String getError(Model model){
        throw new NumberFormatException();
    }
    @ExceptionHandler(NumberFormatException.class)
    public String errorRuntime(NumberFormatException e,
                               Model model){
        String msg=mensaje.getMessage("Error.conversion.string.integer",
                null, Locale.getDefault());
        model.addAttribute("explicacion",msg);
        return "error-general";
    }
}
