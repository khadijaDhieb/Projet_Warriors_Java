package com.projet_warriors;

import com.projet_warriors.bdd.Requette;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // J'instancie mon objet scanner pour les entrées clavier
        Scanner sc = new Scanner(System.in);

//        Requette requette = new Requette();
//        requette.getHeroes();
//        requette.getHeroes();
//        requette.getHeroes();


         Menu partie = new Menu();
        partie.lanceJeu(sc);


    }
}
