package com.nhom3.quanlyguixe.screens.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.nhom3.quanlyguixe.data.model.User;
import com.nhom3.quanlyguixe.data.repo.UserRepository;
import com.nhom3.quanlyguixe.util.base.BaseViewModel;
import com.nhom3.quanlyguixe.util.interfaces.IResultListener;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class MainViewModel extends BaseViewModel {

    private final MutableLiveData<List<User>> listUsers = new MutableLiveData<>();

    private final UserRepository userRepository;

    @Inject
    public MainViewModel(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public LiveData<List<User>> getListUsers() {
        return listUsers;
    }

    public void getAllUsers() {
        registerDisposable(
                executeTaskWithLoading(
                        userRepository.getUsers(),
                        new IResultListener<List<User>>() {
                            @Override
                            public void onSuccess(List<User> data) {
                                listUsers.postValue(data);
                            }

                            @Override
                            public void onError(Throwable throwable) {
                                error.postValue(throwable.getMessage());
                            }
                        }
                )
        );
    }
}
