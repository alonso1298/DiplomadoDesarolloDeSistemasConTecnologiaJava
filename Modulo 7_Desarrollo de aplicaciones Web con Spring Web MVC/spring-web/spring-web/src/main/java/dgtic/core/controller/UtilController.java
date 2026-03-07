package dgtic.core.controller;

import dgtic.core.model.dto.UsuarioDTO;
import dgtic.core.model.entity.UsuarioBd;
import dgtic.core.service.IUsuarioService;
import dgtic.core.util.Archivos;
import jakarta.activation.DataHandler;
import jakarta.activation.FileDataSource;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequestMapping(value = "utilerias")
public class UtilController {

    @Autowired
    private MessageSource mensaje;

    @Autowired
    private IUsuarioService usuarioService;

    @Value("${ejemplo.imagen.ruta}")
    private String archivoRuta;

    @GetMapping("error_particular_uno")
    public String getError(Model model) {
        throw new NumberFormatException();
    }

    @ExceptionHandler(NumberFormatException.class)
    public String errorRuntime(NumberFormatException e,
                               Model model) {
        String msg = mensaje.getMessage("Error.conversion.string.integer",
                null, Locale.getDefault());
        model.addAttribute("explicacion", msg);
        return "error-general";
    }

    @GetMapping("ver-usuario-v6")
    public String verUsuarioV6(Model model) {
        model.addAttribute("usuario", new UsuarioBd());
        model.addAttribute("contenido", "Ingresa los datos siguientes");
        return "utilerias/binding-v6";
    }

    @PostMapping("recibir-usuario-v6")
    public String recibirUsuario4(@Valid @ModelAttribute("usuario") UsuarioBd usuario,
                                  BindingResult bindingResult,
                                  Model model) {
        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                System.out.println("Error: " + error.getDefaultMessage());
            }
            return "utilerias/binding-v6";
        }
        model.addAttribute("usuario", usuario);
        String cadena = "";
        if (!usuario.getNombre().isEmpty() && !usuario.getCorreo().isEmpty()) {
            model.addAttribute("contenido", "Los datos que ingresas son:");
            cadena = "Tu nombre es: " + usuario.getNombre() + " y correo: " + usuario.getCorreo();
        }
        //usuarioService.guardar(usuario);
        //System.out.println(usuario);
        try {
            usuarioService.guardar(usuario);
        } catch (Exception e) {
            String msg = mensaje.getMessage("Error.base.duplicado",
                    null, LocaleContextHolder.getLocale());
            bindingResult.rejectValue("correo", "correo", msg);
            return "utilerias/binding-v6";
        }


        model.addAttribute("usuario", new UsuarioBd());
        model.addAttribute("contenido", "Los datos que ingresas son:");
        model.addAttribute("info", cadena);
        return "utilerias/binding-v6";

    }

    @GetMapping("redirecionar-sin-flash")
    public String redirecionarSinFlash(Model model){
        model.addAttribute("contenido","Se hizo un redireccionamiento");
        return "redirect:/principal";
    }
    @GetMapping("redirecionar-con-flash")
    public String redireccionConFlash(RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("contenido","Se hizo un redireccionamiento");
        return "redirect:/principal";

    }
    @GetMapping("ver-subir-archivo")
    public String verArchivos(Model model){
        model.addAttribute("contenido", "Subir archivo");
        return "utilerias/subir-archivo";
    }
    @PostMapping("salvar-archivo")
    public String recibirFlujo(@RequestParam("imagenarchivo")MultipartFile multipartFile,
                               Model model){
        String imagenNombre=null;
        if(!multipartFile.isEmpty()){
            imagenNombre= Archivos.almacenar(multipartFile,archivoRuta);
            if(imagenNombre!=null){
                System.out.println("nombre de archivo: "+imagenNombre);
            }
        }
        model.addAttribute("alerts","Archivo almacenado");
        model.addAttribute("nombre",imagenNombre);
        return "utilerias/subir-archivo";
    }
    @GetMapping("crear-pdf")
    public String generarPdf(Model model){
        List<UsuarioBd> usuarios=usuarioService.todosUsuarios();
        model.addAttribute("datos", usuarios);
        model.addAttribute("ruta", archivoRuta);
        return "utilerias/crear-pdf";
    }
    @GetMapping("mandar-correo")
    public String email(RedirectAttributes model){
        List<UsuarioBd> usuarioBds=usuarioService.todosUsuarios();
        String gmail = "alonsosagrerogranados@gmail.com";
        String pswd = "Tu clave";
        Properties p = System.getProperties();
        p.setProperty("mail.smtps.host", "smpt.gmail.com");
        p.setProperty("mail.smtps.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        p.setProperty("mail.smtps.socketFactory.fallback", "false");
        p.setProperty("mail.smtp.port", "465");
        p.setProperty("mail.smtp.socketFactory.port", "465");
        p.setProperty("mail.smtps.auth", "true");
        p.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");
        p.setProperty("mail.smtps.ssl.trust", "smtp.gmail.com");
        p.setProperty("mail.smtp.ssl.quitwait", "false");
        //construcción del html
        String cadena = "<h2>Usuarios</br>";
        for (UsuarioBd s : usuarioBds) {
            cadena += "<h2>" +
                    s.getNombre() +
                    "</h2></br>";
        }
        try {
            Session session = Session.getInstance(p, null);
            MimeMessage message = new MimeMessage(session);

            MimeBodyPart texto = new MimeBodyPart();
            texto.setContent(cadena, "text/html;charset=utf-8");
            //adjuntar la imagen
            BodyPart adjunto = new MimeBodyPart();
            String r = archivoRuta + "temp.pdf";
            adjunto.setDataHandler(new DataHandler(new FileDataSource(r)));
            adjunto.setFileName("temp.pdf");
            Multipart multiple = new MimeMultipart();
            multiple.addBodyPart(texto);
            multiple.addBodyPart(adjunto);

            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("tu correo donde mandas", false));
            message.setSubject("Usuario Registrado en B.D");
            message.setContent(multiple);
            message.setSentDate(new Date());


            Transport transport = (Transport) session.getTransport("smtps");
            transport.connect("smtp.gmail.com", gmail, pswd);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addFlashAttribute("contenido", "El correo se mando con éxito");
        return "redirect:/principal";
    }
    @GetMapping("mostrar-archivos")
    public String mostrarArchivos(Model model) throws IOException {
        Path archivoRutas= Paths.get(archivoRuta);
        try (Stream<Path> ruta = Files.walk(archivoRutas, 1)) {
            model.addAttribute("files",
                    ruta.filter(path -> !path.equals(archivoRutas) && !path.toString().endsWith(".pdf"))
                            .map(archivoRutas::relativize)
                            .map(Path::toString)
                            .collect(Collectors.toList()));        }
        model.addAttribute("contenido","Bajar archivos");
        return "utilerias/bajar-archivo";
    }
}