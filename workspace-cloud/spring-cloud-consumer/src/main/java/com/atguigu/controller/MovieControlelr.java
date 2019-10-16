package com.atguigu.controller;


import com.atguigu.entity.User;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MovieControlelr {


    @Autowired
    private RestTemplate restTemplate;

    @Value("${user.userServiceUrl}")
    private String userServiceUrl;


    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id){
        User user = this.restTemplate.getForObject(userServiceUrl + id, User.class);
        return user;
    }


}
