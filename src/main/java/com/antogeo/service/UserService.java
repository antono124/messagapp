package com.antogeo.service;

import com.antogeo.dao.UserDao;
import com.antogeo.entity.User;
import com.antogeo.utils.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.List;
import java.util.Observable;


@Service("userService")
@EnableTransactionManagement
public class UserService extends Observable {

    @Autowired
    private UserDao userDao;

    @Transactional(readOnly = true)
    public User getUserByUsername(String username) {

        return userDao.getUserByUsername(username);
    }

    public void saveColor(Color color, Principal principal){

        //Apply business logic and save the color


        setChanged();
        notifyObservers(color);

    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
