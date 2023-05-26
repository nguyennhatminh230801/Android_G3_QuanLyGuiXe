package com.nhom3.quanlyguixe.di;

import com.nhom3.quanlyguixe.data.repo.UserRepository;
import com.nhom3.quanlyguixe.data.repo.remote.ApiService;
import com.nhom3.quanlyguixe.data.repo.remote.user.IUserRemoteDataSource;
import com.nhom3.quanlyguixe.data.repo.remote.user.UserRemoteDataSource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class RepositoryModule {
    @Provides
    @Singleton
    public UserRepository provideUserRepository(IUserRemoteDataSource iUserRemoteDataSource) {
        return new UserRepository(iUserRemoteDataSource);
    }

    @Provides
    @Singleton
    public IUserRemoteDataSource provideIUserRemoteDataSource(ApiService apiService) {
        return new UserRemoteDataSource(apiService);
    }
}
