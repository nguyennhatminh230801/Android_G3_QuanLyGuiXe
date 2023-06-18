package com.nhom3.quanlyguixe.data.model.typeconverter;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nhom3.quanlyguixe.data.model.Tickets;

import java.lang.reflect.Type;

public class TicketConverter {

    @TypeConverter
    public Tickets toTickets(String json) {
        Type typeToken = new TypeToken<Tickets>() {}.getType();
        return new Gson().fromJson(json, typeToken);
    }

    @TypeConverter
    public String fromTickets(Tickets tickets) {
        return new Gson().toJson(tickets);
    }
}
