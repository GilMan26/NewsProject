
package com.example.newsproject.models;

import com.google.gson.annotations.SerializedName;

public class Source {

    @SerializedName("id")
    private Object mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("description")
    private String description;
    @SerializedName("url")
    private String url;
    @SerializedName("category")
    private String category;
    @SerializedName("language")
    private String language;
    @SerializedName("country")
    private String country;

    public Object getmId() {
        return mId;
    }

    public void setmId(Object mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Object getId() {
        return mId;
    }

    public void setId(Object id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

}
