package com.virgilio.mascotas.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.virgilio.mascotas.classes.Mascota;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(@Nullable Context context) {
        super(context, Config.DATABASE_NAME, null, Config.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String queryCreateTableMascotas = "CREATE TABLE IF NOT EXISTS " + Config.TABLE_MASCOTAS +
                " (" + Config.TABLE_MASCOTAS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Config.TABLE_MASCOTAS_NOMBRE + " TEXT, " +
                Config.TABLE_MASCOTAS_FOTO + " INTEGER)";

        String queryCreateTableLikesMascotas = "CREATE TABLE IF NOT EXISTS " + Config.TABLE_MASCOTAS_LIKES +
                " (" + Config.TABLE_MASCOTAS_LIKES_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Config.TABLE_MASCOTAS_LIKES_ID_MASCOTA + " INTEGER, " +
                Config.TABLE_MASCOTAS_LIKES_NUMERO_LIKES + " INTEGER, " +
                "FOREIGN KEY ( " + Config.TABLE_MASCOTAS_LIKES_ID_MASCOTA + " ) REFERENCES " + Config.TABLE_MASCOTAS + " ( " + Config.TABLE_MASCOTAS_ID + " ) )";

        sqLiteDatabase.execSQL( queryCreateTableMascotas );
        sqLiteDatabase.execSQL( queryCreateTableLikesMascotas );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Config.TABLE_MASCOTAS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Config.TABLE_MASCOTAS_LIKES);
        onCreate( sqLiteDatabase );
    }

    public ArrayList<Mascota> getMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<Mascota>();

        String query = "SELECT * FROM " + Config.TABLE_MASCOTAS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery( query, null );

        while ( result.moveToNext() ){
            Log.e( "id", String.valueOf(result.getInt(0) ));
            Mascota m = new Mascota( result.getInt(0), result.getInt( 2 ), result.getString( 1 ) );
            m.setRaiting( getLikes( m ) );
            mascotas.add( m );
        }

        db.close();

        return mascotas;
    }

    public ArrayList<Mascota> getRanking(){
        ArrayList<Mascota> mascotas = new ArrayList<Mascota>();

        String query = "SELECT  m.*, COUNT(*) AS cantidad " +
                    "FROM " + Config.TABLE_MASCOTAS + " m INNER JOIN " + Config.TABLE_MASCOTAS_LIKES + " ml ON m." + Config.TABLE_MASCOTAS_ID + " = ml." + Config.TABLE_MASCOTAS_LIKES_ID_MASCOTA +
                    " GROUP BY m." + Config.TABLE_MASCOTAS_ID +
                    " ORDER BY cantidad DESC" +
                    " LIMIT 5";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery( query, null );

        while ( result.moveToNext() ){
            Mascota m = new Mascota( result.getInt(0), result.getInt( 2 ), result.getString( 1 ) );
            m.setRaiting( result.getInt(3) );
            mascotas.add( m );
        }

        db.close();

        return mascotas;
    }

    public int getLikes(Mascota mascota){
        int likes = 0;
        String queryRanking = "SELECT COUNT(*) FROM " + Config.TABLE_MASCOTAS_LIKES + " WHERE " + Config.TABLE_MASCOTAS_LIKES_ID_MASCOTA + " = " + mascota.getId();
        SQLiteDatabase dbRanking = this.getWritableDatabase();
        Cursor resultRanking = dbRanking.rawQuery( queryRanking, null );
        while( resultRanking.moveToNext() ){
            likes = resultRanking.getInt(0);
        }
        dbRanking.close();
        return likes;
    }

    public void insertMascota(ContentValues contentValues){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert( Config.TABLE_MASCOTAS, null, contentValues );
        sqLiteDatabase.close();
    }

    public void insertLike(ContentValues contentValues){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert( Config.TABLE_MASCOTAS_LIKES, null, contentValues );
        sqLiteDatabase.close();
    }

    public void deleteMascotas(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete( Config.TABLE_MASCOTAS, null, null );
        sqLiteDatabase.close();
    }

    public void deleteLikes(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete( Config.TABLE_MASCOTAS_LIKES, null, null );
        sqLiteDatabase.close();
    }
}
