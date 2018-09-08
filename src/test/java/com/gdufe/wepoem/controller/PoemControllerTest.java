package com.gdufe.wepoem.controller;

import com.gdufe.wepoem.application.WepoemApplication;
import com.gdufe.wepoem.util.JsonUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WepoemApplication.class)
public class PoemControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac ;

    @Before
    public void setWac() {
        mockMvc = webAppContextSetup(this.wac).build();
    }

    @Test
    public void getAll() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/poem/all")).andExpect(status().isOk()).andDo(print());
    }

    @Test
    public void getByKind() throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("kind", "一年级上册");
        String json = JsonUtil.toJson(map);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/poem/kind").contentType(MediaType.APPLICATION_JSON).content(json)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andDo(print());    }
}