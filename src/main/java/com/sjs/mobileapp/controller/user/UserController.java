package com.sjs.mobileapp.controller.user;

import com.sjs.mobileapp.dto.user.RegisterRequest;
import com.sjs.mobileapp.entity.User;
import com.sjs.mobileapp.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<Object> getAllUsers() {
        return ResponseEntity.ok(Map.of("message", "Fazendo o Lgin"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getOnlyOneUser(@PathVariable Long id) {
        Optional<User> user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/register")
    public ResponseEntity getRegister(@RequestBody @Validated RegisterRequest register) {
        if (userService.findByUsername(register.username()) != null) {
            return ResponseEntity.badRequest().build();
        }
        userService.createUser(register);
        return ResponseEntity.ok(Map.of("message", "criando novo usuario"));
    }
}
