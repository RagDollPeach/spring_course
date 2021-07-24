package org.example.app.services;

import org.example.web.dto.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<LoginForm> getAllUsers() {
        return userRepository.retreiveAll();
    }

    public void store(LoginForm loginForm) {
        userRepository.store(loginForm);
    }
}
