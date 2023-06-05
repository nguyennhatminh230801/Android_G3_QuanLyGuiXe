package com.nhom3.quanlyguixe.screens.employees;

import android.view.LayoutInflater;

import com.nhom3.quanlyguixe.databinding.FragmentAddUpdateEmployeeBinding;
import com.nhom3.quanlyguixe.util.base.BaseFragment;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class AddUpdateEmployeeFragment extends BaseFragment<FragmentAddUpdateEmployeeBinding> {

    @Override
    public FragmentAddUpdateEmployeeBinding inflateViewBinding(LayoutInflater inflater) {
        return FragmentAddUpdateEmployeeBinding.inflate(inflater);
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
