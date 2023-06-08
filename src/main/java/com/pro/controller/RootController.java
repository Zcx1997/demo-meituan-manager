package com.pro.controller;

import com.pro.domain.Root;
import com.pro.service.RootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {
    @Autowired
    private RootService rootService;

    @PostMapping("/dologin")
    public String login(String username,String password){
        Root root = new Root(username,password);
        String login = rootService.login(root);
        return login;
    }
}
