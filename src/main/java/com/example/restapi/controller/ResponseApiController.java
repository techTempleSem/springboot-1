package com.example.restapi.controller;

import com.example.restapi.model.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class ResponseApiController {
    @RequestMapping(path = "",method = RequestMethod.GET)
    @GetMapping
    @ResponseBody
    public UserRequest user(){
        var user = new UserRequest("sem",10,"sem",true);
//        user.setUserName("sem");
//        user.setUserAge(10);
//        user.setEmail("sem");

        log.info("user : {}",user);

        var response = ResponseEntity
                .status(HttpStatus.CREATED)
                .body(user);

        return user;
    }
}
