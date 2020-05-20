package com.projet_warriors;

import com.projet_warriors.personnages.Personnage;

public class CaseVide implements Case {

    private String nom;


    public CaseVide() {
        this.nom = "case vide";
    }

    /**
     * @return méthode getter : return le nom d'une case
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom méthode setter pour l'attribut nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }


    public void interact(Personnage perso) {
        //System.out.println(" ");
    }

    @Override
    public String toString() {
        return "CaseVide{" +
                "nom='" + nom + '\'' +
                '}';
    }
}
