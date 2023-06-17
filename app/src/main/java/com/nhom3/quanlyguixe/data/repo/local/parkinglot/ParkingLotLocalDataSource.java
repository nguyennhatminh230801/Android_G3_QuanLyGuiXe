package com.nhom3.quanlyguixe.data.repo.local.parkinglot;

import com.nhom3.quanlyguixe.data.model.ParkingLots;
import com.nhom3.quanlyguixe.data.repo.IParkingLotDataSource;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;

public class ParkingLotLocalDataSource implements IParkingLotDataSource.Local {

    private final ParkingLotDao parkingLotDao;

    @Inject
    public ParkingLotLocalDataSource(ParkingLotDao parkingLotDao) {
        this.parkingLotDao = parkingLotDao;
    }

    @Override
    public Single<List<ParkingLots>> getAllParkingLots() {
        return parkingLotDao.getAllParkingLots();
    }

    @Override
    public Single<ParkingLots> getParkingLotByID(int parkingLotID) {
        return parkingLotDao.getParkingLotByID(parkingLotID);
    }

    @Override
    public Single<Long> insertParkingLot(ParkingLots parkingLots) {
        return parkingLotDao.insertParkingLot(parkingLots);
    }

    @Override
    public Single<Integer> updateParkingLot(ParkingLots parkingLots) {
        return parkingLotDao.updateParkingLot(parkingLots);
    }

    @Override
    public Single<Integer> deleteParkingLot(ParkingLots parkingLots) {
        return parkingLotDao.deleteParkingLot(parkingLots);
    }
}
