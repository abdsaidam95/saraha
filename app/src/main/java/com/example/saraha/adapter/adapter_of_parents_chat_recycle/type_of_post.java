package com.example.saraha.adapter.adapter_of_parents_chat_recycle;

public class type_of_post {
    public static final int post1 = 1;
    public static final int post2 = 2;
    private int type;
    private  int photo;
    private String string1;
    private String string2;

    public type_of_post(int type, int photo, String string2) {
        this.type = type;
        this.photo = photo;
        this.string2 = string2;
    }

    public type_of_post(int type, String string1, String string2) {
        this.type = type;
        this.string1 = string1;
        this.string2 = string2;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getString1() {
        return string1;
    }

    public void setString1(String string1) {
        this.string1 = string1;
    }

    public String getString2() {
        return string2;
    }

    public void setString2(String string2) {
        this.string2 = string2;
    }
}
