package com.projet_warriors.armes;

import com.projet_warriors.Case;

public class Armes extends Case {

    protected String nom ;
    protected int forceAttaque;

    public Armes() {
        this.nom = "arme";
        this.forceAttaque =0;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getForceAttaque() {
        return forceAttaque;
    }

    public void setForceAttaque(int forceAttaque) {
        this.forceAttaque = forceAttaque;
    }


    @Override
    public String toString() {
        return "Armes{" +
                "nom='" + nom + '\'' +
                ", forceAttaque=" + forceAttaque +
                '}';
    }
}
