package com.quizgame.spring.service;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;

public class ServiceTestBase {

    @Autowired
    private ResetService deleteService;

    @Autowired
    private UserService userService;


    @Before
    public void cleanDatabase(){
        deleteService.resetDatabase();
    }

    protected boolean createUser(String user, String password){
        return userService.createUser(user,password,false);
    }
}
