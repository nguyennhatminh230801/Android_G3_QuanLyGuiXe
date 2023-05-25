package com.nhom3.quanlyguixe.util.base;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

    private T item;

    public BaseViewHolder(@NonNull ViewBinding binding) {
        super(binding.getRoot());
    }

    public void bindItem(T item) {
        this.item = item;
    }
}
