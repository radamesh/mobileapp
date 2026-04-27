package com.sjs.mobileapp.controller.user;

import com.sjs.mobileapp.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public ResponseEntity<Object> getAllUsers() {
        return ResponseEntity.ok(Map.of("message", "Fazendo o Lgin"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getOnlyOneUser(@PathVariable Long id) {
        User user = new User();
        user.setId(id);
        user.setUsername("radame.silva");
        return ResponseEntity.ok(user);
    }
}
