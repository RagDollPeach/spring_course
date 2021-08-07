package org.example.app.services;

import org.apache.log4j.Logger;
import org.example.app.repositorys.UserRepository;
import org.example.web.dto.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {
    private final Logger logger = Logger.getLogger(LoginService.class);
    private final UserRepository userRepository;

    @Autowired
    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean authenticate(String userName, String password) {
        logger.info("try auth  with user-form: " + userName);
        for (LoginForm loginForm : getAllUsers()) {
            if (loginForm.getUsername().equals(userName) && loginForm.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public List<LoginForm> getAllUsers() {
        return userRepository.retreiveAll();
    }

    public void store(LoginForm loginForm) {
        userRepository.store(loginForm);
    }
}