package org.example.web.controllers;

import org.apache.log4j.Logger;
import org.example.app.exeptions.BookShelfLoginException;
import org.example.app.services.LoginService;
import org.example.web.dto.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    private final Logger logger = Logger.getLogger(LoginController.class);
    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping
    public String login(Model model) {
        logger.info("GET /login returns login_page.html");
        model.addAttribute("loginForm", new LoginForm());
        return "login_page";
    }

    @PostMapping("/auth")
    public String authenticate(LoginForm loginFrom) throws BookShelfLoginException {
        if (loginService.authenticate(loginFrom.getUsername(), loginFrom.getPassword())) {
            logger.info("login OK redirect to book shelf");
            return "redirect:/books/shelf";
        } else {
            logger.info("login FAIL redirect back to login");
            throw new BookShelfLoginException("invalid user name or password");
        }
    }

    @PostMapping("/save_user")
    public String saveUser(@NonNull LoginForm loginForm) {
        loginService.store(loginForm);
        logger.info("User saved " + loginForm.getUsername());
        return "redirect:/login";
    }

    @ExceptionHandler(BookShelfLoginException.class)
    public String handleError(Model model, BookShelfLoginException exception) {
        model.addAttribute("errorMassage", exception.getMassage());
        return "errors/404";
    }
}