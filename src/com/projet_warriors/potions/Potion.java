package com.projet_warriors.potions;

import com.projet_warriors.Case;

public class Potion extends Case {

    protected String nom;
    protected int viePoints ;

    public Potion() {
        this.nom="potion de vie";
        this.viePoints = 0;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getViePoints() {
        return viePoints;
    }

    public void setViePoints(int viePoints) {
        this.viePoints = viePoints;
    }

    @Override
    public String toString() {
        return "Potion{" +
                "nom='" + nom + '\'' +
                ", viePoints=" + viePoints +
                '}';
    }
}
