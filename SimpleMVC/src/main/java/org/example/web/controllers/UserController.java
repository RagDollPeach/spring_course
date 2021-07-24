package org.example.web.controllers;

import org.apache.log4j.Logger;
import org.example.app.services.UserService;
import org.example.web.dto.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/login")
public class UserController {

    private final Logger logger = Logger.getLogger(UserController.class);
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save_user")
    public String saveUser(@NonNull LoginForm loginForm) {
        userService.store(loginForm);
        logger.info("User saved " + loginForm.getUserName());
        return "redirect:/login";
    }
}
