package com.example.demo.admin.dao;

import com.example.demo.admin.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by tuyuelai on 2017/6/9.
 */
@Mapper
public interface UserMapper {

    public List<User> listUser();
}
