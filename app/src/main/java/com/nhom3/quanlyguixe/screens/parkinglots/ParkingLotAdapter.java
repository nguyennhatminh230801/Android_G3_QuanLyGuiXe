package com.nhom3.quanlyguixe.screens.parkinglots;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.nhom3.quanlyguixe.R;
import com.nhom3.quanlyguixe.data.model.ParkingLots;
import com.nhom3.quanlyguixe.databinding.ItemParkingLotLayoutBinding;
import com.nhom3.quanlyguixe.util.base.BaseRecyclerViewAdapter;
import com.nhom3.quanlyguixe.util.base.BaseViewHolder;
import com.nhom3.quanlyguixe.util.interfaces.IUpdateDeleteListener;

import java.text.NumberFormat;

public class ParkingLotAdapter extends BaseRecyclerViewAdapter<ParkingLots, ItemParkingLotLayoutBinding, ParkingLotAdapter.ViewHolder> {

    private IUpdateDeleteListener<ParkingLots> listener;

    protected ParkingLotAdapter() {
        super(ParkingLots.getDiffCallback());
    }

    public void setOnUpdateDeleteListener(IUpdateDeleteListener<ParkingLots> listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemParkingLotLayoutBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false));
    }

    public class ViewHolder extends BaseViewHolder<ParkingLots, ItemParkingLotLayoutBinding> {
        public ViewHolder(@NonNull ItemParkingLotLayoutBinding binding) {
            super(binding);
        }

        @Override
        public void bindItem(ParkingLots item) {
            super.bindItem(item);
            Resources resources = viewBinding.getRoot().getContext().getResources();

            viewBinding.textParkingLotId.setText(resources.getString(R.string.text_temp_parking_lot_id, item.getParkingLotId()));

            viewBinding.textParkingLotName.setText(resources.getString(R.string.text_temp_parking_lot_name, item.getParkingLotName()));

            viewBinding.textParkingSlotAvailable.setText(resources.getString(R.string.text_temp_parking_slot_available, item.getParkingSlotRemaining()));

            viewBinding.textParkingSlotMax.setText(resources.getString(R.string.text_temp_parking_slot_max, item.getParkingSlotMax()));

            viewBinding.buttonUpdateParkingLot.setOnClickListener(view -> {
                listener.onUpdate(item);
            });

            viewBinding.buttonDeleteParkingLot.setOnClickListener(view -> {
                listener.onDelete(item, getAdapterPosition());
            });
        }
    }
}
