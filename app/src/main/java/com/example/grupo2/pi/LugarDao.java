package com.example.grupo2.pi;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Delete;
import java.util.List;

@Dao
public interface LugarDao {
    @Query("SELECT * FROM lugar")
    List<Lugar> getAll();

    @Query("SELECT * FROM lugar WHERE id IN (:lugarIds)")
    List<Lugar> loadAllByIds(int[] lugarIds);

    //@Query("SELECT * FROM evento WHERE nombre LIKE :name AND " + "lugar LIKE :place LIMIT 1")
    @Query("SELECT * FROM lugar WHERE nombre LIKE :name LIMIT 1")
    Lugar findByName(String name);

    @Query("SELECT * FROM lugar WHERE id = :id LIMIT 1")
    Lugar findById(int id);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAll(Lugar... lugares);

    @Delete
    void delete(Lugar lugar);
}
