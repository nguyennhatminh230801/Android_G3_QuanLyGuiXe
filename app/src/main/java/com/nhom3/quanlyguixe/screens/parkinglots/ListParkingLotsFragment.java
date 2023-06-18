package com.nhom3.quanlyguixe.screens.parkinglots;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;

import com.nhom3.quanlyguixe.R;
import com.nhom3.quanlyguixe.data.model.ParkingLots;
import com.nhom3.quanlyguixe.databinding.FragmentListParkingLotsBinding;
import com.nhom3.quanlyguixe.util.Constant;
import com.nhom3.quanlyguixe.util.base.BaseFragment;
import com.nhom3.quanlyguixe.util.dialog.AlertDialogFactory;
import com.nhom3.quanlyguixe.util.interfaces.IUpdateDeleteListener;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class ListParkingLotsFragment extends BaseFragment<FragmentListParkingLotsBinding> {
    private ParkingLotViewModel parkingLotViewModel;

    @Inject
    NavController navController;

    private ParkingLotAdapter parkingLotAdapter;

    @Override
    public FragmentListParkingLotsBinding inflateViewBinding(LayoutInflater inflater) {
        return FragmentListParkingLotsBinding.inflate(inflater);
    }

    @Override
    protected void initScreenData() {
        parkingLotViewModel = new ViewModelProvider(this).get(ParkingLotViewModel.class);
        parkingLotAdapter = new ParkingLotAdapter();
        viewBinding.recyclerViewParkingLots.setAdapter(parkingLotAdapter);
        parkingLotViewModel.getAllParkingLots();
    }

    @Override
    protected void addEvent() {
        viewBinding.buttonAddParkingLot.setOnClickListener(view -> {
            navController.navigate(R.id.action_nav_list_parking_lots_to_nav_add_update_parking_slot);
        });

        viewBinding.recyclerViewParkingLots.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                boolean isScrollDown = dy > 0;

                if (isScrollDown) {
                    viewBinding.buttonAddParkingLot.hide();
                } else {
                    viewBinding.buttonAddParkingLot.show();
                }
            }
        });

        parkingLotAdapter.setOnUpdateDeleteListener(new IUpdateDeleteListener<ParkingLots>() {
            @Override
            public void onUpdate(ParkingLots item) {
                AlertDialogFactory.createNormalMessageDialog(
                        getContext(),
                        "Bạn có muốn cập nhật nhà xe này không?",
                        () -> {
                            Bundle bundle = new Bundle();
                            bundle.putBoolean(Constant.KEY_BUNDLE_IS_UPDATE, true);
                            bundle.putParcelable(Constant.KEY_BUNDLE_TICKET, item);
                            navController.navigate(
                                    R.id.action_nav_list_tickets_to_nav_add_update_tickets, bundle);
                        }).show();
            }

            @Override
            public void onDelete(ParkingLots item, int position) {
                AlertDialogFactory.createNormalMessageDialog(
                        getContext(),
                        "Bạn có muốn xóa nhà xe này không?",
                        () -> {
                            parkingLotViewModel.deleteParkingLot(item);
                            List<ParkingLots> ticketsList = new ArrayList<>(parkingLotAdapter.getCurrentList());
                            ticketsList.remove(item);
                            parkingLotAdapter.submitList(ticketsList);
                            parkingLotAdapter.notifyItemRemoved(position);

                            Toast.makeText(getContext(), "Xóa nhà xe xe thành công", Toast.LENGTH_SHORT).show();
                            if (ticketsList.size() == 0) {
                                viewBinding.recyclerViewParkingLots.setVisibility(View.GONE);
                                viewBinding.textEmptyParkingLot.setVisibility(View.VISIBLE);
                            }
                        }).show();
            }
        });
    }

    @Override
    protected void bindToViewModel() {
        parkingLotViewModel.getParkingLots().observe(getViewLifecycleOwner(), parkingLots -> {
            parkingLotAdapter.submitList(parkingLots);
        });
    }
}
