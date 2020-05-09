package com.example.saraha.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class res2_massage_profile_frag {
    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("ProfileID")
    @Expose
    private Integer profileID;
    @SerializedName("Date")
    @Expose
    private String date;
    @SerializedName("IsPublic")
    @Expose
    private Boolean isPublic;
    @SerializedName("IsRead")
    @Expose
    private Boolean isRead;
    @SerializedName("IsDeleted")
    @Expose
    private Boolean isDeleted;
    @SerializedName("UpCount")
    @Expose
    private Integer upCount;
    @SerializedName("DownCount")
    @Expose
    private Integer downCount;
    @SerializedName("SenderID")
    @Expose
    private Integer senderID;
    @SerializedName("Country")
    @Expose
    private String country;
    @SerializedName("Flag")
    @Expose
    private String flag;
    @SerializedName("Ip")
    @Expose
    private String ip;
    @SerializedName("_Data")
    @Expose
    private String data;
    @SerializedName("Img")
    @Expose
    private Object img;
    @SerializedName("MessageID")
    @Expose
    private Integer messageID;

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getProfileID() {
        return profileID;
    }

    public void setProfileID(Integer profileID) {
        this.profileID = profileID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Boolean getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(Boolean isPublic) {
        this.isPublic = isPublic;
    }

    public Boolean getIsRead() {
        return isRead;
    }

    public void setIsRead(Boolean isRead) {
        this.isRead = isRead;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getUpCount() {
        return upCount;
    }

    public void setUpCount(Integer upCount) {
        this.upCount = upCount;
    }

    public Integer getDownCount() {
        return downCount;
    }

    public void setDownCount(Integer downCount) {
        this.downCount = downCount;
    }

    public Integer getSenderID() {
        return senderID;
    }

    public void setSenderID(Integer senderID) {
        this.senderID = senderID;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Object getImg() {
        return img;
    }

    public void setImg(Object img) {
        this.img = img;
    }

    public Integer getMessageID() {
        return messageID;
    }

    public void setMessageID(Integer messageID) {
        this.messageID = messageID;
    }
}
