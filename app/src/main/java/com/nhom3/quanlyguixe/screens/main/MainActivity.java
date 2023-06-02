package com.nhom3.quanlyguixe.screens.main;

import android.view.Menu;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.nhom3.quanlyguixe.R;
import com.nhom3.quanlyguixe.databinding.ActivityMainBinding;
import com.nhom3.quanlyguixe.util.base.BaseActivity;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends BaseActivity<ActivityMainBinding> {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    public ActivityMainBinding inflateViewBinding() {
        return ActivityMainBinding.inflate(getLayoutInflater());
    }

    //Khởi tạo màn hình, dữ liệu
    @Override
    protected void initScreenData() {
        //Khởi tạo thanh tiêu đề
        setSupportActionBar(viewBinding.appBarMain.toolbar);
        initNavigationDrawer();
        updateTitleToolBar("Quản lý nhà xe");
    }

    // Thêm các sự kiện
    @Override
    protected void addEvent() {

    }

    // Gán các biến ViewModel tiện cho việc cập nhật dữ liệu
    @Override
    protected void bindToViewModel() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    private void initNavigationDrawer() {
        DrawerLayout drawer = viewBinding.drawerLayout;
        NavigationView navigationView = viewBinding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration =
                new AppBarConfiguration.Builder(
                        R.id.nav_home,
                        R.id.nav_list_employee,
                        R.id.nav_list_shift_manager,
                        R.id.nav_list_tickets,
                        R.id.nav_list_parking_lots,
                        R.id.nav_reports_detail
                )
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    public void updateTitleToolBar(String title) {
        viewBinding.appBarMain.toolbar.setTitle(title);
    }
}