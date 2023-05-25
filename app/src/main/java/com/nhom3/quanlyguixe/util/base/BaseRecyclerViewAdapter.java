package com.nhom3.quanlyguixe.util.base;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import java.util.concurrent.Executors;

public abstract class BaseRecyclerViewAdapter<T, VH extends BaseViewHolder<T>>
        extends ListAdapter<T, VH> {
    protected BaseRecyclerViewAdapter(@NonNull DiffUtil.ItemCallback<T> diffCallback) {
        super(new AsyncDifferConfig.Builder(diffCallback)
                .setBackgroundThreadExecutor(Executors.newSingleThreadExecutor())
                .build());

    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.bindItem(getItem(position));
    }
}
