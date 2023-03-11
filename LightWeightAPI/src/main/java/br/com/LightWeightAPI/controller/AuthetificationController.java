package br.com.LightWeightAPI.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthetificationController {

    @PostMapping
    public ResponseEntity doLogin() {
        System.out.println("FLU");
        return ResponseEntity.ok().build();
    }
}
