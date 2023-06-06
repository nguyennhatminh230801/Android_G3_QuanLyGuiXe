package com.nhom3.quanlyguixe.data.repo;

import com.nhom3.quanlyguixe.data.model.Employees;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

public interface IEmployeeDataSource {
    interface Local {
        Single<List<Employees>> getAllEmployees();
        Single<Employees> getEmployeeByID(int employeeID);
        Single<Long> insertEmployee(Employees employees);
        Single<Integer> updateEmployee(Employees employees);
        Single<Integer> deleteEmployee(Employees employees);
    }

    interface Remote {

    }
}
