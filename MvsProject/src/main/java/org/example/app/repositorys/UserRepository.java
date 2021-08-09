package org.example.app.repositorys;

import org.apache.log4j.Logger;
import org.example.web.dto.LoginForm;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository implements UserRepositoryImpl {

    private final Logger logger = Logger.getLogger(UserRepository.class);
    private final List<LoginForm> subscribers = new ArrayList<>();

    @Override
    public List<LoginForm> retreiveAll() {
        return new ArrayList<>(subscribers);
    }

    @Override
    public void store(LoginForm userForm) {
        logger.info("Store new subscriber " + userForm);
        subscribers.add(userForm);
    }
}