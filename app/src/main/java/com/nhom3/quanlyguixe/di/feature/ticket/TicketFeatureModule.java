package com.nhom3.quanlyguixe.di.feature.ticket;

import com.nhom3.quanlyguixe.data.repo.ITicketDataSource;
import com.nhom3.quanlyguixe.data.repo.TicketRepository;
import com.nhom3.quanlyguixe.data.repo.local.ticket.TicketDao;
import com.nhom3.quanlyguixe.data.repo.local.ticket.TicketLocalDataSource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class TicketFeatureModule {

    @Singleton
    @Provides
    public ITicketDataSource.Local provideTicketLocalDataSource(TicketDao ticketDao) {
        return new TicketLocalDataSource(ticketDao);
    }

    @Singleton
    @Provides
    public TicketRepository provideTicketRepository(ITicketDataSource.Local ticketLocalDataSource) {
        return new TicketRepository(ticketLocalDataSource);
    }
}
