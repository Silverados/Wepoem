package com.gdufe.wepoem.mapper;

import com.gdufe.wepoem.entity.PoemEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PoemMapper {
    List<PoemEntity> selectAll();
    List<PoemEntity> selectByKind(String kind);
}
