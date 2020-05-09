
package com.example.saraha.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class CommentModelResc {

    @SerializedName("Messages")
    @Expose
    private ArrayList<Message> massge=null;
    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("Message_Error")
    @Expose
    private String messageError;

    public ArrayList<Message> getMassge() {
        return massge;
    }

    public void setMassge(ArrayList<Message> massge) {
        this.massge = massge;
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


