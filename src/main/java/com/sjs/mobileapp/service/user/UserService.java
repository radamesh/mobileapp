package com.sjs.mobileapp.service.user;

import com.sjs.mobileapp.entity.User;
import com.sjs.mobileapp.exception.ValidationException;
import com.sjs.mobileapp.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class UserService {

    public final UserRepository userRepository;

    public void createUser(User user) {
        try {
            log.info("User create success {}", user.getId());
            userRepository.save(user);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ValidationException(e.getMessage());
        }
    }

}
