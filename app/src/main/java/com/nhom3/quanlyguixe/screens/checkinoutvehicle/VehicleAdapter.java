package com.nhom3.quanlyguixe.screens.checkinoutvehicle;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.nhom3.quanlyguixe.R;
import com.nhom3.quanlyguixe.data.model.Vehicle;
import com.nhom3.quanlyguixe.databinding.ItemVehicleCheckOutBinding;
import com.nhom3.quanlyguixe.util.Constant;
import com.nhom3.quanlyguixe.util.base.BaseRecyclerViewAdapter;
import com.nhom3.quanlyguixe.util.base.BaseViewHolder;
import com.nhom3.quanlyguixe.util.interfaces.IStateChangeListener;

public class VehicleAdapter
        extends BaseRecyclerViewAdapter<Vehicle, ItemVehicleCheckOutBinding, VehicleAdapter.ViewHolder> {

    private IStateChangeListener<Vehicle> stateChangeListener;

    protected VehicleAdapter() {
        super(Vehicle.getDiffCallback());
    }

    public void setStateChangeListener(IStateChangeListener<Vehicle> stateChangeListener) {
        this.stateChangeListener = stateChangeListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                ItemVehicleCheckOutBinding.inflate(
                        LayoutInflater.from(parent.getContext()),
                        parent,
                        false
                )
        );
    }

    public class ViewHolder extends BaseViewHolder<Vehicle, ItemVehicleCheckOutBinding> {
        public ViewHolder(@NonNull ItemVehicleCheckOutBinding binding) {
            super(binding);
        }

        @Override
        public void bindItem(Vehicle item) {
            super.bindItem(item);
            Resources resources = viewBinding.getRoot().getContext().getResources();

            viewBinding.textVehicleNumber.setText(resources.getString(R.string.text_vehicle_number, item.getVehicleNumber()));

            viewBinding.textVehicleTicketType.setText(resources.getString(R.string.text_vehicle_ticket_type, item.getTicket()));

            viewBinding.textVehicleOwner.setText(resources.getString(R.string.text_vehicle_owner, item.getCustomerName()));

            String time = Constant.DATE_TIME_FORMAT.format(item.getDateTimeIn());

            viewBinding.textVehicleTimeIn.setText(resources.getString(R.string.text_vehicle_time_in, time));

            viewBinding.checkboxCheckout.setOnCheckedChangeListener((compoundButton, isCheck) -> {
                stateChangeListener.onStateChange(item, getAdapterPosition(), isCheck);
            });
        }
    }
}
