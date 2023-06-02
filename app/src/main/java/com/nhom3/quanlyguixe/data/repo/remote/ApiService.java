package com.nhom3.quanlyguixe.data.repo.remote;


import com.nhom3.quanlyguixe.data.model.User;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface ApiService {

    @GET("api/v1/user")
    Single<List<User>> getUsers();
}
