package com.projet_warriors.ennemis;

import com.projet_warriors.Case;
import com.projet_warriors.PlateauJeu;
import com.projet_warriors.personnages.Personnage;

public abstract class Ennemis implements Case {

    protected String nom ;
    protected int viePoints;
    protected int forcaAttaque;


    public Ennemis() {
        this.nom ="";
        this.viePoints=0;
        this.forcaAttaque=0;
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

    public int getForcaAttaque() {
        return forcaAttaque;
    }

    public void setForcaAttaque(int forcaAttaque) {
        this.forcaAttaque = forcaAttaque;
    }

    public void interact(Personnage perso){

        System.out.println(" Ouups! Vous venez de tomber sur un " + this.nom + " ! Un combat s'engage ! ");

        int attaqueHero = perso.getForce()-this.viePoints ;

        if (attaqueHero >= 0){
            System.out.println("Bravo ! T'as vaincu le " + this.nom);
        }else{
            System.out.println("Ta force n'était pas suffisante! C'est à lui d'attaquer maintenant !");

                int attaqueEnnemi = this.forcaAttaque- perso.getVie() ;

                if (attaqueEnnemi >=0){
                    System.out.println("Ah non ! Il t'as vaincu ... !");
                }else{
                    System.out.println("Bravo ! Très bonne défense ! Au revoir " + this.nom);
                }
        }


    }


    @Override
    public String toString() {
        return "Ennemis{" +
                "nom='" + nom + '\'' +
                ", viePoints=" + viePoints +
                ", forcaAttaque=" + forcaAttaque +
                '}';
    }
}
