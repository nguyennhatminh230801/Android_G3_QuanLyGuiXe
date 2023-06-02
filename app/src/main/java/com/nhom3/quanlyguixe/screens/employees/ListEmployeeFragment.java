package com.nhom3.quanlyguixe.screens.employees;

import android.view.LayoutInflater;

import androidx.lifecycle.ViewModelProvider;

import com.nhom3.quanlyguixe.databinding.FragmentListEmployeeBinding;
import com.nhom3.quanlyguixe.util.base.BaseFragment;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class ListEmployeeFragment extends BaseFragment<FragmentListEmployeeBinding> {

    private EmployeeViewModel employeeViewModel;
    @Override
    public FragmentListEmployeeBinding inflateViewBinding(LayoutInflater inflater) {
        return FragmentListEmployeeBinding.inflate(inflater);
    }

    @Override
    protected void initScreenData() {
        employeeViewModel = new ViewModelProvider(this).get(EmployeeViewModel.class);
    }

    @Override
    protected void addEvent() {

    }

    @Override
    protected void bindToViewModel() {

    }
}
