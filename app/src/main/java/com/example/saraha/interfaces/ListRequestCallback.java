package com.example.saraha.interfaces;

import java.util.List;

public interface ListRequestCallback<T> {

    void onSuccess(List<T> objects);

    void onFailed();
}

