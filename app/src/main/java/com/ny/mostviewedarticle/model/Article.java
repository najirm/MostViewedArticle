package com.ny.mostviewedarticle.model;

import com.google.gson.annotations.SerializedName;

public class Article {
    @SerializedName("url")
    private String url;

    @SerializedName("title")
    private String title;

    @SerializedName("byline")
    private String author;

    @SerializedName("published_date")
    private String publishedDate;

    @SerializedName("media")
    private MediaList media;

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public MediaList getMedia() {
        return media;
    }
}
