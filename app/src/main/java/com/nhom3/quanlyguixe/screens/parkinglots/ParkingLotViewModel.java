package com.nhom3.quanlyguixe.screens.parkinglots;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.nhom3.quanlyguixe.data.model.ParkingLots;
import com.nhom3.quanlyguixe.data.repo.ParkingLotRepository;
import com.nhom3.quanlyguixe.util.base.BaseViewModel;
import com.nhom3.quanlyguixe.util.interfaces.IResultListener;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class ParkingLotViewModel extends BaseViewModel {

    private final MutableLiveData<List<ParkingLots>> _parkinglots = new MutableLiveData<>();

    public LiveData<List<ParkingLots>> getParkingLots() {
        return _parkinglots;
    }

    private final ParkingLotRepository parkingLotRepository;

    @Inject
    public ParkingLotViewModel(ParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;

        getAllParkingLots();
    }

    public void getAllParkingLots() {
        registerDisposable(
                executeTaskWithLoading(
                        parkingLotRepository.getAllParkingLots(),
                        new IResultListener<List<ParkingLots>>() {
                            @Override
                            public void onSuccess(List<ParkingLots> data) {
                                _parkinglots.setValue(data);
                            }

                            @Override
                            public void onError(Throwable throwable) {
                                error.postValue(throwable.getMessage());
                            }
                        }
                )
        );
    }

    public void insertParkingLot(ParkingLots parkinglots) {
        registerDisposable(
                executeTaskWithLoading(
                        parkingLotRepository.insertParkingLot(parkinglots),
                        new IResultListener<Long>() {
                            @Override
                            public void onSuccess(Long data) {
                                _backToPreviousScreen.setValue(true);
                            }

                            @Override
                            public void onError(Throwable throwable) {
                                error.setValue(throwable.getMessage());
                            }
                        }
                )
        );
    }

    public void updateParkingLot(ParkingLots parkinglots) {
        registerDisposable(
                executeTaskWithLoading(
                        parkingLotRepository.updateParkingLot(parkinglots),
                        new IResultListener<Integer>() {
                            @Override
                            public void onSuccess(Integer data) {
                                _backToPreviousScreen.setValue(true);
                            }

                            @Override
                            public void onError(Throwable throwable) {
                                error.setValue(throwable.getMessage());
                            }
                        }
                )
        );
    }

    public void deleteParkingLot(ParkingLots parkinglots) {
        registerDisposable(
                executeTaskWithLoading(
                        parkingLotRepository.deleteParkingLot(parkinglots),
                        new IResultListener<Integer>() {
                            @Override
                            public void onSuccess(Integer data) {
                            }

                            @Override
                            public void onError(Throwable throwable) {
                                error.setValue(throwable.getMessage());
                            }
                        }
                )
        );
    }
}
