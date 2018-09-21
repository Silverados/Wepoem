package com.gdufe.wepoem.service;

import com.gdufe.wepoem.application.WepoemApplication;
import com.gdufe.wepoem.service.PoemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = WepoemApplication.class)
public class PoemServiceTest {


    @Autowired
    PoemService poemService;

    @Test
    public void selectAll() {
        System.out.println(poemService.selectAll());
    }

    @Test
    public void selectByKind(){
        String s = poemService.selectByKind("一年级");
        System.out.println(s);
    }

    @Test
    public void selectRandomByKind(){
        String s = poemService.selectRandomByKind("一年级");
        System.out.println(s);
    }
}