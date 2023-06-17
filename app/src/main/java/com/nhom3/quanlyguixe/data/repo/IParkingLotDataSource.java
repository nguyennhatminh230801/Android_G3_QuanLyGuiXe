package com.nhom3.quanlyguixe.data.repo;

import com.nhom3.quanlyguixe.data.model.ParkingLots;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

public interface IParkingLotDataSource {
    interface Local {
        Single<List<ParkingLots>> getAllParkingLots();

        Single<ParkingLots> getParkingLotByID(int parkingLotID);

        Single<Long> insertParkingLot(ParkingLots parkingLots);

        Single<Integer> updateParkingLot(ParkingLots parkingLots);

        Single<Integer> deleteParkingLot(ParkingLots parkingLots);
    }
}
