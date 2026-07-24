package com.sjs.mobileapp.controller.auth;

import com.sjs.mobileapp.dto.auth.LoginRequest;
import com.sjs.mobileapp.dto.error.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity getAuthLogin(@RequestBody @Validated LoginRequest login) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword());
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        var authentication = this.authenticationManager.authenticate(usernamePassword);
        return ResponseEntity.ok(authentication);
    }

    @PostMapping("/logout")
    public ResponseEntity<Object> getAuthLogout() {
        return ResponseEntity.ok(Map.of("message", "Fazendo o Logout"));
    }
}
