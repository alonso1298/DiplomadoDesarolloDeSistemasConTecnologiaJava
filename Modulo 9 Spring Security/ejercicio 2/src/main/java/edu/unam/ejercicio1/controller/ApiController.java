package edu.unam.ejercicio1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class ApiController {

    @@GetMapping("/api/public/info")
    public String publicInfo() {
        return "Información pública";
    }

    @GetMapping("/api/admin/dashboard")
    public String adminDashboard() {
        return "Dashboard de administrador";
    }

}
