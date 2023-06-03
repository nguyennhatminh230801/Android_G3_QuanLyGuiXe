package com.nhom3.quanlyguixe.screens.tickets;

import com.nhom3.quanlyguixe.data.model.Tickets;
import com.nhom3.quanlyguixe.data.repo.TicketRepository;
import com.nhom3.quanlyguixe.util.base.BaseViewModel;
import com.nhom3.quanlyguixe.util.interfaces.IResultListener;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class TicketViewModel extends BaseViewModel {

    private final TicketRepository ticketRepository;

    @Inject
    public TicketViewModel(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public void getAllTickets() {
        registerDisposable(
                executeTaskWithLoading(
                        ticketRepository.getAllTickets(),
                        new IResultListener<List<Tickets>>() {
                            @Override
                            public void onSuccess(List<Tickets> data) {

                            }

                            @Override
                            public void onError(Throwable throwable) {

                            }
                        }
                )
        );
    }

    public void insertTicket(Tickets tickets) {
        registerDisposable(
                executeTaskWithLoading(
                        ticketRepository.insertTicket(tickets),
                        new IResultListener<Long>() {
                            @Override
                            public void onSuccess(Long data) {

                            }

                            @Override
                            public void onError(Throwable throwable) {

                            }
                        }
                )
        );
    }

    public void updateTicket(Tickets tickets) {
        registerDisposable(
                executeTaskWithLoading(
                        ticketRepository.updateTicket(tickets),
                        new IResultListener<Integer>() {
                            @Override
                            public void onSuccess(Integer data) {

                            }

                            @Override
                            public void onError(Throwable throwable) {

                            }
                        }
                )
        );
    }

    public void deleteTicket(Tickets tickets) {
        registerDisposable(
                executeTaskWithLoading(
                        ticketRepository.deleteTicket(tickets),
                        new IResultListener<Integer>() {
                            @Override
                            public void onSuccess(Integer data) {
                            }

                            @Override
                            public void onError(Throwable throwable) {

                            }
                        }
                )
        );
    }
}
