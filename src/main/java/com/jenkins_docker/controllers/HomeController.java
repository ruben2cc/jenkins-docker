package com.jenkins_docker.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("hello")
    public String helloController() {
        return "Hola Ruben y hola mundo, primer controller";
    }

    @GetMapping("host")
    public String mainController() {
        return "El pod es: " + System.getenv("HOSTNAME") + " container ID";
    }
}
