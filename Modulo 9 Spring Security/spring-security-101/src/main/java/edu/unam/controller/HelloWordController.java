package edu.unam.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/auth")
public class HelloWordController {

    @GetMapping("/welcome")
    public String helloWord(){
        log.info("estoy en mi log!!!!");
        return "Hello Word";
    }

    @GetMapping("/goodbye")
    public String goodByeWorld(){
        log.info("estoy en mi log!!!!");
        return "God Bye Word";
    }
}
