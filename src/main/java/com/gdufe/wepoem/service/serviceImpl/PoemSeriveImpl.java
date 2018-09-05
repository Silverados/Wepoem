package com.gdufe.wepoem.service.serviceImpl;

import com.gdufe.wepoem.entity.PoemEntity;
import com.gdufe.wepoem.mapper.PoemMapper;
import com.gdufe.wepoem.service.PoemService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoemSeriveImpl implements PoemService {
    @Autowired
    PoemMapper poemMapper;

    @Override
    public String selectAll() {
        List<PoemEntity> poemEntities = poemMapper.selectAll();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(poemEntities);
    }
}
