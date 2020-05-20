package com.projet_warriors.ennemis;

import com.projet_warriors.Case;
import com.projet_warriors.PlateauJeu;
import com.projet_warriors.personnages.Personnage;

public abstract class Ennemis implements Case {

    protected String nom;
    protected int viePoints;
    protected int forcaAttaque;
    protected Boolean status = false;


    public Ennemis() {
        this.nom = "";
        this.viePoints = 0;
        this.forcaAttaque = 0;
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void interact(Personnage perso) {

        int attaqueHero = perso.getForce() - this.viePoints;

        if (attaqueHero >= 0 && perso.getForce()!=0) {
            System.out.println("Bravo ! T'as vaincu le " + this.nom);
            perso.setForce(attaqueHero);
            System.out.println(perso);
        } else {
            System.out.println("Ta force n'est pas suffisante! On passe au Round 2 : C'est '" + this.nom+ "' qui attaque!");
            perso.setForce(0);
            int attaqueEnnemi = perso.getVie()-this.forcaAttaque ;

            if (attaqueEnnemi <= 0) {
                this.status = true;
                System.out.println("Ah non ! Il t'as vaincu ! Game Over !");
            } else {
                perso.setVie(attaqueEnnemi);
                System.out.println("Bravo ! Très bonne défense ! Au revoir " + this.nom);
                System.out.println(perso);
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
