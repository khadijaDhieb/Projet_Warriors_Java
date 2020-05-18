package com.projet_warriors;

import com.projet_warriors.personnages.Personnage;

import java.util.Scanner;

public class Menu {

    Personnage playerHero;

    public Menu() {
        System.out.println("Vous avez lancez une nouvelle partie: Bienvenue ! Si vous changez d'avis, vous pouvez tapez 'quitter' !");
    }


    //------------------ Méthode du déroule de jeu

    /**
     * @param input
     * méthode qui s'occupe de lancer le jeu
     */
    public void lanceJeu(Scanner input) {

        PlayGame partie = new PlayGame();

        this.createPlayerValid(input, partie);
        System.out.println(this.playerHero);

        System.out.println("Appuyer sur entrer pour commencer le jeu ");
        String choice = input.nextLine();
        partie.exitJeu(choice, input);


        System.out.println("--> Que la partie commence !" +
                "Vous êtes sur la première case du plateau de jeu.");

        partie.play(input, playerHero);
        this.choixRelanceJeu(input);

    }

    //------------------------- Méthode qui permet de s'assurer que la crétaion d'un joueur a bien était faites

    /**
     * @param input qui réprésente l'objet scanner
     * @param partie qui répresente l'objet play game
     * validation de la création d'un personnage
     */
    public void createPlayerValid(Scanner input, PlayGame partie) {

        boolean ready = false;

        do {

            System.out.println("Quel personnage vous voulez créer : Guerrier ou Magicien ?");
            String playerChoice = input.nextLine();
            //partie.exitJeu(playerChoice, input);

            this.playerHero = partie.createPlayer(playerChoice);

            if (playerHero != null) {
                String heroName = this.chooseName(partie, input);
                this.playerHero = partie.setPlayerName(playerHero, heroName);
                ready = true;
            } else {
                String status = partie.statusJeu(input);
                if (status.equals("quitter")) {
                    partie.exitJeu(status, input);
                } else {
                    System.out.println("Super ! merci de bien remplir les informations demandées ^^");
                }
            }
        } while (!ready);

    }


    //----------------- Méthode qui permet à l'utilisateur de choisir le nom de son personnage

    /**
     * @param partie : objet de la classe playGame
     * @param input : objet scanner
     * @return : retourne un String
     */
    public String chooseName(PlayGame partie, Scanner input) {
        String heroName = "";

        while (heroName.equals("")) {
            System.out.println("Un super héros demande un super nom nn ? Merci d'entrer le nom de votre personnage ");
            heroName = input.nextLine();
        }
        partie.exitJeu(heroName, input);
        return heroName;
    }


    //------------------- Méthode qui permet de choisir entre: quitter / recommencer une partie

    /**
     * @param input : objet scanner
     *              méthode pour le replay game
     */
    public void choixRelanceJeu(Scanner input) {
        System.out.println("Vous Voulez reprendre la partie ou quitter ? Oui ou Non ");
        String choix = input.nextLine();

        if (choix.toLowerCase().equals("oui")) {
            this.lanceJeu(input);
        } else {
            System.exit(0);
        }

    }


}




