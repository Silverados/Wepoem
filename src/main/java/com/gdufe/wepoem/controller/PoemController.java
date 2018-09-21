package com.gdufe.wepoem.controller;

import com.gdufe.wepoem.entity.request.KindEntity;
import com.gdufe.wepoem.service.PoemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/poem",produces="application/json;charset=UTF-8")
public class PoemController {

    @Autowired
    PoemService poemService;

    @RequestMapping(value = "/all")
    public String getAll(){
        return poemService.selectAll();
    }


    @RequestMapping(value = "/kind",method = RequestMethod.POST)
    public String getByKind(@RequestBody KindEntity entity) {
        return poemService.selectByKind(entity.getKind());
    }

    @RequestMapping(value = "/randomKind",method = RequestMethod.POST)
    public String getRandomByKind(@RequestBody KindEntity entity) {
        return poemService.selectRandomByKind(entity.getKind());
    }
}
