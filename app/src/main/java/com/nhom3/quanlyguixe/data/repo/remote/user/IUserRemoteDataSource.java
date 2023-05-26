package com.nhom3.quanlyguixe.data.repo.remote.user;

import com.nhom3.quanlyguixe.data.model.User;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

public interface IUserRemoteDataSource {
    Single<List<User>> getUsers();
}
