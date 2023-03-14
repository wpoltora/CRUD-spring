package com.example;

import com.example.dao.IUserDAO;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AdminInitializer implements ApplicationRunner {

    @Autowired
    IUserDAO userDAO;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // create an admin account and save it to the database
        User admin = new User(0, "admin", "admin", User.Role.ADMIN);
        userDAO.persistUser(admin);
    }
}
