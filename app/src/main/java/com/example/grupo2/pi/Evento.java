package com.example.grupo2.pi;
import android.support.annotation.NonNull;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import static android.arch.persistence.room.ForeignKey.CASCADE;

// parentColumns pertenece a la tabla referenciada
// childColumns pertenece a la tabla referenciadora
@Entity(foreignKeys = @ForeignKey(entity = Lugar.class,
        parentColumns = "id",
        childColumns = "lugarId",
        onDelete = CASCADE))
public class Evento {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int uid;

    @ColumnInfo(name = "nombre")
    private String nombre;

    @ColumnInfo(name = "lugarId")
    private int lugarId;

    public Evento(String nombre, int lugarId) {
        this.nombre = nombre;
        this.lugarId = lugarId;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLugarId() {
        return lugarId;
    }

    public void setLugarId(int lugarId) {
        this.lugarId = lugarId;
    }

    // Getters and setters are ignored for brevity,
    // but they're required for Room to work.
}
