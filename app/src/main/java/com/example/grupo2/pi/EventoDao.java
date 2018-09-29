package com.example.grupo2.pi;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Delete;
import java.util.List;

@Dao
public interface EventoDao {
    @Query("SELECT * FROM evento")
    List<Evento> getAll();

    @Query("SELECT * FROM evento WHERE uid IN (:userIds)")
    List<Evento> loadAllByIds(int[] userIds);

    //@Query("SELECT * FROM evento WHERE nombre LIKE :name AND " + "lugar LIKE :place LIMIT 1")
    @Query("SELECT * FROM evento WHERE nombre LIKE :name LIMIT 1")
    Evento findByName(String name);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAll(Evento... eventos);

    @Delete
    void delete(Evento evento);
}
