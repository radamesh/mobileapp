package com.sjs.mobileapp.controller.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<Object> getAuthLogin() {
        return ResponseEntity.ok(Map.of("message", "Fazendo o Lgin"));
    }

    @PostMapping("/logout")
    public ResponseEntity<Object> getAuthLogout() {
        return ResponseEntity.ok(Map.of("message", "Fazendo o Logout"));
    }
}
