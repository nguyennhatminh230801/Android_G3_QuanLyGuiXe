package com.nhom3.quanlyguixe.util.interfaces;

public interface IUpdateDeleteListener<T> {

    public void onUpdate(T item);

    public void onDelete(T item, int position);
}
