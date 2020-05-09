package com.example.saraha.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class model_res1_profile_frag {
    @SerializedName("Messages")
    @Expose
    private List<res2_massage_profile_frag> messages = null;
    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("Message_Error")
    @Expose
    private String messageError;

    public List<res2_massage_profile_frag> getMessages() {
        return messages;
    }

    public void setMessages(List<res2_massage_profile_frag> messages) {
        this.messages = messages;
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
