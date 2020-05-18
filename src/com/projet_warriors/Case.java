package com.projet_warriors;

import com.projet_warriors.personnages.Personnage;

public abstract class Case {

    protected String nom;

    public Case() {
        this.nom = "";
    }

    /**
     * @return méthode getter : return le nom d'une case
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom  méthode setter pour l'attribut nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @param perso méthode qui s'occupe de l'intéraction
     */
    public void interact(Personnage perso) {
    }

    /**
     * @return : la présentation de l'objet créé en string
     */
    @Override
    public String toString() {
        return "Case{" +
                "nom='" + nom + '\'' +
                '}';
    }
}
