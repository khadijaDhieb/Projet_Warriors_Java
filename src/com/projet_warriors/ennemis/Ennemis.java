package com.projet_warriors.ennemis;

import com.projet_warriors.Case;
import com.projet_warriors.personnages.Guerrier;
import com.projet_warriors.personnages.Personnage;

public abstract class Ennemis extends Case {

    protected String nom ;
    protected int viePoints;
    protected int forcaAttaque;


    public Ennemis() {
        this.nom ="";
        this.viePoints=0;
        this.forcaAttaque=0;
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

    public int getForcaAttaque() {
        return forcaAttaque;
    }

    public void setForcaAttaque(int forcaAttaque) {
        this.forcaAttaque = forcaAttaque;
    }

    public void interact(Personnage perso){
        System.out.println(" Ouuups! Vous venez de tomber sur un " + this.nom + " ! Un combat s'engage ! ");

    }


    @Override
    public String toString() {
        return "Ennemis{" +
                "nom='" + nom + '\'' +
                ", viePoints=" + viePoints +
                ", forcaAttaque=" + forcaAttaque +
                '}';
    }
}
