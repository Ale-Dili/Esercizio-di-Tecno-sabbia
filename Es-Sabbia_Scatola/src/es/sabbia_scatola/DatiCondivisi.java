/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.sabbia_scatola;

import java.util.ArrayList;

/**
 *
 * @author Alessandro
 */
public class DatiCondivisi {

    private int lungS, altS; //dimensioni schermo
    private int numRighe, numColonne;

    private boolean sposta;         //PROVA

    private int perSabbia; //percentuale sabbia
    private Sensore s = new Sensore();
    private Scatole[] array;

    public DatiCondivisi(int lungS, int altS, int perSabbia) {
        this.lungS = lungS;
        this.altS = altS;
        this.numColonne = 3;
        this.numRighe = 2;
        this.perSabbia = perSabbia;

        array = new Scatole[6];

    }

    public DatiCondivisi() {

        this.perSabbia = 100;
        this.numColonne = 5;
        this.numRighe = 2;
        array = new Scatole[numColonne * numRighe];
    }

    public boolean isSposta() {
        return sposta;
    }

    public void setSposta(boolean sposta) {
        this.sposta = sposta;
    }

    public void setS(Sensore s) {
        this.s = s;
    }

    public Sensore getS() {
        return s;
    }

    public int getNumRighe() {
        return numRighe;
    }

    public void setNumRighe(int numRighe) {
        this.numRighe = numRighe;
    }

    public int getNumColonne() {
        return numColonne;
    }

    public void setNumColonne(int numColonne) {
        this.numColonne = numColonne;
    }

    public float getInclinazioneX() {
        return s.getInclinazioneX();
    }

    public float getInclinazioneY() {
        return s.getInclinazioneY();
    }

    public void setInclinazioneX(float inclinazione) {
        s.setInclinazioneX(inclinazione);
    }

    public void setInclinazioneY(float inclinazione) {
        s.setInclinazioneY(inclinazione);
    }

    public int getLungS() {
        return lungS;
    }

    public int getAltS() {
        return altS;
    }

    public void setLungS(int lungS) {
        this.lungS = lungS;
    }

    public void setAltS(int altS) {
        this.altS = altS;
    }

    public void setPerSabbia(int perSabbia) {
        this.perSabbia = perSabbia;
    }

    public int getPerSabbia() {
        return perSabbia;
    }

    public Scatole[] getArray() {
        return array;
    }

    public void setArray(Scatole[] array) {
        this.array = array;
    }

}
