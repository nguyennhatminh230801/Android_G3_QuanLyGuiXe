package com.nhom3.quanlyguixe.di.feature.employee;

import com.nhom3.quanlyguixe.data.repo.EmployeeRepository;
import com.nhom3.quanlyguixe.data.repo.IEmployeeDataSource;
import com.nhom3.quanlyguixe.data.repo.local.employee.EmployeeDao;
import com.nhom3.quanlyguixe.data.repo.local.employee.EmployeeLocalDataSource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class EmployeeFeatureModule {

    @Singleton
    @Provides
    public IEmployeeDataSource.Local provideEmployeeLocalDataSource(EmployeeDao employeeDao) {
        return new EmployeeLocalDataSource(employeeDao);
    }

    @Singleton
    @Provides
    public EmployeeRepository provideEmployeeRepository(IEmployeeDataSource.Local employeeLocalDataSource) {
        return new EmployeeRepository(employeeLocalDataSource);
    }
}
