package com.example.saraha.models;

public class model_of_parnts_chat {
    private String st1;
    private String st2;
    private  int php;

    public model_of_parnts_chat(String st1, String st2, int php) {
        this.st1 = st1;
        this.st2 = st2;
        this.php = php;
    }

    public String getSt1() {
        return st1;
    }

    public int getPhp() {
        return php;
    }

    public void setPhp(int php) {
        this.php = php;
    }

    public void setSt1(String st1) {
        this.st1 = st1;
    }

    public String getSt2() {
        return st2;
    }

    public void setSt2(String st2) {
        this.st2 = st2;
    }
}
