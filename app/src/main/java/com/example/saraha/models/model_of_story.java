package com.example.saraha.models;

public class model_of_story {
    private int photo;
    private String text;

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public model_of_story(int photo, String text) {
        this.photo = photo;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
