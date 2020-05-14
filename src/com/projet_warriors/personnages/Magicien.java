package com.projet_warriors.personnages;

import com.projet_warriors.personnages.Personnage;

public class Magicien extends Personnage {


    public Magicien() {
        super();
        this.vie = 3;
        this.force = 8;
    }

    public Magicien(String name) {
        super.nom = name;
        this.vie = 3;
        this.force = 8;
    }

    public Magicien(String name, int lifeLevel, int power) {
        super(name, lifeLevel, power);
    }


}
