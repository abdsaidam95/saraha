package com.example.saraha.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class replaymassagemodel {
    @SerializedName("Info")
    @Expose
    private Object info;
    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("Message_Error")
    @Expose
    private String messageError;

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
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