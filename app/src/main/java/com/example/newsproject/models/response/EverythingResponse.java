
package com.example.newsproject.models.response;

import java.util.List;

import com.example.newsproject.models.News;
import com.google.gson.annotations.SerializedName;

public class EverythingResponse {

    @SerializedName("articles")
    private List<News> mArticles;
    @SerializedName("status")
    private String mStatus;
    @SerializedName("totalResults")
    private Long mTotalResults;

    public List<News> getArticles() {
        return mArticles;
    }

    public void setArticles(List<News> articles) {
        mArticles = articles;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

    public Long getTotalResults() {
        return mTotalResults;
    }

    public void setTotalResults(Long totalResults) {
        mTotalResults = totalResults;
    }

}