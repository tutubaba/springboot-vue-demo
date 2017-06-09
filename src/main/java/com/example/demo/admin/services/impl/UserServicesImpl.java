package com.example.demo.admin.services.impl;

import com.example.demo.admin.dao.UserMapper;
import com.example.demo.admin.model.User;
import com.example.demo.admin.services.IUserServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tuyuelai on 2017/6/9.
 */
@Service("userServices")
public class UserServicesImpl implements IUserServices {
    private final static Logger logger = LoggerFactory.getLogger(UserServicesImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> listUser() {
        List<User> userList = null;
        try{
            userList = userMapper.listUser();
        }catch (Exception e){
            logger.error("",e);
        }
        return userList;
    }
}
