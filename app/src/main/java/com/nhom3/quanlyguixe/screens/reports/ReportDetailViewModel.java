package com.nhom3.quanlyguixe.screens.reports;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.nhom3.quanlyguixe.data.model.Tickets;
import com.nhom3.quanlyguixe.data.model.Vehicle;
import com.nhom3.quanlyguixe.data.repo.TicketRepository;
import com.nhom3.quanlyguixe.data.repo.VehicleRepository;
import com.nhom3.quanlyguixe.util.base.BaseViewModel;
import com.nhom3.quanlyguixe.util.interfaces.IResultListener;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class ReportDetailViewModel extends BaseViewModel {


     private final MutableLiveData<List<Vehicle>> _listUsers = new MutableLiveData();
     final LiveData<List<Vehicle>> listUsers = _listUsers;

    private final MutableLiveData<List<Tickets>> _listTicket = new MutableLiveData();
    final LiveData<List<Tickets>> listTicket = _listTicket;

    private final VehicleRepository vehicleRepository;
    private final TicketRepository ticketRepository;

    @Inject
    public ReportDetailViewModel(VehicleRepository vehicleRepository, TicketRepository ticketRepository) {
        this.vehicleRepository = vehicleRepository;
        this.ticketRepository = ticketRepository;
    }

    public void getVehicleByDate(Date startDate, Date endDate) {
        registerDisposable(
                executeTaskWithLoading(
                        vehicleRepository.getAllVehicles(),
                        new IResultListener<List<Vehicle>>() {
                            @Override
                            public void onSuccess(List<Vehicle> data) {
                               try{
                                   List<Vehicle> list = data.stream().filter(item -> (
                                           item.getDateTimeIn().getTime() >= startDate.getTime() && item.getDateTimeIn().getTime() <= endDate.getTime()
                                   )).collect(Collectors.toList());
                                   _listUsers.setValue(list);
                               }catch (Exception e) {
                                   _listUsers.setValue(data);
                               }

                            }

                            @Override
                            public void onError(Throwable throwable) {
                                error.postValue(throwable.getMessage());
                            }
                        }
                )
        );
    }

    public void getTicket() {
        registerDisposable(
                executeTaskWithLoading(
                        ticketRepository.getAllTickets(),
                        new IResultListener<List<Tickets>>() {
                            @Override
                            public void onSuccess(List<Tickets> data) {

                                _listTicket.setValue(data);
                            }

                            @Override
                            public void onError(Throwable throwable) {
                                error.postValue(throwable.getMessage());
                            }
                        }
                )
        );
    }

    public Tickets findTicketsById(Integer  id){
        for (Tickets t : _listTicket.getValue()) {
            if(t.getTicketID() == id)
                return t;
        }
        return null;
    }
}
