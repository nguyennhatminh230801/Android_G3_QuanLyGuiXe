package com.nhom3.quanlyguixe.screens.main.home;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.nhom3.quanlyguixe.R;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class HomeViewModel extends ViewModel {
    private final List<ScreenEntry> listScreenEntries = Arrays.asList(
            new ScreenEntry(R.drawable.ic_employee, R.string.nav_list_employee_title, ScreenCategoryEnum.EMPLOYEE_SCREEN),
            new ScreenEntry(R.drawable.ic_parking_lots, R.string.nav_list_parking_lots_title, ScreenCategoryEnum.PARKING_LOTS_SCREEN),
            new ScreenEntry(R.drawable.ic_report, R.string.nav_reports_detail_title, ScreenCategoryEnum.REPORT_SCREEN),
            new ScreenEntry(R.drawable.ic_shift_manager, R.string.nav_list_shift_manager_title, ScreenCategoryEnum.SHIFT_MANAGER_SCREEN),
            new ScreenEntry(R.drawable.ic_ticket, R.string.nav_list_ticket_title, ScreenCategoryEnum.TICKET_SCREEN)
    );

    private final MutableLiveData<List<ScreenEntry>> screenEntries = new MutableLiveData<>();

    @Inject
    public HomeViewModel() {
        screenEntries.setValue(listScreenEntries);
    }

    public MutableLiveData<List<ScreenEntry>> getListScreenEntries() {
        return screenEntries;
    }
}