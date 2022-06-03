package com.example.cc201;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AjouterSociete extends AppCompatActivity {
    EditText e1, e2, e3;
    Mydb db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_societe);
        db = new Mydb(this);
        e1 = findViewById(R.id.ed1);
        e2 = findViewById(R.id.ed2);
        e3 = findViewById(R.id.ed3);
    }

    public void annuler(View view) {
        finish();
    }

    public void enregistrer(View view) {
        Societe p = new Societe();

        p.setNom(e1.getText().toString());
        p.setSecteurActivité(e2.getText().toString());
        p.setNombreemployé(Integer.valueOf(e3.getText().toString()));

        if (Mydb.ajouter_societe(db.getWritableDatabase(),p) == -1){
            Toast.makeText(this, "L'insertion echoue ", Toast.LENGTH_SHORT).show();
            return;

        }
            Toast.makeText(this, "Insertion avec succes ", Toast.LENGTH_SHORT).show();
    }
}