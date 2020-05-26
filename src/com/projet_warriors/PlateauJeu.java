package com.projet_warriors;

import java.util.ArrayList;
import java.util.Collections;

import com.projet_warriors.armes.*;
import com.projet_warriors.potions.*;
import com.projet_warriors.ennemis.*;

public class PlateauJeu {

    private ArrayList<Case> cases= new ArrayList<Case>();
    private int plateau = 64;

    public PlateauJeu() {

        for (int i= 0 ; i < this.plateau ; i++){

            switch(i) {
                case 45: case 52: case 56: case 62:
                    this.cases.add(new Dragon());
                    break;
                case 10: case 20: case 25: case 32: case 35: case 36: case 37: case 40 : case 44: case 47:
                    this.cases.add(new Sorcier());
                    break;
                case 3: case 6: case 9: case 12: case 15: case 18: case 21: case 24: case 27: case 30:
                    this.cases.add(new Gobelin());
                    break;
                case 2: case 11: case 5: case 22: case 38:
                    this.cases.add(new Massue());
                    break;
                case 19: case 26: case 42: case 53:
                   this.cases.add(new Epee());
                    break;
                case 48: case 49:
                    this.cases.add(new BouleDeFeu());
                    break;
                case 1: case 4: case 8: case 17: case 23:
                    this.cases.add(new Eclair());
                    break;
                case 7: case 13: case 31: case 33: case 39: case 43:
                    this.cases.add(new PotionStandard());
                    break;
                case 28: case 41:
                    this.cases.add(new PotionGrande());
                    break;
                default:
                   this.cases.add(new CaseVide());
            }
        }

    }

    public void randamPlateau(){
        Collections.shuffle(this.cases);
    }

    public Case caseAt(int index){
        return this.cases.get(index);
    }

    public ArrayList getCases() {
        return cases;
    }

    public void setCases(ArrayList cases) {
        this.cases = cases;
    }

    public int getPlateau() {
        return plateau;
    }

    public void setPlateau(int plateau) {
        this.plateau = plateau;
    }
}
