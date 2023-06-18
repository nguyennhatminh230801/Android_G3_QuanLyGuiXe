package com.nhom3.quanlyguixe.screens.shiftmanager;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;

import com.nhom3.quanlyguixe.R;
import com.nhom3.quanlyguixe.data.model.Employees;
import com.nhom3.quanlyguixe.data.model.ScheduleEmployee;
import com.nhom3.quanlyguixe.databinding.FragmentListShiftManagerBinding;
import com.nhom3.quanlyguixe.screens.shiftmanager.adapter.ScheduleEmployeeAdapter;
import com.nhom3.quanlyguixe.util.Constant;
import com.nhom3.quanlyguixe.util.base.BaseFragment;
import com.nhom3.quanlyguixe.util.dialog.AlertDialogFactory;
import com.nhom3.quanlyguixe.util.interfaces.IUpdateDeleteListener;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class ListShiftManagerFragment extends BaseFragment<FragmentListShiftManagerBinding> {


    private ShiftManagerViewModel scheduleViewModel;
    private ScheduleEmployeeAdapter employeeAdapter;

    @Inject
    NavController navController;
    @Override
    public FragmentListShiftManagerBinding inflateViewBinding(LayoutInflater inflater) {
        return FragmentListShiftManagerBinding.inflate(inflater);
    }

    @Override
    protected void initScreenData() {
        employeeAdapter = new ScheduleEmployeeAdapter();
        viewBinding.recyclerViewScheduleCustomer.setAdapter(employeeAdapter);

        scheduleViewModel = new ViewModelProvider(this).get(ShiftManagerViewModel.class);
        scheduleViewModel.getAllEmployees();

    }

    @Override
    protected void addEvent() {
        viewBinding.buttonAddTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                navController.navigate(R.id.action_nav_list_shift_manager_to_addUpdateListShiftFragment);

            }
        });


        employeeAdapter.setOnUpdateDeleteListener(new IUpdateDeleteListener<ScheduleEmployee>() {
            @Override
            public void onUpdate(ScheduleEmployee item) {
                AlertDialogFactory.createNormalMessageDialog(
                        getContext(),
                        "Bạn có muốn cập nhật nhân viên này không?",
                        () -> {
                            Bundle bundle = new Bundle();
                            bundle.putBoolean(Constant.KEY_BUNDLE_IS_UPDATE, true);
                            bundle.putParcelable(Constant.KEY_BUNDLE_EMPLOYEE, item);
                            navController.navigate(
                                    R.id.action_nav_list_shift_manager_to_addUpdateListShiftFragment, bundle);
                        }).show();
            }

            @Override
            public void onDelete(ScheduleEmployee item, int position) {
                AlertDialogFactory.createNormalMessageDialog(
                        getContext(),
                        "Bạn có muốn xóa nhân viên này không?",
                        () -> {
                            scheduleViewModel.deleteEmployee(item);
                            List<ScheduleEmployee> employeeList = new ArrayList<>(employeeAdapter.getCurrentList());
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
        scheduleViewModel.getEmployees().observe(getViewLifecycleOwner(), employees -> {
            Log.d("bindToViewModel: ", employees+" ");
            employeeAdapter.submitList(employees);
        });
    }
}
