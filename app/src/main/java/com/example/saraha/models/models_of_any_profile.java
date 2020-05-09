package com.example.saraha.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class models_of_any_profile {
    @SerializedName("Info")
    @Expose
    private List<chaid_model_of_any_profile> info = null;
    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("Message_Error")
    @Expose
    private String messageError;

    public List<chaid_model_of_any_profile> getInfo() {
        return info;
    }

    public void setInfo(List<chaid_model_of_any_profile> info) {
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
