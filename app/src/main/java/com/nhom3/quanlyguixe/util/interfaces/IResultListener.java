package com.nhom3.quanlyguixe.util.interfaces;

public interface IResultListener<T> {

    void onSuccess(T data);

    void onError(Throwable throwable);
}