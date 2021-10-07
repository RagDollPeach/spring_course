package org.example.app.repositorys;

import org.example.web.dto.LoginForm;

import java.util.List;

public interface UserRepositoryImpl {
    List<LoginForm> retreiveAll();

    void store(LoginForm userForm);
}
