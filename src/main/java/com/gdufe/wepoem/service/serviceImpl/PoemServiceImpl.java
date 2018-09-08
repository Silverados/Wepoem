package com.gdufe.wepoem.service.serviceImpl;

import com.gdufe.wepoem.entity.PoemEntity;
import com.gdufe.wepoem.mapper.PoemMapper;
import com.gdufe.wepoem.service.PoemService;
import com.gdufe.wepoem.util.JsonUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoemServiceImpl implements PoemService {
    @Autowired
    PoemMapper poemMapper;

    @Override
    public String selectAll() {
        List<PoemEntity> poemEntities = poemMapper.selectAll();
        return JsonUtil.toJson(poemEntities);
    }

    @Override
    public String selectByKind(String kind) {
        List<PoemEntity> poemEntities = poemMapper.selectByKind(kind);
        return JsonUtil.toJson(poemEntities);
    }


}
