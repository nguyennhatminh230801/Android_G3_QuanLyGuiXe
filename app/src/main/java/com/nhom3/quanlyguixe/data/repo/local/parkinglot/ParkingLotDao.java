package com.nhom3.quanlyguixe.data.repo.local.parkinglot;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.nhom3.quanlyguixe.data.model.ParkingLots;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

@Dao
public interface ParkingLotDao {

    @Query("SELECT * FROM parkinglots")
    Single<List<ParkingLots>> getAllParkingLots();

    @Query("SELECT * FROM parkinglots WHERE parkinglotID = :parkinglotID")
    Single<ParkingLots> getParkingLotByID(int parkinglotID);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Single<Long> insertParkingLot(ParkingLots parkinglots);

    @Update
    Single<Integer> updateParkingLot(ParkingLots parkinglots);

    @Delete
    Single<Integer> deleteParkingLot(ParkingLots parkinglots);
}
