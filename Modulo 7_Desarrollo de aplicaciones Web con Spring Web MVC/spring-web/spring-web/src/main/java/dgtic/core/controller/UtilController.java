package dgtic.core.controller;

import dgtic.core.model.dto.UsuarioDTO;
import dgtic.core.model.entity.UsuarioBd;
import dgtic.core.service.IUsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@Controller
@RequestMapping(value = "utilerias")
public class UtilController {

    @Autowired
    private MessageSource mensaje;

    @Autowired
    private IUsuarioService usuarioService;

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
    @GetMapping("ver-usuario-v6")
    public String verUsuarioV6(Model model){
        model.addAttribute("usuario",new UsuarioBd());
        model.addAttribute("contenido","Ingresa los datos siguientes");
        return "utilerias/binding-v6";
    }
    @PostMapping("recibir-usuario-v6")
    public String recibirUsuario4(@Valid @ModelAttribute("usuario") UsuarioBd usuario,
                                  BindingResult bindingResult,
                                  Model model){
        if(bindingResult.hasErrors()){
            for(ObjectError error:bindingResult.getAllErrors()){
                System.out.println("Error: "+error.getDefaultMessage());
            }
            return "utilerias/binding-v6";
        }
        model.addAttribute("usuario",usuario);
        String cadena="";
        if(!usuario.getNombre().isEmpty() && !usuario.getCorreo().isEmpty()){
            model.addAttribute("contenido","Los datos que ingresas son:");
            cadena="Tu nombre es: "+usuario.getNombre()+" y correo: "+usuario.getCorreo();
        }
        usuarioService.guardar(usuario);
        System.out.println(usuario);
        model.addAttribute("alerts", "Se almaceno con éxito");

        model.addAttribute("usuario",new UsuarioBd());
        model.addAttribute("contenido","Los datos que ingresas son:");
        model.addAttribute("info",cadena);
        return "utilerias/binding-v6";

    }
}
