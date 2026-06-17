package com.jenkins_docker.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("hello")
    public String helloController() {
        return "Hola Ruben y hola mundo, primer controller";
    }
}
