package com.projet_warriors.personnages;

import com.projet_warriors.armes.Arme;

public class Guerrier extends Personnage {

    private Arme arme;
    private String bouclier ;

    public Guerrier() {
       this("");
    }

    public Guerrier(String name) {
        this(name ,5 , 5 , 10 , 10);
    }

    public Guerrier(String name, int lifeLevel, int power , int maxV , int maxF) {
        super(name , lifeLevel , power ,maxV , maxF );
        this.arme = new Arme();
        this.bouclier="bouclier";
    }

    public Arme getArme() {
        return arme;
    }

    public void setArme(Arme arme) {
        this.arme = arme;
    }
    public String getBouclier() {
        return bouclier;
    }

    public void setBouclier(String bouclier) {
        this.bouclier = bouclier;
    }

    @Override
    public String toString() {
        return  super.toString()+
                " , arme = " + arme +
                ", bouclier='" + bouclier + '\'' +
                '}';
    }

}
