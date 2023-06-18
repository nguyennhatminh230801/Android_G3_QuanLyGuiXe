package com.nhom3.quanlyguixe.util;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.nhom3.quanlyguixe.data.model.Employees;
import com.nhom3.quanlyguixe.data.model.ParkingLots;
import com.nhom3.quanlyguixe.data.model.Tickets;
import com.nhom3.quanlyguixe.data.model.Vehicle;
import com.nhom3.quanlyguixe.data.model.typeconverter.DateConverter;
import com.nhom3.quanlyguixe.data.model.typeconverter.TicketConverter;
import com.nhom3.quanlyguixe.data.repo.local.employee.EmployeeDao;
import com.nhom3.quanlyguixe.data.repo.local.parkinglot.ParkingLotDao;
import com.nhom3.quanlyguixe.data.repo.local.ticket.TicketDao;
import com.nhom3.quanlyguixe.data.repo.local.vehicle.VehicleDao;

@Database(entities = {Employees.class, Tickets.class, ParkingLots.class, Vehicle.class}, version = 1)
@TypeConverters({DateConverter.class, TicketConverter.class})
public abstract class QuanLyGuiXeDatabase extends RoomDatabase {
    public abstract EmployeeDao employeeDao();

    public abstract TicketDao ticketDao();

    public abstract ParkingLotDao parkingLotDao();

    public abstract VehicleDao vehicleDao();
}
