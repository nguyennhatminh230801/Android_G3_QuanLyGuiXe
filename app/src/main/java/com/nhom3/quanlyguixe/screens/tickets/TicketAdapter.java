package com.nhom3.quanlyguixe.screens.tickets;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.nhom3.quanlyguixe.R;
import com.nhom3.quanlyguixe.data.model.Tickets;
import com.nhom3.quanlyguixe.databinding.ItemTicketLayoutBinding;
import com.nhom3.quanlyguixe.util.Constant;
import com.nhom3.quanlyguixe.util.base.BaseRecyclerViewAdapter;
import com.nhom3.quanlyguixe.util.base.BaseViewHolder;
import com.nhom3.quanlyguixe.util.interfaces.IUpdateDeleteListener;

import java.text.NumberFormat;

public class TicketAdapter extends BaseRecyclerViewAdapter<Tickets, ItemTicketLayoutBinding, TicketAdapter.ViewHolder> {

    private IUpdateDeleteListener<Tickets> listener;

    protected TicketAdapter() {
        super(Tickets.getDiffCallback());
    }

    public void setOnUpdateDeleteListener(IUpdateDeleteListener<Tickets> listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemTicketLayoutBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false));
    }

    public class ViewHolder extends BaseViewHolder<Tickets, ItemTicketLayoutBinding> {
        public ViewHolder(@NonNull ItemTicketLayoutBinding binding) {
            super(binding);
        }

        @Override
        public void bindItem(Tickets item) {
            super.bindItem(item);
            Resources resources = viewBinding.getRoot().getContext().getResources();

            viewBinding.textTicketId.setText(resources.getString(R.string.text_temp_ticket_id, item.getTicketID()));

            viewBinding.textTicketType.setText(resources.getString(R.string.text_temp_ticket_type, item.getTicketType()));

            String displayPrice = NumberFormat.getCurrencyInstance().format(item.getPrice());
            viewBinding.textTicketPrice.setText(resources.getString(R.string.text_temp_ticket_price, displayPrice));

            String displayExpirationDate = Constant.YEAR_FORMAT.format(item.getExpirationDate());
            viewBinding.textTicketExpirationDate.setText(resources.getString(R.string.text_temp_ticket_expiration_date, displayExpirationDate));

            viewBinding.buttonUpdateTicket.setOnClickListener(view -> {
                listener.onUpdate(item);
            });

            viewBinding.buttonDeleteTicket.setOnClickListener(view -> {
                listener.onDelete(item, getAdapterPosition());
            });
        }
    }
}
