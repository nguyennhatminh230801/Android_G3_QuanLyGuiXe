package com.nhom3.quanlyguixe.di;

import android.content.Context;

import androidx.room.Room;

import com.nhom3.quanlyguixe.util.QuanLyGuiXeDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class DatabaseModule {

    @Provides
    @Singleton
    public QuanLyGuiXeDatabase provideQuanLyGuiXeDatabase(@ApplicationContext Context appContext) {
        return Room.databaseBuilder(
                appContext,
                QuanLyGuiXeDatabase.class,
                "QuanLyGuiXeDB"
        ).build();
    }
}
