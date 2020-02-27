package com.example.templates.controller;

import com.example.templates.api.CommonResult;
import com.example.templates.generator.model.User;
import com.example.templates.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "listAll",method = RequestMethod.GET)
    public CommonResult<List<User>> getAllUser(){
        return CommonResult.success(userService.listAllUser());
    }

}
