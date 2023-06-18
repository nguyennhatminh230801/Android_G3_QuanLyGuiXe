package com.nhom3.quanlyguixe.screens.reports;

import android.app.DatePickerDialog;
import android.view.LayoutInflater;
import android.view.View;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.nhom3.quanlyguixe.data.model.Vehicle;
import com.nhom3.quanlyguixe.databinding.FragmentReportDetailBinding;
import com.nhom3.quanlyguixe.util.Constant;
import com.nhom3.quanlyguixe.util.base.BaseFragment;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class ReportDetailFragment extends BaseFragment<FragmentReportDetailBinding> {

    private ReportDetailViewModel reportDetailViewModel;

    private Date startDate = null;
    private Date endDate = null;

    @Override
    public FragmentReportDetailBinding inflateViewBinding(LayoutInflater inflater) {
        return FragmentReportDetailBinding.inflate(inflater);
    }

    @Override
    protected void initScreenData() {
        reportDetailViewModel = new ViewModelProvider(this).get(ReportDetailViewModel.class);
        reportDetailViewModel.getTicket();
    }

    @Override
    protected void addEvent() {

        viewBinding.textInputStartDay.setOnClickListener(view -> {

            // chọn time start
            DatePickerDialog picker = new DatePickerDialog(getContext());
            picker.show();
            picker.setOnDateSetListener((datePicker, year, month, day) -> {
                Date date = new Date(year - Constant.DEFAULT_START_YEAR, month, day);
                startDate = date;
                viewBinding.textInputStartDay.getEditText().setText(Constant.YEAR_FORMAT.format(date));

                // thời điểm kết thúc và thời điểm ban đầu khác null sẽ truy vấn

                if (startDate != null && endDate != null) {
                    reportDetailViewModel.getVehicleByDate(startDate, endDate);
                }
            });
        });

        viewBinding.textInputStartDay.getEditText().setOnClickListener(view -> {
            DatePickerDialog picker = new DatePickerDialog(getContext());
            picker.show();
            picker.setOnDateSetListener((datePicker, year, month, day) -> {
                Date date = new Date(year - Constant.DEFAULT_START_YEAR, month, day);
                startDate = date;
                viewBinding.textInputStartDay.getEditText().setText(Constant.YEAR_FORMAT.format(date));

                // thời điểm kết thúc và thời điểm ban đầu khác null sẽ truy vấn

                if (startDate != null && endDate != null) {
                    reportDetailViewModel.getVehicleByDate(startDate, endDate);
                }
            });
        });

        viewBinding.textInputEndDay.getEditText().setOnClickListener(view ->{
            DatePickerDialog picker = new DatePickerDialog(getContext());
            picker.show();
            picker.setOnDateSetListener((datePicker, year, month, day) -> {
                Date date = new Date(year - Constant.DEFAULT_START_YEAR, month, day);
                endDate = date;

                // thời điểm kết thúc và thời điểm ban đầu khác null sẽ truy vấn
                if (startDate != null && endDate != null) {
                    reportDetailViewModel.getVehicleByDate(startDate, endDate);
                }
                viewBinding.textInputEndDay.getEditText().setText(Constant.YEAR_FORMAT.format(date));
            });
        });

        viewBinding.textInputEndDay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                // chọn time end
                DatePickerDialog picker = new DatePickerDialog(getContext());
                picker.show();
                picker.setOnDateSetListener((datePicker, year, month, day) -> {
                    Date date = new Date(year - Constant.DEFAULT_START_YEAR, month, day);
                    endDate = date;

                    // thời điểm kết thúc và thời điểm ban đầu khác null sẽ truy vấn
                    if (startDate != null && endDate != null) {
                        reportDetailViewModel.getVehicleByDate(startDate, endDate);
                    }
                    viewBinding.textInputEndDay.getEditText().setText(Constant.YEAR_FORMAT.format(date));
                });
            }
        });
    }


    @Override
    protected void bindToViewModel() {
        reportDetailViewModel.listUsers.observe(getViewLifecycleOwner(), new Observer<List<Vehicle>>() {
            @Override
            public void onChanged(List<Vehicle> vehicles) {
                Long sum = 0L;
                Set<Integer> set = new HashSet<>();
                for (Vehicle vehicle : vehicles) {
                    if(vehicle.getTicket() != null){
                       if(vehicle.getTicket().getPrice() != null){
                           sum += vehicle.getTicket().getPrice();
                           set.add(vehicle.getTicket().getTicketID());
                       }
                    }
                }
                viewBinding.textViewValueRevenue.setText(sum.toString());
                viewBinding.textViewValueVehicleAmount.setText(vehicles.size() +"");
                viewBinding.textViewValueDayTicketSold.setText(set.size()+"");
            }
        });
    }
}
