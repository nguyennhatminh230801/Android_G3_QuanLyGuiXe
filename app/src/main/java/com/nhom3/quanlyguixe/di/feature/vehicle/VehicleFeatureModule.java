package com.nhom3.quanlyguixe.di.feature.vehicle;

import com.nhom3.quanlyguixe.data.repo.IVehicleDataSource;
import com.nhom3.quanlyguixe.data.repo.VehicleRepository;
import com.nhom3.quanlyguixe.data.repo.local.vehicle.VehicleDao;
import com.nhom3.quanlyguixe.data.repo.local.vehicle.VehicleLocalDataSource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class VehicleFeatureModule {

    @Singleton
    @Provides
    public IVehicleDataSource.Local provideVehicleLocalDataSource(VehicleDao vehicleDao) {
        return new VehicleLocalDataSource(vehicleDao);
    }

    @Singleton
    @Provides
    public VehicleRepository provideVehicleRepository(IVehicleDataSource.Local vehicleLocalDataSource) {
        return new VehicleRepository(vehicleLocalDataSource);
    }
}
