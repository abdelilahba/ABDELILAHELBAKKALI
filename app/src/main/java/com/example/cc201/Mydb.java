package com.example.cc201;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Mydb extends SQLiteOpenHelper {
    public static String DB_NAME=" societes.db";
    public static String T_NAME=" societe";
    public static String COL1="id";
    public static String COL2="raisonsociale";
    public static String COL3=" nb_employe";

    public Mydb(Context c){
        super(c,DB_NAME,null,1);


    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
