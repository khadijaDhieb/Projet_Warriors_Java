package com.projet_warriors;

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

    @Override
    public String toString() {
        return "Case{" +
                "nom='" + nom + '\'' +
                '}';
    }
}
