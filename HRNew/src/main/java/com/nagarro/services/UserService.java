package com.nagarro.services;

import com.nagarro.dto.User;
import com.nagarro.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User validateUser(String username, String password) {
        return userDao.validate(username, password);
    }

}