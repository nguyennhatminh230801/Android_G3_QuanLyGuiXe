package com.nhom3.quanlyguixe.screens.checkinoutvehicle;

import android.view.LayoutInflater;


import androidx.navigation.NavController;

import com.nhom3.quanlyguixe.R;
import com.nhom3.quanlyguixe.databinding.FragmentCheckInOutVehicleBinding;
import com.nhom3.quanlyguixe.util.base.BaseFragment;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class CheckinCheckOutVehicleFragment extends BaseFragment<FragmentCheckInOutVehicleBinding> {

    @Inject
    NavController navController;

    @Override
    public FragmentCheckInOutVehicleBinding inflateViewBinding(LayoutInflater inflater) {
        return FragmentCheckInOutVehicleBinding.inflate(inflater);
    }

    @Override
    protected void initScreenData() {

    }

    @Override
    protected void addEvent() {
        viewBinding.buttonCheckInVehicle.setOnClickListener(view -> {
            navController.navigate(R.id.action_nav_checkin_checkout_vehicle_to_nav_checkin_vehicle);
        });

        viewBinding.buttonCheckOutVehicle.setOnClickListener(view -> {
            navController.navigate(R.id.action_nav_checkin_checkout_vehicle_to_nav_checkout_vehicle);
        });
    }

    @Override
    protected void bindToViewModel() {
        /* no-op */
    }
}
