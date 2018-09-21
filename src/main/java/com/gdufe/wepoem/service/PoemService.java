package com.gdufe.wepoem.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public interface PoemService {
    String selectAll();
    String selectByKind(String kind);
    String selectRandomByKind(String kind);
}
