package com.projet_warriors;

import com.projet_warriors.personnages.Personnage;

import java.util.Scanner;

public class Menu {

    Personnage playerHero ;

    public Menu() {
        System.out.println("Vous avez lancez une nouvelle partie: Bienvenue ! Si vous changez d'avis, vous pouvez tapez 'quitter' !");
    }


    //------------------ Méthode du déroule de jeu


    public void lanceJeu(Scanner input) {

        PlayGame partie = new PlayGame();

        this.createPlayerValid(input, partie );
        System.out.println(playerHero);

        System.out.println("Appuyer sur entrer pour commencer le jeu ");
        String choice = input.nextLine();
        partie.exitJeu(choice , input);


        System.out.println("--> Que la partie commence !" +
                "Vous êtes sur la première case du plateau de jeu.");

        partie.play(input , playerHero);
        this.choixRelanceJeu(input);

    }

    //------------------------- Méthode qui permet de s'assurer que la crétaion d'un joueur a bien était faites

    public void createPlayerValid(Scanner input, PlayGame partie ) {

        boolean ready = false;

        do {

            System.out.println("Quel personnage vous voulez créer : Guerrier ou Magicien ?");
            String playerChoice = input.nextLine();
            //partie.exitJeu(playerChoice, input);

            playerHero = partie.createPlayer(playerChoice);

            if (playerHero != null) {
                playerHero = partie.chooseName(playerHero, input);
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

    //------------------- Méthode qui permet de choisir entre: quitter / recommencer une partie

    public void choixRelanceJeu(Scanner input){
        System.out.println("Vous Voulez reprendre la partie ou quitter ? Oui ou Non ");
        String choix = input.nextLine();

        if (choix.toLowerCase().equals("oui")){
            this.lanceJeu(input);
        }else{
            System.exit(0);
        }

    }




}




