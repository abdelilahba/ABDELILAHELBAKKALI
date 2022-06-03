package com.example.cc201;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class EditerSociete extends AppCompatActivity {
    Spinner sp;
    Mydb db;
    EditText ed1,ed2,ed3;
    ArrayList<Societe> societes;
    ArrayAdapter n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editer_societe);

        db=new Mydb(this);
        sp=findViewById(R.id.sp);
        ed1=findViewById(R.id.ed1);
        societes= Mydb.recuperertous_societe(db.getReadableDatabase());
        ed2=findViewById(R.id.ed2);
        ed3=findViewById(R.id.ed3);
        ArrayList<Societe> a =Mydb.recuperertous_societe(db.getReadableDatabase());
        ArrayList<String> s =new ArrayList<>();
        for(Societe e : a){
            s.add(e.getId()+"-"+e.getNom());
        }
        n = new ArrayAdapter(this,R.layout.activity_editer_societe,s);
        sp.setAdapter(n);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Societe s = societes.get(i);
                ed1.setText(s.getNom());
                ed2.setText(s.getSecteurActivité());
                ed3.setText(Integer.valueOf(s.Nombreemployé));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    public void supprime(View view) {
        AlertDialog.Builder alert = new AlertDialog.Builder(EditerSociete.this);
        alert.setTitle("Suppresion une societe ");
        alert.setMessage("VOUS ETES VRAIMENT SUR ?");

        alert.setPositiveButton("Supprime", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Societe p = societes.get(sp.getSelectedItemPosition());

                if(Mydb.supprime_societe(db.getWritableDatabase(),p.getId())==-1)
                    Toast.makeText(EditerSociete.this, "suppression echoue", Toast.LENGTH_SHORT).show();
                else {
                    Toast.makeText(EditerSociete.this, "Suppression avec succes reussie", Toast.LENGTH_SHORT).show();
                    n.remove(p.getId() + " - " + p.getNom());
                }
            }
        });

        alert.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(EditerSociete.this, "votre tentative est annuler ", Toast.LENGTH_SHORT).show();
            }
        });

        alert.show();


    }

    public void modifier(View view) {
        AlertDialog.Builder alert = new AlertDialog.Builder(EditerSociete.this);
        alert.setTitle("Modifier la societe ");
        alert.setMessage("Voulez-vous modifier cette entreprise  ?");
        alert.setPositiveButton("Modifier", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Societe e = societes.get(sp.getSelectedItemPosition());

                e.setNom(ed1.getText().toString());
                e.setSecteurActivité(ed2.getText().toString());
                e.setNombreemployé(Integer.valueOf(ed3.getText().toString()));

                if(Mydb.modifier_societe(db.getWritableDatabase(),e)==-1)
                    Toast.makeText(EditerSociete.this, "Modification echoue", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(EditerSociete.this, "Modification reussie", Toast.LENGTH_SHORT).show();
            }
        });
        alert.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(EditerSociete.this, "vous etes annuler ", Toast.LENGTH_SHORT).show();
            }
        });

        alert.show();
    }
}