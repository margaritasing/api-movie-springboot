package com.bbva.apimoviespring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CharacterController {

    @GetMapping("/character")
    public String mensaje(){

        return "Hola soy tu servidor";
    }
}
