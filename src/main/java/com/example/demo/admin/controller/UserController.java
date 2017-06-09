package com.example.demo.admin.controller;

import com.example.demo.admin.model.User;
import com.example.demo.admin.services.IUserServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by tuyuelai on 2017/6/9.
 */

@Controller
@RequestMapping("user")
public class UserController{
    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserServices userServices;


    @RequestMapping(value = "/add")
    @ResponseBody
    public String addUser(@RequestBody User user){
        return "";
    }

    @RequestMapping(value = "/del")
    @ResponseBody
    public String delUser(@RequestBody User user){
        return "";
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public List<User> listUser(){
        return userServices.listUser();
    }


    @RequestMapping("/hello")
    @ResponseBody
    public User hello() {
        User user = new User();
        user.setUserId(1);
        user.setUserName("aa");
        return user;
    }
}
