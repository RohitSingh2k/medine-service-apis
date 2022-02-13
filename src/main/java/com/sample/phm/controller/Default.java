package com.sample.phm.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class Default {

    /**
     * Default response for the API
     * @return String
     */
    @GetMapping("/")
    public String sayHello() {
        return "Spring Boot API starts working";
    }
}
