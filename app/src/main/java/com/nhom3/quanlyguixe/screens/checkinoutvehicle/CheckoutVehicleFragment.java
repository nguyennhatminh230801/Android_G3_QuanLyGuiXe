package com.nhom3.quanlyguixe.screens.checkinoutvehicle;

import android.view.LayoutInflater;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;

import com.nhom3.quanlyguixe.data.model.Vehicle;
import com.nhom3.quanlyguixe.databinding.FragmentCheckOutVehicleBinding;
import com.nhom3.quanlyguixe.util.base.BaseFragment;
import com.nhom3.quanlyguixe.util.interfaces.IStateChangeListener;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class CheckoutVehicleFragment extends BaseFragment<FragmentCheckOutVehicleBinding> {

    @Inject
    NavController navController;

    CheckinCheckoutVehicleViewModel viewModel;

    private VehicleAdapter vehicleAdapter;

    private final ArrayList<Vehicle> listSelectedVehicle = new ArrayList<>();

    @Override
    public FragmentCheckOutVehicleBinding inflateViewBinding(LayoutInflater inflater) {
        return FragmentCheckOutVehicleBinding.inflate(inflater);
    }

    @Override
    protected void initScreenData() {
        viewModel = new ViewModelProvider(this).get(CheckinCheckoutVehicleViewModel.class);
        vehicleAdapter = new VehicleAdapter();
        viewBinding.recyclerViewVehicle.setAdapter(vehicleAdapter);
        viewModel.getAllVehicles();
    }

    @Override
    protected void addEvent() {
        viewBinding.recyclerViewVehicle.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                boolean isScrollDown = dy > 0;

                if(isScrollDown) {
                    viewBinding.buttonCheckOut.hide();
                } else {
                    viewBinding.buttonCheckOut.show();
                }
            }
        });

        vehicleAdapter.setStateChangeListener((item, position, isChecked) -> {
            if (isChecked) {
                listSelectedVehicle.add(item);
            } else {
                listSelectedVehicle.remove(item);
            }
        });

        viewBinding.buttonCheckOut.setOnClickListener(v -> {
            viewModel.deleteVehicle(listSelectedVehicle);
        });
    }

    @Override
    protected void bindToViewModel() {
        viewModel.getVehicles().observe(getViewLifecycleOwner(), vehicles -> {
            vehicleAdapter.submitList(vehicles);
        });

        viewModel.isCheckOutComplete().observe(getViewLifecycleOwner(), isCheckOutComplete -> {
            if (isCheckOutComplete) {
                Toast.makeText(getContext(), "Check-out thành công", Toast.LENGTH_SHORT).show();
                navController.navigateUp();
            }
        });
    }

    @Override
    public void onDestroy() {
        viewModel.resetCompleteState();
        super.onDestroy();
    }
}
