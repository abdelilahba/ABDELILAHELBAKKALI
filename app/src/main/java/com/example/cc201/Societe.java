package com.example.cc201;

import java.io.Serializable;

public class Societe  implements Serializable {
    public  int id;
    public String Nom;
    public String SecteurActivité;
    public int Nombreemployé;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getSecteurActivité() {
        return SecteurActivité;
    }

    public void setSecteurActivité(String secteurActivité) {
        SecteurActivité = secteurActivité;
    }

    public int getNombreemployé() {
        return Nombreemployé;
    }

    public void setNombreemployé(int nombreemployé) {
        Nombreemployé = nombreemployé;
    }
}
