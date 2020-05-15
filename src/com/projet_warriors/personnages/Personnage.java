package com.projet_warriors.personnages;

import com.projet_warriors.armes.Arme;
import com.projet_warriors.potions.Potion;

public abstract class Personnage {

    protected String nom;
    protected int vie;
    protected int force;
    protected int maxForce;
    protected int maxVie;

    public Personnage() {
        this("");
    }

    public Personnage(String nom) {
        this(nom, 0, 0, 0, 0);
    }


    public Personnage(String name, int lifeLevel, int power, int maxV, int maxF) {
        this.nom = name;
        this.vie = lifeLevel;
        this.force = power;
        this.maxVie = maxV;
        this.maxForce = maxF;

    }


    public void addVie(int pPotion) {
        int pPoints = pPotion + this.vie;
        if (pPoints <= this.maxVie) {
            this.vie = pPoints;
        } else {
            this.vie = this.maxVie;
        }
        System.out.println(" Votre niveau de vie actuel est de : " + this.vie);
    }

    public void addForce(int pForce) {
        //System.out.println("test");
        int aForce = pForce + this.force;
        if (aForce <= this.maxForce) {
            this.force = aForce;
        } else {
            this.force = this.maxForce;
        }
        System.out.println(" Votre force actuel est de : " + this.force);
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
