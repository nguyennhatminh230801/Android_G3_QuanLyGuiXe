package com.nhom3.quanlyguixe.screens.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.nhom3.quanlyguixe.databinding.FragmentHomeBinding;
import com.nhom3.quanlyguixe.util.base.BaseFragment;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HomeFragment extends BaseFragment<FragmentHomeBinding> {
    private HomeViewModel homeViewModel;

    @Override
    public FragmentHomeBinding inflateViewBinding(LayoutInflater inflater) {
        return FragmentHomeBinding.inflate(inflater);
    }

    @Override
    protected void initScreenData() {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
    }

    @Override
    protected void addEvent() {

    }

    @Override
    protected void bindToViewModel() {

    }
}