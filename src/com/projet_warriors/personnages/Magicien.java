package com.projet_warriors.personnages;

import com.projet_warriors.armes.Armes;


public class Magicien extends Personnage {

    private Armes sort;
    private String philtre ;

    public Magicien() {
        this("");
    }

    public Magicien(String name) {
//        super(name , 3 , 8);
//        this.sort = new Armes() ;

        this(name , 3 , 8);

    }

    public Magicien(String name, int lifeLevel, int power) {
        super(name, lifeLevel, power);
        this.sort = new Armes() ;
    }

    public Armes getSort() {
        return sort;
    }

    public void setSort(Armes sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return  super.toString()+
                " , sort=" + sort +
                ", philtre='" + philtre + '\'' +
                '}';
    }
}
