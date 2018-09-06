package com.gdufe.wepoem.util;

import org.junit.Test;

import java.util.List;
import java.util.Map;

public class JsonUtilTest {

    @Test
    public void objectToJson() {
    }

    @Test
    public void gsonToBean() {

    }

    @Test
    public void jsonToList() {
        List<Integer> list = JsonUtil.toList("[5,6]", Integer.TYPE);
        System.out.println(list);
    }

    @Test
    public void gsonToListMaps() {
        String gsonString = "[{1:\"a\"},{2:\"b\"}]";
        List<Map<Integer, String>> list = JsonUtil.toListMaps(gsonString, Integer.class, String.class);
        System.out.println(list);
    }

    @Test
    public void gsonToMaps() {
    }
}