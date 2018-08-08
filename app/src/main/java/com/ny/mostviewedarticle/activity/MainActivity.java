package com.ny.mostviewedarticle.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.ny.mostviewedarticle.R;
import com.ny.mostviewedarticle.adapter.ArticleAdapter;
import com.ny.mostviewedarticle.model.Article;
import com.ny.mostviewedarticle.presenter.ArticlePresenter;
import com.ny.mostviewedarticle.view.ArticleView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ArticleView {

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading....");
        progressDialog.show();

        ArticlePresenter articlePresenter = new ArticlePresenter(MainActivity.this, this);
        articlePresenter.getArticles();
    }

    @Override
    public void populateArticle(List<Article> articleList) {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        ArticleAdapter articleAdapter = new ArticleAdapter(this, articleList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(articleAdapter);
    }

    @Override
    public void hideProgress() {
        progressDialog.dismiss();
    }

    @Override
    public void showToast() {
        Toast.makeText(MainActivity.this, "Something went wrong. Please try later.", Toast.LENGTH_LONG).show();
    }
}
