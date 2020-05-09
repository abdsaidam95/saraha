package com.example.saraha.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class holderofarraysearch {
    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("NickName")
    @Expose
    private String nickName;
    @SerializedName("Image")
    @Expose
    private String image;
    @SerializedName("FacebookID")
    @Expose
    private String facebookID;

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFacebookID() {
        return facebookID;
    }

    public void setFacebookID(String facebookID) {
        this.facebookID = facebookID;
    }
}
