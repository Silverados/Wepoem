package com.gdufe.wepoem.service.serviceImpl;

import com.gdufe.wepoem.entity.PoemEntity;
import com.gdufe.wepoem.entity.response.PoemResponse;
import com.gdufe.wepoem.mapper.PoemMapper;
import com.gdufe.wepoem.service.PoemService;
import com.gdufe.wepoem.util.JsonUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    @Override
    public String selectRandomByKind(String kind) {
        List<PoemEntity> poemEntities = poemMapper.selectByKind(kind);
        List<PoemResponse> poemResponses = new ArrayList<>(poemEntities.size());
        List<String> temp = new ArrayList<>();
        Pattern pattern = Pattern.compile(".*?[，。？！]");
        for (PoemEntity entity : poemEntities) {
            Matcher matcher = pattern.matcher(entity.getContent().replaceAll("\\(.*\\)",""));
            while (matcher.find()) {
                temp.add(matcher.group());
            }
            PoemResponse response = new PoemResponse(entity,temp);
            poemResponses.add(response);
            temp = new ArrayList<>();
        }
        return JsonUtil.toJson(poemResponses);
    }


}
