package com.virgilio.mascotas.db;

import android.content.ContentValues;
import android.content.Context;

import com.virgilio.mascotas.R;
import com.virgilio.mascotas.classes.Mascota;

import java.util.ArrayList;

public class ConstructorRanking {

    private Context context;

    public ConstructorRanking(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> getRanking(){

        BaseDatos db = new BaseDatos( context );
        return db.getRanking();
    }

    public void insertMascotas( BaseDatos db ){
        ContentValues contentValues = new ContentValues();
        contentValues.put( Config.TABLE_MASCOTAS_NOMBRE, "Ragnar" );
        contentValues.put( Config.TABLE_MASCOTAS_FOTO, R.drawable.app1 );
        db.insertMascota( contentValues );

        contentValues = new ContentValues();
        contentValues.put( Config.TABLE_MASCOTAS_NOMBRE, "Dogui" );
        contentValues.put( Config.TABLE_MASCOTAS_FOTO, R.drawable.app8 );
        db.insertMascota( contentValues );

        contentValues = new ContentValues();
        contentValues.put( Config.TABLE_MASCOTAS_NOMBRE, "Manini" );
        contentValues.put( Config.TABLE_MASCOTAS_FOTO, R.drawable.app2 );
        db.insertMascota( contentValues );
    }
}
