package com.projet_warriors;

import com.projet_warriors.personnages.Personnage;

public interface Case {

    /**
     * @param perso méthode qui s'occupe de l'intéraction
     */
    void interact(Personnage perso);

}
