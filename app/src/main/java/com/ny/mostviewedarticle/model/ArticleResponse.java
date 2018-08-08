package com.ny.mostviewedarticle.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ArticleResponse {
    public List<Article> getArticleList() {
        return articleList;
    }

    @SerializedName("results")
    private List<Article> articleList;
}
