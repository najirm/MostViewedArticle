package com.ny.mostviewedarticle.model;

import com.google.gson.annotations.SerializedName;

public class MediaMetaData {
    @SerializedName("url")
    private String url;

    public String getUrl() {
        return url;
    }
}
