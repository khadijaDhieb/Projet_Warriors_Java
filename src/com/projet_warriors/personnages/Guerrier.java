package com.projet_warriors.personnages;

import com.projet_warriors.armes.Armes;

public class Guerrier extends Personnage {

    private Armes arme;
    private String bouclier ;

    public Guerrier() {
        super.nom="";
        super.vie=5;
        super.force=5;
        this.arme = new Armes() ;
    }


    public Guerrier(String name) {
        super.nom = name;
        super.vie = 5 ;
        super.force=5;
        this.arme = new Armes() ;
    }

    public Guerrier(String name, int lifeLevel, int power) {
        super(name , lifeLevel , power);
        this.arme = new Armes() ;
    }

    public Armes getArmes() {
        return arme;
    }

    public void setArmes(Armes armes) {
        this.arme = armes;
    }

    @Override
    public String toString() {
        return  super.toString()+
                " , arme = " + arme +
                ", bouclier='" + bouclier + '\'' +
                '}';
    }

}
