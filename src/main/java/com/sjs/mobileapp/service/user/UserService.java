package com.sjs.mobileapp.service.user;

import com.sjs.mobileapp.dto.user.RegisterRequest;
import com.sjs.mobileapp.entity.user.User;
import com.sjs.mobileapp.exception.ValidationException;
import com.sjs.mobileapp.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class UserService {

    @Autowired
    public final UserRepository userRepository;

    public UserDetails findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void createUser(RegisterRequest register) {
        try {
            log.info("User create success {}", register.id());
            String encrypted = new BCryptPasswordEncoder().encode(register.password());
            User newUser = new User(register.username(), encrypted);
            userRepository.save(newUser);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ValidationException(e.getMessage());
        }
    }
    
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

}
