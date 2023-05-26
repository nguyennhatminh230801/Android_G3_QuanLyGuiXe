package com.nhom3.quanlyguixe.data.repo.remote.user;

import com.nhom3.quanlyguixe.data.model.User;
import com.nhom3.quanlyguixe.data.repo.remote.ApiService;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;

public class UserRemoteDataSource implements IUserRemoteDataSource{

    private final ApiService apiService;

    @Inject
    public UserRemoteDataSource(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public Single<List<User>> getUsers() {
        return apiService.getUsers();
    }
}
