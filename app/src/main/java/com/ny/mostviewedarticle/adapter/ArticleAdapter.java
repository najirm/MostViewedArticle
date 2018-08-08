package com.ny.mostviewedarticle.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ny.mostviewedarticle.R;
import com.ny.mostviewedarticle.activity.DetailActivity;
import com.ny.mostviewedarticle.model.Article;

import java.text.MessageFormat;
import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {

    private List<Article> mArticleList;
    private Context mContext;

    public ArticleAdapter(Context context, List<Article> articleList) {
        this.mContext = context;
        this.mArticleList = articleList;
    }

    @NonNull
    @Override
    public ArticleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_most_viewed, parent, false);
        return new ArticleAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ArticleAdapter.ViewHolder holder, int position) {
        holder.article = mArticleList.get(position);
        if (mArticleList.get(position).getMedia() != null && !mArticleList.get(position).getMedia().isEmpty() &&
                mArticleList.get(position).getMedia().get(0).getMediaMetaDataList() != null &&
                !mArticleList.get(position).getMedia().get(0).getMediaMetaDataList().isEmpty()) {
            Glide.with(holder.imageView.getContext())
                    .load(mArticleList.get(position).getMedia().get(0).getMediaMetaDataList().get(1).getUrl())
                    .into(holder.imageView);
        }
        holder.tvTitle.setText(mArticleList.get(position).getTitle());
        holder.tvAuthor.setText(mArticleList.get(position).getAuthor());

        holder.tvDate.setText(MessageFormat.format(mContext.getString(R.string.published_date), mArticleList.get(position).getPublishedDate()));

        holder.row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra("url", holder.article.getUrl());

                    context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mArticleList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final View row;
        private final ImageView imageView;
        private final TextView tvTitle;
        private final TextView tvAuthor;
        private final TextView tvDate;
        private Article article;

        private ViewHolder(View view) {
            super(view);
            row = view;
            imageView = view.findViewById(R.id.imageView);
            tvTitle = view.findViewById(R.id.tvTitle);
            tvAuthor = view.findViewById(R.id.tvAuthor);
            tvDate = view.findViewById(R.id.tvDate);
        }
    }
}
