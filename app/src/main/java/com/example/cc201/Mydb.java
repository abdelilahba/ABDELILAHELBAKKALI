package com.example.cc201;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class Mydb extends SQLiteOpenHelper {
    public static String DB_NAME = " societes.db";
    public static String TABLE_NAME = " societe";
    public static String COL1 = "id";
    public static String COL2 = "raisonsociale";
    public static String COL3 = "Secteur_activite";
    public static String COL4 = " nb_employe";

    public Mydb(Context c) {
        super(c, DB_NAME, null, 1);


    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String req = "CREATE TABLE " + TABLE_NAME + "(" + COL1 + " integer primary key autoincrement," + COL2 + " text," + COL3 + " text," + COL4 + "integer)";
        sqLiteDatabase.execSQL(req);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql= "DROP TABLE " + TABLE_NAME;
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);

    }

    public static long ajouter_societe(SQLiteDatabase sqLiteDatabase, Societe e) {
        ContentValues ct = new ContentValues();
        ct.put(COL2, e.getNom());
        ct.put(COL3, e.getSecteurActivit√©());
        ct.put(COL4, e.getNombreemploy√©());
        return sqLiteDatabase.insert(TABLE_NAME, null, ct);
    }

    public static long modifier_societe(SQLiteDatabase sqLiteDatabase, Societe e) {
        ContentValues c = new ContentValues();
        c.put(COL2, e.getNom());
        c.put(COL3, e.getSecteurActivit√©());
        c.put(COL4, e.getNombreemploy√©());
        return sqLiteDatabase.update(TABLE_NAME, c, "id=" + e.getId(), null);
    }

    public static long supprime_societe(SQLiteDatabase sqLiteDatabase, int id) {
        return sqLiteDatabase.delete(TABLE_NAME, "id=" + id, null);
    }

    public static ArrayList<Societe> recuperertous_societe(SQLiteDatabase db) {
        ArrayList<Societe> societes = new ArrayList<>();

        Cursor cur = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        while (cur.moveToNext()) {
            Societe e = new Societe();
            e.setId(cur.getInt(0));
            e.setNom(cur.getString(1));
            e.setSecteurActivit√©(cur.getString(2));
            e.setNombreemploy√©(cur.getInt(3));
            societes.add(e);
        }
        return societes;
    }
    public static Societe recupereunesocite(SQLiteDatabase sqLiteDatabase, int id){
        Societe s = null;

        Cursor cur = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE id = " + id,null);

        if(cur.moveToNext()){
            s = new Societe();
            s.setId(cur.getInt(0));
            s.setNom(cur.getString(1));
            s.setSecteurActivit√©(cur.getString(2));
            s.setNombreemploy√©(cur.getInt(3));
        }

        return s;
    }
}

