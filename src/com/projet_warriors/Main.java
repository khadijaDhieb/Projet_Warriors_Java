package com.projet_warriors;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // J'instancie mon objet scanner pour les entrées clavier
        Scanner sc = new Scanner(System.in);

//        PlateauJeu test = new PlateauJeu();
//
//        ArrayList cases = test.getCases();
//        for (int i = 0; i < test.getPlateau(); i++) {
//            if (5 == i) {
//                System.out.println(cases.get(i));
//                //Case casePlateau = cases.get(i);
//            }
//        }

        Menu partie = new Menu();
        partie.lanceJeu(sc);


    }
}
