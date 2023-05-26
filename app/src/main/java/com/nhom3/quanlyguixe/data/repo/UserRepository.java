package com.nhom3.quanlyguixe.data.repo;

import com.nhom3.quanlyguixe.data.model.User;
import com.nhom3.quanlyguixe.data.repo.remote.user.IUserRemoteDataSource;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;

public class UserRepository implements IUserRemoteDataSource {

    private final IUserRemoteDataSource remote;

    public @Inject UserRepository(IUserRemoteDataSource iUserRemoteDataSource) {
        this.remote = iUserRemoteDataSource;
    }

    @Override
    public Single<List<User>> getUsers() {
        return remote.getUsers();
    }
}
