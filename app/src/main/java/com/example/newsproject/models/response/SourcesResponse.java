
package com.example.newsproject.models.response;

import java.util.List;

import com.example.newsproject.models.Source;
import com.google.gson.annotations.SerializedName;

public class SourcesResponse {

    @SerializedName("sources")
    private List<Source> mSources;
    @SerializedName("status")
    private String mStatus;

    public List<Source> getSources() {
        return mSources;
    }

    public void setSources(List<Source> sources) {
        mSources = sources;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

}
