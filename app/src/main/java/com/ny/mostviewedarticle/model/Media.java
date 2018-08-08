package com.ny.mostviewedarticle.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Media {
    @SerializedName("media-metadata")
    private List<MediaMetaData> mediaMetaDataList;

    public List<MediaMetaData> getMediaMetaDataList() {
        return mediaMetaDataList;
    }
}
