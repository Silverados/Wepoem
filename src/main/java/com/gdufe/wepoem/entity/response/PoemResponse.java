package com.gdufe.wepoem.entity.response;

import com.gdufe.wepoem.entity.PoemEntity;

import java.util.List;

/**
 * @author weiyuwang
 * @since 2018/9/21 17:00
 */
public class PoemResponse {
    private String title;
    private String author;
    private List<String> content;
    private String mean;
    private String kind;
    private String url;

    public PoemResponse(PoemEntity poemEntity,List<String> content) {
        this.title = poemEntity.getTitle();
        this.author = poemEntity.getAuthor();
        this.content = content;
        this.mean = poemEntity.getMean();
        this.kind = poemEntity.getKind();
        this.url = poemEntity.getUrl();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<String> getContent() {
        return content;
    }

    public void setContent(List<String> content) {
        this.content = content;
    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
