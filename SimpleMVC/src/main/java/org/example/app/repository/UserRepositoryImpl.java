package org.example.app.repository;

import org.example.web.dto.LoginForm;

import java.util.List;

public interface UserRepositoryImpl {

    List<LoginForm> retreiveAll();

    void store(LoginForm userForm);
}
