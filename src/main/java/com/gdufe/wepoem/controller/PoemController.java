package com.gdufe.wepoem.controller;

import com.gdufe.wepoem.service.PoemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/poem")
public class PoemController {

    @Autowired
    PoemService poemService;

    @RequestMapping(value = "/all",produces="application/json;charset=UTF-8")
    public String getAll(){
        return poemService.selectAll();
    }
}
