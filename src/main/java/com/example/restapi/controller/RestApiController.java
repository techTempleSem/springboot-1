package com.example.restapi.controller;

import com.example.restapi.model.BookQueryParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
public class RestApiController {
    @GetMapping(path="/hello")
    public String hello(){
        var html = "<html><body><h1>Hello Spring Boot</h1></body></html>";
        return html;
    }

    @GetMapping(path = "/echo/{message}/{age}/{isMan}")
    public String echo(
            @PathVariable(name="message") String msg,
            @PathVariable int age,
            @PathVariable boolean isMan
    ){
        System.out.println("echo message : "+msg);
        System.out.println("echo age : "+age);
        System.out.println("echo isMan : "+isMan);
        return msg;
    }

    @GetMapping(path = "/book")
    public String book(
            @RequestParam String category,
            @RequestParam String issuedYear,
            @RequestParam(name="issued-month") String issuedMonth,
            @RequestParam String issued_day
    ){
        System.out.println("echo category : "+category);
        System.out.println("echo issuedYear : "+issuedYear);
        System.out.println("echo issuedMonth : "+issuedMonth);
        System.out.println("echo issued_day : "+issued_day);
        return "hello";
    }

    @GetMapping(path = "/book2")
    public String book2(
            BookQueryParam bookQueryParam
    ){
        System.out.println("echo category : "+bookQueryParam);
        return "hello";
    }

    @DeleteMapping(path = {
            "/user/{userName}/delete",
            "/user/{userName}/del"
    })
    public String book4(
            @PathVariable String userName
    ){
        log.info(userName);
        return "hello";
    }
}
