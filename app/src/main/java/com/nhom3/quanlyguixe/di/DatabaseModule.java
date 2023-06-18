package com.nhom3.quanlyguixe.di;

import android.content.Context;

import androidx.room.Room;

import com.nhom3.quanlyguixe.data.repo.local.employee.EmployeeDao;
import com.nhom3.quanlyguixe.data.repo.local.parkinglot.ParkingLotDao;
import com.nhom3.quanlyguixe.data.repo.local.ticket.TicketDao;
import com.nhom3.quanlyguixe.data.repo.local.vehicle.VehicleDao;
import com.nhom3.quanlyguixe.util.QuanLyGuiXeDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class DatabaseModule {

    @Provides
    @Singleton
    public QuanLyGuiXeDatabase provideQuanLyGuiXeDatabase(@ApplicationContext Context appContext) {
        return Room.databaseBuilder(
                appContext,
                QuanLyGuiXeDatabase.class,
                "QuanLyGuiXeDB"
        ).build();
    }

    @Provides
    @Singleton
    public EmployeeDao provideEmployeeDao(QuanLyGuiXeDatabase database) {
        return database.employeeDao();
    }

    @Provides
    @Singleton
    public TicketDao provideTicketDao(QuanLyGuiXeDatabase database) {
        return database.ticketDao();
    }

    @Provides
    @Singleton
    public ParkingLotDao provideParkingLotDao(QuanLyGuiXeDatabase database) {return database.parkingLotDao();}

    @Provides
    @Singleton
    public VehicleDao provideVehicleDao(QuanLyGuiXeDatabase database) {
        return database.vehicleDao();
    }
}
