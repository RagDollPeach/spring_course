package org.example.app.services;
import org.apache.log4j.Logger;
import org.example.web.dto.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private Logger logger = Logger.getLogger(LoginService.class);
    private UserService userService;

    @Autowired
    public LoginService(UserService userService) {
        this.userService = userService;
    }

    public boolean authenticate(String userName, String password) {
        logger.info("try auth  with user-form: " + userName);
        for (LoginForm loginForm: userService.getAllUsers()) {
            if (loginForm.getUserName().equals(userName) && loginForm.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
