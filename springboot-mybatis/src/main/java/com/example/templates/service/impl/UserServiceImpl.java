package com.example.templates.service.impl;

import com.example.templates.generator.mapper.UserMapper;
import com.example.templates.generator.model.User;
import com.example.templates.generator.model.UserExample;
import com.example.templates.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    private UserMapper userMapper;

    @Override
    public List<User> listAllUser() {
        return userMapper.selectByExample(new UserExample());
    }
}
