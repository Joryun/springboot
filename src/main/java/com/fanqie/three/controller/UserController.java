package com.fanqie.three.controller;

import com.fanqie.three.controller.entity.UserEntity;

import com.fanqie.three.controller.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2018/10/9.
 */
@RestController
@RequestMapping(value="/user")
public class UserController {
    @Autowired
    private UserJPA userJPA;

    @RequestMapping(value="/list",method = RequestMethod.GET)
    public List<UserEntity> list(){
        return userJPA.findAll();
    }

    @RequestMapping(value = "/save",method = RequestMethod.GET)
    public UserEntity save(UserEntity entity){
        return userJPA.save(entity);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public List<UserEntity> delete(Long id){
        userJPA.deleteById(id);
        return userJPA.findAll();
    }
}
