package com.nhom3.quanlyguixe.util;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.nhom3.quanlyguixe.data.model.Employees;
import com.nhom3.quanlyguixe.data.model.typeconverter.DateConverter;
import com.nhom3.quanlyguixe.data.repo.local.employee.EmployeeDao;

@Database(entities = {Employees.class}, version = 1)
@TypeConverters({DateConverter.class})
public abstract class QuanLyGuiXeDatabase extends RoomDatabase {
    public abstract EmployeeDao employeeDao();
}
