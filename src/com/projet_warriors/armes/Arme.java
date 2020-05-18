package com.projet_warriors.armes;

import com.projet_warriors.Case;
import com.projet_warriors.personnages.Guerrier;
import com.projet_warriors.personnages.Personnage;

public class Arme extends Case {

    protected String nom;
    protected int forceAttaque;

    public Arme() {
        this.nom = "arme";
        this.forceAttaque = 0;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getForceAttaque() {
        return forceAttaque;
    }

    public void setForceAttaque(int forceAttaque) {
        this.forceAttaque = forceAttaque;
    }

    public void interact(Personnage perso) {

        if (perso instanceof Guerrier) {
            ((Guerrier) perso).setArme(this);
            System.out.println(" Vous venez de collecter un " + this.nom + " ! vous gagnez " + this.forceAttaque + " points de force d'attaque en plus ! ");
            perso.addForce(this.forceAttaque);
            System.out.println(perso);
        }
    }


    @Override
    public String toString() {
        return "Arme{" +
                "nom='" + nom + '\'' +
                ", forceAttaque=" + forceAttaque +
                '}';
    }
}
