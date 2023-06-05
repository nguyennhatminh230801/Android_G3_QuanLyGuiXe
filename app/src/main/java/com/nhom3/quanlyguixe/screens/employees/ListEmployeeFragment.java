package com.nhom3.quanlyguixe.screens.employees;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;

import com.nhom3.quanlyguixe.R;
import com.nhom3.quanlyguixe.data.model.Employees;
import com.nhom3.quanlyguixe.databinding.FragmentListEmployeeBinding;
import com.nhom3.quanlyguixe.util.Constant;
import com.nhom3.quanlyguixe.util.base.BaseFragment;
import com.nhom3.quanlyguixe.util.dialog.AlertDialogFactory;
import com.nhom3.quanlyguixe.util.interfaces.IUpdateDeleteListener;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class ListEmployeeFragment extends BaseFragment<FragmentListEmployeeBinding> {

    private EmployeeViewModel employeeViewModel;

    private EmployeeAdapter employeeAdapter;

    @Inject
    NavController navController;

    @Override
    public FragmentListEmployeeBinding inflateViewBinding(LayoutInflater inflater) {
        return FragmentListEmployeeBinding.inflate(inflater);
    }

    @Override
    protected void initScreenData() {
        employeeViewModel = new ViewModelProvider(this).get(EmployeeViewModel.class);
        employeeAdapter = new EmployeeAdapter();
        viewBinding.recyclerViewEmployees.setAdapter(employeeAdapter);
        employeeViewModel.getAllEmployees();
    }

    @Override
    protected void addEvent() {
        viewBinding.buttonAddEmployee.setOnClickListener(view -> {
            navController.navigate(R.id.action_nav_list_employee_to_nav_add_update_employee);
        });

        viewBinding.recyclerViewEmployees.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                boolean isScrollDown = dy > 0;

                if(isScrollDown) {
                    viewBinding.buttonAddEmployee.hide();
                } else {
                    viewBinding.buttonAddEmployee.show();
                }
            }
        });

        employeeAdapter.setOnUpdateDeleteListener(new IUpdateDeleteListener<Employees>() {
            @Override
            public void onUpdate(Employees item) {
                AlertDialogFactory.createNormalMessageDialog(
                        getContext(),
                        "Bạn có muốn cập nhật nhân viên này không?",
                        () -> {
                            Bundle bundle = new Bundle();
                            bundle.putBoolean(Constant.KEY_BUNDLE_IS_UPDATE, true);
                            bundle.putParcelable(Constant.KEY_BUNDLE_EMPLOYEE, item);
                            navController.navigate(
                                    R.id.action_nav_list_tickets_to_nav_add_update_tickets, bundle);
                        }).show();
            }

            @Override
            public void onDelete(Employees item, int position) {
                AlertDialogFactory.createNormalMessageDialog(
                        getContext(),
                        "Bạn có muốn xóa nhân viên này không?",
                        () -> {
                            employeeViewModel.deleteEmployee(item);
                            List<Employees> employeeList = new ArrayList<>(employeeAdapter.getCurrentList());
                            employeeList.remove(item);
                            employeeAdapter.submitList(employeeList);
                            employeeAdapter.notifyItemRemoved(position);

                            Toast.makeText(getContext(), "Xóa nhân viên thành công", Toast.LENGTH_SHORT).show();
                        }).show();
            }
        });
    }

    @Override
    protected void bindToViewModel() {
        employeeViewModel.getEmployees().observe(getViewLifecycleOwner(), employees -> {
            employeeAdapter.submitList(employees);
        });
    }
}
