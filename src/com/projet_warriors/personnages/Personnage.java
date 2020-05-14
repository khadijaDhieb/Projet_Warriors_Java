package com.projet_warriors.personnages;

public abstract class Personnage {

    protected String nom;
    protected int vie;
    protected int force;


    public Personnage(){
        this("");
    }

    public Personnage(String nom) {
        this(nom , 0 , 0);
    }


    public Personnage(String name, int lifeLevel, int power) {
        this.nom= name;
        this.vie = lifeLevel;
        this.force = power;
    }



    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getVie() {
        return vie;
    }

    public void setVie(int vie) {
        this.vie = vie;
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }


    @Override
    public String toString() {
        return "Mon Hero : {" +
                "nom='" + nom + '\'' +
                ", vie=" + vie +
                ", force=" + force
                ;
    }
}
