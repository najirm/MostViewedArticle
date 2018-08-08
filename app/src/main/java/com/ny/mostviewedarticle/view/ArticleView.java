package com.ny.mostviewedarticle.view;

import com.ny.mostviewedarticle.model.Article;

import java.util.List;

public interface ArticleView {
    void populateArticle(List<Article> articles);

    void hideProgress();

    void showToast();
}
