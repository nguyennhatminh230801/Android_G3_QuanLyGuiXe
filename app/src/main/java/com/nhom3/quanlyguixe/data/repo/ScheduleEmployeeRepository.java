package com.nhom3.quanlyguixe.data.repo;

import com.nhom3.quanlyguixe.data.model.ScheduleEmployee;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;

public class ScheduleEmployeeRepository implements IScheduleEmployeeDataSource.Local{


    private final IScheduleEmployeeDataSource.Local local;

    @Inject
    public ScheduleEmployeeRepository(IScheduleEmployeeDataSource.Local local) {
        this.local = local;
    }


    @Override
    public Single<List<ScheduleEmployee>> getAllSchedule() {
        return local.getAllSchedule();
    }

    @Override
    public Single<Long> insertEmployee(ScheduleEmployee employees) {
        return local.insertEmployee(employees);
    }

    @Override
    public Single<Integer> updateEmployee(ScheduleEmployee employees) {
        return local.updateEmployee(employees);
    }

    @Override
    public Single<Integer> deleteEmployee(ScheduleEmployee employees) {
        return local.deleteEmployee(employees);
    }
}
