package com.nhom3.quanlyguixe.data.repo;

import com.nhom3.quanlyguixe.data.model.ScheduleEmployee;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

public interface IScheduleEmployeeDataSource {
    interface Local {
        Single<List<ScheduleEmployee>> getAllSchedule();
        Single<Long> insertEmployee(ScheduleEmployee employees);
        Single<Integer> updateEmployee(ScheduleEmployee employees);
        Single<Integer> deleteEmployee(ScheduleEmployee employees);
    }
}


