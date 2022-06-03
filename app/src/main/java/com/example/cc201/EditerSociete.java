package com.example.cc201;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class EditerSociete extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editer_societe);
        Spinner sp;
        Mydb db;
        EditText ed1,ed2,ed3;
        ArrayList<Societe> societes;
        ArrayAdapter n;
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


    }
}