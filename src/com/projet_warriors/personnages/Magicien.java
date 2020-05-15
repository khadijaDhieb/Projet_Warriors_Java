package com.projet_warriors.personnages;


import com.projet_warriors.armes.Sort;

public class Magicien extends Personnage {

    private Sort sort ;
    private String philtre;

    public Magicien() {
        this("");
    }

    public Magicien(String name) {
//        super(name , 3 , 8);
//        this.sort = new Armes() ;

        this(name, 3, 8 , 6,15);

    }

    public Magicien(String name, int lifeLevel, int power , int maxV , int maxF) {
        super(name, lifeLevel, power , maxV , maxF);
        this.philtre = "philtre";
        this.sort = new Sort() ;
    }

    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    public String getPhiltre() {
        return philtre;
    }

    public void setPhiltre(String philtre) {
        this.philtre = philtre;
    }

    @Override
    public String toString() {
        return super.toString() +
                " , sort=" + sort +
                ", philtre='" + philtre + '\'' +
                '}';
    }
}
