package com.projet_warriors.personnages;

import com.projet_warriors.armes.Arme;

public class Guerrier extends Personnage {

    private Arme arme;


    public Guerrier() {
       this("");
    }

    public Guerrier(String name) {
        this(name ,5 , 5 , 10 , 10);
    }

    public Guerrier(String name, int lifeLevel, int power , int maxV , int maxF) {
        super(name , lifeLevel , power ,maxV , maxF , "bouclier");
        this.arme = new Arme();
    }

    public Arme getArme() {
        return arme;
    }

    public void setArme(Arme arme) {
        this.arme = arme;
    }

    @Override
    public String toString() {
        return  super.toString()+
                " , arme = " + arme  +
                '}';
    }

}
