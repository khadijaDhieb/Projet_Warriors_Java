package com.projet_warriors;

import com.projet_warriors.personnages.Personnage;

public class CaseVide extends Case{

    public CaseVide() {
        super.nom = "case vide";
    }

    public void interact(Personnage perso){
        //System.out.println(" ");
    }
}
