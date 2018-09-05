package com.gdufe.wepoem.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/poem")
public class PoemController {

    @RequestMapping(value = "/content")
    public String hello(){
        return "hello";
    }
}
