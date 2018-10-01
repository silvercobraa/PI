package com.example.grupo2.pi;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import static android.widget.Toast.*;

public class Base extends AsyncTask<Void, Void, Void> {
    String mensaje, error;

    public String getMensaje(){
        return mensaje;
    }
    public String getError(){
        return error;
    }

    public Base(){

    }

    @Override
    protected Void doInBackground(Void... voids) {
        return null;
    }

    public void ConectarBaseDeDatos() {
        Log.i("Hola", "Chao");
        String url = "jdbc:postgresql://plop.inf.udec.cl/bdi2017d";
        String dbname = "bdi2017d";
        String user = "bdi2017d";
        String password = "bdi2017d";
        Log.i("Holaaa", "Chaoooo");

        try{
            Class.forName("org.postgresql.Driver");
            mensaje = "conecta1";
            Connection con = DriverManager.getConnection(url, user, password);
            mensaje = "conecta2";
            Log.i("Conectado", "Entré a la base");
            Log.i("Desconectado", "Me sale");

            Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery("select usar from Usuario.user");
            while(rs.next()){
                String coffeName = rs.getString("user");
            }

        } catch(Exception e){
            Log.i("nonononono", "nonono"+e.getMessage());
            e.printStackTrace();
            error = e.getClass().getName() + ": " + e.getMessage();
        }

    }

}
