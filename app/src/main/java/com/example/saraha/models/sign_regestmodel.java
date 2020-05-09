package com.example.saraha.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class sign_regestmodel {

    @SerializedName("Info")
    @Expose
    private List<objectsign> info = null;
    @SerializedName("AccessToken")
    @Expose
    private String accessToken;
    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("Message_Error")
    @Expose
    private String messageError;

    public List<objectsign> getInfo() {
        return info;
    }

    public void setInfo(List<objectsign> info) {
        this.info = info;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessageError() {
        return messageError;
    }

    public void setMessageError(String messageError) {
        this.messageError = messageError;
    }

}
