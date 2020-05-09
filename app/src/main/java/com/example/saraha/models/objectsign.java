package com.example.saraha.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class objectsign {
    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("ProfileID")
    @Expose
    private String profileID;
    @SerializedName("Email")
    @Expose
    private String email;
    @SerializedName("NickName")
    @Expose
    private String nickName;
    @SerializedName("Password")
    @Expose
    private String password;
    @SerializedName("Image")
    @Expose
    private String image;
    @SerializedName("Notifications")
    @Expose
    private Boolean notifications;
    @SerializedName("Date")
    @Expose
    private String date;
    @SerializedName("IsActive")
    @Expose
    private Boolean isActive;
    @SerializedName("FacebookID")
    @Expose
    private Object facebookID;
    @SerializedName("accessToken")
    @Expose
    private Object accessToken;
    @SerializedName("Details")
    @Expose
    private Object details;
    @SerializedName("PendingCount")
    @Expose
    private Integer pendingCount;
    @SerializedName("VisitsCount")
    @Expose
    private Integer visitsCount;
    @SerializedName("MessagesCount")
    @Expose
    private Integer messagesCount;
    @SerializedName("MessagesPublicCount")
    @Expose
    private Object messagesPublicCount;
    @SerializedName("Gender")
    @Expose
    private Object gender;
    @SerializedName("DOB")
    @Expose
    private Object dOB;
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

    public String getProfileID() {
        return profileID;
    }

    public void setProfileID(String profileID) {
        this.profileID = profileID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Boolean getNotifications() {
        return notifications;
    }

    public void setNotifications(Boolean notifications) {
        this.notifications = notifications;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Object getFacebookID() {
        return facebookID;
    }

    public void setFacebookID(Object facebookID) {
        this.facebookID = facebookID;
    }

    public Object getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(Object accessToken) {
        this.accessToken = accessToken;
    }

    public Object getDetails() {
        return details;
    }

    public void setDetails(Object details) {
        this.details = details;
    }

    public Integer getPendingCount() {
        return pendingCount;
    }

    public void setPendingCount(Integer pendingCount) {
        this.pendingCount = pendingCount;
    }

    public Integer getVisitsCount() {
        return visitsCount;
    }

    public void setVisitsCount(Integer visitsCount) {
        this.visitsCount = visitsCount;
    }

    public Integer getMessagesCount() {
        return messagesCount;
    }

    public void setMessagesCount(Integer messagesCount) {
        this.messagesCount = messagesCount;
    }

    public Object getMessagesPublicCount() {
        return messagesPublicCount;
    }

    public void setMessagesPublicCount(Object messagesPublicCount) {
        this.messagesPublicCount = messagesPublicCount;
    }

    public Object getGender() {
        return gender;
    }

    public void setGender(Object gender) {
        this.gender = gender;
    }

    public Object getDOB() {
        return dOB;
    }

    public void setDOB(Object dOB) {
        this.dOB = dOB;
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
}
