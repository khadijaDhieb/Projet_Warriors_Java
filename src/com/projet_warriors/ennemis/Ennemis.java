package com.projet_warriors.ennemis;

public abstract class Ennemis {

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
}
