package com.example.saraha.interfaces;

public interface ObjectRequestCallback<T> {

    void onSuccess(T object);

    void onFailed();
}


