package com.nhom3.quanlyguixe.data.repo.local.employee;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.nhom3.quanlyguixe.data.model.Employees;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

@Dao
public interface EmployeeDao {

    @Query("SELECT * FROM employees")
    Single<List<Employees>> getAllEmployees();

    @Query("SELECT * FROM employees WHERE employeeID = :employeeID")
    Single<Employees> getEmployeeByID(int employeeID);

    @Insert
    Single<Long> insertEmployee(Employees employees);

    @Update
    Single<Integer> updateEmployee(Employees employees);

    @Delete
    Single<Integer> deleteEmployee(Employees employees);
}
