package com.projet_warriors;

import com.projet_warriors.personnages.Personnage;

public abstract class Case {

    protected String nom ;

    public Case() {
        this.nom = "";
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void interact(Personnage perso){
    }

    @Override
    public String toString() {
        return "Case{" +
                "nom='" + nom + '\'' +
                '}';
    }
}
