package com.projet_warriors.personnages;

import com.projet_warriors.personnages.Personnage;

public class Guerrier extends Personnage {


    public Guerrier() {
        this.vie=5;
        this.force=5;
    }


    public Guerrier(String name) {
        this.nom = name;
        this.vie = 5 ;
        this.force=5;
    }

    public Guerrier(String name, int lifeLevel, int power) {
        super();
    }


}
