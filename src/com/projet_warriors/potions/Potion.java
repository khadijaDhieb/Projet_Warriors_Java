package com.projet_warriors.potions;

import com.projet_warriors.Case;
import com.projet_warriors.personnages.Guerrier;
import com.projet_warriors.personnages.Personnage;

public class Potion extends Case {

    protected String nom;
    protected int viePoints ;

    public Potion() {
        this.nom="potion de vie";
        this.viePoints = 0;
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

    public void interact(Personnage perso){
        System.out.println(" Vous venez de collecter un "+ this.nom + " ! vous gagnez " + this.viePoints + "de points de vie de plus ! ");
        perso.addVie(this.viePoints);
        System.out.println(perso);
    }

    @Override
    public String toString() {
        return "Potion{" +
                "nom='" + nom + '\'' +
                ", viePoints=" + viePoints +
                '}';
    }
}
