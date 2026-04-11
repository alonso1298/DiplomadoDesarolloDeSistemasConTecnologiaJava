package edu.unam.controller;

import edu.unam.service.AdminService;
import edu.unam.service.HomeService;
import edu.unam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
// IoC
public class HomeController {
    // Atributo
    private final AdminService adminService;
    private final UserService userService;
    private final HomeService homeService;

    // Controlador Inyeccion
    @Autowired
    public HomeController(AdminService adminService,
                          UserService userService,
                          HomeService homeService) {
        this.adminService = adminService;
        this.userService = userService;
        this.homeService = homeService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("text", homeService.getText());
        return "index";
    }

    @GetMapping("/index")
    public String index() {
        return "redirect:/";
    }

    @GetMapping("/user")
    public String user(Model model) {
        model.addAttribute("text", userService.getText());
        return "user";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("text", adminService.getText());
        return "admin";
    }
}
