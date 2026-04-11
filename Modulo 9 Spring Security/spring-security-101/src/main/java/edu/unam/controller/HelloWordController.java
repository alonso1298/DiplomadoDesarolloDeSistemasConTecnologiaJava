package edu.unam.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class HelloWordController {

    @GetMapping("/welcome")
    public String helloWord(){
        return "Hello Word";
    }
}
