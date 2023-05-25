package com.nhom3.quanlyguixe.di;

import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class DatabaseModule {

//    @Provides
//    @Singleton
//    public QuanLyGuiXeDatabase provideQuanLyGuiXeDatabase(@ApplicationContext Context appContext) {
//        return Room.databaseBuilder(
//                appContext,
//                QuanLyGuiXeDatabase.class,
//                "QuanLyGuiXeDB"
//        ).build();
//    }
}
