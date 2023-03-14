package com.example.dao.impl;

import com.example.dao.IUserDAO;
import com.example.model.User;
import com.example.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;

@Repository
public class UserDAOImpl implements IUserDAO {
    @Autowired
    UserRepository userRepository;

    @Override
    public User getUserByLogin(String login) {
        User result = userRepository.findByLogin(login);
        return result;
    }

    @Override
    public boolean persistUser(User user) {
        if(userRepository.findByLogin(user.getLogin()) != null){
            return false;
        }
        userRepository.save(user);
        return true;
    }
}
