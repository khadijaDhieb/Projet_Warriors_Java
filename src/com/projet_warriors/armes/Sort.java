package com.projet_warriors.armes;

import com.projet_warriors.Case;
import com.projet_warriors.personnages.Guerrier;
import com.projet_warriors.personnages.Magicien;
import com.projet_warriors.personnages.Personnage;

public class Sort extends Case{

        protected String nom;
        protected int forceAttaque;

        public Sort() {
            this.nom = "sort";
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

        public void interact(Personnage perso){
            if (perso instanceof Magicien){
                ((Magicien) perso).setSort(this);
                System.out.println(" Vous venez de collecter un " +this.nom +" ! vous gagnez " + this.forceAttaque + " points de force d'attaque de plus ! ");
                perso.addForce(this.forceAttaque);
            }
        }


        @Override
        public String toString() {
            return "Sort{" +
                    "nom='" + nom + '\'' +
                    ", forceAttaque=" + forceAttaque +
                    '}';
        }


}
