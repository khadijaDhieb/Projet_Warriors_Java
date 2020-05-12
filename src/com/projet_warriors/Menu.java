package com.projet_warriors;

import java.util.Scanner;

public class Menu {
    //Boolean ready = false;

    public Menu() {
        System.out.println("Vous avez lancez une nouvelle partie: Bienvenue !");
    }

    public void play() {

        boolean ready = false;
        Object playerHero;


        do {

            Scanner sc = new Scanner(System.in);
            System.out.println("Quel personnage vous voulez créer : Guerrier ou Magicien ?");
            String playerChoice = sc.nextLine();


            PlayGame partie = new PlayGame();
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

    }
}




