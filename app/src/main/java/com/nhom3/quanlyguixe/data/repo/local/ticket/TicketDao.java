package com.nhom3.quanlyguixe.data.repo.local.ticket;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.nhom3.quanlyguixe.data.model.Tickets;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

@Dao
public interface TicketDao {

    @Query("SELECT * FROM tickets")
    Single<List<Tickets>> getAllTickets();

    @Query("SELECT * FROM tickets WHERE ticketID = :ticketID")
    Single<Tickets> getTicketByID(int ticketID);

    @Insert
    Single<Long> insertTicket(Tickets tickets);

    @Update
    Single<Integer> updateTicket(Tickets tickets);

    @Delete
    Single<Integer> deleteTicket(Tickets tickets);
}
