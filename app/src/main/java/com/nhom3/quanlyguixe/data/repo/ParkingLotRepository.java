package com.nhom3.quanlyguixe.data.repo;

import com.nhom3.quanlyguixe.data.model.ParkingLots;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;

public class ParkingLotRepository implements IParkingLotDataSource.Local {

    private final IParkingLotDataSource.Local local;

    @Inject
    public ParkingLotRepository(IParkingLotDataSource.Local local) {
        this.local = local;
    }

    @Override
    public Single<List<ParkingLots>> getAllParkingLots() {
        return local.getAllParkingLots();
    }

    @Override
    public Single<ParkingLots> getParkingLotByID(int parkingLotID) {
        return local.getParkingLotByID(parkingLotID);
    }

    @Override
    public Single<Long> insertParkingLot(ParkingLots parkingLots) {
        return local.insertParkingLot(parkingLots);
    }

    @Override
    public Single<Integer> updateParkingLot(ParkingLots parkingLots) {
        return local.updateParkingLot(parkingLots);
    }

    @Override
    public Single<Integer> deleteParkingLot(ParkingLots parkingLots) {
        return local.deleteParkingLot(parkingLots);
    }

}
