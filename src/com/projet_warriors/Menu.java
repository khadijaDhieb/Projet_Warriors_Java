package com.projet_warriors;

import java.util.Scanner;

public class Menu {

    public Menu() {
        System.out.println("Vous avez lancez une nouvelle partie: Bienvenue !");
    }

    public void lanceJeu() {

        boolean ready = false;
        Object playerHero;

        PlayGame partie = new PlayGame();
        do {

            Scanner sc = new Scanner(System.in);
            System.out.println("Quel personnage vous voulez créer : Guerrier ou Magicien ?");
            String playerChoice = sc.nextLine();


            playerHero = partie.createPlayer(playerChoice);

            if (playerHero != null) {
                System.out.println(playerHero);
                ready = true;
            } else {
                Boolean quitte = partie.quitteJeu();
                if (quitte == true) {
                    System.out.println("La partie est terminée: Au revoir !");
                    break;
                } else {
                    System.out.println("Super ! merci de bien remplir les informations demandées ^^");
                }
            }
        } while (!ready);


        Scanner start = new Scanner(System.in);
        System.out.println("Appuyer sur entrer pour commencer le jeu ");
        start.nextLine();

        System.out.println("--> Que la partie commence !" +
                "Vous êtes sur la première case du plateau de jeu.");

        partie.play();


    }
}




