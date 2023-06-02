package com.nhom3.quanlyguixe.screens.employees;

import android.view.LayoutInflater;

import com.nhom3.quanlyguixe.databinding.FragmentListEmployeeBinding;
import com.nhom3.quanlyguixe.util.base.BaseFragment;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class ListEmployeeFragment extends BaseFragment<FragmentListEmployeeBinding> {

    @Override
    public FragmentListEmployeeBinding inflateViewBinding(LayoutInflater inflater) {
        return FragmentListEmployeeBinding.inflate(inflater);
    }

    @Override
    protected void initScreenData() {

    }

    @Override
    protected void addEvent() {

    }

    @Override
    protected void bindToViewModel() {

    }
}
