package com.nhom3.quanlyguixe.screens.shiftmanager;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.nhom3.quanlyguixe.data.model.ScheduleEmployee;
import com.nhom3.quanlyguixe.data.repo.ScheduleEmployeeRepository;
import com.nhom3.quanlyguixe.util.base.BaseViewModel;
import com.nhom3.quanlyguixe.util.interfaces.IResultListener;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class ShiftManagerViewModel extends BaseViewModel {
    private final ScheduleEmployeeRepository employeeRepository;

    private final MutableLiveData<List<ScheduleEmployee>> _scheduleListEmployees = new MutableLiveData<>();

    public LiveData<List<ScheduleEmployee>> getEmployees() {
        return _scheduleListEmployees;
    }


    @Inject
    public ShiftManagerViewModel(ScheduleEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;

    }

    public void insertEmployee(ScheduleEmployee employees) {
        registerDisposable(
                executeTaskWithLoading(
                        employeeRepository.insertEmployee(employees),
                        new IResultListener<Long>() {
                            @Override
                            public void onSuccess(Long data) {
                                _backToPreviousScreen.setValue(true);
                            }

                            @Override
                            public void onError(Throwable throwable) {
                                error.postValue(throwable.getMessage());
                            }
                        }
                )
        );
    }

    public void getAllEmployees() {
        registerDisposable(
                executeTaskWithLoading(
                        employeeRepository.getAllSchedule(),
                        new IResultListener<List<ScheduleEmployee>>() {
                            @Override
                            public void onSuccess(List<ScheduleEmployee> data) {
                                _scheduleListEmployees.setValue(data);
                            }

                            @Override
                            public void onError(Throwable throwable) {
                                error.postValue(throwable.getMessage());
                            }
                        }
                )
        );
    }


    public void updateEmployee(ScheduleEmployee employees) {
        registerDisposable(
                executeTaskWithLoading(
                        employeeRepository.updateEmployee(employees),
                        new IResultListener<Integer>() {
                            @Override
                            public void onSuccess(Integer data) {
                                _backToPreviousScreen.setValue(true);
                            }

                            @Override
                            public void onError(Throwable throwable) {
                                error.postValue(throwable.getMessage());
                            }
                        }
                )
        );
    }

    public void deleteEmployee(ScheduleEmployee employees) {
        registerDisposable(
                executeTaskWithLoading(
                        employeeRepository.deleteEmployee(employees),
                        new IResultListener<Integer>() {
                            @Override
                            public void onSuccess(Integer data) {

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
