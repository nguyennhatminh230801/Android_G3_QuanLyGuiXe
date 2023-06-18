package com.nhom3.quanlyguixe.screens.checkinoutvehicle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.nhom3.quanlyguixe.data.model.Tickets;
import com.nhom3.quanlyguixe.data.model.Vehicle;
import com.nhom3.quanlyguixe.data.repo.TicketRepository;
import com.nhom3.quanlyguixe.data.repo.VehicleRepository;
import com.nhom3.quanlyguixe.util.base.BaseViewModel;
import com.nhom3.quanlyguixe.util.interfaces.IResultListener;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class CheckinCheckoutVehicleViewModel extends BaseViewModel {

    private final VehicleRepository vehicleRepository;

    private final TicketRepository ticketRepository;

    private final MutableLiveData<List<Vehicle>> _vehicles = new MutableLiveData<>();

    public LiveData<List<Vehicle>> getVehicles() {
        return _vehicles;
    }

    private final MutableLiveData<Boolean> _isCheckOutComplete = new MutableLiveData<>(false);

    public LiveData<Boolean> isCheckOutComplete() {
        return _isCheckOutComplete;
    }


    private final MutableLiveData<List<Tickets>> _tickets = new MutableLiveData<>();

    public LiveData<List<Tickets>> getTickets() {
        return _tickets;
    }

    @Inject
    public CheckinCheckoutVehicleViewModel(
            VehicleRepository vehicleRepository,
            TicketRepository ticketRepository
    ) {
        this.vehicleRepository = vehicleRepository;
        this.ticketRepository = ticketRepository;
    }

    public void getAllTickets() {
        registerDisposable(
                executeTaskWithLoading(
                        ticketRepository.getAllTickets(),
                        new IResultListener<List<Tickets>>() {
                            @Override
                            public void onSuccess(List<Tickets> data) {
                                _tickets.setValue(data);
                            }

                            @Override
                            public void onError(Throwable throwable) {
                                error.setValue(throwable.getMessage());
                            }
                        }
                )
        );
    }

    public void getAllVehicles() {
        registerDisposable(
                executeTaskWithLoading(
                        vehicleRepository.getAllVehicles(),
                        new IResultListener<List<Vehicle>>() {
                            @Override
                            public void onSuccess(List<Vehicle> data) {
                                _vehicles.setValue(data);
                            }

                            @Override
                            public void onError(Throwable throwable) {
                                error.setValue(throwable.getMessage());
                            }
                        }
                )
        );
    }

    public void insertVehicle(Vehicle vehicle) {
        registerDisposable(
                executeTaskWithLoading(
                        vehicleRepository.insertVehicle(vehicle),
                        new IResultListener<Long>() {

                            @Override
                            public void onSuccess(Long data) {
                                _backToPreviousScreen.setValue(true);
                            }

                            @Override
                            public void onError(Throwable throwable) {

                            }
                        }
                )
        );
    }

    public void deleteVehicle(List<Vehicle> vehicle) {
        registerDisposable(
                executeTaskWithLoading(
                        vehicleRepository.deleteVehicle(vehicle),
                        new IResultListener<Integer>() {

                            @Override
                            public void onSuccess(Integer data) {
                                _isCheckOutComplete.setValue(true);
                            }

                            @Override
                            public void onError(Throwable throwable) {

                            }
                        }
                )
        );
    }

    public void resetCompleteState() {
        _isCheckOutComplete.setValue(false);
    }
}
