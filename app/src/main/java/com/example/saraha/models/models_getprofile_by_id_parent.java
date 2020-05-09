package com.example.saraha.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class models_getprofile_by_id_parent {
    @SerializedName("Info")
    @Expose
    private List<models_chaild_get_prof_by_id> info = null;
    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("Message_Error")
    @Expose
    private String messageError;

    public List<models_chaild_get_prof_by_id> getInfo() {
        return info;
    }

    public void setInfo(List<models_chaild_get_prof_by_id> info) {
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
