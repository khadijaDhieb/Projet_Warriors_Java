package com.projet_warriors;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // J'instancie mon objet scanner pour les entrées clavier
        Scanner sc = new Scanner(System.in);

      //  Sauvegarde.getHero(1);

        Menu partie = new Menu();
        partie.lanceJeu(sc);


    }
}
