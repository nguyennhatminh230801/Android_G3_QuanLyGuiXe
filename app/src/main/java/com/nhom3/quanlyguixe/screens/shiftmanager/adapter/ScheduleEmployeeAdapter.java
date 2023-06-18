package com.nhom3.quanlyguixe.screens.shiftmanager.adapter;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.nhom3.quanlyguixe.R;
import com.nhom3.quanlyguixe.data.model.ScheduleEmployee;
import com.nhom3.quanlyguixe.databinding.ItemListShiftManagerBinding;
import com.nhom3.quanlyguixe.util.base.BaseRecyclerViewAdapter;
import com.nhom3.quanlyguixe.util.base.BaseViewHolder;
import com.nhom3.quanlyguixe.util.interfaces.IUpdateDeleteListener;

public class ScheduleEmployeeAdapter extends BaseRecyclerViewAdapter<ScheduleEmployee, ItemListShiftManagerBinding, ScheduleEmployeeAdapter.ViewHolder> {

    public ScheduleEmployeeAdapter() {
        super(ScheduleEmployee.getDiffCallback());
    }

    private IUpdateDeleteListener<ScheduleEmployee> listener;

    public void setOnUpdateDeleteListener(IUpdateDeleteListener<ScheduleEmployee> listener) {
        this.listener = listener;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemListShiftManagerBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    public class ViewHolder extends BaseViewHolder<ScheduleEmployee, ItemListShiftManagerBinding> {

        public ViewHolder(@NonNull ItemListShiftManagerBinding binding) {
            super(binding);
        }

        @Override
        public void bindItem(ScheduleEmployee item) {
            super.bindItem(item);

            Resources resources = viewBinding.getRoot().getContext().getResources();

            viewBinding.textArea.setText(resources.getString(R.string.text_address, item.getAreaName()));

            viewBinding.textEmployeeName.setText(resources.getString(R.string.text_employee_name_title, item.getFullName()));

            viewBinding.textScheduleTime.setText(resources.getString(R.string.text_schedule_time_employee, item.getScheduleTime()));
//            String displayDateText = Constant.YEAR_FORMAT.format(item.getTime());

            viewBinding.textDate.setText(resources.getString(R.string.text_date, item.getTime()));

            viewBinding.buttonUpdateTicket.setOnClickListener(v -> listener.onUpdate(item));

            viewBinding.buttonDeleteTicket.setOnClickListener(v -> listener.onDelete(item, getAdapterPosition()));
        }
    }
}
