package com.projet_warriors;

public class Magicien {

    private String nomMagicien;
    private int vieMagicien = 3;
    private int forceMagicien = 8;
    private String imageMagicien = "Image Magicien";

    public void setNomMagicien(String nomMagicien) {
        this.nomMagicien = nomMagicien;
    }

    public String getNomMagicien() {
        return nomMagicien;
    }

    public int getVieMagicien() {
        return vieMagicien;
    }

    public void setVieMagicien(int vieMagicien) {
        this.vieMagicien = vieMagicien;
    }

    public int getForceMagicien() {
        return forceMagicien;
    }

    public void setForceMagicien(int forceMagicien) {
        this.forceMagicien = forceMagicien;
    }

    public String getImageMagicien() {
        return imageMagicien;
    }

    public void setImageMagicien(String imageMagicien) {
        this.imageMagicien = imageMagicien;
    }


//    enum level {
//        NIVEAU5 = 5,
//        NIVEAU6,
//        NIVEAU7,
//        NIVEAU8,
//        NIVEAU9,
//        NIVEAU10;
//
//
//    }

    public Magicien() {
    }

    public Magicien(String name) {
        this.nomMagicien = name;
    }

    public Magicien(String name, int lifeLevel, int power, String photo) {
        this.nomMagicien = name;
        this.vieMagicien = lifeLevel;
        this.forceMagicien = power;
        this.imageMagicien = photo;
    }

    @Override
    public String toString() {
        return "Magicien{" +
                "nomMagicien='" + nomMagicien + '\'' +
                ", vieMagicien=" + vieMagicien +
                ", forceMagicien=" + forceMagicien +
                ", imageMagicien='" + imageMagicien + '\'' +
                '}';
    }

}
