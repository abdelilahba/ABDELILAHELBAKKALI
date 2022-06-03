package com.example.cc201;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class ListeSocietes extends AppCompatActivity {
   ListView lst;
    Mydb db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_societes);
        lst=findViewById(R.id.transition_layout_save);
        db=new Mydb(this);
        db=new Mydb(this);
        ArrayList<Societe> e =Mydb.recuperertous_societe(db.getReadableDatabase());
        ArrayList<HashMap<String,Object>> h = new ArrayList<>();
        for(Societe ec : e){
            HashMap<String,Object> b =new HashMap<>();
            b.put("Nom",ec.getNom());
            b.put("nbemploye",ec.getNombreemployé());
            h.add(b);
        }
        String[] from = {"Nom","nbemploye"};
        int [] to ={R.id.txtnom,R.id.txtnbemploye};
        SimpleAdapter b = new SimpleAdapter(this,h,R.layout.tous_societes,from,to);
        lst.setAdapter(b);

    }
}