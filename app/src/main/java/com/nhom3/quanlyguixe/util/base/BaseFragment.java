package com.nhom3.quanlyguixe.util.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;

import dagger.hilt.android.AndroidEntryPoint;

public abstract class BaseFragment<VB extends ViewBinding> extends Fragment {

    protected VB viewBinding;

    public abstract VB inflateViewBinding(LayoutInflater inflater);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewBinding = inflateViewBinding(inflater);
        return viewBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initScreenData();
        addEvent();
        bindToViewModel();
    }

    @Override
    public void onDestroy() {
        viewBinding = null;
        super.onDestroy();
    }

    protected abstract void initScreenData();

    protected abstract void addEvent();

    protected abstract void bindToViewModel();
}
