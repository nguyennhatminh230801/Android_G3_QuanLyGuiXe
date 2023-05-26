package com.nhom3.quanlyguixe.screens.main;

import android.widget.Toast;

import androidx.lifecycle.ViewModelProvider;

import com.nhom3.quanlyguixe.data.model.User;
import com.nhom3.quanlyguixe.databinding.ActivityMainBinding;
import com.nhom3.quanlyguixe.util.base.BaseActivity;

import java.util.Objects;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends BaseActivity<ActivityMainBinding> {

    private MainViewModel mainViewModel;

    @Override
    public ActivityMainBinding inflateViewBinding() {
        return ActivityMainBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initScreenData() {
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        mainViewModel.getAllUsers();
    }

    @Override
    protected void addEvent() {
        viewBinding.buttonLogin.setOnClickListener(view -> {
            User user = new User();
            user.setUsername(Objects.requireNonNull(viewBinding.inputLayoutUsername.getEditText()).getText().toString());
            user.setPassword(Objects.requireNonNull(viewBinding.inputLayoutPassword.getEditText()).getText().toString());

            boolean hasUserName = false;

            if (mainViewModel.getListUsers().getValue() != null) {
                for (User user1 : mainViewModel.getListUsers().getValue()) {
                    if (user1.getPassword().equals(user.getPassword())
                            && user1.getUsername().equals(user.getUsername())) {
                        hasUserName = true;
                        break;
                    }
                }

                if (hasUserName) {
                    Toast.makeText(getBaseContext(), "Thành công!!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getBaseContext(), "Thất bại!!", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getBaseContext(), "Không có dữ liệu!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void bindToViewModel() {
        mainViewModel.checkHasError().observe(this, error -> {
            Toast.makeText(getBaseContext(), error, Toast.LENGTH_SHORT).show();
        });
    }
}