package com.example.grupo2.pi;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Evento.class, Lugar.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract EventoDao eventoDao();
    public abstract LugarDao lugarDao();
}
