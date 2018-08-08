package com.ny.mostviewedarticle.presenter;

import android.content.Context;
import android.support.annotation.NonNull;

import com.ny.mostviewedarticle.R;
import com.ny.mostviewedarticle.model.ArticleResponse;
import com.ny.mostviewedarticle.network.ApiService;
import com.ny.mostviewedarticle.network.RetrofitClient;
import com.ny.mostviewedarticle.view.ArticleView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticlePresenter {

    private ArticleView mArticleView;
    private Context mContext;

    public ArticlePresenter(Context context, ArticleView articleView) {
        this.mArticleView = articleView;
        this.mContext = context;
    }

    public void getArticles() {
        ApiService service = RetrofitClient.getRetrofitInstance().create(ApiService.class);

        String API_KEY = mContext.getResources().getString(R.string.api_key);
        Call<ArticleResponse> call = service.getArticles("all-sections", 7, API_KEY);
        call.enqueue(new Callback<ArticleResponse>() {

            @Override
            public void onResponse(@NonNull Call<ArticleResponse> call, @NonNull Response<ArticleResponse> response) {
                mArticleView.hideProgress();
                mArticleView.populateArticle(response.body().getArticleList());
            }

            @Override
            public void onFailure(@NonNull Call<ArticleResponse> call, @NonNull Throwable t) {
                mArticleView.hideProgress();
                mArticleView.showToast();
            }
        });
    }
}
